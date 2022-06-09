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

	@Override
	public List<ProductVo> brandyList() {
		List<ProductVo> brandyList = productDao.brandyList();
		return brandyList;
	}

	@Override
	public List<ProductVo> whiskyList() {
		List<ProductVo> wiskeyList = productDao.whiskyList();
		return wiskeyList;
	}

	@Override
	public List<ProductVo> beerList() {
		List<ProductVo> beerList = productDao.beerList();
		return beerList;
	}

	@Override
	public List<ProductVo> traditionalList() {
		List<ProductVo> traditionalList = productDao.traditionalList();
		return traditionalList;
	}

}
