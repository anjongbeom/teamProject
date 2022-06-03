package com.kh.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	
	
	// 메뉴1으로 포워드
	@RequestMapping(value= "/menu1", method = RequestMethod.GET)
	public String menu1() {
		return "/product/menu1";
	}
	

	
	
	

}
