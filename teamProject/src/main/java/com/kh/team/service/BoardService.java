package com.kh.team.service;

import java.util.List;

import com.kh.team.vo.BoardVo;
import com.kh.team.vo.PagingDto;


public interface BoardService {
	
	public boolean create(BoardVo boardVo); // �� ���� (Create)
	public BoardVo read(int bno); // �� �б� (Read)
	public boolean update(BoardVo boardVo); // �� ���� (Update)
	public boolean delete(int bno); // �� ���� (Delete)
	public List<BoardVo> list(PagingDto pagingDto); // �� ��� (Read)
	public int getCount(PagingDto pagingDto);
	public boolean insertReply(BoardVo boardVo); // ��� �ۼ�
	
}
