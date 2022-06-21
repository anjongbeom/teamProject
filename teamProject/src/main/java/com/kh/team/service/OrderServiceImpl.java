package com.kh.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.team.dao.OrderDao;
import com.kh.team.vo.OrderDto;
@Service
public class OrderServiceImpl implements OrderService{

	
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public boolean create(OrderDto orderDto) {		
		return orderDao.create(orderDto);
	}

}
