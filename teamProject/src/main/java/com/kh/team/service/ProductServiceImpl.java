package com.kh.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.team.dao.ProductDao;
import com.kh.team.vo.ProductVo;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public List<ProductVo> list() {
		List<ProductVo> list = productDao.list();
		return list;
	}

}
