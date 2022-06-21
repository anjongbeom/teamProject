package com.kh.team.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
@RequestMapping("/manager")
public class ManagerController {
	
//	@Autowired
//	private MemberService memberService;
//	
//	@Autowired
//	private ProductService productService;

	
	@RequestMapping(value = "/managerForm", method = RequestMethod.GET)
	public String managerForm() {
		System.out.println("MemberController, managerForm ");
		return "/manager/manager_form";
		
	}
	
	

}
