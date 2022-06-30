package com.kh.team.service;

import java.util.List;

import com.kh.team.vo.BoardVo;
import com.kh.team.vo.PagingDto;


public interface BoardService {
	
	public boolean create(BoardVo boardVo);
	public BoardVo read(int bno);
	public boolean update(BoardVo boardVo);
	public boolean delete(int bno);
	public List<BoardVo> list(PagingDto pagingDto);
	public int getCount(PagingDto paginDto);
	public boolean insertReply(BoardVo boardVo);
	
}
