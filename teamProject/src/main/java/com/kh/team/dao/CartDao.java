package com.kh.team.dao;

import java.util.List;

import com.kh.team.vo.CartDto;
import com.kh.team.vo.CartVo;
import com.kh.team.vo.MemberVo;
import com.kh.team.vo.OrderDto;
import com.kh.team.vo.SummaryDto;

public interface CartDao {
	
	/* 카트 추가 */
	public boolean addCart(CartVo cartDto) ;
	

	
	/* 카트 수량 수정 */
	public int modifyCount(CartVo cartDto);
	
//	public List<CartDto> getCart(String member_Id);
	
	/* 카트 목록 */
	public List<CartVo> getCartList(String member_Id);
	
	/* 카트 확인 */
	public CartVo checkCart(CartVo cartDto);
	
	/* 카트에 들어갈 값*/ 
	public List<CartDto> getOrderList(CartDto cartDto);

	public SummaryDto getTotalSummary(SummaryDto summaryDto);
	
	public void deleteCart(String str) throws Exception;

	public void insertOrder(String member_id) throws Exception;
	
	public void insertOrderDetail(String str) throws Exception;
	
}
