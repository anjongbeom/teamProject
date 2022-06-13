package com.kh.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.kh.team.service.MemberService;
import com.kh.team.vo.MemberVo;



@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	
	
	
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm() {
		System.out.println("MemberController, joinForm ");
		return "/member/join_form";
		
	}
	
	
	@RequestMapping(value = "/join_run", method = RequestMethod.POST)
	public String joinRun(MemberVo memberVo, MultipartFile file) {

		System.out.println("MemberController, join_run, memberVo: " + memberVo);
		memberService.insertMember(memberVo);
		return "redirect:/";
	}
	
	

}
