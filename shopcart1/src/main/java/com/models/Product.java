package com.models;

public class Product {

	private int Prod_id;
	private String Prod_title;
	private int Prod_prct_id;
	private int Prod_hsnc_id;
	private String Prod_brand;
	private String Prod_image;
	private int Prod_price;
	private int hsnc_gstc_percentage;
	private int prod_mrp;

	public Product() {

	}

	public Product(int prod_id, String prod_title, int prod_prct_id, int prod_hsnc_id, String prod_brand,
			String prod_image, int prod_price) {
		super();
		Prod_id = prod_id;
		Prod_title = prod_title;
		Prod_prct_id = prod_prct_id;
		Prod_hsnc_id = prod_hsnc_id;
		Prod_brand = prod_brand;
		Prod_image = prod_image;
		Prod_price = prod_price;
	}

	public int getHsnc_gstc_percentage() {
		return hsnc_gstc_percentage;
	}

	public void setHsnc_gstc_percentage(int hsnc_gstc_percentage) {
		this.hsnc_gstc_percentage = hsnc_gstc_percentage;
	}

	public int getProd_mrp() {
		return prod_mrp;
	}

	public void setProd_mrp(int prod_mrp) {
		this.prod_mrp = prod_mrp;
	}

	public int getProd_id() {
		return Prod_id;
	}

	public void setProd_id(int prod_id) {
		Prod_id = prod_id;
	}

	public String getProd_title() {
		return Prod_title;
	}

	public void setProd_title(String prod_title) {
		Prod_title = prod_title;
	}

	public int getProd_prct_id() {
		return Prod_prct_id;
	}

	public void setProd_prct_id(int prod_prct_id) {
		Prod_prct_id = prod_prct_id;
	}

	public int getProd_hsnc_id() {
		return Prod_hsnc_id;
	}

	public void setProd_hsnc_id(int prod_hsnc_id) {
		Prod_hsnc_id = prod_hsnc_id;
	}

	public String getProd_brand() {
		return Prod_brand;
	}

	public void setProd_brand(String prod_brand) {
		Prod_brand = prod_brand;
	}

	public String getProd_image() {
		return Prod_image;
	}

	public void setProd_image(String prod_image) {
		Prod_image = prod_image;
	}

	public void setProd_price(int prod_price) {
		Prod_price = prod_price;
	}

	public int getProd_price() {

		return Prod_price;
	}

}
