package com.kh.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.team.dao.Non_memberBoardDao;
import com.kh.team.vo.NonMemberBoardVo;

@Service
public class Non_memberBoardServiceImpl implements Non_memberBoardService{
	
	@Autowired
	private Non_memberBoardDao dao;
	
	@Override
	public boolean nonInsertBoardMember(NonMemberBoardVo nonmemberBoardVo) {
		// TODO Auto-generated method stub
		boolean result =dao.nonInsertBoardMember(nonmemberBoardVo);
		return result;
	}

	@Override
	public List<NonMemberBoardVo> nonSelectListBoardMember() {
		// TODO Auto-generated method stub
		List<NonMemberBoardVo> list = dao.nonSelectListBoardMember();
		return list;
	}

	@Override
	public NonMemberBoardVo nonSelectBoardMember(int bno) {
		// TODO Auto-generated method stub
		NonMemberBoardVo list =dao.nonSelectBoardMember(bno);
		return list;
	}

	@Override
	public boolean nonUpdateBoardMember(NonMemberBoardVo nonMemberBoardVo) {
		// TODO Auto-generated method stub
		boolean result =dao.nonUpdateBoardMember(nonMemberBoardVo);
		return result;
	}

	@Override
	public boolean nonDeleteBoardMember(int bno) {
		// TODO Auto-generated method stub
		boolean result = dao.nonDeleteBoardMember(bno);
		return result;
	}

	@Override
	public NonMemberBoardVo replyForm(int bno) {
		// TODO Auto-generated method stub
		NonMemberBoardVo list =dao.replyForm(bno);
		return list;
	}
	
	

	@Override
	public boolean replyRun(NonMemberBoardVo nonMemberBoardVo) {
		// TODO Auto-generated method stub
		boolean result =dao.replyRun(nonMemberBoardVo);
		return result;
	}

}
