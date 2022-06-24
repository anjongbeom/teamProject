package com.kh.team.dao;

import java.util.List;

import com.kh.team.vo.CartVo;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductCate;
import com.kh.team.vo.ProductVo;

public interface ProductDao {
	

	public List<ProductVo> list(PagingDto pagingDto, String cate_code);
	public ProductVo detail(String product_id);
	public ProductVo basket(String product_id);
	public List<ProductCate> cateList();
	
	public List<ProductVo> brandyList();
	public List<ProductVo> whiskyList();
	public List<ProductVo> beerList();
	public List<ProductVo> traditionalList();
	public ProductVo read(String product_id);
	
	
	public boolean addCart(CartVo cartDto) ;
	
	public void deleteCart(String str) throws Exception;

	public void insertOrder(String member_id) throws Exception;
	
	public boolean insertOrderDetail(String product_id, int product_count) throws Exception;
}
