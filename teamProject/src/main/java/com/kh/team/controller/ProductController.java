package com.kh.team.controller;

import java.io.FileInputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.team.service.ProductService;
import com.kh.team.vo.CartDto;
import com.kh.team.vo.CartVo;
import com.kh.team.vo.MemberVo;
import com.kh.team.vo.OrderDto;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductVo;



@Controller
@RequestMapping("/product")
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	
	
	@RequestMapping(value= "/menu", method = RequestMethod.GET)
	public String menu() {
		return "/product/menu";
	}
	

	
	
	// 목록
	@RequestMapping(value= "/list", method = RequestMethod.GET)
	public String list(String cate_code, Model model, PagingDto pagingDto, HttpSession session) {
//		pagingDto.setCount(productService.getCount(pagingDto));
//		pagingDto.setPage(pagingDto.getPage());
		System.out.println("cate_code :" + cate_code);
		List<ProductVo> productVo = productService.list(pagingDto, cate_code);
//		model.addAttribute("boardList", boardList);
//		model.addAttribute("productVo", productVo);
		session.setAttribute("productVo", productVo);
		return "/product/menu";
	}
	
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(String product_id, Model model, PagingDto pagingDto) {
		System.out.println("ProductController, read, id: " + product_id);
		System.out.println("ProductController, read, pagingDto: " + pagingDto);
		
		ProductVo productVo = productService.read(product_id);
		model.addAttribute("boardVo", productVo);
		model.addAttribute("pagingDto", pagingDto);
		return "board/read";
	}
	
	
	
	
	// 제품 상세
	@RequestMapping(value= "/detail", method = RequestMethod.GET)
	public String detail(String product_id, Model model, PagingDto pagingDto) {
		ProductVo productVo = productService.detail(product_id);
//		System.out.println("product_id: " + product_id);
//		System.out.println("detail, ProductVo : " + productVo);
		model.addAttribute("productVo", productVo);
		return "/product/product_detail";
	}
	
	
	// 제품 구매
	@RequestMapping(value= "/purchase", method = RequestMethod.GET)
	public String purchase(String product_id, Model model, PagingDto pagingDto) {
		ProductVo productVo = productService.detail(product_id);

		model.addAttribute("productVo", productVo);
		return "/product/purchase";
	}
	
	

//	@RequestMapping(value= "/addCart", method = RequestMethod.GET)
//	@ResponseBody
//	public String addCart(Model model, PagingDto pagingDto, 
//			HttpSession session, CartVo cartVo)throws Exception  {
//		MemberVo loginVo = (MemberVo)session.getAttribute("loginVo");
//		String  member_id = loginVo.getMember_id();
//		cartVo.setMember_id(member_id);
//		System.out.println("cart, cartVo:" + cartVo);
//		boolean result = productService.addCart(cartVo);
//		System.out.println("CartController, list, result:" + result);
//		return String.valueOf(result);
//	}
//	
//	
//	//카트 삭제
//	@ResponseBody
//	@RequestMapping(value= "/deleteCart", method = RequestMethod.POST)
//	public int deleteCart(HttpSession session,
//	@RequestParam(value = "chk[]") List<String> chArr, CartDto cartDto) throws Exception {
//		MemberVo loginVo = (MemberVo)session.getAttribute("loginVo");
//		String member_id = loginVo.getMember_id();
//		System.out.println("발자취 컨트롤 cartDto: " + cartDto);
//		int result = 0;
//		String cart_id = "";
//		
//		if(loginVo != null) {
//			cartDto.setMember_id(member_id);
//			
//			for(String i : chArr) {
//				cart_id = i;
//				productService.deleteCart(cart_id);
//			}
//			
//			result = 1;
//			
//		}
//		
//		return result;
//	}
	
	
	//제품 구매창에서 바로 구매 할시 관리자 DB로 바로 넘어감
		@RequestMapping(value = "/sellProduct", method = RequestMethod.GET)
		@ResponseBody
		public String sellProduct(HttpSession session,ProductVo productVo,int product_count) throws Exception {
			MemberVo loginVo = (MemberVo)session.getAttribute("loginVo");
			String member_id = loginVo.getMember_id();
			System.out.println("productVo:"+productVo);
			System.out.println("product_count:"+product_count);
			boolean result=productService.transInsertOrder(productVo.getProduct_id(), product_count, member_id);		
					
			return String.valueOf(result);
			
		}
//		//제품 구매창에서 바로 구매 할시 관리자 DB로 바로 넘어감
//		@RequestMapping(value = "/purchaseProduct", method = RequestMethod.POST)
//		@ResponseBody
//		public String purchase(@RequestParam(value="chk[]") List<String> chk,
//				HttpSession session,ProductVo productVo) throws Exception {
//			MemberVo loginVo = (MemberVo)session.getAttribute("loginVo");
//			String member_id = loginVo.getMember_id();
//			
////			System.out.println(chk.size());	
//			productService.insertOrder(member_id);
//			for (String str : chk) {
//				System.out.println("str:"+str); 
//				productService.insertOrderDetail(str);
//				productService.deleteCart(str);
//			}			
//			return "true";
//			
//		}
	
//	
//	@RequestMapping(value= "/brandyList", method = RequestMethod.GET)
//	public String brandyList(Model model, PagingDto pagingDto, HttpSession session) {
//		List<ProductVo> productVo = productService.brandyList();
//		session.setAttribute("productVo", productVo);
//		return "/product/menu";
//	}
//	@RequestMapping(value= "/whiskyList", method = RequestMethod.GET)
//	public String whiskyList(Model model, PagingDto pagingDto, HttpSession session) {
//		List<ProductVo> productVo = productService.whiskyList();
//		session.setAttribute("productVo", productVo);
//		return "/product/menu";
//	}
//	@RequestMapping(value= "/beerList", method = RequestMethod.GET)
//	public String beerList(Model model, PagingDto pagingDto, HttpSession session) {
//		List<ProductVo> productVo = productService.beerList();
//		session.setAttribute("productVo", productVo);
//		return "/product/menu";
//	}
//	@RequestMapping(value= "/traditionalList", method = RequestMethod.GET)
//	public String traditionalList(Model model, PagingDto pagingDto, HttpSession session) {
//		List<ProductVo> productVo = productService.traditionalList();
//		session.setAttribute("productVo", productVo);
//		return "/product/menu";
//	}
 
	
	
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
