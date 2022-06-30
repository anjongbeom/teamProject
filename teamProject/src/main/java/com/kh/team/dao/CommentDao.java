package com.kh.team.dao;

import java.util.List;

import com.kh.team.vo.CommentVo;


public interface CommentDao {
	public boolean insertComment(CommentVo commentVo);
	public List<CommentVo> commentList(int bno);
	public boolean updateComment(CommentVo commentVo);
	public boolean deleteComment(int cno);
	
}
