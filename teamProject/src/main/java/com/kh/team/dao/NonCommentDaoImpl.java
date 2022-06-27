package com.kh.team.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.team.vo.NonCommentVo;
@Repository
public class NonCommentDaoImpl implements NonCommentDao{
	
	private final String NAMESPACE="com.kh.team.non_comment.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean nonCommentInsert(NonCommentVo nonCommentVo) {
		// TODO Auto-generated method stub
		int result = sqlSession.insert(NAMESPACE+"commentInsert",nonCommentVo);
		if(result>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<NonCommentVo> nonCommentSelect(int bno) {
		// TODO Auto-generated method stub
		List<NonCommentVo> list= sqlSession.selectList(NAMESPACE+"commentSelect",bno);
		return list;
	}

	@Override
	public boolean nonCommentUpdate(NonCommentVo nonCommentVo) {
		// TODO Auto-generated method stub
		int result = sqlSession.update(NAMESPACE+"commentUpdate",nonCommentVo);
		if(result>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean nonCommentDelete(int cno) {
		// TODO Auto-generated method stub
		int result = sqlSession.delete(NAMESPACE+"commentDelete",cno);
		if(result>0) {
			return true;
		}
		return false;
	}
	
}
