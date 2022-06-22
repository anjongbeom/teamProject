package com.kh.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.team.dao.CartDao;
import com.kh.team.vo.CartDto;
import com.kh.team.vo.CartVo;
import com.kh.team.vo.MemberVo;
import com.kh.team.vo.OrderDto;
import com.kh.team.vo.SummaryDto;
@Service
public class CartServiceImpl implements CartService{

	
	@Autowired
	private CartDao cartDao;
	
	@Override
	public boolean addCart(CartVo cartVo) {
//		CartVo checkCart = cartDao.checkCart(cartVo);
//		System.out.println("checkCart : "+ checkCart);
//		if(checkCart != null) {
//			return 2;
//		}
		return cartDao.addCart(cartVo);
	}

	@Override
	public List<CartVo> getCartList(String member_id) {
		List<CartVo> cartList = cartDao.getCartList(member_id);
		System.out.println("cartList: " + cartList); 		
		return cartList;
	}

	@Override
	public List<CartDto> getOrderList(CartDto cartDto) {
		List<CartDto> orderList = cartDao.getOrderList(cartDto);
//		System.out.println("orderList : " + orderList);
		return orderList;
	}

	

	@Override
	public SummaryDto getTotalSummary(SummaryDto summaryDto) {
		SummaryDto totalSummary = cartDao.getTotalSummary(summaryDto);
//		System.out.println("CartServiceImpl, getTotalSummary, totalSummary : " + totalSummary);
		return totalSummary;
		
	}

	@Override
	public void deleteCart(CartDto cartDto) throws Exception {
		System.out.println("발자취 서비스 cartDto:" + cartDto);
		cartDao.deleteCart(cartDto);
		
		
	}
	
	


}
