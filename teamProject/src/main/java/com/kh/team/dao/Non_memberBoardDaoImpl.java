package com.kh.team.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.team.vo.NonMemberBoardVo;
@Repository
public class Non_memberBoardDaoImpl implements Non_memberBoardDao{
	
	private static final String NAMESPACE="com.kh.team.mappers.nonmemberboard."; 
	
	@Autowired
	SqlSession sqlSession;
	
	
	@Override
	public boolean nonInsertBoardMember(NonMemberBoardVo nonmemberBoardVo) {
		// TODO Auto-generated method stub
		int result =sqlSession.insert(NAMESPACE+"nonInsertBoardMember",nonmemberBoardVo);
		if(result>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<NonMemberBoardVo> nonSelectListBoardMember() {
		// TODO Auto-generated method stub
		List<NonMemberBoardVo> list =sqlSession.selectList(NAMESPACE+"nonSelectListBoardMember");
		return list;
	}

	@Override
	public NonMemberBoardVo nonSelectBoardMember(int bno) {
		// TODO Auto-generated method stub
		NonMemberBoardVo list = sqlSession.selectOne(NAMESPACE+"nonSelectBoardMember",bno);
		return list;
	}

	@Override
	public boolean nonUpdateBoardMember(NonMemberBoardVo nonMemberBoardVo) {
		// TODO Auto-generated method stub
		int result = sqlSession.update(NAMESPACE+"nonUpdateBoardMember",nonMemberBoardVo);
		if(result>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean nonDeleteBoardMember(int bno) {
		// TODO Auto-generated method stub
		int result =sqlSession.delete(NAMESPACE+"nonDeleteBoardMember",bno);
		if(result>0) {
			return true;
		}
		return false;
	}

	@Override
	public NonMemberBoardVo replyForm(int bno) {
		// TODO Auto-generated method stub
		NonMemberBoardVo list= sqlSession.selectOne(NAMESPACE+"nonSelectBoardMember",bno);
		return list;
	}

	@Override
	public boolean replyRun(NonMemberBoardVo nonMemberBoardVo) {
		// TODO Auto-generated method stub
		int result=sqlSession.insert(NAMESPACE+"nonInsertReply",nonMemberBoardVo);
		if(result>0) {
			return true;
		}
		return false;
	}

}
