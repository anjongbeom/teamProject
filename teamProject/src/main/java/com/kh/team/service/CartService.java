package com.kh.team.service;


import java.util.List;

import com.kh.team.vo.CartDto;
import com.kh.team.vo.CartVo;
import com.kh.team.vo.MemberVo;
import com.kh.team.vo.OrderDto;
import com.kh.team.vo.SummaryDto;

public interface CartService {
	
	public boolean addCart(CartVo cartVo);
	
	/* 카트 목록 */
	public List<CartVo> getCartList(String member_id);
	
	

	public List<CartDto> getOrderList(CartDto cartDto);


	public SummaryDto getTotalSummary(SummaryDto summaryDto);
	
	public void deleteCart(CartDto cartDto) throws Exception;
	
}
