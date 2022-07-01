package com.kh.team.vo;

import java.sql.Date;

public class CommentVo {
	private int cno;
	private int bno;
	private String content;
	private String member_id;
	private Date regdate;

	public CommentVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentVo(int cno, int bno, String content, String member_id, Date regdate) {
		super();
		this.cno = cno;
		this.bno = bno;
		this.content = content;
		this.member_id = member_id;
		this.regdate = regdate;
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

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "CommentVo [cno=" + cno + ", bno=" + bno + ", content=" + content + ", member_id=" + member_id
				+ ", regdate=" + regdate + "]";
	}

	

}
