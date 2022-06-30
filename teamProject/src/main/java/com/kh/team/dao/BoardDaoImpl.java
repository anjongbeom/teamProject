package com.kh.team.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		if(count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public BoardVo read(int bno) {
		BoardVo boardVo = sqlSession.selectOne(NAMESPACE + "read", bno);
		return boardVo;
	}

	@Override
	public boolean update(BoardVo boardVo) {
		int count = sqlSession.update(NAMESPACE + "update", boardVo);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int bno) {
		int count = sqlSession.delete(NAMESPACE+"delete",bno);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<BoardVo> list(PagingDto pagingDto) {
		List<BoardVo> list = sqlSession.selectList(
				NAMESPACE + "list", pagingDto);
		return list;
	}

	@Override
	public int getCount(PagingDto paginDto) {
		int count = sqlSession.selectOne(NAMESPACE + "getCount" , paginDto);
		return count;
	}

	@Override
	public boolean insertReply(BoardVo boardVo) {
		int count = sqlSession.insert(NAMESPACE + "insertReply",boardVo);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public void updateReSeq(BoardVo boardVo) {
		sqlSession.update(NAMESPACE + "updateReSeq", boardVo);
		
	}

	@Override
	public void updateViewCnt(int bno) {
		sqlSession.update(NAMESPACE + "updateViewCnt", bno);
		
	}

	@Override
	public int getNextBno() {
		int bno = sqlSession.selectOne(NAMESPACE + "getNextBno");
		System.out.println("getNextBno, bno:" + bno);
		return bno;
	}

	@Override
	public void insertAttach(String filename, int bno) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("filename", filename);
		parameter.put("bno", bno);
		sqlSession.insert(NAMESPACE + "insertAttach", parameter);
	}

	


}
