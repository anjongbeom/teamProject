package com.kh.team.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.team.service.ManagerService;
import com.kh.team.util.MailSenderUtil;
import com.kh.team.vo.BoardVo;
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

	
	// 매니저 폼
	@RequestMapping(value = "/managerForm", method = RequestMethod.GET)
	public String managerForm() {
		System.out.println("MemberController, managerForm: ");
		return "/manager/manager_form";
	}
	
	// 제품 등록 폼
	@RequestMapping(value = "/stockCreateForm", method = RequestMethod.GET)
	public String stockCreateForm() {
		System.out.println("MemberController, stock_create_form: ");
		return "/manager/stock_create_form";
	}
	
	// 제품 등록 실행
	@RequestMapping(value = "/stockCreation", method = RequestMethod.GET)
	public String stockCreation(ProductVo productVo) {
		System.out.println("MemberController, stockCreation: ");
		managerService.createStock(productVo);
		return "redirect:/manager/stockList";
	}
	
	
	
	
	// 제품 리스트 얻기
	@RequestMapping(value = "/stockList", method = RequestMethod.GET)
	public String stockList(HttpSession session, PagingDto pagingDto) {
		System.out.println("MemberController, stockList: ");
		pagingDto.setCount(managerService.getProductCount(pagingDto)); // getCount -> list()
		pagingDto.setPage(pagingDto.getPage());
		List<ProductVo> stock_list = managerService.getStockList(pagingDto);
		session.setAttribute("stock_list", stock_list);
		
		return "/manager/stock_list";
	}
	
	
	// 제품 수정 폼
	@RequestMapping(value = "/stockInfoForm", method = RequestMethod.GET)
	public String stockModifyForm(String product_id, Model model, PagingDto pagingDto) {
		System.out.println("managerController, stockModifyForm: " + product_id);
		ProductVo productVo = managerService.getProductInfoById(product_id);
		model.addAttribute("productVo", productVo);
		model.addAttribute("pagingDto", pagingDto);
		
		return "/manager/stock_info_form";
	}
	
	// 제품 수정 실행
	@RequestMapping(value = "/stockModifyRun", method = RequestMethod.GET)
	public String stockModifyRun(ProductVo productVo, Model model, PagingDto pagingDto) {
		System.out.println("managerController, stockModifyRun: " + productVo);
		managerService.stockModifyRun(productVo);
		return "redirect:/manager/stockList";
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
//			for (String order_detail_no : checked_list) { // 체크 항목 확인용
//				System.out.println(order_detail_no); }
		managerService.orderApproval(checked_list);

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
		return "redirect:/manager/managerForm";
	}
	
	
	
	// 멤버 등록 폼 -> 회원가입으로 대체하기
	@RequestMapping(value = "/memberCreateForm", method = RequestMethod.GET)
	public String memberCreateForm() {
		System.out.println("MemberController, memberCreateForm");
		return "/manager/member_create_form";
	}
		
	
	
	// 멤버 등록 실행
	@RequestMapping(value = "/memberCreation", method = RequestMethod.POST)
	public String memberCreation(MemberVo memberVo , RedirectAttributes rttr) {
		System.out.println("MemberController, memberCreation");
		boolean memberCreation_result = managerService.createMember(memberVo);
		System.out.println("memberCreation_result"+memberCreation_result);
		rttr.addFlashAttribute("memberCreation_result", memberCreation_result);
		return "redirect:/manager/managerForm";
	}
	
	
		
	
	// 멤버 리스트로 이동
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	public String memberList(HttpSession session, PagingDto pagingDto) {
		System.out.println("MemberController, memberList ");
		pagingDto.setCount(managerService.getMemberCount(pagingDto)); // getCount -> list()
		pagingDto.setPage(pagingDto.getPage());
		
		List<MemberVo> member_list = managerService.getMemberList(pagingDto);
		session.setAttribute("member_list", member_list);
		
		return "/manager/member_list";
	}
	
	
	// 멤버 정보 폼
	@RequestMapping(value = "/memberInfoForm", method = RequestMethod.GET)
	public String memberInfoForm(String member_id, Model model, PagingDto pagingDto) {
		System.out.println("managerController, memberInfoForm: " + member_id);
		
		MemberVo memberVo = managerService.getMemberInfoById(member_id);
		model.addAttribute("memberVo", memberVo);
		return "/manager/member_info_form";
	}
	
	
	// 멤버 정보 수정  
	@RequestMapping(value = "/memberModifyRun", method = RequestMethod.GET)
	public String memberModifRun(MemberVo memberVo, Model model, PagingDto pagingDto, RedirectAttributes rttr) {
		System.out.println("memberModifyRun, memberVo: " + memberVo);
		boolean update_result = managerService.memberModify(memberVo);
		rttr.addFlashAttribute("update_result", update_result);
		return "redirect:/manager/memberList";
	}
	
	
	
	
	
	

}
