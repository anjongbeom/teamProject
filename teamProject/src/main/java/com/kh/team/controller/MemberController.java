package com.kh.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/member")
public class MemberController {

	
	
	
	@RequestMapping(value = "/joinPrev", method = RequestMethod.GET)
	public String joinPrev() {
		System.out.println("MemberController, joinPrev ");
		return "/member/join_prev";
		
	}
	
	@RequestMapping(value = "/joinForm", method = RequestMethod.POST)
	public String joinForm() {
		System.out.println("MemberController, joinForm ");
		return "/member/join_form";
		
	}
	

}
