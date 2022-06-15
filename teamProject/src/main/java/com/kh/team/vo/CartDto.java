package com.kh.team.vo;

public class CartDto {
	//cart
	
	private int cartid;
	private String member_id;
	private String product_id;
	private int product_count;
	
	//product
	private String product_name;
	private int product_price;
	private int product_discount;
	
	//add option
	private int salePrice;	
	private int totalPrice;
	
	
	

	public int getCartid() {
		return cartid;
	}



	public void setCartid(int cartid) {
		this.cartid = cartid;
	}



	public String getMember_id() {
		return member_id;
	}



	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}



	public String getProduct_id() {
		return product_id;
	}



	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}



	public int getProduct_count() {
		return product_count;
	}



	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}



	public String getProduct_name() {
		return product_name;
	}



	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}



	public int getProduct_price() {
		return product_price;
	}



	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}



	public int getProduct_discount() {
		return product_discount;
	}



	public void setProduct_discount(int product_discount) {
		this.product_discount = product_discount;
	}



	public int getSalePrice() {
		return salePrice;
	}



	public int getTotalPrice() {
		return totalPrice;
	}

	
	public void initSaleTotal() {
		this.salePrice = (int) (this.product_discount * (1-this.product_discount));
		this.totalPrice = this.salePrice*this.product_count;
	}


	@Override
	public String toString() {
		return "CartDto [cartid=" + cartid + ", member_id=" + member_id + ", product_id=" + product_id
				+ ", product_count=" + product_count + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_discount=" + product_discount + ", salePrice=" + salePrice
				+ ", totalPrice=" + totalPrice + "]";
	}
	
	
	
	
	
}
