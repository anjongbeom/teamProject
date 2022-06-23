package com.kh.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.team.dao.ManagerDao;
import com.kh.team.vo.MemberVo;
import com.kh.team.vo.OrderVo;
import com.kh.team.vo.OrderedDtailDto;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductVo;

@Service
public class ManagerServiceImpl implements ManagerService {
	
	
	@Autowired
	private ManagerDao managerDao;
	


	@Override
	public boolean createStock() {
		boolean result = managerDao.createStock();
		return result;
	}

	@Override
	public List<ProductVo> getStockList(PagingDto pagingDto) {
		List<ProductVo> result = managerDao.getStockList(pagingDto);
		return result;
	}

	@Override
	public int getCount(PagingDto pagingDto) {
		int count =  managerDao.getCount(pagingDto);
		return count;
	}
	
	// 주문된 목록
	@Override
	public List<OrderVo> getOrderedList() {
		List<OrderVo> result = managerDao.getOrderedList();
		return result;
	}
		
	// 주문된 상세 목록
	@Override
	public List<OrderedDtailDto> getOrderedDetailList(int order_no) {
		List<OrderedDtailDto> list = managerDao.getOrderedDetailList(order_no);
		return list;
	}
	
	
	// 체크한 품목 승인 / getOneOrderedDetail, orderApproval, deleteApprovedData
	@Override
	public boolean orderApproval(String[] checked_list) {
		for (String order_detail_no : checked_list) { // 체크된 항목들의 detail_no를 배열로 향상된 for
			int parse_order_detail_no = Integer.parseInt(order_detail_no);
			OrderedDtailDto ordered_detail = 
					managerDao.getOneOrderedDetail(parse_order_detail_no); // order_detail_no에 대한 정보 1개 가져오기(ordered_detail)
			System.out.println("ordered_detail: " + ordered_detail); // 얻어낸 하나의 요청 확인
			boolean apporoval_result = managerDao.orderApproval(ordered_detail); // 주문 상세에서 승인(재고 감소)
			
			boolean update_result = false;
			boolean Overall_result = false;
			System.out.println("apporoval_result: " + apporoval_result);
			if (apporoval_result == true) { // 주문승인 결과가 true일 때 해당 ORDER_DETAIL_STATUS_CODE 가 1 -> 2로 
				update_result = managerDao.updateApprovedDataToSecond(parse_order_detail_no);
			}
			
			if (apporoval_result && update_result) {
				Overall_result = true;
			}
		}
		
		return true; // 결과 수정 필요!!!!
	}

}
