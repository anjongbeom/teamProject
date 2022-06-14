package com.kh.team.vo;

public class GradeVo {
	private String fk_member_id;
	private String member_grade;
	private int bonuspoint;
	private int bonusratio;
	
	public GradeVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GradeVo(String fk_member_id, String member_grade, int bonuspoint, int bonusratio) {
		super();
		this.fk_member_id = fk_member_id;
		this.member_grade = member_grade;
		this.bonuspoint = bonuspoint;
		this.bonusratio = bonusratio;
	}

	public String getFk_member_id() {
		return fk_member_id;
	}

	public void setFk_member_id(String fk_member_id) {
		this.fk_member_id = fk_member_id;
	}

	public String getMember_grade() {
		return member_grade;
	}

	public void setMember_grade(String member_grade) {
		this.member_grade = member_grade;
	}

	public int getBonuspoint() {
		return bonuspoint;
	}

	public void setBonuspoint(int bonuspoint) {
		this.bonuspoint = bonuspoint;
	}

	public int getBonusratio() {
		return bonusratio;
	}

	public void setBonusratio(int bonusratio) {
		this.bonusratio = bonusratio;
	}

	@Override
	public String toString() {
		return "GradeVo [fk_member_id=" + fk_member_id + ", member_grade=" + member_grade + ", bonuspoint=" + bonuspoint
				+ ", bonusratio=" + bonusratio + "]";
	}
	
	
}
