package com.kh.team;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.team.dao.CartDao;
import com.kh.team.vo.CartVo;
import com.kh.team.vo.MemberVo;

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
		
		CartVo cartDto = new CartVo();
		cartDto.setMember_id(member_id);
		cartDto.setProduct_id(product_id);
		cartDto.setProduct_count(count);
		
		int result = 0;
//		result = cartDao.addCart(cartDto);
		
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
		
		CartVo cartDto = new CartVo();
		cartDto.setCartid(cartid);
		cartDto.setProduct_count(count);
		
		cartDao.modifyCount(cartDto);
		
	}

	
	
	/* 카트 확인 */

	@Test
	public void checkCartTest() {
		
		String member_id = "user01";
		String product_id = "a00001";
		
		CartVo cartDto = new CartVo();
		cartDto.setMember_id(member_id);
		cartDto.setProduct_id(product_id);
		
		CartVo resutlCart = cartDao.checkCart(cartDto);
		System.out.println("결과 : " + resutlCart);
		
	}
}
