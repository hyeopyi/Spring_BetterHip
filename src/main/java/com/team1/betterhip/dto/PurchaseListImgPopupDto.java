package com.team1.betterhip.dto;

public class PurchaseListImgPopupDto {

	//field 
	String purchase_user_id;
	String purchase_img_fileName; //첨부파일 이미지 이름 
	Byte [] purchase_img; //첨부파일 이미지 blob 받아오는 변수 
	String purchase_img_base64Image; //purchase_img base64 형변환 후 받을 변수 
	
	
	//constructor 
	public PurchaseListImgPopupDto() {
		// TODO Auto-generated constructor stub
	}


	public PurchaseListImgPopupDto(String purchase_user_id, String purchase_img_fileName, Byte[] purchase_img,
			String purchase_img_base64Image) {
		super();
		this.purchase_user_id = purchase_user_id;
		this.purchase_img_fileName = purchase_img_fileName;
		this.purchase_img = purchase_img;
		this.purchase_img_base64Image = purchase_img_base64Image;
	}

	
	//method
	public String getPurchase_user_id() {
		return purchase_user_id;
	}


	public void setPurchase_user_id(String purchase_user_id) {
		this.purchase_user_id = purchase_user_id;
	}


	public String getPurchase_img_fileName() {
		return purchase_img_fileName;
	}


	public void setPurchase_img_fileName(String purchase_img_fileName) {
		this.purchase_img_fileName = purchase_img_fileName;
	}


	public Byte[] getPurchase_img() {
		return purchase_img;
	}


	public void setPurchase_img(Byte[] purchase_img) {
		this.purchase_img = purchase_img;
	}


	public String getPurchase_img_base64Image() {
		return purchase_img_base64Image;
	}


	public void setPurchase_img_base64Image(String purchase_img_base64Image) {
		this.purchase_img_base64Image = purchase_img_base64Image;
	}
	
}
