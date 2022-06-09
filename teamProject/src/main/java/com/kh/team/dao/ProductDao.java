package com.kh.team.dao;

import java.util.List;

import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductVo;

public interface ProductDao {
	

	public List<ProductVo> list(PagingDto pagingDto);
	public ProductVo detail(String product_id);
	
	public List<ProductVo> brandyList();
	public List<ProductVo> whiskyList();
	public List<ProductVo> beerList();
	public List<ProductVo> traditionalList();

}
