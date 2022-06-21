package com.kh.team.service;


import java.util.List;

import com.kh.team.vo.CartVo;
import com.kh.team.vo.MemberVo;
import com.kh.team.vo.OrderDto;

public interface CartService {
	
	public boolean addCart(CartVo cartVo);
	
	/* 카트 목록 */
	public List<CartVo> getCartList(String member_id);
}
