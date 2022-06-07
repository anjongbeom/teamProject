package com.kh.team.dao;

import java.util.List;

import com.kh.team.vo.BoardVo;
import com.kh.team.vo.PagingDto;

public interface BoardDao {
	
	public boolean create(BoardVo boardVo); // 글 쓰기 (Create)
	public BoardVo read(int bno); // 글 읽기 (Read)
	public boolean update(BoardVo boardVo);// 글 수정 (Update)
	public boolean delete(int bno);// 글 삭제 (Delete)
	public List<BoardVo> list(PagingDto pagingDto);// 글 목록 (Read)
	public int getCount(PagingDto pagingDto);
	public boolean insertReply(BoardVo boardVo); // 답글 쓰기
	public void updateRESeq(BoardVo boardVo); // 답글 순서 조정
	public void updateViewCnt(int bno); // 조회수 증가
	public int getNextBno(); // BNO얻기
	public void insertAttach(String filename, int bno); // 

}
