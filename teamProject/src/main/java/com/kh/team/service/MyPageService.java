package com.kh.team.service;

import java.util.List;

import com.kh.team.vo.MemberVo;
import com.kh.team.vo.OrderVo;
import com.kh.team.vo.OrderedDetailDto;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductVo;

public interface MyPageService {
	
	
	public List<OrderedDetailDto> getOrderedDetailList(String member_id); // 주문된 상세 목록 얻기 by member_id
	
	
	
	// 삭제 예정
	
	public boolean createStock(ProductVo productVo); // 제품 등록
	public List<ProductVo> getStockList(PagingDto pagingDto); // 제품 목록 얻기
	public void stockModifyRun(ProductVo productVo); // 제품 수정 실행
	
	public ProductVo getProductInfoById(String product_id); // id로 제품 정보 얻기
	public int getProductCount(PagingDto pagingDto); // 제품 개수 얻기
	
	
	// 주문 승인하기
	public List<OrderVo> getOrderedList(int order_status_code); // 주문된 목록
//	public List<OrderedDetailDto> getOrderedDetailList(int order_no); // 주문된 상세 목록 얻기
	public boolean orderApproval(String[] checked_list); // 체크한 품목 승인
//	public String getOrderDetailStatusCode(int order_no); // 주문 안의 주문상세 상태코드 얻기
	
	public void updateOrderStatusCode(OrderedDetailDto ordered_detail_dto); // order_no의 주문 상태 코드(ORDER_STATUS_CODE)를 변경
	public int getOrderNoByDetailNo(int order_detail_no); // detail_no로 order_no 얻기
	public String getMemberIdByOrderNo(int order_no); // order_no로 fk_member_id를 얻기
	public String getMemberTelByMemberId(int order_no); //	order_no로  member_tel를 얻기
	
	
	// 반품 승인하기
	public List<OrderedDetailDto> getReturnedList(int order_detail_status_code); // 반품 요청목록 얻기
	public void returnApproval(String[] checked_return_list); // 체크한 반품품목 승인
	
	
	// 멤버 등록
	public boolean createMember(MemberVo memberVo); // 멤버 등록
	public MemberVo getMemberInfoById(String member_id); // 멤버 정보 얻기
	public boolean memberModify(MemberVo memberVo); // 멤버 수정 실행
	
	// 멤버 리스트
	public List<MemberVo> getMemberList(PagingDto pagingDto); // 재고 총 개수 얻기(paging에 필요)
	public int getMemberCount(PagingDto pagingDto); // 멤버 개수 얻기
	
	
}
