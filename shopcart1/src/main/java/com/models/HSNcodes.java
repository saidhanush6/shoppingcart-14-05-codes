package com.models;

public class HSNcodes {

	private int hsnc_id;
	private String hsnc_hsncode;
	private int hsnc_gstc_percentage;

	public HSNcodes() {

	}

	public HSNcodes(int hsnc_id, String hsnc_hsncode, int hsnc_gstc_percentage) {
		super();
		this.hsnc_id = hsnc_id;
		this.hsnc_hsncode = hsnc_hsncode;
		this.hsnc_gstc_percentage = hsnc_gstc_percentage;
	}

	public int getHsnc_id() {
		return hsnc_id;
	}

	public void setHsnc_id(int hsnc_id) {
		this.hsnc_id = hsnc_id;
	}

	public String getHsnc_hsncode() {
		return hsnc_hsncode;
	}

	public void setHsnc_hsncode(String hsnc_hsncode) {
		this.hsnc_hsncode = hsnc_hsncode;
	}

	public int getHsnc_gstc_percentage() {
		return hsnc_gstc_percentage;
	}

	public void setHsnc_gstc_percentage(int hsnc_gstc_percentage) {
		this.hsnc_gstc_percentage = hsnc_gstc_percentage;
	}

}
