package com.kh.team.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.team.vo.CartDto;
import com.kh.team.vo.CartVo;
import com.kh.team.vo.SummaryDto;
@Repository
public class CartDaoImpl implements CartDao{

	private final static String NAMESPACE = "com.kh.team.mappers.cart.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean addCart(CartVo cartVo) {
//		Map<String, Object> parameter =new HashMap<String, Object>();
//		parameter.put("product_count", cartDto.getProduct_count());
//		parameter.put("product_id", cartDto.getProduct_id());
		int num = sqlSession.insert(NAMESPACE + "addCart", cartVo);
		if (num > 0) {
			return true;
		}
		return false;
	}


	@Override
	public int modifyCount(CartVo cartDto) {
		return 0;
	}


	@Override
	public CartVo checkCart(CartVo cartDto) {
		return null;
	}
	
	@Override
	public List<CartVo> getCartList(String member_Id) {
		List<CartVo> list = sqlSession.selectList(NAMESPACE + "getCartList",member_Id);
		return list;
	}

	@Override
	public List<CartDto> getOrderList(CartDto cartDto) {
		List<CartDto> orderList = sqlSession.selectList(NAMESPACE + "getOrderList", cartDto);
		return orderList;
	}

	@Override
	public SummaryDto getTotalSummary(SummaryDto summaryDto) {
		SummaryDto totalSummary = sqlSession.selectOne(NAMESPACE + "getTotalSummary", summaryDto);
		return totalSummary;
	}

	@Override
	public void deleteCart(String str) throws Exception {
		sqlSession.delete(NAMESPACE+"deleteCart", str);
	}
	
	@Override
	public void insertOrder(String member_id) throws Exception {
		sqlSession.insert(NAMESPACE+"insertOrder", member_id);
	}

	@Override
	public void insertOrderDetail(String str) throws Exception {
		sqlSession.insert(NAMESPACE+"insertOrderDetail", str);
	}

	
	


	



	


}
