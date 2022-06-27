package com.kh.team.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<OrderVo> getOrderedList(int order_status_code) {
		List<OrderVo> list = sqlSession.selectList(NAMESPACE + "getOrderedList", order_status_code);
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
	public void updateApprovedPointForMember(OrderedDtailDto ordered_detail) {
		sqlSession.update(NAMESPACE + "updateApprovedPointForMember", ordered_detail);
	}
	
	
	
	
	// 주문안의 주문상세 상태코드들 얻기 
	@Override
	public List<Map<String,Object>> getNumberOfOrderDetailStatusCode(int order_detail_no) {
		List<Map<String,Object>> result = sqlSession.selectList(NAMESPACE + "getNumberOfOrderDetailStatusCode", order_detail_no);
		return result;
	}
	
	
//	order_no의 주문 상태 코드(ORDER_STATUS_CODE)를 변경
	public void updateOrderStatusCode(int order_no) {
		System.out.println("order_no : " + order_no);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("order_no", order_no);
		sqlSession.update(NAMESPACE + "updateOrderStatusCode", map);
		
	}
	
	// detail_no로 order_no 얻기
	public int getOrderNoByDetailNo(int order_detail_no) {
		int result = sqlSession.selectOne(NAMESPACE + "getOrderNoByDetailNo", order_detail_no);
		return result;
	}
	
//	order_no로 fk_member_id를 얻기
	public String getMemberIdByOrderNo(int order_no) {
		String result = sqlSession.selectOne(NAMESPACE + "getMemberIdByOrderNo", order_no);
		return result;
	}
	
	
//	order_no로  member_tel를 얻기 
	public String getMemberTelByMemberId(int order_no) {
		String result = sqlSession.selectOne(NAMESPACE + "getMemberTelByMemberId", order_no);
		return result;
	}
	
	
}
