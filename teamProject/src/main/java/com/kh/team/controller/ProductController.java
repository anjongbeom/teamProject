package com.kh.team.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.team.service.ProductService;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductVo;



@Controller
@RequestMapping("/product")
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	
	
	@RequestMapping(value= "/menu1", method = RequestMethod.GET)
	public String menu1() {
		return "/product/menu1";
	}
	
	
	// 목록
	@RequestMapping(value= "/list", method = RequestMethod.GET)
	public String list(Model model, PagingDto pagingDto, HttpSession session) {
//		pagingDto.setCount(productService.getCount(pagingDto));
//		pagingDto.setPage(pagingDto.getPage());
		List<ProductVo> productVo = productService.list();
//		model.addAttribute("boardList", boardList);
//		model.addAttribute("productVo", productVo);
		session.setAttribute("productVo", productVo);
		return "/product/menu1";
	}

	
	
	

}
