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
	
	public List<OrderVo> getOrderedList(int order_status_code); // 주문된 목록
	public List<OrderedDtailDto> getOrderedDetailList(int order_no); // 주문된 상세 목록
	public boolean orderApproval(String[] checked_list); // 체크한 품목 승인
//	public String getOrderDetailStatusCode(int order_no); // 주문 안의 주문상세 상태코드 얻기
	
	public void updateOrderStatusCode(int order_no); // order_no의 주문 상태 코드(ORDER_STATUS_CODE)를 변경
	
	public int getOrderNoByDetailNo(int order_detail_no); // detail_no로 order_no 얻기
	
}
