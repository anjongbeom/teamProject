package com.kh.team.service;

import java.util.List;

import com.kh.team.vo.ProductVo;

public interface ProductService {
	
	public List<ProductVo> list(); // �ַ� ��� (Read)
	public List<ProductVo> brandyList();
	public List<ProductVo> whiskyList();
	public List<ProductVo> beerList();
	public List<ProductVo> traditionalList();
	
}
