package com.kh.team.vo;

import java.sql.Date;

public class MemberVo {
	
	private String user_id;
	private String pw;
	private String name;
	private String nick_name;
	private String email;
	private String favorite;
	private Date regdate;
	private Date updatedate;
	
	
	public MemberVo() {
	}
	
	
	public MemberVo(String user_id, String pw, String name, String nick_name, String email, String favorite,
			Date regdate, Date updatedate) {
		super();
		this.user_id = user_id;
		this.pw = pw;
		this.name = name;
		this.nick_name = nick_name;
		this.email = email;
		this.favorite = favorite;
		this.regdate = regdate;
		this.updatedate = updatedate;
	}


	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFavorite() {
		return favorite;
	}
	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	
	@Override
	public String toString() {
		return "MemberVo [user_id=" + user_id + ", pw=" + pw + ", name=" + name + ", nick_name=" + nick_name
				+ ", email=" + email + ", favorite=" + favorite + ", regdate=" + regdate + ", updatedate=" + updatedate
				+ "]";
	}
	
	
}
