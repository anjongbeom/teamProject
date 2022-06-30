package com.kh.team.service;

import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.team.dao.ManagerDao;
import com.kh.team.dao.MemberDao;
import com.kh.team.util.MailSenderUtil;
import com.kh.team.util.SmsSendUtil;
import com.kh.team.vo.OrderVo;
import com.kh.team.vo.OrderedDetailDto;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductVo;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	MailSenderUtil mailSenderUtil;

	@Autowired
	SmsSendUtil smsSendUtil;

	@Autowired
	private ManagerDao managerDao;

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private JavaMailSender mailSender;

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
		int count = managerDao.getCount(pagingDto);
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
	public List<OrderedDetailDto> getOrderedDetailList(int order_no) {
		List<OrderedDetailDto> list = managerDao.getOrderedDetailList(order_no);
		return list;
	}

	
	// 체크한 품목 승인 Dao/
	// List<Map<String,Object>> codes =
	// managerDao.getNumberOfOrderDetailStatusCode(세분화에 필요 <폐기>)
	// getOneOrderedDetail(order_detail_no에 대한 정보 1개 가져오기(ordered_detail) ),
	// orderApproval, updateApprovedDataToSecond, updateApprovedPointForMember
	// getOrderNoByDetailNo, updateOrderStatusCode, getOrderDetailStatusCode
	// getMemberIdByOrderNo(
	@Transactional
	@Override
	public boolean orderApproval(String[] checked_list) {
		for (String order_detail_no : checked_list) { // 체크된 항목들의 detail_no를 배열로 향상된 for
			int parse_order_detail_no = Integer.parseInt(order_detail_no);

			// 테스트 중 (ORDER_STATUS_CODE 세분화(폐기 예정 ^^)를 위해)
//			List<Map<String, Object>> codes 
//				= managerDao.getNumberOfOrderDetailStatusCode(parse_order_detail_no); // parse_order_detail_no로 // 얻기
//			System.out.println("codes: " + codes + order_detail_no);
//			String order_no_num = codes.get(1).get("FK_ORDER_DETAIL_STATUS_CODE").toString();
//			System.out.println("order_no_num: " + order_no_num);

//			int sum_of_fk_order_detail_status_code = 0;
//			for (Map map : codes) {
//				System.out.println("Map > FK_ORDER_DETAIL_STATUS_CODE : " + map.get("FK_ORDER_DETAIL_STATUS_CODE"));
//				sum_of_fk_order_detail_status_code += Integer
//						.parseInt(map.get("FK_ORDER_DETAIL_STATUS_CODE").toString());
//			}
//			System.out.println("sum_of_fk_order_detail_status_code : " + sum_of_fk_order_detail_status_code);

			OrderedDetailDto ordered_detail_dto = 
					managerDao.getOneOrderedDetail(parse_order_detail_no); // ! order_detail_no에 대한 정보 1개 가져오기(ordered_detail_dto)
			System.out.println("ordered_detail: " + ordered_detail_dto); // 확인
			boolean apporoval_result = managerDao.orderApproval(ordered_detail_dto); // ! 주문 상세에서 승인(재고 감소)
			
			System.out.println("apporoval_result: " + apporoval_result);
			if (apporoval_result == true) { // 주문승인 결과가 true일 때
				ordered_detail_dto.setOrder_detail_status_code("2"); //	order_detail_no으로 fk_order_detail_status_code를 2로 변경
				managerDao.updateApprovedDataToSecond(parse_order_detail_no);// ! 해당 ORDER_DETAIL_STATUS_CODE  1 -> 2로
				managerDao.updateApprovedPointForMember(ordered_detail_dto); // ! OrderedDetailDto[]를 넘겨줘서 해당 포인트 차감
				ordered_detail_dto.setOrder_status_code("2"); // mapper에서 사용할 order_no를 set
				managerDao.updateOrderStatusCode(ordered_detail_dto); // ! order_no의 주문 상태 코드(ORDER_STATUS_CODE)를 2로 변경
			}
		}
		// sms 자동 발송
		String first_detail_no = checked_list[0];
		int order_no = managerDao.getOrderNoByDetailNo(Integer.parseInt(first_detail_no)); // detail_no로 order_no 얻기
		String member_id = managerDao.getMemberIdByOrderNo(order_no); // order_no로 member_id 얻기
		System.out.println("order_no : " + order_no);
		System.out.println("member_id : " + member_id);
		String reciever = "01036252375";
		String content = "서비스에서 메서드 형태로 보내기";
//		smsSendUtil.sendSms(reciever, content);

		// 메일 전송
//		mailSenderUtil.sendMail("서비스에서 제목 테스트중", "서비스에서 내용 테스트중", "ajb5209@naver.com");
		
		return true; // 결과 수정 필요!!!!
	}

	// order_no의 주문 상태 코드(ORDER_STATUS_CODE)를 변경
	@Override
	public void updateOrderStatusCode(OrderedDetailDto ordered_detail_dto) {
		System.out.println("ordered_detail_dto " + ordered_detail_dto);
		managerDao.updateOrderStatusCode(ordered_detail_dto);

	}

	// detail_no로 order_no 얻기
	@Override
	public int getOrderNoByDetailNo(int order_detail_no) {
		return 0;
	}

	// order_no로 fk_member_id를 얻기
	@Override
	public String getMemberIdByOrderNo(int order_no) {
		return "";
	}

	// order_no로 member_tel를 얻기
	@Override
	public String getMemberTelByMemberId(int order_no) {
		return null;
	}

	// MailSendUtil 구현
	public void mailSenderUtil(String subject, String content, String to) {

//		String subject = "메일 테스트 제목1 입니다.";
//		String content = "메일 테스트 내용1 입니다." + "<img src=\"/product/displayImage?filename=C:/z_product/Dalmore.jpg\">";
//		String  from = "kerk0214@gmail.com";
//		String  to = "ajb5209@naver.com";

		try {
			MimeMessage mail = mailSender.createMimeMessage();

			MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
			// true는 멀티파트 메세지를 사용하겠다는 의미

			// 빈에 아이디 설정한 것은 단순히 smtp 인증을 받기 위해 사용 따라서 보내는이(setFrom())반드시 필요
			// 보내는이와 메일주소를 수신하는이가 볼때 모두 표기 되게 원하신다면 아래의 코드를 사용하시면 됩니다.
			// mailHelper.setFrom("보내는이 이름 <보내는이 아이디@도메인주소>");
			mailHelper.setFrom("김용현 <kerk0214@gmail.com>");
			mailHelper.setTo(to);
			mailHelper.setSubject(subject);
			mailHelper.setText(content, true);

			mailSender.send(mail);

		} catch (Exception e) {
			e.printStackTrace();
		}

	} // mailSender

	// 반품 요청목록 얻기
	@Override
	public List<OrderedDetailDto> getReturnedList(int order_detail_status_code) {
		List<OrderedDetailDto> return_list = managerDao.getReturnedList(order_detail_status_code);
		return return_list;
	}

	// 반품 승인
	@Override
	public void returnApproval(String[] checked_return_list) {
		for (String order_detail_no : checked_return_list) { // 체크된 항목들의 detail_no를 배열로 향상된 for
			int parse_order_detail_no = Integer.parseInt(order_detail_no); // 체크된 항목의 order_detail_no를 정수형으로 parse
			
			OrderedDetailDto ordered_detail_dto = 
					managerDao.getOrderedDetailByOrderDetailNo(parse_order_detail_no); // order_detail_no로 OrderedDetailDto정보 얻기
			System.out.println("Dto: " + ordered_detail_dto);
			
			// ordered_detail_dto를 넘겨줘서 반품한 member_id, product_id, product_price, product_amount 사용하기 (회원에게 포인트 환급)
			managerDao.updateRefundPointForMember(ordered_detail_dto); // 반품 회원의 포인트 환불
			
//			int order_no = managerDao.getOrderNoByDetailNo(parse_order_detail_no); // ! detail_no로 order_no 얻기
			ordered_detail_dto.setOrder_status_code("6"); // Order_status_code를 6으로 set
			managerDao.updateOrderStatusCode(ordered_detail_dto); // ! order_no의 주문 상태 코드(ORDER_STATUS_CODE) update
			
			
		}
	}

}
