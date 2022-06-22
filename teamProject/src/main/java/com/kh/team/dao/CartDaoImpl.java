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
		// TODO Auto-generated method stub
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
//		System.out.println("CartDaoImpl, getOrderList, cartDto:" + cartDto);
		List<CartDto> orderList = sqlSession.selectList(NAMESPACE + "getOrderList", cartDto);
//		System.out.println("CartDaoImpl, getOrderList, orderList:" + orderList);
		return orderList;
	}

	@Override
	public SummaryDto getTotalSummary(SummaryDto summaryDto) {
		SummaryDto totalSummary = sqlSession.selectOne(NAMESPACE + "getTotalSummary", summaryDto);
//		System.out.println("CartDaoImpl, getTotalSummary, totalSummary:" + totalSummary);
		return totalSummary;
	}

	@Override
	public void deleteCart(CartDto cartDto) throws Exception {
		System.out.println("발자취 다오+ cartDto:" +cartDto);
		sqlSession.delete(NAMESPACE+"deleteCart", cartDto);
//		if(num == 0) {
//			return true;
//		}
//		return false;
		
	}


}
