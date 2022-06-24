package com.kh.team.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<OrderVo> getOrderedList(int order_status_code) {
		List<OrderVo> result = managerDao.getOrderedList(order_status_code);
		return result;
	}
		
	// 주문된 상세 목록
	@Override
	public List<OrderedDtailDto> getOrderedDetailList(int order_no) {
		List<OrderedDtailDto> list = managerDao.getOrderedDetailList(order_no);
		return list;
	}
	
	
	// 체크한 품목 승인 Dao/ 
	// getNumberOfOrderDetailStatusCode, getOneOrderedDetail, 
	// orderApproval, updateApprovedDataToSecond, updateApprovedPointForMember
	@Override
	public boolean orderApproval(String[] checked_list) {

		for (String order_detail_no : checked_list) { // 체크된 항목들의 detail_no를 배열로 향상된 for
			int parse_order_detail_no = Integer.parseInt(order_detail_no);
			
			// 테스트 중 (ORDER_STATUS_CODE 세분화(폐기 예정 ^^)를 위해) 
			List<Map<String,Object>> codes = managerDao.getNumberOfOrderDetailStatusCode(parse_order_detail_no); // parse_order_detail_no로 주문안에 상세상태코드들 얻기
//			System.out.println("codes: " + codes + order_detail_no);
//			String order_no_num = codes.get(1).get("FK_ORDER_DETAIL_STATUS_CODE").toString();
//			System.out.println("order_no_num: " + order_no_num);
			
			int sum_of_fk_order_detail_status_code = 0; 
			for(Map map : codes) {
				System.out.println("Map > FK_ORDER_DETAIL_STATUS_CODE : " + map.get("FK_ORDER_DETAIL_STATUS_CODE"));
				sum_of_fk_order_detail_status_code += Integer.parseInt(map.get("FK_ORDER_DETAIL_STATUS_CODE").toString());
			}
			System.out.println("sum_of_fk_order_detail_status_code : " + sum_of_fk_order_detail_status_code);
			
//			if (sum_of_fk_order_detail_status_code > 1) { // 1보다 크면 승인대기 이후 상태 FK_ORDER_STATUS_CODE: 2: 승인 완료 로 변경
//			} else {
//			}
			// !!! int sum_of_fk_order_detail_status_code = 0; 가 1보다 크면 혼재 상태로 FK_ORDER_STATUS_CODE: 2: 승인 완료 로 변경
			
			OrderedDtailDto ordered_detail = 
					managerDao.getOneOrderedDetail(parse_order_detail_no); // order_detail_no에 대한 정보 1개 가져오기(ordered_detail)
			System.out.println("ordered_detail: " + ordered_detail); // 확인
			boolean apporoval_result = managerDao.orderApproval(ordered_detail); // 주문 상세에서 승인(재고 감소)
			
			boolean update_result = false;
			boolean Overall_result = false;
			System.out.println("apporoval_result: " + apporoval_result);
			if (apporoval_result == true) { // 주문승인 결과가 true일 때
				update_result = 
						managerDao.updateApprovedDataToSecond(parse_order_detail_no);// 해당 ORDER_DETAIL_STATUS_CODE 1 -> 2로 
				managerDao.updateApprovedPointForMember(ordered_detail); // OrderedDtailDto[]를 넘겨줘서 해당 포인트 차감
				// FK_ORDER_STATUS_CODE가 1 -> 3(부분) or 1 -> 4(전체 발송완료)
				// ORDER_DETAIL_STATUS_CODE가 1인 것을 (order_no)로 조회해서 없으면 
				
				int order_no = managerDao.getOrderNoByDetailNo(parse_order_detail_no);
				System.out.println("orderApproval, order_no : " + order_no);
				managerDao.updateOrderStatusCode(order_no);
				
				
//				String codes = managerDao.getOrderDetailStatusCode(parse_order_detail_no); // parse_order_detail_no로 주문안에 상세상태코드들 얻기
//				System.out.println();
			}
			
			if (apporoval_result && update_result) {
				Overall_result = true;
			}

		}
		return true; // 결과 수정 필요!!!!
	}
		
	
	// order_no의 주문 상태 코드(ORDER_STATUS_CODE)를 변경
	@Override
	public void updateOrderStatusCode(int order_no) {
		System.out.println("order no service "+order_no);
		managerDao.updateOrderStatusCode(order_no);
		
	}

	
	// detail_no로 order_no 얻기
	@Override
	public int getOrderNoByDetailNo(int order_detail_no) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	
}
