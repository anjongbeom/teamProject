package com.kh.team;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.team.service.CartService;
import com.kh.team.vo.CartVo;
import com.kh.team.vo.MemberVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class CartServiceTest {
	
	@Autowired
	private CartService cartService;
	
	//등록 테스트
	@Test
	public void addCartTest() {
		//given
			String member_id = "user01";
			String product_id = "a00001";
			int product_count = 1;
			
			CartVo cartDtO = new CartVo(); 
			cartDtO.setMember_id(member_id);
			cartDtO.setProduct_id(product_id);
			cartDtO.setProduct_count(product_count);
		
		//when
//			int result = cartService.addCart(cartDtO);
		
		//then
//			System.out.println("** result : " + result);
		
		
	}
		
		
}
	
	

