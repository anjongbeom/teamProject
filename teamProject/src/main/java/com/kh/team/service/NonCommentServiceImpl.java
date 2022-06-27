package com.kh.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.team.dao.NonCommentDao;
import com.kh.team.vo.NonCommentVo;

@Service
public class NonCommentServiceImpl implements NonCommentService{
	
	@Autowired
	private NonCommentDao dao;
	
	@Override
	public boolean nonCommentInsert(NonCommentVo nonCommentVo) {
		// TODO Auto-generated method stub
		boolean result = dao.nonCommentInsert(nonCommentVo);
		return result;
	}

	@Override
	public List<NonCommentVo> nonCommentSelect(int bno) {
		// TODO Auto-generated method stub
		List<NonCommentVo> list = dao.nonCommentSelect(bno);
		return list;
	}

	@Override
	public boolean nonCommentUpdate(NonCommentVo nonCommentVo) {
		// TODO Auto-generated method stub
		boolean result =dao.nonCommentUpdate(nonCommentVo);
		return result;
	}

	@Override
	public boolean nonCommentDelete(int cno) {
		// TODO Auto-generated method stub
		boolean result = dao.nonCommentDelete(cno);
		return result;
	}


}
