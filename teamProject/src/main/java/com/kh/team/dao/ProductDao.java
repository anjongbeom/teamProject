package com.kh.team.dao;

import java.util.List;

import com.kh.team.vo.ProductVo;

public interface ProductDao {
	

	public List<ProductVo> list();
	public List<ProductVo> brandyList();
	public List<ProductVo> wiskeyList();
	public List<ProductVo> beerList();
	public List<ProductVo> traditionalList();

}
