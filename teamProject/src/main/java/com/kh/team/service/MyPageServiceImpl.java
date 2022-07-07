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
import com.kh.team.dao.MyPageDao;
import com.kh.team.util.MailSenderUtil;
import com.kh.team.util.SmsSendUtil;
import com.kh.team.vo.MemberVo;
import com.kh.team.vo.MessageToSendVo;
import com.kh.team.vo.OrderVo;
import com.kh.team.vo.OrderedDetailDto;
import com.kh.team.vo.PagingDto;
import com.kh.team.vo.ProductVo;

@Service
public class MyPageServiceImpl implements MyPageService {

	@Autowired
	private MyPageDao myPageDao;
	
	// 주문된 상세 목록
	@Override
	public List<OrderedDetailDto> getOrderedDetailList(String member_id) {
		System.out.println("MyPageServiceImpl, getOrderedDetailList, member_id : " + member_id);
		List<OrderedDetailDto> list = myPageDao.getOrderedDetailList(member_id);
		return list;
	}
	
	// 반품 요청
	@Override
	public boolean requestReturn(int order_detail_no) {
		System.out.println("MyPageServiceImpl, requestReturn, order_detail_no : " + order_detail_no);
		boolean result = myPageDao.requestReturn(order_detail_no);
		return result;
	}
	
	
	
	// 삭제 예정
	
	

}
