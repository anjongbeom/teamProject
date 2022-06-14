package com.kh.team.dao;

import com.kh.team.vo.MemberVo;

public interface MemberDao {
	
	public void insertMember(MemberVo memberVo);
	public MemberVo getMemberByIdAndPw(String member_id, String member_pw);
	
	
	
}
