package com.kh.team.dao;

import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.team.vo.MemberVo;


@Repository
public class MemberDaoImpl implements MemberDao{
	private final String NAMESPACE = "com.kh.team.mappers.member.";
			
	
	@Autowired //@Inject
	private SqlSession sqlSession;
	
	
	@Override
	public void insertMember(MemberVo memberVo) {
		sqlSession.insert(NAMESPACE + "insertMember", memberVo);
	}

}
