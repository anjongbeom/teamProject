package com.kh.team.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.team.service.CartService;
import com.kh.team.vo.CartDto;
import com.kh.team.vo.CartVo;
import com.kh.team.vo.MemberVo;
import com.kh.team.vo.OrderDto;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductVo;
import com.kh.team.vo.SummaryDto;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	
	/* 장바구니 추가 */
	/**
	 * 0: 등록 실패
	 * 1: 등록 성공
	 * 2: 등록된 데이터 존재
	 * 5: 로그인 필요
	 * 
	 */
	
	@RequestMapping(value= "/list", method = RequestMethod.GET)
	public String list(HttpSession session, Model model) {
		MemberVo loginVo = (MemberVo)session.getAttribute("loginVo");
		String member_id = loginVo.getMember_id();
		List<CartVo> cartList =  cartService.getCartList(member_id);
		model.addAttribute("cartList", cartList);
		return "cart/list";
	}
	
	@RequestMapping(value= "/orderList", method = RequestMethod.GET)
	public String orderList(CartDto cartDto, Model model,SummaryDto summaryDto,
			PagingDto pagingDto, HttpSession session) {
		MemberVo loginVo = (MemberVo)session.getAttribute("loginVo");
		cartDto.setMember_id(loginVo.getMember_id());
		summaryDto.setMember_id(loginVo.getMember_id());
		List<CartDto> orderList = cartService.getOrderList(cartDto);
		System.out.println("orderList:" + orderList);
		model.addAttribute("orderList", orderList);
		SummaryDto totalSummary = cartService.getTotalSummary(summaryDto);
		model.addAttribute("totalSummary",totalSummary);
		return "cart/list";
	}
	
	
	
	
	
	@RequestMapping(value= "/addCart", method = RequestMethod.GET)
	@ResponseBody
	public String addCart(Model model, PagingDto pagingDto, 
			HttpSession session, CartVo cartVo)throws Exception  {
		MemberVo loginVo = (MemberVo)session.getAttribute("loginVo");
		String  member_id = loginVo.getMember_id();
		cartVo.setMember_id(member_id);
		System.out.println("cart, cartVo:" + cartVo);
//		model.addAttribute("cardVo", cartVo);
		// 로그인한 사용자의 ?
//		String login_id = request.getParameter("login_id");
//		String product_id = request.getParameter("product_id");
//		String product_price = request.getParameter("product_price");
//		String product_amount = request.getParameter("product_amount");
		
//		System.out.println("basket, login_id: " + login_id);
//		System.out.println("basket, product_id: " + product_id);
//		System.out.println("basket, product_price: " + product_price);
//		System.out.println("basket, product_amount: " + product_amount);
		
//		model.addAttribute("login_id", login_id);
//		model.addAttribute("product_id", product_id);
//		model.addAttribute("product_price", product_price);
//		model.addAttribute("product_amount", product_amount);
		
//		System.out.println("basket,model login_id: " + login_id);
//		System.out.println("basket,model product_id: " + product_id);
//		System.out.println("basket,model product_price: " + product_price);
//		System.out.println("basket,model product_amount: " + product_amount);
		
		boolean result = cartService.addCart(cartVo);
		System.out.println("CartController, list, result:" + result);
		return String.valueOf(result);
	}
	
	
	//카트 삭제
	@ResponseBody
	@RequestMapping(value= "/deleteCart", method = RequestMethod.POST)
	public int deleteCart(HttpSession session,
	@RequestParam(value = "chk[]") List<String> chArr, CartDto cartDto) throws Exception {
		MemberVo loginVo = (MemberVo)session.getAttribute("loginVo");
		String member_id = loginVo.getMember_id();
		System.out.println("발자취 컨트롤 cartDto: " + cartDto);
		int result = 0;
		int cart_id = 0;
		
		if(loginVo != null) {
			cartDto.setMember_id(member_id);
			
			for(String i : chArr) {
				cart_id = Integer.parseInt(i);
				cartDto.setCart_id(cart_id);
				cartService.deleteCart(cartDto);
			}
			
			result = 1;
			
		}
		
		return result;
	}
	
	
	
	
	
//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	@ResponseBody
//	public String addCartPOST(CartVo cartVo, HttpSession session) {
//		
//		// 로그인 체크
//		
//		MemberVo memberVo = (MemberVo)session.getAttribute("loginVo");
//		System.out.println("CartController,memberVo : "+ memberVo);
//		if (memberVo == null) {
//			return "5";
//		};
//		
//		// 카트 등록
//		boolean result = cartService.addCart(cartVo);
//		
//		return String.valueOf(result);
//	}
	
	
	
}
