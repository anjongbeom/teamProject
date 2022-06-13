package com.kh.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.kh.team.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {
	
//	@Autowired
//	@Qualifier("impl")
//	private MemberDao memberDao;
	
	@Override
	public void insertMember(MemberVo memberVo) {
//		memberDao.insertMember(memberVo);
		
	}

}
