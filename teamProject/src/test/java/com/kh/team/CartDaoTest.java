package com.kh.team;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.team.dao.CartDao;
import com.kh.team.vo.CartDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class CartDaoTest {
	
	@Autowired
	private CartDao cartDao;
	
	@Test
	public void addCart() throws Exception {
		String member_id = "user01";
		String product_id = "a00001";
		int count = 2;
		
		CartDto cartDto = new CartDto();
		cartDto.setMember_id(member_id);
		cartDto.setProduct_id(product_id);
		cartDto.setProduct_count(count);
		
		int result = 0;
		result = cartDao.addCart(cartDto);
		
		System.out.println("결과 : " + result);
		
	}	

	
	/* 카트 삭제 */

	@Test
	public void deleteCartTest() {
		int cartid = 1;
		
		cartDao.deleteCart(cartid);

	}
	/* 카트 수량 수정 */

	@Test
	public void modifyCartTest() {
		int cartid = 3;
		int count = 5;
		
		CartDto cartDto = new CartDto();
		cartDto.setCartid(cartid);
		cartDto.setProduct_count(count);
		
		cartDao.modifyCount(cartDto);
		
	}

	
	/* 카트 목록 */ 

	@Test
	public void getCartTest() {
		String member_id = "user01";
		
		
		List<CartDto> list = cartDao.getCart(member_id);
		for(CartDto cartDto : list) {
			System.out.println(cartDto);
			cartDto.initSaleTotal();
			System.out.println("init cart : " + cartDto);
		}
		
		
	
	}
	/* 카트 확인 */

	@Test
	public void checkCartTest() {
		
		String member_id = "user01";
		String product_id = "a00001";
		
		CartDto cartDto = new CartDto();
		cartDto.setMember_id(member_id);
		cartDto.setProduct_id(product_id);
		
		CartDto resutlCart = cartDao.checkCart(cartDto);
		System.out.println("결과 : " + resutlCart);
		
	}
}
