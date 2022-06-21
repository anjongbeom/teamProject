package com.kh.team.vo;

public class CartVo {
	private int cartid;
	private String member_id;
	private String product_id;
	private int product_count;

	public CartVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartVo(int cartid, String member_id, String product_id, int product_count) {
		super();
		this.cartid = cartid;
		this.member_id = member_id;
		this.product_id = product_id;
		this.product_count = product_count;
	}

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

	@Override
	public String toString() {
		return "CartVo [cartid=" + cartid + ", member_id=" + member_id + ", product_id=" + product_id
				+ ", product_count=" + product_count + "]";
	}

}
