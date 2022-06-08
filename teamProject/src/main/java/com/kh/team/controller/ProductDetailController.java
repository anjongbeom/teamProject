package com.kh.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product_detail")
public class ProductDetailController {
	
	
	
	// 메뉴 1으로 포워드
	@RequestMapping(value= "/wiskey1", method = RequestMethod.GET)
	public String wiskey1() {
		return "/product_detail/wiskey1";
	}
	
	

	
	
	

}
