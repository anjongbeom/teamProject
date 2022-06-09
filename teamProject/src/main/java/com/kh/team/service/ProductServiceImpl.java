package com.kh.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.team.dao.ProductDao;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductVo;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public List<ProductVo> list(PagingDto pagingDto) {
		List<ProductVo> list = productDao.list(pagingDto);
		return list;
	}
	
	@Override
	public ProductVo detail(String product_id) {
		ProductVo productVo = productDao.detail(product_id);
		return productVo;
	}
	
	

	@Override
	public List<ProductVo> brandyList() {
		List<ProductVo> brandyList = productDao.brandyList();
		return brandyList;
	}

	@Override
	public List<ProductVo> whiskyList() {
		List<ProductVo> whiskyList = productDao.whiskyList();
		return whiskyList;
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

	@Override
	public ProductVo basket(String product_id) {
		ProductVo productVo = productDao.basket(product_id);
		return productVo;
	}

}
