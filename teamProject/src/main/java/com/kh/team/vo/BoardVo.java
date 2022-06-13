package com.kh.team.vo;

import java.sql.Date;
import java.util.Arrays;
	

public class BoardVo {
	private int board_no;
	private String board_title;
	private String board_content;
	private String writer;
	private Date regdate;
	private int viewcnt;
	private int re_group;
	private int re_level;
	private int re_seq;
	private String[] files;
	
	public BoardVo() {
	}


	public BoardVo(String board_title, String board_content, String writer) {
		super();
		this.board_title = board_title;
		this.board_content = board_content;
		this.writer = writer;
	}

	
	

	// testInsert �ӽÿ�
	public BoardVo(int board_no, String title, String content, String writer) {
		super();
		this.board_no = board_no;
		this.board_title = board_title;
		this.board_content = board_content;
		this.writer = writer;
	}


	public BoardVo(int board_no, String board_title, String board_content, String writer, Date regdate, int viewcnt) {
		super();
		this.board_no = board_no;
		this.board_title = board_title;
		this.board_content = board_content;
		this.writer = writer;
		this.regdate = regdate;
		this.viewcnt = viewcnt;
	}


	public BoardVo(int board_no, String board_title, String board_content, String writer, Date regdate, int viewcnt,
			int re_group, int re_level, int re_seq, String[] files) {
		super();
		this.board_no = board_no;
		this.board_title = board_title;
		this.board_content = board_content;
		this.writer = writer;
		this.regdate = regdate;
		this.viewcnt = viewcnt;
		this.re_group = re_group;
		this.re_level = re_level;
		this.re_seq = re_seq;
		this.files = files;
	}


	public int getBoard_no() {
		return board_no;
	}


	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}


	public String getBoard_title() {
		return board_title;
	}


	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}


	public String getBoard_content() {
		return board_content;
	}


	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	public int getViewcnt() {
		return viewcnt;
	}


	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}


	public int getRe_group() {
		return re_group;
	}


	public void setRe_group(int re_group) {
		this.re_group = re_group;
	}


	public int getRe_level() {
		return re_level;
	}


	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}


	public int getRe_seq() {
		return re_seq;
	}


	public void setRe_seq(int re_seq) {
		this.re_seq = re_seq;
	}


	public String[] getFiles() {
		return files;
	}


	public void setFiles(String[] files) {
		this.files = files;
	}


	@Override
	public String toString() {
		return "BoardVo [board_no=" + board_no + ", board_title=" + board_title + ", board_content=" + board_content
				+ ", writer=" + writer + ", regdate=" + regdate + ", viewcnt=" + viewcnt + ", re_group=" + re_group
				+ ", re_level=" + re_level + ", re_seq=" + re_seq + ", files=" + Arrays.toString(files) + "]";
	}

	
	
}

