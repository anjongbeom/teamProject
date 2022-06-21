package com.kh.team.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.team.vo.CartVo;
import com.kh.team.vo.MemberVo;
import com.kh.team.vo.OrderDto;
import com.kh.team.vo.ProductVo;
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
	public int deleteCart(int cartId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyCount(CartVo cartDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CartVo> getCartList(String member_Id) {
		List<CartVo> list = sqlSession.selectList(NAMESPACE + "getCartList",member_Id);
		return list;
	}

	@Override
	public CartVo checkCart(CartVo cartDto) {
		
		return null;
	}

}
