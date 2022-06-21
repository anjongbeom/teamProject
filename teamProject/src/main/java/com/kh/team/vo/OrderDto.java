package com.kh.team.vo;

public class OrderDto {
	private String member_id;
	private String product_id;
	private int product_price; 
	private int product_amount;
	
	
	public OrderDto() {
	}


	public OrderDto(String product_id, int product_amount, int product_price, String member_id) {
		super();
		this.member_id = member_id;
		this.product_id = product_id;
		this.product_price = product_price;
		this.product_amount = product_amount;
	}


	public String getProduct_id() {
		return product_id;
	}


	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}


	public int getProduct_amount() {
		return product_amount;
	}


	public void setProduct_amount(int product_amount) {
		this.product_amount = product_amount;
	}


	public int getProduct_price() {
		return product_price;
	}


	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}


	public String getMember_id() {
		return member_id;
	}


	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}


	@Override
	public String toString() {
		return "OrderDto [product_id=" + product_id + ", product_amount=" + product_amount + ", product_price="
				+ product_price + ", member_id=" + member_id + "]";
	}

	
	
	

}
