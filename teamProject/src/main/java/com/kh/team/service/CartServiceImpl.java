package com.kh.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.team.dao.CartDao;
import com.kh.team.vo.CartDto;
@Service
public class CartServiceImpl implements CartService{

	
	@Autowired
	private CartDao cartDao;
	
	@Override
	public int addCart(CartDto cartDto) {
		CartDto checkCart = cartDao.checkCart(cartDto);
		
		if(checkCart != null) {
			return 2;
		}
		try {
			return cartDao.addCart(cartDto);
		} catch (Exception e) {
			return 0;
		}
	}


}
