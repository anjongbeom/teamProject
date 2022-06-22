package com.kh.team.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.team.vo.OrderVo;
import com.kh.team.vo.OrderedDtailDto;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductVo;

@Repository
public class ManagerDaoImpl implements ManagerDao{
	private final String NAMESPACE = "com.kh.team.mappers.manager.";

	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public boolean createStock() {
		return false;
	}

	@Override
	public List<ProductVo> getStockList(PagingDto pagingDto) {
		List<ProductVo> list = sqlSession.selectList(NAMESPACE + "getStockList", pagingDto);
		return list;
	}

	
	@Override
	public int getCount(PagingDto pagingDto) {
		int count = sqlSession.selectOne(NAMESPACE + "getCount", pagingDto);
		return count;
	}

	// 주문된 목록 
	@Override
	public List<OrderVo> getOrderedList() {
		List<OrderVo> list = sqlSession.selectList(NAMESPACE + "getOrderedList");
		return list;
	}
	
	// 주문된 상세 목록
	@Override
	public List<OrderedDtailDto> getOrderedDetailList(int order_no) {
		List<OrderedDtailDto> list = sqlSession.selectList(NAMESPACE + "getOrderedDetailList", order_no);
		return list;
	}
	
	
	
	
	// 체크한 상세 품목얻기 by order_detail_no
	@Override
	public OrderedDtailDto getOneOrderedDetail(int order_detail_no) {
		OrderedDtailDto list = sqlSession.selectOne(NAMESPACE + "getOneOrderedDetail", order_detail_no);
		return list;
	}
	

	// 주문 승인(해당품목 재고감소)
	@Override
	public boolean orderApproval(OrderedDtailDto ordered_detail) {
		int approval_result = sqlSession.update(NAMESPACE + "orderApproval", ordered_detail);
		if (approval_result > 0) {
			return true;
		}
		return false;
	}
	
	// 승인된 주문상세 정보 삭제
	@Override
	public boolean deleteApprovedData(int order_detail_no) {
		int delete_approval_data_result = sqlSession.update(NAMESPACE + "deleteApprovedData", order_detail_no);
		if (delete_approval_data_result > 0) {
			return true;
		}
		return false;
	}
	
}
