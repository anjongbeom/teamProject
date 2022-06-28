package com.kh.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.team.dao.MemberDao;
import com.kh.team.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	
	// 회원 가입
	@Override
	public void insertMember(MemberVo memberVo) {
		memberDao.insertMember(memberVo);
	}
	
	
	// 로그인 정보 확인
	@Override
	public MemberVo getMemberByIdAndPw(String member_id, String member_pw) {
		MemberVo memberVo = memberDao.getMemberByIdAndPw(member_id, member_pw);
		return memberVo;
	}

	
	// 아이디 중복 체크
	@Override
	public String idOverlap(String member_id) {
		String result = memberDao.idOverlap(member_id);
		return result;
	}
	

}
