package com.kh.team.dao;

import com.kh.team.vo.MemberVo;

public interface MemberDao {
	
	public void insertMember(MemberVo memberVo); // 회원가입
	public MemberVo getMemberByIdAndPw(String member_id, String member_pw);  // 로그인 정보 확인
	public String idOverlap(String member_id); // 아이디 중복 체크
	
	
}
