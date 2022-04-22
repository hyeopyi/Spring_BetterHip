package com.team1.betterhip.dto;

public class TestDto {


	byte[] cake_img;
	
	public TestDto() {
		
	}

	public TestDto(byte[] cake_img) {
		super();
		this.cake_img = cake_img;
	}

	public byte[] getCake_img() {
		return cake_img;
	}

	public void setCake_img(byte[] cake_img) {
		this.cake_img = cake_img;
	}


}
