package com.kh.team.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.team.service.CartService;
import com.kh.team.service.ManagerService;
import com.kh.team.service.MyPageService;
import com.kh.team.vo.CartDto;
import com.kh.team.vo.CartVo;
import com.kh.team.vo.MemberVo;
import com.kh.team.vo.OrderedDetailDto;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.SummaryDto;

@Controller
@RequestMapping("/myPage")
public class MyPageController {

	@Autowired
	private MyPageService myPageService;
	
	
	// 마이페이지 요청
	@RequestMapping(value= "/myPageForm", method = RequestMethod.GET)
	public String myPageForm(HttpSession session, HttpServletRequest request) {

		return "myPage/my_page";
	}
	
	// 주문 목록 가져오기
	@RequestMapping(value= "/getOrderedDetailList", method = RequestMethod.GET)
	@ResponseBody
	public List<OrderedDetailDto> getOrderedDetailList(HttpSession session, HttpServletRequest request) {
		MemberVo loginVo = (MemberVo) session.getAttribute("loginVo");
		System.out.println("MypageController, myPageForm, loginVo: " + loginVo);
		// member_id로 구매목록 가져오기
		List<OrderedDetailDto> my_ordered_detail_List = 
				myPageService.getOrderedDetailList(loginVo.getMember_id());
		session.setAttribute("my_ordered_detail_List", my_ordered_detail_List);
		System.out.println("my_ordered_detail_List : " + my_ordered_detail_List);
		
		return my_ordered_detail_List;
	}
	
	
	// 반품 신청하기
	@RequestMapping(value= "/requestReturn", method = RequestMethod.POST)
	@ResponseBody
	public String requestReturn(@RequestParam Map<String, Object> map) {
		// ajax로 얻은 order_detail_no를 int로 형변환
		int order_detail_no = Integer.parseInt(String.valueOf(map.get("order_detail_no")));
		System.out.println("MypageController, requestReturn, order_detail_no" + order_detail_no);
		boolean result = myPageService.requestReturn(order_detail_no);
		return String.valueOf(result);
	}
	
	
}
