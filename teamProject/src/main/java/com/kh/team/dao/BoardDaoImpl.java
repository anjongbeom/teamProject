package com.kh.team.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.team.vo.BoardVo;
import com.kh.team.vo.PagingDto;

@Repository
public class BoardDaoImpl implements BoardDao{
	private final static String NAMESPACE = "com.kh.team.mappers.board.";
	
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public boolean create(BoardVo boardVo) {
		int count = sqlSession.insert(NAMESPACE + "create", boardVo);
		if (count > 0) {
			return true;
		}
		return false;
	}

	
	@Override
	public BoardVo read(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int bno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BoardVo> list(PagingDto pagingDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount(PagingDto pagingDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean insertReply(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateRESeq(BoardVo boardVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateViewCnt(int bno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNextBno() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertAttach(String filename, int bno) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
