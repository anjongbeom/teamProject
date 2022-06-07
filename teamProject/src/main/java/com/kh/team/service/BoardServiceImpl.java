package com.kh.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.team.dao.BoardDaoImpl;
import com.kh.team.vo.BoardVo;
import com.kh.team.vo.PagingDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDaoImpl boardDao;

	@Override
	public boolean create(BoardVo boardVo) {
		boolean result = boardDao.create(boardVo);
		return result;
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
	
	

}
