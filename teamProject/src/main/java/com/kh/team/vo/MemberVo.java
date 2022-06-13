package com.kh.team.vo;

import java.sql.Date;

public class MemberVo {
	
	private String member_id;
	private String member_pw;
	private String member_name;
	private String nickname;
	private String email;
	private String favorite;
	private Date regdate;
	private Date updatedate;
	private String member_tel;
	private int member_point;
	private String address;
	
	public MemberVo() {
	}

	public MemberVo(String member_id, String member_pw, String member_name, String nickname, String email,
			String favorite, Date regdate, Date updatedate, String member_tel, int member_point, String address) {
		super();
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.nickname = nickname;
		this.email = email;
		this.favorite = favorite;
		this.regdate = regdate;
		this.updatedate = updatedate;
		this.member_tel = member_tel;
		this.member_point = member_point;
		this.address = address;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public String getMember_tel() {
		return member_tel;
	}

	public void setMember_tel(String member_tel) {
		this.member_tel = member_tel;
	}

	public int getMember_point() {
		return member_point;
	}

	public void setMember_point(int member_point) {
		this.member_point = member_point;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "MemberVo [member_id=" + member_id + ", member_pw=" + member_pw + ", member_name=" + member_name
				+ ", nickname=" + nickname + ", email=" + email + ", favorite=" + favorite + ", regdate=" + regdate
				+ ", updatedate=" + updatedate + ", member_tel=" + member_tel + ", member_point=" + member_point
				+ ", address=" + address + "]";
	}

	
}
