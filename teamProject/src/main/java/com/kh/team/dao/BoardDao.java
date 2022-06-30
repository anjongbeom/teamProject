package com.kh.team.dao;

import java.util.List;

import com.kh.team.vo.BoardVo;
import com.kh.team.vo.PagingDto;

public interface BoardDao {
	
	public boolean create(BoardVo boardVo);
	public BoardVo read(int bno);
	public boolean update(BoardVo boardVo);
	public boolean delete(int bno);
	public List<BoardVo> list(PagingDto paginDto);
	public int getCount(PagingDto paginDto);
	public boolean insertReply(BoardVo boardVo);
	public void updateReSeq(BoardVo boardVo); 
	public void updateViewCnt(int bno);
	public int getNextBno();
	public void insertAttach(String filename, int bno);
}
