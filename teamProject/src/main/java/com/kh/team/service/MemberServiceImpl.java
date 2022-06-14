package com.kh.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.team.dao.MemberDao;
import com.kh.team.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public void insertMember(MemberVo memberVo) {
		memberDao.insertMember(memberVo);
	}
	
	@Override
	public MemberVo getMemberByIdAndPw(String member_id, String member_pw) {
		MemberVo memberVo = memberDao.getMemberByIdAndPw(member_id, member_pw);
		return memberVo;
	}
	

}
