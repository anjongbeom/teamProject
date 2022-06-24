package com.kh.team.vo;

public class OrderedDtailDto {
	
	private int order_detail_no;
	private String product_image;
	private String product_id;
	private int product_price;
	private int order_product_amount;
	private String member_id;
	private String order_detail_status_code;
	private String product_kor_name;
	private String order_detail_status_descript;
	
	
	public OrderedDtailDto() {
	}


	public OrderedDtailDto(int order_detail_no, String product_image, String product_id, int product_price,
			int order_product_amount, String member_id, String order_detail_status_code, String product_kor_name,
			String order_detail_status_descript) {
		super();
		this.order_detail_no = order_detail_no;
		this.product_image = product_image;
		this.product_id = product_id;
		this.product_price = product_price;
		this.order_product_amount = order_product_amount;
		this.member_id = member_id;
		this.order_detail_status_code = order_detail_status_code;
		this.product_kor_name = product_kor_name;
		this.order_detail_status_descript = order_detail_status_descript;
	}


	public int getOrder_detail_no() {
		return order_detail_no;
	}


	public void setOrder_detail_no(int order_detail_no) {
		this.order_detail_no = order_detail_no;
	}


	public String getProduct_image() {
		return product_image;
	}


	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}


	public String getProduct_id() {
		return product_id;
	}


	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}


	public int getProduct_price() {
		return product_price;
	}


	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}


	public int getOrder_product_amount() {
		return order_product_amount;
	}


	public void setOrder_product_amount(int order_product_amount) {
		this.order_product_amount = order_product_amount;
	}


	public String getMember_id() {
		return member_id;
	}


	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}


	public String getOrder_detail_status_code() {
		return order_detail_status_code;
	}
	
	
	public void setOrder_detail_status_code(String order_detail_status_code) {
		this.order_detail_status_code = order_detail_status_code;
	}


	public String getProduct_kor_name() {
		return product_kor_name;
	}


	public void setProduct_kor_name(String product_kor_name) {
		this.product_kor_name = product_kor_name;
	}


	public String getOrder_detail_status_descript() {
		return order_detail_status_descript;
	}


	public void setOrder_detail_status_descript(String order_detail_status_descript) {
		this.order_detail_status_descript = order_detail_status_descript;
	}


	@Override
	public String toString() {
		return "OrderedDtailDto [order_detail_no=" + order_detail_no + ", product_image=" + product_image
				+ ", product_id=" + product_id + ", product_price=" + product_price + ", order_product_amount="
				+ order_product_amount + ", member_id=" + member_id + ", order_detail_status_code="
				+ order_detail_status_code + ", product_kor_name=" + product_kor_name
				+ ", order_detail_status_descript=" + order_detail_status_descript + "]";
	}

	
	
	
	
}