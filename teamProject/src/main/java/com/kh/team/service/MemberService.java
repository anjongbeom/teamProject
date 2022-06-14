package com.kh.team.service;

import com.kh.team.vo.MemberVo;

public interface MemberService {
	
	public void insertMember(MemberVo memberVo);
	public MemberVo getMemberByIdAndPw(String member_id, String member_pw);

}
