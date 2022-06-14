package com.kh.team.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm() {
		System.out.println("MemberController, loginForm ");
		return "/member/login_form";
		
	}
	
	
	@RequestMapping(value = "/loginRun", method = RequestMethod.POST)
	public String loginRun(String member_id, String member_pw, HttpSession session, RedirectAttributes rttr, 
			String saveId, HttpServletResponse response) {
		System.out.println("member_id: " + member_id);
		System.out.println("member_pw: " + member_pw);
		MemberVo memberVo = memberService.getMemberByIdAndPw(member_id, member_pw);
		
		if (memberVo == null) {
			rttr.addFlashAttribute("login_result", "fail");
			return "redirect:/";
		} else {
			session.setAttribute("loginVo", memberVo);
			if (saveId != null && !saveId.equals("")) {
				Cookie cookie = new Cookie("saveId", member_id);
				cookie.setPath("/");
				cookie.setMaxAge(50 * 50 * 24* 7); // 깨지는지 확인필요
				response.addCookie(cookie);
			} else {
				Cookie cookie = new Cookie("saveId", member_id);
				cookie.setPath("/");
				cookie.setMaxAge(0); // 깨지는지 확인필요
				response.addCookie(cookie);
			}
			
//			String targetLocation = (String)session.getAttribute("targetLocation");
//			if (targetLocation == null || targetLocation.equals("")) {
//				return "redirect:/board/list?page=1";
//			}
			return "redirect:/product/list" /*+ targetLocation*/;
		}
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate(); // 
		// session.setAttribute("a", xxx); -> session.removeAttribute("a") 
		// session.setAttribute("a", xxx);
		return "redirect:/member/loginForm";
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
