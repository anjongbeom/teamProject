package com.kh.team.dao;

import java.util.List;

import com.kh.team.vo.CartDto;

public interface CartDao {
	
	/* 카트 추가 */
	public int addCart(CartDto CartDto) throws Exception;
	
	/* 카트 삭제 */
	public int deleteCart(int cartId);
	
	/* 카트 수량 수정 */
	public int modifyCount(CartDto CartDto);
	
	/* 카트 목록 */
	public List<CartDto> getCart(String memberId);
	
	/* 카트 확인 */
	public CartDto checkCart(CartDto CartDto);
}
