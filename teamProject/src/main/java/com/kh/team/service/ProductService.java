package com.kh.team.service;

import java.util.List;

import com.kh.team.vo.CartVo;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductCate;
import com.kh.team.vo.ProductVo;

public interface ProductService {
	
	public List<ProductVo> list(PagingDto pagingDto, String cate_code);
	public ProductVo detail(String product_id);
	public ProductVo basket(String product_id);
	public List<ProductCate> cateList();
	
	public ProductVo read(String product_id);
	
	
	public boolean addCart(CartVo cartVo) ;
	
	public void deleteCart(String str) throws Exception;

	public void insertOrder(String member_id) throws Exception;
	
	public boolean insertOrderDetail(String product_id, int product_count) throws Exception;
	
	public boolean transInsertOrder(String product_id, int product_count,String member_id);
}
