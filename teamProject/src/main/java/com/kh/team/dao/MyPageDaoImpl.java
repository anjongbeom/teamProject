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
public class MyPageDaoImpl implements MyPageDao{
	private final String NAMESPACE = "com.kh.team.mappers.myPage.";

	@Autowired
	private SqlSession sqlSession;
	
	
	// 주문된 상세 목록
	@Override
	public List<OrderedDetailDto> getOrderedDetailList(String member_id) {
		System.out.println("MyPageDaoImpl, getOrderedDetailList, member_id : " + member_id);
		List<OrderedDetailDto> list = sqlSession.selectList(NAMESPACE + "getOrderedDetailList", member_id);
		return list;
	}
	
	
	// ajax 반품신청
	@Override
	public boolean requestReturn(int order_detail_no) {
//		HashMap<String, Object> map = new HashMap<>();
//		map.put("order_detail_no", order_detail_no);
//		System.out.println("MyPageDaoImpl, requestReturn, order_detail_no" + map);
		System.out.println("MyPageDaoImpl, requestReturn, order_detail_no : " + order_detail_no);
		int count = sqlSession.update(NAMESPACE + "requestReturn", order_detail_no);
		if (count > 0) {
			return true;
		}
		return false;
	}


	@Override
	public boolean createStock(ProductVo productVo) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<ProductVo> getStockList(PagingDto pagingDto) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void stockModifyRun(ProductVo productVo) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ProductVo getProductInfoById(String product_id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getProductCount(PagingDto pagingDto) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<OrderVo> getOrderedList(int order_status_code) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public OrderedDetailDto getOneOrderedDetail(int order_detail_no) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean orderApproval(OrderedDetailDto ordered_detail_dto) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean updateApprovedDataToSecond(int order_detail_no) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void updateApprovedPointForMember(OrderedDetailDto ordered_detail_dto) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Map<String, Object>> getNumberOfOrderDetailStatusCode(int order_detail_no) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void updateOrderStatusCode(OrderedDetailDto ordered_detail_dto) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateOrderDetailStatusCode(OrderedDetailDto ordered_detail_dto) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int getOrderNoByDetailNo(int order_detail_no) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String getMemberIdByOrderNo(int order_no) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getMemberTelByMemberId(int order_no) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public MemberVo getMemberVoById(String member_id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<MessageToSendVo> getMessageToSendVo() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<OrderedDetailDto> getReturnedList(int order_detail_status_code) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean orderRefund(OrderedDetailDto ordered_detail_dto) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean updateApprovedDataToSixth(int order_detail_no) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public OrderedDetailDto getOrderedDetailByOrderDetailNo(int order_detail_no) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void updateRefundPointForMember(OrderedDetailDto ordered_detail_dto) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean createMember(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public MemberVo getMemberInfoById(String member_id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean memberModify(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<MemberVo> getMemberList(PagingDto pagingDto) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getMemberCount(PagingDto pagingDto) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
	// 삭제 예정
	
	
	
	
	
}
