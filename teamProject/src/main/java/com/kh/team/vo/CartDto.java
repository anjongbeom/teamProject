package com.kh.team.vo;

public class CartDto {
	private int cart_id;
	private int product_amount;
	private String product_image;
	private String product_name;
	private String product_kor_name;
	private String product_id;
	private int total_price;
	private String member_id;
	private int point_earned;
	private int sum_total_price;
	private int sum_product_amount;
	private int sum_point_earned;

	public CartDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDto(int cart_id, int product_amount, String product_image, String product_name, String product_kor_name,
			String product_id, int total_price, String member_id, int point_earned, int sum_total_price,
			int sum_product_amount, int sum_point_earned) {
		super();
		this.cart_id = cart_id;
		this.product_amount = product_amount;
		this.product_image = product_image;
		this.product_name = product_name;
		this.product_kor_name = product_kor_name;
		this.product_id = product_id;
		this.total_price = total_price;
		this.member_id = member_id;
		this.point_earned = point_earned;
		this.sum_total_price = sum_total_price;
		this.sum_product_amount = sum_product_amount;
		this.sum_point_earned = sum_point_earned;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getProduct_amount() {
		return product_amount;
	}

	public void setProduct_amount(int product_amount) {
		this.product_amount = product_amount;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_kor_name() {
		return product_kor_name;
	}

	public void setProduct_kor_name(String product_kor_name) {
		this.product_kor_name = product_kor_name;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getPoint_earned() {
		return point_earned;
	}

	public void setPoint_earned(int point_earned) {
		this.point_earned = point_earned;
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
		return "CartDto [cart_id=" + cart_id + ", product_amount=" + product_amount + ", product_image=" + product_image
				+ ", product_name=" + product_name + ", product_kor_name=" + product_kor_name + ", product_id="
				+ product_id + ", total_price=" + total_price + ", member_id=" + member_id + ", point_earned="
				+ point_earned + ", sum_total_price=" + sum_total_price + ", sum_product_amount=" + sum_product_amount
				+ ", sum_point_earned=" + sum_point_earned + "]";
	}

}
