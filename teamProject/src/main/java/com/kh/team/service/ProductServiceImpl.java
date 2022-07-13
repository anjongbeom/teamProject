package com.kh.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.team.dao.ProductDao;
import com.kh.team.vo.CartVo;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductCate;
import com.kh.team.vo.ProductVo;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public List<ProductVo> list(PagingDto pagingDto, String cate_code) {
		List<ProductVo> list = productDao.list(pagingDto, cate_code);
		return list;
	}
	
	@Override
	public ProductVo detail(String product_id) {
		ProductVo productVo = productDao.detail(product_id);
		return productVo;
	}
	

	@Override
	public ProductVo basket(String product_id) {
		ProductVo productVo = productDao.basket(product_id);
		return productVo;
	}
	
	
	@Override
	public ProductVo read(String product_id) {
		ProductVo productVo = productDao.read(product_id);
		return productVo;
	}

	@Override
	public List<ProductCate> cateList() {
		List<ProductCate> cateList = productDao.cateList();
		return cateList;
	}

	@Override
	public boolean addCart(CartVo cartVo) {
		return productDao.addCart(cartVo);
	}

	@Override
	public void deleteCart(String str) throws Exception {
		System.out.println("발자취 서비스 cartDto:" + str);
		productDao.deleteCart(str);
	}

	@Override
	public void insertOrder(String member_id) throws Exception {
		System.out.println("발자취 서비스 cartDto:" + member_id);
		productDao.insertOrder(member_id);
	}

	@Override
	public boolean insertOrderDetail(String product_id, int product_count) throws Exception {
			return productDao.insertOrderDetail(product_id, product_count);
	}
	
	@Transactional
	@Override
	public boolean transInsertOrder(String product_id, int product_count, String member_id) {
//		System.out.println("transInsertOrder, member_id: " + member_id);
		try {
			productDao.insertOrder(member_id);
			productDao.insertOrderDetail(product_id, product_count);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
