package com.kh.team.dao;

import java.util.List;

import com.kh.team.vo.OrderVo;
import com.kh.team.vo.OrderedDtailDto;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductVo;

public interface ManagerDao {

	
	public boolean createStock(); // 재고 등록
	public List<ProductVo> getStockList(PagingDto pagingDto); // 재고 총 개수 얻기(paging에 필요)
	public int getCount(PagingDto pagingDto); // 테스트용 get
	
	// 주문된 목록, 상세 목록 매니저 확인 페이지
	public List<OrderVo> getOrderedList(); // 주문된 목록
	public List<OrderedDtailDto> getOrderedDetailList(int order_no); // 주문된 상세 목록 얻기
	
	// 체크된 품목들 승인하기
	public OrderedDtailDto getOneOrderedDetail(int order_detail_no); // 주문된 하나의 상세 품목 얻기
	public boolean orderApproval(OrderedDtailDto ordered_detail); // 체크한 품목 승인
	public boolean deleteApprovedData(int order_detail_no); // 승인된 주문상세 정보 삭제
	
	
}
