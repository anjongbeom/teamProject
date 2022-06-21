package com.kh.team.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.team.service.OrderService;
import com.kh.team.vo.CartVo;
import com.kh.team.vo.MemberVo;
import com.kh.team.vo.OrderDto;
import com.kh.team.vo.PagingDto;




@Controller
@RequestMapping("/order")
public class OrderController {
	
	
	@Autowired
	private OrderService orderService;
	
	
	
	
//	@RequestMapping(value= "/basket", method = RequestMethod.POST)
//	public String basket(Model model, PagingDto pagingDto, HttpServletRequest request,OrderDto orderDto) {
//
//		String login_id = request.getParameter("login_id");
//		String product_id = request.getParameter("product_id");
//		String product_price = request.getParameter("product_price");
//		String product_amount = request.getParameter("product_amount");
//		System.out.println("basket, login_id: " + login_id);
//		System.out.println("basket, product_id: " + product_id);
//		System.out.println("basket, product_price: " + product_price);
//		System.out.println("basket, product_amount: " + product_amount);
//	
//		return product_id;
//	}
	
	
	

}
