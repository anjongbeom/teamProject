package com.kh.team.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	
	
	//아이디 중복확인 처리
	@RequestMapping(value="/idOverlap", method=RequestMethod.POST)
	public void idOverlap(HttpServletResponse response, @RequestParam("id") String id) throws IOException {
		//@RequestParam는 요청의 특정 파라미터 값을 찾아낼 때 사용하는 어노테이션
//		ms.idOverlap(id,response);	//서비스에 있는 idOverlap 호출.
	}

	

}
