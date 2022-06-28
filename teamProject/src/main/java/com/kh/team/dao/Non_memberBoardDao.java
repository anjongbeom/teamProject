package com.kh.team.dao;

import java.util.List;

import com.kh.team.vo.NonMemberBoardVo;

public interface Non_memberBoardDao {
	public boolean nonInsertBoardMember(NonMemberBoardVo nonmemberBoardVo);
	public List<NonMemberBoardVo> nonSelectListBoardMember();
	public NonMemberBoardVo nonSelectBoardMember(int bno);
	public boolean nonUpdateBoardMember(NonMemberBoardVo nonMemberBoardVo);
	public boolean nonDeleteBoardMember(int bno);
	public NonMemberBoardVo replyForm(int bno);
	public boolean replyRun(NonMemberBoardVo nonMemberBoardVo);
}
