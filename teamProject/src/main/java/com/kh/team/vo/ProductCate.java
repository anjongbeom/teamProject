package com.kh.team.vo;

public class ProductCate {

	private String cate_code;
	private String cate_name;
	private String cate_type;
	private String cate_desc;
	private String cate_image;

	public ProductCate() {
		super();
	}

	public ProductCate(String cate_code, String cate_name, String cate_type, String cate_desc, String cate_image) {
		super();
		this.cate_code = cate_code;
		this.cate_name = cate_name;
		this.cate_type = cate_type;
		this.cate_desc = cate_desc;
		this.cate_image = cate_image;
	}

	public String getCate_code() {
		return cate_code;
	}

	public void setCate_code(String cate_code) {
		this.cate_code = cate_code;
	}

	public String getCate_name() {
		return cate_name;
	}

	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}

	public String getCate_type() {
		return cate_type;
	}

	public void setCate_type(String cate_type) {
		this.cate_type = cate_type;
	}

	public String getCate_desc() {
		return cate_desc;
	}

	public void setCate_desc(String cate_desc) {
		this.cate_desc = cate_desc;
	}

	public String getCate_image() {
		return cate_image;
	}

	public void setCate_image(String cate_image) {
		this.cate_image = cate_image;
	}

	@Override
	public String toString() {
		return "ProductCate [cate_code=" + cate_code + ", cate_name=" + cate_name + ", cate_type=" + cate_type
				+ ", cate_desc=" + cate_desc + ", cate_image=" + cate_image + "]";
	}

}
