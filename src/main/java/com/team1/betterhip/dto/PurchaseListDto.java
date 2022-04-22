package com.team1.betterhip.dto;

import java.sql.Timestamp;

public class PurchaseListDto {

	//Field 
		int purchase_id;
		Timestamp purchase_date; 
		String purchase_date_string; //purchase_date 형변환 후 받을 변수 
		String cake_name; 
		Byte [] cake_img;
		String cake_img_base64Image; //cake_img 형변환 후 받을 변수 
		String cake_option; //customize 선택사항 하나로 합쳐서 받을 변수 
		String customize_taste;
		String customize_size;
		String customize_cream_type;
		String customize_cream_color;		
		String purchase_text;
		int purchase_quantity; 
		int purchase_price;
		String purchase_price_string; //purchase_price 형변환 후 받을 변수 
		String purchase_status;
		Timestamp purchase_pickup_date;
		String purchase_pickup_date_string; //purchase_pickup_date 형변환 후 받을 변수 
		
	//Constructor 
		
		public PurchaseListDto() {
			// TODO Auto-generated constructor stub
		}
		
		
		public PurchaseListDto(int purchase_id, Timestamp purchase_date, String purchase_date_string, String cake_name,
				Byte[] cake_img, String cake_img_base64Image, String cake_option, String customize_taste,
				String customize_size, String customize_cream_type, String customize_cream_color, String purchase_text,
				int purchase_quantity, int purchase_price, String purchase_price_string, String purchase_status,
				Timestamp purchase_pickup_date, String purchase_pickup_date_string) {
			super();
			this.purchase_id = purchase_id;
			this.purchase_date = purchase_date;
			this.purchase_date_string = purchase_date_string;
			this.cake_name = cake_name;
			this.cake_img = cake_img;
			this.cake_img_base64Image = cake_img_base64Image;
			this.cake_option = cake_option;
			this.customize_taste = customize_taste;
			this.customize_size = customize_size;
			this.customize_cream_type = customize_cream_type;
			this.customize_cream_color = customize_cream_color;
			this.purchase_text = purchase_text;
			this.purchase_quantity = purchase_quantity;
			this.purchase_price = purchase_price;
			this.purchase_price_string = purchase_price_string;
			this.purchase_status = purchase_status;
			this.purchase_pickup_date = purchase_pickup_date;
			this.purchase_pickup_date_string = purchase_pickup_date_string;
		}

		//Method
		public int getPurchase_id() {
			return purchase_id;
		}


		public void setPurchase_id(int purchase_id) {
			this.purchase_id = purchase_id;
		}


		public Timestamp getPurchase_date() {
			return purchase_date;
		}


		public void setPurchase_date(Timestamp purchase_date) {
			this.purchase_date = purchase_date;
		}


		public String getPurchase_date_string() {
			return purchase_date_string;
		}


		public void setPurchase_date_string(String purchase_date_string) {
			this.purchase_date_string = purchase_date_string;
		}


		public String getCake_name() {
			return cake_name;
		}


		public void setCake_name(String cake_name) {
			this.cake_name = cake_name;
		}


		public Byte[] getCake_img() {
			return cake_img;
		}


		public void setCake_img(Byte[] cake_img) {
			this.cake_img = cake_img;
		}


		public String getCake_img_base64Image() {
			return cake_img_base64Image;
		}


		public void setCake_img_base64Image(String cake_img_base64Image) {
			this.cake_img_base64Image = cake_img_base64Image;
		}


		public String getCake_option() {
			return cake_option;
		}


		public void setCake_option(String cake_option) {
			this.cake_option = cake_option;
		}


		public String getCustomize_taste() {
			return customize_taste;
		}


		public void setCustomize_taste(String customize_taste) {
			this.customize_taste = customize_taste;
		}


		public String getCustomize_size() {
			return customize_size;
		}


		public void setCustomize_size(String customize_size) {
			this.customize_size = customize_size;
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


		public String getPurchase_price_string() {
			return purchase_price_string;
		}


		public void setPurchase_price_string(String purchase_price_string) {
			this.purchase_price_string = purchase_price_string;
		}


		public String getPurchase_status() {
			return purchase_status;
		}


		public void setPurchase_status(String purchase_status) {
			this.purchase_status = purchase_status;
		}


		public Timestamp getPurchase_pickup_date() {
			return purchase_pickup_date;
		}


		public void setPurchase_pickup_date(Timestamp purchase_pickup_date) {
			this.purchase_pickup_date = purchase_pickup_date;
		}


		public String getPurchase_pickup_date_string() {
			return purchase_pickup_date_string;
		}


		public void setPurchase_pickup_date_string(String purchase_pickup_date_string) {
			this.purchase_pickup_date_string = purchase_pickup_date_string;
		}
		
		
	


	
	
}
