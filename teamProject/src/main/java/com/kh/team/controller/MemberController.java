package com.kh.team.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.team.service.MemberService;
import com.kh.team.service.ProductService;
import com.kh.team.vo.MemberVo;
import com.kh.team.vo.ProductCate;



@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ProductService productService;

	
	
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
			return "redirect:/member/loginForm";
		} else {
			session.setAttribute("loginVo", memberVo);
			if (saveId != null && !saveId.equals("")) {
				Cookie cookie = new Cookie("saveId", member_id);
				cookie.setPath("/");
				cookie.setMaxAge(50 * 50 * 24* 7); 
				response.addCookie(cookie);
			} else {
				Cookie cookie = new Cookie("saveId", member_id);
				cookie.setPath("/");
				cookie.setMaxAge(0); 
				response.addCookie(cookie);
			}
			
//			productService.list(pagingDto)
			List<ProductCate> cateList = productService.cateList();
			session.setAttribute("cateList", cateList);
		
			String targetLocation = (String)session.getAttribute("targetLocation");
			if (targetLocation == null || targetLocation.equals("")) {
				return "redirect:/";
			}
			return "redirect:" + targetLocation;
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
	
	
	
	//????????? ???????????? ??????
	@RequestMapping(value="/idOverlap", method=RequestMethod.POST)
	@ResponseBody
	public String idOverlap(HttpServletResponse response, @RequestParam("member_id") String member_id) throws IOException {
		//@RequestParam??? ????????? ?????? ???????????? ?????? ????????? ??? ???????????? ???????????????
		String result = memberService.idOverlap(member_id);	//???????????? ?????? idOverlap ??????.
		System.out.println("MemberController, result: " + result);
		
		return String.valueOf(result);
	}
	
	
	// ???????????????
	@RequestMapping(value = "/myPageForm", method = RequestMethod.GET)
	public String myPage() {
		System.out.println("MemberController, joinForm ");
		return "/member/join_form";
		
	}
	
	
	
}
