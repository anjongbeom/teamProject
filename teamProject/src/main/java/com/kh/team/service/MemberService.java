package com.kh.team.service;

import com.kh.team.vo.MemberVo;

public interface MemberService {
	
	public MemberVo getMemberByIdAndPw(String member_id, String member_pw); // 로그인 정보 확인
	public void insertMember(MemberVo memberVo); // 회원 가입
	public String idOverlap(String member_id); // 아이디 중복 체크
	
	

}
