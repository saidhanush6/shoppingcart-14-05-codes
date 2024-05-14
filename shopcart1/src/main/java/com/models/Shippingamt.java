package com.models;

public class Shippingamt {

	private int orvl_from;
	private int orvl_to;
	private int orvl_shippingamount;

	public Shippingamt() {

	}

	public Shippingamt(int orvl_from, int orvl_to, int orvl_shippingamount) {
		super();
		this.orvl_from = orvl_from;
		this.orvl_to = orvl_to;
		this.orvl_shippingamount = orvl_shippingamount;
	}

	public int getOrvl_from() {
		return orvl_from;
	}

	public void setOrvl_from(int orvl_from) {
		this.orvl_from = orvl_from;
	}

	public int getOrvl_to() {
		return orvl_to;
	}

	public void setOrvl_to(int orvl_to) {
		this.orvl_to = orvl_to;
	}

	public int getOrvl_shippingamount() {
		return orvl_shippingamount;
	}

	public void setOrvl_shippingamount(int orvl_shippingamount) {
		this.orvl_shippingamount = orvl_shippingamount;
	}

}
