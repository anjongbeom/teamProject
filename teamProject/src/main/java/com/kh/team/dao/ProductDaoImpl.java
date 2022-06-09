package com.kh.team.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductVo;

@Repository
public class ProductDaoImpl implements ProductDao {
	private final static String NAMESPACE = "com.kh.team.mappers.product.";
	
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public List<ProductVo> list(PagingDto pagingDto) {
		List<ProductVo> list = sqlSession.selectList(NAMESPACE + "list", pagingDto);
		return list;
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
}
