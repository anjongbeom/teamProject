package com.kh.team.dao;

import java.util.List;
import java.util.Map;

import com.kh.team.vo.MemberVo;
import com.kh.team.vo.MessageToSendVo;
import com.kh.team.vo.OrderVo;
import com.kh.team.vo.OrderedDetailDto;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductVo;

public interface ManagerDao {

	
	public boolean createStock(ProductVo productVo); // 제품 등록 실행
	public List<ProductVo> getStockList(PagingDto pagingDto); // 제품 목록 얻기
	public void stockModifyRun(ProductVo productVo); // 제품 수정 실행
	
	
	public ProductVo getProductInfoById(String product_id); // id로 제품 정보 얻기 
	public int getProductCount(PagingDto pagingDto); // 제품 총개수 얻기
	
	// 주문된 목록, 상세 목록 매니저 확인 페이지
	public List<OrderVo> getOrderedList(int order_status_code); // 주문된 목록
	public List<OrderedDetailDto> getOrderedDetailList(int order_no); // 주문된 상세 목록 얻기
	
	// 체크된 품목들 주문 승인하기
	public OrderedDetailDto getOneOrderedDetail(int order_detail_no); // 주문된 하나의 상세 품목 얻기
	public boolean orderApproval(OrderedDetailDto ordered_detail_dto); // 체크한 품목 승인(재고 감소)
	public boolean updateApprovedDataToSecond(int order_detail_no); // 승인된 컬럼 데이터(fk_order_detail_status_code) 2로 변경 
	public void updateApprovedPointForMember(OrderedDetailDto ordered_detail_dto); // OrderedDtailDto[]를 넘겨줘서 해당 포인트 차감
	public List<Map<String,Object>> getNumberOfOrderDetailStatusCode(int order_detail_no); // 주문 안의 주문상세 상태코드 얻기
	
	public void updateOrderStatusCode(OrderedDetailDto ordered_detail_dto); // order_no의 주문 상태 코드(ORDER_STATUS_CODE)를 변경
	public void updateOrderDetailStatusCode(OrderedDetailDto ordered_detail_dto); // order_detail_no의 주문 상태 코드(ORDER_Detail_STATUS_CODE)를 변경
	
	// ~로 ~얻기
	public int getOrderNoByDetailNo(int order_detail_no); // detail_no로 order_no 얻기
	public String getMemberIdByOrderNo(int order_no); // order_no로 fk_member_id를 얻기
	public String getMemberTelByMemberId(int order_no); //	order_no로  member_tel를 얻기
	public MemberVo getMemberVoById(String member_id); // member_id로 MemberVo 얻기
	public List<MessageToSendVo> getMessageToSendVo(); // MessageToSendVo 리스트 얻기
	
	
	// 체크된 품목들 반품 승인하기
	public List<OrderedDetailDto> getReturnedList(int order_detail_status_code); // 반품 요청목록 얻기
	public boolean orderRefund(OrderedDetailDto ordered_detail_dto); // 반품 승인 (재고 증가)
	boolean updateApprovedDataToSixth(int order_detail_no); // 반품 승인된 컬럼 데이터(fk_order_detail_status_code) 6으로 변경 
	public OrderedDetailDto getOrderedDetailByOrderDetailNo(int order_detail_no); // order_detail_no로 OrderedDetailDto 정보 얻기
	public void updateRefundPointForMember(OrderedDetailDto ordered_detail_dto); // 반품 회원의 포인트 환불
	
	
	// 멤버 등록
	public boolean createMember(MemberVo memberVo); // 멤버 등록
	public MemberVo getMemberInfoById(String member_id); // 멤버 정보 얻기
	
	// 멤버 리스트
	public List<MemberVo> getMemberList(PagingDto pagingDto); // 재고 총 개수 얻기(paging에 필요)
	public int getMemberCount(PagingDto pagingDto); // 멤버 개수 얻기
	
	
}
