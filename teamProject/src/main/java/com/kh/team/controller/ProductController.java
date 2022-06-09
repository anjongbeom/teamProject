package com.kh.team.controller;

import java.io.FileInputStream;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.team.service.ProductService;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductVo;



@Controller
@RequestMapping("/product")
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	
	
	@RequestMapping(value= "/menu", method = RequestMethod.GET)
	public String menu1() {
		return "/product/menu";
	}
	
	
	// 목록
	@RequestMapping(value= "/list", method = RequestMethod.GET)
	public String list(Model model, PagingDto pagingDto, HttpSession session) {
//		pagingDto.setCount(productService.getCount(pagingDto));
//		pagingDto.setPage(pagingDto.getPage());
		List<ProductVo> productVo = productService.list(pagingDto);
//		model.addAttribute("boardList", boardList);
//		model.addAttribute("productVo", productVo);
		session.setAttribute("productVo", productVo);
		return "/product/menu";
	}
	
	
	// 제품 상세
	@RequestMapping(value= "/detail", method = RequestMethod.GET)
	public String detail(String product_id, Model model, PagingDto pagingDto) {
		ProductVo productVo = productService.detail(product_id);
		System.out.println("product_id: " + product_id);
		System.out.println("detail, ProductVo : " + productVo);
		
		model.addAttribute("productVo", productVo);
		return "/product/product_detail";
	}
	
	
	
	@RequestMapping(value= "/brandyList", method = RequestMethod.GET)
	public String brandyList(Model model, PagingDto pagingDto, HttpSession session) {
		List<ProductVo> productVo = productService.brandyList();
		session.setAttribute("productVo", productVo);
		return "/product/menu";
	}
	@RequestMapping(value= "/whiskyList", method = RequestMethod.GET)
	public String whiskyList(Model model, PagingDto pagingDto, HttpSession session) {
		List<ProductVo> productVo = productService.whiskyList();
		session.setAttribute("productVo", productVo);
		return "/product/menu";
	}
	@RequestMapping(value= "/beerList", method = RequestMethod.GET)
	public String beerList(Model model, PagingDto pagingDto, HttpSession session) {
		List<ProductVo> productVo = productService.beerList();
		session.setAttribute("productVo", productVo);
		return "/product/menu";
	}
	@RequestMapping(value= "/traditionalList", method = RequestMethod.GET)
	public String traditionalList(Model model, PagingDto pagingDto, HttpSession session) {
		List<ProductVo> productVo = productService.traditionalList();
		session.setAttribute("productVo", productVo);
		return "/product/menu";
	}

	
	// 파일 이름으로 서버에서 이미지 가져오기(제품 이미지 가져올 때 사용)
	@RequestMapping(value = "/displayImage", method = RequestMethod.GET)
	@ResponseBody
	public byte[] displayImage(String filename) throws Exception {
		FileInputStream fis;
		fis = new FileInputStream(filename);
		byte[] data = IOUtils.toByteArray(fis);
		fis.close();
		return data;
	}
	
	

}
