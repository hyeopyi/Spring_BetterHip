package com.team1.betterhip.dto;

import java.sql.Blob;



public class CartDto {
	
	// Field
	int purchase_id;
	int purchase_quantity;
	int purchase_price;
	int purchase_cake_id;
	String customize_size;
	String customize_taste;
	String customize_cream_type;
	String customize_cream_color;
	String purchase_text;
	String purchase_cake_name;
	String purchase_pickup_date;
	byte[] cake_img; 
	String cake_img_base64;
	String custom_img_base64;

	
	
	// Constructor	
	public CartDto() {
		
	}



	public CartDto(int purchase_id, int purchase_quantity, int purchase_price, int purchase_cake_id,
			String customize_size, String customize_taste, String customize_cream_type, String customize_cream_color,
			String purchase_text, String purchase_cake_name, String purchase_pickup_date, byte[] cake_img,
			String cake_img_base64, String custom_img_base64) {
		super();
		this.purchase_id = purchase_id;
		this.purchase_quantity = purchase_quantity;
		this.purchase_price = purchase_price;
		this.purchase_cake_id = purchase_cake_id;
		this.customize_size = customize_size;
		this.customize_taste = customize_taste;
		this.customize_cream_type = customize_cream_type;
		this.customize_cream_color = customize_cream_color;
		this.purchase_text = purchase_text;
		this.purchase_cake_name = purchase_cake_name;
		this.purchase_pickup_date = purchase_pickup_date;
		this.cake_img = cake_img;
		this.cake_img_base64 = cake_img_base64;
		this.custom_img_base64 = custom_img_base64;
	}



	public int getPurchase_id() {
		return purchase_id;
	}



	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}



	public int getPurchase_quantity() {
		return purchase_quantity;
	}



	public void setPurchase_quantity(int purchase_quantity) {
		this.purchase_quantity = purchase_quantity;
	}



	public int getPurchase_price() {
		return purchase_price;
	}



	public void setPurchase_price(int purchase_price) {
		this.purchase_price = purchase_price;
	}



	public int getPurchase_cake_id() {
		return purchase_cake_id;
	}



	public void setPurchase_cake_id(int purchase_cake_id) {
		this.purchase_cake_id = purchase_cake_id;
	}



	public String getCustomize_size() {
		return customize_size;
	}



	public void setCustomize_size(String customize_size) {
		this.customize_size = customize_size;
	}



	public String getCustomize_taste() {
		return customize_taste;
	}



	public void setCustomize_taste(String customize_taste) {
		this.customize_taste = customize_taste;
	}



	public String getCustomize_cream_type() {
		return customize_cream_type;
	}



	public void setCustomize_cream_type(String customize_cream_type) {
		this.customize_cream_type = customize_cream_type;
	}



	public String getCustomize_cream_color() {
		return customize_cream_color;
	}



	public void setCustomize_cream_color(String customize_cream_color) {
		this.customize_cream_color = customize_cream_color;
	}



	public String getPurchase_text() {
		return purchase_text;
	}



	public void setPurchase_text(String purchase_text) {
		this.purchase_text = purchase_text;
	}



	public String getPurchase_cake_name() {
		return purchase_cake_name;
	}



	public void setPurchase_cake_name(String purchase_cake_name) {
		this.purchase_cake_name = purchase_cake_name;
	}



	public String getPurchase_pickup_date() {
		return purchase_pickup_date;
	}



	public void setPurchase_pickup_date(String purchase_pickup_date) {
		this.purchase_pickup_date = purchase_pickup_date;
	}



	public byte[] getCake_img() {
		return cake_img;
	}



	public void setCake_img(byte[] cake_img) {
		this.cake_img = cake_img;
	}



	public String getCake_img_base64() {
		return cake_img_base64;
	}



	public void setCake_img_base64(String cake_img_base64) {
		this.cake_img_base64 = cake_img_base64;
	}



	public String getCustom_img_base64() {
		return custom_img_base64;
	}



	public void setCustom_img_base64(String custom_img_base64) {
		this.custom_img_base64 = custom_img_base64;
	}



	

}
