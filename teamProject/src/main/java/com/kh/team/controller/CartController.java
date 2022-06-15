package com.kh.team.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.team.service.CartService;
import com.kh.team.vo.CartDto;
import com.kh.team.vo.MemberVo;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping(value = "/cart/add", method = RequestMethod.POST)
	@ResponseBody	
	public String addCartPOST(CartDto cartDto, HttpServletRequest request) {
		
		// 로그인 체크
		HttpSession session = request.getSession();
		MemberVo memberVo = (MemberVo)session.getAttribute("member");
		if (memberVo == null) {
			return "5";
		}
		
		// 카트 등록
		int result = cartService.addCart(cartDto);
		
		return result + "";
	}
}
