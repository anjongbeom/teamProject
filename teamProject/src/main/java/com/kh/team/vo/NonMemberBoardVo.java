package com.kh.team.vo;

import java.sql.Date;


public class NonMemberBoardVo {
	private int bno;  //글번호
	private String title;
	private String writer;
	private String email;
	private String pwd;
	private String content;
	private Date reg_date;
	private int readcount;
	private int re_group; //글그룹번호
	private int re_step;  //그룹내댓글순서
	private int re_level; //그룹내 댓글깊이
	
	public NonMemberBoardVo() {
		super();
	}

	public NonMemberBoardVo(int bno, String title, String writer, String email, String pwd, String content,
			Date reg_date, int readcount, int re_group, int re_step, int re_level) {
		super();
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.email = email;
		this.pwd = pwd;
		this.content = content;
		this.reg_date = reg_date;
		this.readcount = readcount;
		this.re_group = re_group;
		this.re_step = re_step;
		this.re_level = re_level;
	}
	
	
	
	
	

	

	public NonMemberBoardVo(String title, String writer, String content, int re_group, int re_step, int re_level) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.re_group = re_group;
		this.re_step = re_step;
		this.re_level = re_level;
	}

	public NonMemberBoardVo(String title, String writer, String email, String pwd, String content, int readcount,
			int re_group, int re_step, int re_level) {
		super();
		this.title = title;
		this.writer = writer;
		this.email = email;
		this.pwd = pwd;
		this.content = content;
		this.readcount = readcount;
		this.re_group = re_group;
		this.re_step = re_step;
		this.re_level = re_level;
	}

	

	

	public NonMemberBoardVo(int bno, String title, String writer, String email, String content) {
		super();
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.email = email;
		this.content = content;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getRef() {
		return re_group;
	}

	public void setRef(int re_group) {
		this.re_group = re_group;
	}

	public int getRe_step() {
		return re_step;
	}

	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}

	public int getRe_level() {
		return re_level;
	}

	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}

	
	
	public int getRe_group() {
		return re_group;
	}

	public void setRe_group(int re_group) {
		this.re_group = re_group;
	}

	@Override
	public String toString() {
		return "NonMemberBoardVo [bno=" + bno + ", title=" + title + ", writer=" + writer + ", email=" + email
				+ ", pwd=" + pwd + ", content=" + content + ", reg_date=" + reg_date + ", readcount=" + readcount
				+ ", re_group=" + re_group + ", re_step=" + re_step + ", re_level=" + re_level + "]";
	}
	
	
}	

