package com.kh.team.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kh.team.vo.MemberVo;


public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVo memberVo = (MemberVo) session.getAttribute("loginVo");
		System.out.println("memberVo:" +memberVo);
		if (memberVo == null) {
			String uri = request.getRequestURI();
			String queryString = request.getQueryString();
			System.out.println("uri: " + uri); 
			System.out.println("queryString: " + queryString); 
			String targetLocation = uri + "?" + queryString;
			session.setAttribute("targetLocation", targetLocation);
			response.sendRedirect("/member/loginForm");
			return false;
		}
		
		return true; 
	}

}
