package com.kh.team.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.team.vo.MemberVo;
import com.kh.team.vo.MessageToSendVo;
import com.kh.team.vo.OrderVo;
import com.kh.team.vo.OrderedDetailDto;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductVo;

@Repository
public class MyPageDaoImpl implements MyPageDao{
	private final String NAMESPACE = "com.kh.team.mappers.myPage.";

	@Autowired
	private SqlSession sqlSession;
	
	
	// 주문된 상세 목록
	@Override
	public List<OrderedDetailDto> getOrderedDetailList(String member_id) {
		System.out.println("MyPageDaoImpl, getOrderedDetailList, member_id : " + member_id);
		List<OrderedDetailDto> list = sqlSession.selectList(NAMESPACE + "getOrderedDetailList", member_id);
		return list;
	}
	
	
	// ajax 반품신청
	@Override
	public boolean requestReturn(int order_detail_no) {
//		HashMap<String, Object> map = new HashMap<>();
//		map.put("order_detail_no", order_detail_no);
//		System.out.println("MyPageDaoImpl, requestReturn, order_detail_no" + map);
		System.out.println("MyPageDaoImpl, requestReturn, order_detail_no : " + order_detail_no);
		int count = sqlSession.update(NAMESPACE + "requestReturn", order_detail_no);
		if (count > 0) {
			return true;
		}
		return false;
	}

	
}
