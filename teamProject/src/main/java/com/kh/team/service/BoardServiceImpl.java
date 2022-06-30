package com.kh.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.team.dao.BoardDao;
import com.kh.team.dao.BoardDaoImpl;
import com.kh.team.vo.BoardVo;
import com.kh.team.vo.PagingDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public boolean create(BoardVo boardVo) {
		// tbl_board(bno) <- ref: tbl_attach(bno)
		int bno = boardDao.getNextBno();
		System.out.println("BoardServiceImpl, create, bno: " + bno);
		boardVo.setBno(bno);
		System.out.println("BoardServiceImpl, create, boardVo: " + boardVo); // file자체가 안넘어오네요
		boolean result = boardDao.create(boardVo); // tbl_board
		String[] files = boardVo.getFiles();
		if (files != null && files.length != 0) {
			for(String filename : files) {
				System.out.println("BoardServiceImpl, create, filename: " + filename);
				boardDao.insertAttach(filename, bno); // tbl_attach
			}
		}
		
		return result;
	}

	@Override
	public BoardVo read(int bno) {
		boardDao.updateViewCnt(bno);
		BoardVo boardVo = boardDao.read(bno);
		return boardVo;
	}

	@Override
	public boolean update(BoardVo boardVo) {
		boolean result = boardDao.update(boardVo);
		return result;
	}

	@Override
	public boolean delete(int bno) {
		boolean result = boardDao.delete(bno);
		return result;
	}

	@Override
	public List<BoardVo> list(PagingDto pagingDto) {
		List<BoardVo> list = boardDao.list(pagingDto);
		return list;
	}

	@Override
	public int getCount(PagingDto paginDto) {
		int count = boardDao.getCount(paginDto);
		return count;
	}

	@Override
	@Transactional
	public boolean insertReply(BoardVo boardVo) {
		boardDao.updateReSeq(boardVo);
		boolean result = boardDao.insertReply(boardVo);
		return result;
	}
	
	

}
