package com.kh.team.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.team.vo.OrderDto;
@Repository
public class OrderDaoImpl implements OrderDao{

private final String NAMESPACE = "com.kh.ex01.mappers.order.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean create(OrderDto orderDto) {
		int count = sqlSession.insert(NAMESPACE + "create", orderDto);
		if(count > 0) {
			return true;
		}
		return false;
	}
	

}
