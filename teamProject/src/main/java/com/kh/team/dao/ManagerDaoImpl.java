package com.kh.team.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.team.vo.MemberVo;
import com.kh.team.vo.MessageToSendVo;
import com.kh.team.vo.OrderVo;
import com.kh.team.vo.OrderedDetailDto;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductVo;

@Repository
public class ManagerDaoImpl implements ManagerDao{
	private final String NAMESPACE = "com.kh.team.mappers.manager.";

	@Autowired
	private SqlSession sqlSession;
	
	
	// 제품 등록 실행
	@Override
	public boolean createStock(ProductVo productVo) {
		int insert_count = sqlSession.insert(NAMESPACE + "createStock", productVo);
		if (insert_count > 0) {
			return true;
		}
		return false;
	}

	// 제품 목록 얻기
	@Override
	public List<ProductVo> getStockList(PagingDto pagingDto) {
		System.out.println("pagingDto: " + pagingDto);
		List<ProductVo> list = sqlSession.selectList(NAMESPACE + "getStockList", pagingDto);
		return list;
	}

	
	// 제품 개수 얻기
	@Override
	public int getProductCount(PagingDto pagingDto) {
		int count = sqlSession.selectOne(NAMESPACE + "getProductCount", pagingDto);
		return count;
	}

	// 주문된 목록 
	@Override
	public List<OrderVo> getOrderedList(int order_status_code) {
		List<OrderVo> list = sqlSession.selectList(NAMESPACE + "getOrderedList", order_status_code);
		return list;
	}
	
	// 주문된 상세 목록
	@Override
	public List<OrderedDetailDto> getOrderedDetailList(int order_no) {
		List<OrderedDetailDto> list = sqlSession.selectList(NAMESPACE + "getOrderedDetailList", order_no);
		return list;
	}
	
	
	
	
	// 체크한 상세 품목얻기 by order_detail_no
	@Override
	public OrderedDetailDto getOneOrderedDetail(int order_detail_no) {
		OrderedDetailDto list = sqlSession.selectOne(NAMESPACE + "getOneOrderedDetail", order_detail_no);
		return list;
	}
	

	// 주문 승인(해당품목 재고감소)
	@Override
	public boolean orderApproval(OrderedDetailDto ordered_detail_dto) {
		int approval_result = sqlSession.update(NAMESPACE + "orderApproval", ordered_detail_dto);
		if (approval_result > 0) {
			return true;
		}
		return false;
	}
	
	// 승인된 컬럼 데이터(fk_order_detail_status_code) 2로 변경 
	@Override
	public boolean updateApprovedDataToSecond(int order_detail_no) {
		int delete_approval_data_result = sqlSession.update(NAMESPACE + "updateApprovedDataToSecond", order_detail_no);
		if (delete_approval_data_result > 0) {
			return true;
		}
		return false;
	}

	// 주문자의 포인트 차감
	@Override
	public void updateApprovedPointForMember(OrderedDetailDto ordered_detail_dto) {
		sqlSession.update(NAMESPACE + "updateApprovedPointForMember", ordered_detail_dto);
	}
	
	
	
	
	// 주문안의 주문상세 상태코드들 얻기 
	@Override
	public List<Map<String,Object>> getNumberOfOrderDetailStatusCode(int order_detail_no) {
		List<Map<String,Object>> result = sqlSession.selectList(NAMESPACE + "getNumberOfOrderDetailStatusCode", order_detail_no);
		return result;
	}
	
	
	// order_no의 주문 상태 코드(ORDER_STATUS_CODE)를 변경 (서비스에서 ORDER_STATUS_CODE를 set)
	public void updateOrderStatusCode(OrderedDetailDto ordered_detail_dto) {
		System.out.println("updateOrderStatusCode, ordered_detail_dto : " + ordered_detail_dto);
		sqlSession.update(NAMESPACE + "updateOrderStatusCode", ordered_detail_dto);
	}
	
	// order_detail_no의 주문 상태 코드(ORDER_DETAIL_STATUS_CODE)를 변경 (서비스에서 ORDER_DETAIL_STATUS_CODE를 set)
	public void updateOrderDetailStatusCode(OrderedDetailDto ordered_detail_dto) {
		System.out.println("updateOrderDetailStatusCode, ordered_detail_dto : " + ordered_detail_dto);
		sqlSession.update(NAMESPACE + "updateOrderDetailStatusCode", ordered_detail_dto);
	}
	
	
	
	
	// detail_no로 order_no 얻기
	public int getOrderNoByDetailNo(int order_detail_no) {
		int result = sqlSession.selectOne(NAMESPACE + "getOrderNoByDetailNo", order_detail_no);
		return result;
	}
	
	// order_no로 fk_member_id를 얻기
	public String getMemberIdByOrderNo(int order_no) {
		String result = sqlSession.selectOne(NAMESPACE + "getMemberIdByOrderNo", order_no);
		return result;
	}
	
	
	// order_no로  member_tel를 얻기 
	public String getMemberTelByMemberId(int order_no) {
		String result = sqlSession.selectOne(NAMESPACE + "getMemberTelByMemberId", order_no);
		return result;
	}
	
	// 반품 목록 얻기
	@Override
	public List<OrderedDetailDto> getReturnedList(int order_detail_status_code) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("order_detail_status_code", order_detail_status_code);
		List<OrderedDetailDto> return_list = sqlSession.selectList(NAMESPACE + "getReturnedList", order_detail_status_code);
		return return_list;
	}
	
	
	// 반품 승인(해당품목 재고증가)
	@Override
	public boolean orderRefund(OrderedDetailDto ordered_detail_dto) {
		int refund_result = sqlSession.update(NAMESPACE + "orderRefund", ordered_detail_dto);
		if (refund_result > 0) {
			return true;
		}
		return false;
	}
	
	// 반품 승인된 컬럼 데이터(fk_order_detail_status_code) 6으로 변경 
	@Override
	public boolean updateApprovedDataToSixth(int order_detail_no) {
		int delete_approval_data_result = sqlSession.update(NAMESPACE + "updateApprovedDataToSixth", order_detail_no);
		if (delete_approval_data_result > 0) {
			return true;
		}
		return false;
	}
	
	
	// order_detail_no로 OrderedDetailDto 정보 얻기
	@Override
	public OrderedDetailDto getOrderedDetailByOrderDetailNo(int order_detail_no) {
		
		// int -> map
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("map_order_detail_no", order_detail_no);
		OrderedDetailDto orderedDetailDto = sqlSession.selectOne(NAMESPACE + "getOrderedDetailByOrderDetailNo", map);
		return orderedDetailDto;
	}
	
	// 반품 회원의 포인트 환불
	@Override
	public void updateRefundPointForMember(OrderedDetailDto ordered_detail_dto) {
		Map<String, Object> map = new HashMap<String, Object>();
//		int test_num = 10;
//		map.put("test_num", test_num);
		map.put("ordered_detail_dto", ordered_detail_dto);
		
		sqlSession.update(NAMESPACE + "updateRefundPointForMember", ordered_detail_dto);
	}

	// member_id로 Vo얻기
	@Override
	public MemberVo getMemberVoById(String member_id) {
		MemberVo memberVo = sqlSession.selectOne(NAMESPACE + "getMemberVoById", member_id);
		return memberVo;
	}
	
	// MessageToSendVo 리스트 얻기
	@Override
	public List<MessageToSendVo> getMessageToSendVo() {
		List<MessageToSendVo> messageToSendVo = sqlSession.selectList(NAMESPACE + "getMessageToSendVo");
		return messageToSendVo;
	}
	
	
	// 멤버 목록 얻기
	@Override
	public List<MemberVo> getMemberList(PagingDto pagingDto) {
		List<MemberVo> member_list = sqlSession.selectList(NAMESPACE + "getMemberList", pagingDto);
		return member_list;
	}
	
	// 제품 개수 얻기
	@Override
	public int getMemberCount(PagingDto pagingDto) {
		int count = sqlSession.selectOne(NAMESPACE + "getMemberCount", pagingDto);
		return count;
	}
	
	
	
}
