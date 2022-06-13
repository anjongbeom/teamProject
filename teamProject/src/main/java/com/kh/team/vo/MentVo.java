package com.kh.team.vo;

public class MentVo {
	
	private int ment_num;
	private String real_ment;
	
	public MentVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MentVo(int ment_num, String real_ment) {
		super();
		this.ment_num = ment_num;
		this.real_ment = real_ment;
	}

	public int getMent_num() {
		return ment_num;
	}

	public void setMent_num(int ment_num) {
		this.ment_num = ment_num;
	}

	public String getReal_ment() {
		return real_ment;
	}

	public void setReal_ment(String real_ment) {
		this.real_ment = real_ment;
	}

	@Override
	public String toString() {
		return "MentVo [ment_num=" + ment_num + ", real_ment=" + real_ment + "]";
	}

	
}
