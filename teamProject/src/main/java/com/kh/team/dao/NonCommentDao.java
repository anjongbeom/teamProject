package com.kh.team.dao;

import java.util.List;

import com.kh.team.vo.NonCommentVo;

public interface NonCommentDao {
	public boolean nonCommentInsert(NonCommentVo nonCommentVo);
	public List<NonCommentVo> nonCommentSelect(int bno);
	public boolean nonCommentUpdate(NonCommentVo nonCommentVo);
	public boolean nonCommentDelete(int cno);
}
