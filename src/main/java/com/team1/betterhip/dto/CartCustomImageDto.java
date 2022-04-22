package com.team1.betterhip.dto;

public class CartCustomImageDto {
	
	byte[] custom_img;
	
	public CartCustomImageDto() {
	
	}
	
	public CartCustomImageDto(byte[] custom_img) {
		super();
		this.custom_img = custom_img;
	}

	public byte[] getCustom_img() {
		return custom_img;
	}

	public void setCustom_img(byte[] custom_img) {
		this.custom_img = custom_img;
	}	

}
