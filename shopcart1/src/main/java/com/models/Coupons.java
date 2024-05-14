package com.models;

public class Coupons {

	private String coupon_id;
	private int discount_amount;

	public Coupons() {

	}

	public Coupons(String coupon_id, int discount_amount) {
		super();
		this.coupon_id = coupon_id;
		this.discount_amount = discount_amount;
	}

	public String getCoupon_id() {
		return coupon_id;
	}

	public void setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
	}

	public int getDiscount_amount() {
		return discount_amount;
	}

	public void setDiscount_amount(int discount_amount) {
		this.discount_amount = discount_amount;
	}

}
