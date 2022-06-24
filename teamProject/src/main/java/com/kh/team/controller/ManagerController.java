package com.kh.team.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.team.service.ManagerService;
import com.kh.team.util.ExampleSend;
import com.kh.team.vo.OrderVo;
import com.kh.team.vo.OrderedDtailDto;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductVo;


import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	

	@Autowired
	private JavaMailSender mailSender;

	
	@RequestMapping(value = "/managerForm", method = RequestMethod.GET)
	public String managerForm() {
		System.out.println("MemberController, managerForm ");
		return "/manager/manager_form";
	}
	
	@RequestMapping(value = "/stockCreation", method = RequestMethod.GET)
	public String stockCreation() {
		System.out.println("MemberController, stockCreation ");
		return "/manager/stock_creation";
	}
	
	@RequestMapping(value = "/stockList", method = RequestMethod.GET)
	public String stockList(HttpSession session, PagingDto pagingDto) {
		System.out.println("MemberController, stockList ");
		pagingDto.setCount(managerService.getCount(pagingDto)); // getCount -> list()
		pagingDto.setPage(pagingDto.getPage());
		
		List<ProductVo> stock_list = managerService.getStockList(pagingDto);
		session.setAttribute("stock_list", stock_list);
		
		return "/manager/stock_list";
	}
	
	
	// 주문된 목록
	@RequestMapping(value = "/orderedList", method = RequestMethod.GET)
	public String orderedList(HttpSession session, PagingDto pagingDto) {
		int order_status_code = 1; // 가져올 상태코드
		List<OrderVo> orderVo = managerService.getOrderedList(order_status_code); 
		System.out.println("orderVo" + orderVo);
		session.setAttribute("orderVo", orderVo);
		return "/manager/ordered_list";
	}
	
	
	// 주문된 상세 목록 
	@RequestMapping(value = "/orderedDetailList", method = RequestMethod.GET)
	public String orderedDetailList(HttpSession session, PagingDto pagingDto,
							OrderedDtailDto orderedDtailDto, int order_no) {
		List<OrderedDtailDto> ordered_detail_List = managerService.getOrderedDetailList(order_no); 
		System.out.println("ordered_detail_List" + ordered_detail_List);
		session.setAttribute("ordered_detail_List", ordered_detail_List);
		
		return "/manager/ordered_detail_list";
	}
	
	
	
	// 체크된 상세품목 승인 - > orderApproval 
	@RequestMapping(value = "/orderApproval", method = RequestMethod.GET)
	public String orderApproval(HttpSession session, PagingDto pagingDto,
							OrderedDtailDto orderedDtailDto, HttpServletRequest request) {
		String[] checked_list = request.getParameterValues("checked_list");
//			for (String order_detail_no : checked_list) {
//				System.out.println(order_detail_no);
//			}
		managerService.orderApproval(checked_list);
		return "redirect:/manager/orderedList"; // 
	}
	
	
	// OrderStatusCode 변경 -> 2
	@RequestMapping(value = "/updateOrderStatusCode", method = RequestMethod.GET)
	public String updateOrderStatusCode(HttpSession session, PagingDto pagingDto,
					OrderedDtailDto orderedDtailDto, HttpServletRequest request) {
		managerService.updateOrderStatusCode(1);
		
		return "redirect:/manager/orderedList"; // 
	}
	
	
	// 반품 목록
	@RequestMapping(value = "/returnList", method = RequestMethod.GET)
	public String returnList(HttpSession session, PagingDto pagingDto,
							OrderedDtailDto orderedDtailDto) {
		
		return "/manager/return_list";
		
	}
	
	
	// 텍스트 보내기 api(coolSms)
	@RequestMapping(value = "/coolSms", method = RequestMethod.GET)
	public String coolSms(HttpSession session) {
		
		String reciever = "01036252375";
		String content = "쿨 sms 테스트중2";
		ExampleSend.sender(reciever, content);
		
		return "redirect:/manager/managerForm";
	}
	
	
	
	// 메일링 서비스
	@RequestMapping(value = "/sendMail", method = RequestMethod.GET)
    public void sendMailTest() throws Exception{
        
        String subject = "메일링 테스트1 입니다.";
        String content = "메일 테스트 내용1 입니다.";
        String from = "kerk0214@gmail.com";
        String to = "ajb5209@naver.com";
        
        try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper mailHelper = new MimeMessageHelper(mail,true,"UTF-8");
            // true는 멀티파트 메세지를 사용하겠다는 의미
            
            /*
             * 단순한 텍스트 메세지만 사용시엔 아래의 코드도 사용 가능 
             * MimeMessageHelper mailHelper = new MimeMessageHelper(mail,"UTF-8");
             */
            
            mailHelper.setFrom("김용현 <kerk0214@gmail.com>");
            // 빈에 아이디 설정한 것은 단순히 smtp 인증을 받기 위해 사용 따라서 보내는이(setFrom())반드시 필요
            // 보내는이와 메일주소를 수신하는이가 볼때 모두 표기 되게 원하신다면 아래의 코드를 사용하시면 됩니다.
            //mailHelper.setFrom("보내는이 이름 <보내는이 아이디@도메인주소>");
            mailHelper.setTo(to);
            mailHelper.setSubject(subject);
            mailHelper.setText(content, true);
            // true는 html을 사용하겠다는 의미입니다.
            
            /*
             * 단순한 텍스트만 사용하신다면 다음의 코드를 사용하셔도 됩니다. mailHelper.setText(content);
             */
            
            mailSender.send(mail);
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
	
	

}
