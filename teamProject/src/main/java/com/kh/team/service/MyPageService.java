package com.kh.team.service;

import java.util.List;

import com.kh.team.vo.MemberVo;
import com.kh.team.vo.OrderVo;
import com.kh.team.vo.OrderedDetailDto;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductVo;

public interface MyPageService {
	
	// 주문 내역 member_id로 얻기
	public List<OrderedDetailDto> getOrderedDetailList(String member_id); // 주문된 상세 목록 얻기 by member_id
	
	

	// 반품 신청하기
	public boolean requestReturn(int order_detail_no); // order_detail_no에 해당하는 상태코드 반품 신청으로 변경
	
	
	
	
	
}
