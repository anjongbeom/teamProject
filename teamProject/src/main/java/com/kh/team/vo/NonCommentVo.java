package com.kh.team.vo;

import java.sql.Date;

public class NonCommentVo {
	
	private int cno; //comment primary key
	private int bno; //NonMemberBoardVo bno
	private String content; //글내용
	private String adminId; // ="admin" 사용자아이디
	private Date regdate; //등록날짜
	
	public NonCommentVo() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "NonCommentVo [cno=" + cno + ", bno=" + bno + ", content=" + content + ", adminId=" + adminId
				+ ", regdate=" + regdate + "]";
	}
	
	
	
	
	
	
	
	
	
}
