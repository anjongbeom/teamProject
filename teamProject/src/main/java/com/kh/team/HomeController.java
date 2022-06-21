package com.kh.team;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.team.service.MemberService;
import com.kh.team.service.ProductService;
import com.kh.team.vo.MemberVo;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductCate;
import com.kh.team.vo.ProductVo;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model,
			HttpSession session, PagingDto pagingDto) {
		logger.info("Welcome home! The client locale is {}.", locale);
//		List<ProductVo> productVo = productService.list(pagingDto);
		
		String product_id = "a00004";
		ProductVo productVo = productService.read(product_id);
		session.setAttribute("productVo", productVo);
		
		
		// 카테 리스트 확인용
		List<ProductCate> cateList = productService.cateList();
		session.setAttribute("cateList", cateList);
		
		
		
		// 홈에서 로그인 한 것처럼만들기
		MemberVo memberVo = memberService.getMemberByIdAndPw("user01", "1234");
		session.setAttribute("loginVo", memberVo);
		
		
		
//		System.out.println("HomeController, product_id: " + product_id);
//		System.out.println("HomeController, productVo: " + productVo);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "/home";
	}
	
}
