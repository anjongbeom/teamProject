package com.kh.team.service;

import java.util.List;

import com.kh.team.vo.MemberVo;
import com.kh.team.vo.OrderVo;
import com.kh.team.vo.OrderedDtailDto;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductVo;

public interface ManagerService {


	public boolean createStock(); // 재고 등록
	public List<ProductVo> getStockList(PagingDto pagingDto); // 재고 총 개수 얻기(paging에 필요)
	public int getCount(PagingDto pagingDto); // 테스트용 get
	
	public List<OrderVo> getOrderedList(); // 주문된 목록
	public List<OrderedDtailDto> getOrderedDetailList(int order_no); // 주문된 상세 목록
	public boolean orderApproval(String[] checked_list); // 체크한 품목 승인
	
}
