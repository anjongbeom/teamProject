package com.kh.team.vo;

import java.sql.Date;

public class OrderVo {
	private int order_no;
	private Date order_date;
	private String member_id;
	private String order_status_code;
	
	public OrderVo() {
		// TODO Auto-generated constructor stub
	}

	public OrderVo(int order_no, Date order_date, String member_id, String order_status_code) {
		super();
		this.order_no = order_no;
		this.order_date = order_date;
		this.member_id = member_id;
		this.order_status_code = order_status_code;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getOrder_status_code() {
		return order_status_code;
	}

	public void setOrder_status_code(String order_status_code) {
		this.order_status_code = order_status_code;
	}

	@Override
	public String toString() {
		return "OrderVo [order_no=" + order_no + ", order_date=" + order_date + ", member_id=" + member_id
				+ ", order_status_code=" + order_status_code + "]";
	}

	
	

}
