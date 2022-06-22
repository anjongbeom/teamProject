package com.kh.team.vo;

public class SummaryDto {
	private String product_id;
	private String member_id;
	private int sum_total_price;
	private int sum_product_amount;
	private int sum_point_earned;
	
	public SummaryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SummaryDto(String product_id, String member_id, int sum_total_price, int sum_product_amount,
			int sum_point_earned) {
		super();
		this.product_id = product_id;
		this.member_id = member_id;
		this.sum_total_price = sum_total_price;
		this.sum_product_amount = sum_product_amount;
		this.sum_point_earned = sum_point_earned;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getSum_total_price() {
		return sum_total_price;
	}

	public void setSum_total_price(int sum_total_price) {
		this.sum_total_price = sum_total_price;
	}

	public int getSum_product_amount() {
		return sum_product_amount;
	}

	public void setSum_product_amount(int sum_product_amount) {
		this.sum_product_amount = sum_product_amount;
	}

	public int getSum_point_earned() {
		return sum_point_earned;
	}

	public void setSum_point_earned(int sum_point_earned) {
		this.sum_point_earned = sum_point_earned;
	}

	@Override
	public String toString() {
		return "SummaryDto [product_id=" + product_id + ", member_id=" + member_id + ", sum_total_price="
				+ sum_total_price + ", sum_product_amount=" + sum_product_amount + ", sum_point_earned="
				+ sum_point_earned + "]";
	}

	

}
