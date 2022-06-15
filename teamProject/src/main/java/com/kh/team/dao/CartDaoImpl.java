package com.kh.team.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.team.vo.CartDto;
@Repository
public class CartDaoImpl implements CartDao{

	private final static String NAMESPACE = "com.kh.team.mappers.board.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int addCart(CartDto CartDtO) {
		int num = sqlSession.insert(NAMESPACE + "addCart", CartDtO);
		return num;
	}

	@Override
	public int deleteCart(int cartId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyCount(CartDto CartDtO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CartDto> getCart(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartDto checkCart(CartDto CartDtO) {
		// TODO Auto-generated method stub
		return null;
	}

}
