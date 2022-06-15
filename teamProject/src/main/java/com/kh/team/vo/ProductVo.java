package com.kh.team.vo;

public class ProductVo {
	
	private String product_id;
	private String product_name;
	private String product_price;
	private int product_stock;
	private int product_capacity;
	private int product_alcohol_degree;
	private String product_expiration_date;
	private String product_origin;
	private String product_image;
	private String product_descript;
	private int product_discount;
	
	public ProductVo() {
	}


	


	public ProductVo(String product_id, String product_name, String product_price, int product_stock,
			int product_capacity, int product_alcohol_degree, String product_expiration_date, String product_origin,
			String product_image, String product_descript, int product_discount) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_stock = product_stock;
		this.product_capacity = product_capacity;
		this.product_alcohol_degree = product_alcohol_degree;
		this.product_expiration_date = product_expiration_date;
		this.product_origin = product_origin;
		this.product_image = product_image;
		this.product_descript = product_descript;
		this.product_discount = product_discount;
	}





	public String getProduct_id() {
		return product_id;
	}


	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public String getProduct_price() {
		return product_price;
	}


	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}


	public int getProduct_stock() {
		return product_stock;
	}


	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}


	public int getProduct_capacity() {
		return product_capacity;
	}


	public void setProduct_capacity(int product_capacity) {
		this.product_capacity = product_capacity;
	}


	public int getProduct_alcohol_degree() {
		return product_alcohol_degree;
	}


	public void setProduct_alcohol_degree(int product_alcohol_degree) {
		this.product_alcohol_degree = product_alcohol_degree;
	}


	public String getProduct_expiration_date() {
		return product_expiration_date;
	}


	public void setProduct_expiration_date(String product_expiration_date) {
		this.product_expiration_date = product_expiration_date;
	}


	public String getProduct_origin() {
		return product_origin;
	}


	public void setProduct_origin(String product_origin) {
		this.product_origin = product_origin;
	}


	public String getProduct_image() {
		return product_image;
	}


	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	
	


	public String getProduct_descript() {
		return product_descript;
	}


	public void setProduct_descript(String product_descript) {
		this.product_descript = product_descript;
	}


	
	
	public int getProduct_discount() {
		return product_discount;
	}





	public void setProduct_discount(int product_discount) {
		this.product_discount = product_discount;
	}





	@Override
	public String toString() {
		return "ProductVo [product_id=" + product_id + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_stock=" + product_stock + ", product_capacity=" + product_capacity
				+ ", product_alcohol_degree=" + product_alcohol_degree + ", product_expiration_date="
				+ product_expiration_date + ", product_origin=" + product_origin + ", product_image=" + product_image
				+ ", product_descript=" + product_descript + ", product_discount=" + product_discount + "]";
	}


}
