package com.kh.team.dao;

import java.util.List;

import com.kh.team.vo.CartVo;
import com.kh.team.vo.MemberVo;
import com.kh.team.vo.OrderDto;

public interface CartDao {
	
	/* 카트 추가 */
	public boolean addCart(CartVo cartDto) ;
	
	/* 카트 삭제 */
	public int deleteCart(int cartId);
	
	/* 카트 수량 수정 */
	public int modifyCount(CartVo cartDto);
	
	/* 카트 목록 */
//	public List<CartDto> getCart(String member_Id);
	
	public List<CartVo> getCartList(String member_Id);
	
	/* 카트 확인 */
	public CartVo checkCart(CartVo cartDto);
}
