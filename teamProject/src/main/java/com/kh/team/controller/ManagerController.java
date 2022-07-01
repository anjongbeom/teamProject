package com.kh.team.controller;

import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.team.service.ManagerService;
import com.kh.team.util.MailSenderUtil;
import com.kh.team.vo.MemberVo;
import com.kh.team.vo.OrderVo;
import com.kh.team.vo.OrderedDetailDto;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductVo;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	MailSenderUtil mailSenderUtil;
	
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
							OrderedDetailDto orderedDtailDto, int order_no) {
		List<OrderedDetailDto> ordered_detail_List = managerService.getOrderedDetailList(order_no); 
		System.out.println("ordered_detail_List" + ordered_detail_List);
		session.setAttribute("ordered_detail_List", ordered_detail_List);
		
		return "/manager/ordered_detail_list";
	}
	
	
	
	// 체크된 상세품목 승인 - > orderApproval 
	@RequestMapping(value = "/orderApproval", method = RequestMethod.GET)
	public String orderApproval(HttpSession session, PagingDto pagingDto,
							OrderedDetailDto orderedDtailDto, HttpServletRequest request) {
		String[] checked_list = request.getParameterValues("checked_list");
//			for (String order_detail_no : checked_list) {
//				System.out.println(order_detail_no); }
		managerService.orderApproval(checked_list);
//		MailSenderTest email = new MailSenderTest();
//		mailSenderUtil.sendMail("서비스에서 util 테스트중", "서비스에서 util테스트중", "ajb5209@naver.com", "kerk0214@gmail.com");
		
		return "redirect:/manager/orderedList"; 
	}
	
	
	// OrderStatusCode 변경 -> 2
	@RequestMapping(value = "/updateOrderStatusCode", method = RequestMethod.GET)
	public String updateOrderStatusCode(HttpSession session, PagingDto pagingDto,
					OrderedDetailDto orderedDtailDto, HttpServletRequest request) {
//		managerService.updateOrderStatusCode(1);
		return "redirect:/manager/orderedList"; // 
	}
	
	
	// 반품 목록
	@RequestMapping(value = "/returnList", method = RequestMethod.GET)
	public String returnList(HttpSession session, PagingDto pagingDto,
							OrderedDetailDto orderedDtailDto, Model model) {
		int order_detail_status_code = 5; // 가져올 상태코드
		List<OrderedDetailDto> return_list = managerService.getReturnedList(order_detail_status_code);
		System.out.println("return_list" + return_list);
		
		model.addAttribute("return_list", return_list);
//		session.setAttribute("returned_list", value);
		return "/manager/return_list";
	}
	
	// 반품 승인
	@RequestMapping(value = "/returnApproval", method = RequestMethod.GET)
	public String returnApproval(HttpSession session, PagingDto pagingDto,
								OrderedDetailDto orderedDtailDto, HttpServletRequest request) {
		String[] checked_return_list = request.getParameterValues("checked_return_list");
		managerService.returnApproval(checked_return_list);
		
		return "redirect:/manager/return_list";
	}
								
	
	
	// 멤버 리스트로 이동
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	public String memberList(HttpSession session, PagingDto pagingDto) {
		System.out.println("MemberController, memberList ");
		pagingDto.setCount(managerService.getCount(pagingDto)); // getCount -> list()
		pagingDto.setPage(pagingDto.getPage());
		
		// getMemberList(pagingDto)
		List<MemberVo> member_list = managerService.getMemberList(pagingDto);
		session.setAttribute("member_list", member_list);
		
		return "/manager/member_list";
	}
	
	
	

}
