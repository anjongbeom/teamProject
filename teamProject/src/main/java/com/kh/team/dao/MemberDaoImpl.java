package com.kh.team.dao;

import java.util.HashMap;
import java.util.Map;

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
	
	
	@Override
	public MemberVo getMemberByIdAndPw(String member_id, String member_pw) {
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put("member_id", member_id);
		parameter.put("member_pw", member_pw);
		
		MemberVo memberVo = sqlSession.selectOne(NAMESPACE + "getMemberByIdAndPw", parameter);
		return memberVo;
	}

}
