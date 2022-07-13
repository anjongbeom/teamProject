package com.kh.team.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.team.vo.CartVo;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductCate;
import com.kh.team.vo.ProductVo;

@Repository
public class ProductDaoImpl implements ProductDao {
	private final static String NAMESPACE = "com.kh.team.mappers.product.";
	
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public List<ProductVo> list(PagingDto pagingDto, String cate_code) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("pagingDto", pagingDto);
		paramMap.put("cate_code", cate_code);
		List<ProductVo> list = sqlSession.selectList(NAMESPACE + "list", paramMap);
		return list;
	}
	
	@Override
	public ProductVo detail(String product_id) {
		ProductVo productVo = sqlSession.selectOne(NAMESPACE + "detail", product_id);
		return productVo;
	}
	

	@Override
	public List<ProductVo> brandyList() {
		List<ProductVo> brandyList = sqlSession.selectList(NAMESPACE + "brandyList");
		return brandyList;
	}


	@Override
	public List<ProductVo> whiskyList() {
		List<ProductVo> whiskyList = sqlSession.selectList(NAMESPACE + "whiskyList");
		return whiskyList;
	}


	@Override
	public List<ProductVo> beerList() {
		List<ProductVo> beerList = sqlSession.selectList(NAMESPACE + "beerList");
		return beerList;
	}


	@Override
	public List<ProductVo> traditionalList() {
		List<ProductVo> traditionalList = sqlSession.selectList(NAMESPACE + "traditionalList");
		return traditionalList;
	}

	@Override
	public ProductVo basket(String product_id) {
		ProductVo productVo = sqlSession.selectOne(NAMESPACE + "basket", product_id);
		return productVo;
	}

	@Override
	public ProductVo read(String product_id) {
		ProductVo productVo = sqlSession.selectOne(NAMESPACE + "read", product_id);
		return productVo;
	}

	@Override
	public List<ProductCate> cateList() {
		List<ProductCate> cateList = sqlSession.selectList(NAMESPACE + "cateList");
		return cateList;
	}

	@Override
	public boolean addCart(CartVo cartVo) {
		int num = sqlSession.insert(NAMESPACE + "addCart", cartVo);
		if (num > 0) {
			return true;
		}
		return false;
	}

	@Override
	public void deleteCart(String str) throws Exception {
		sqlSession.delete(NAMESPACE+"deleteCart", str);
		
	}

	@Override
	public void insertOrder(String member_id) throws Exception {
		sqlSession.insert(NAMESPACE+"insertOrder", member_id);
		
	}

	@Override
	public boolean insertOrderDetail(String product_id,int product_count) throws Exception {
		Map<String, Object> parameter =new HashMap<>();
		parameter.put("product_id", product_id);
		parameter.put("product_count", product_count);
		int count=sqlSession.insert(NAMESPACE+"insertOrderDetail", parameter);
		if(count>0) {
			return true;
		}
		return false;
		
	}
}
