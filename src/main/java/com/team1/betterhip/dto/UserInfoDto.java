package com.team1.betterhip.dto;

import java.sql.Timestamp;

public class UserInfoDto {

	
	//Field 
	
		String user_id;
		String user_pw; 
		String user_name; 
		String user_phone; 
		String user_email; 
		String user_postcode; 
		String user_address; 
		String user_address_detail;
		Timestamp user_joindate;
		String user_joindate_string;
	
	
	 //Constructor 
		
		
	  public UserInfoDto() {
		// TODO Auto-generated constructor stub
	}


	 
	public UserInfoDto(String user_id, String user_pw, String user_name, String user_phone, String user_email,
			String user_postcode, String user_address, String user_address_detail, Timestamp user_joindate,
			String user_joindate_string) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.user_email = user_email;
		this.user_postcode = user_postcode;
		this.user_address = user_address;
		this.user_address_detail = user_address_detail;
		this.user_joindate = user_joindate;
		this.user_joindate_string = user_joindate_string;
	}


	//Method 
	public String getUser_id() {
		return user_id;
	}



	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}



	public String getUser_pw() {
		return user_pw;
	}



	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}



	public String getUser_name() {
		return user_name;
	}



	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}



	public String getUser_phone() {
		return user_phone;
	}



	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}



	public String getUser_email() {
		return user_email;
	}



	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}



	public String getUser_postcode() {
		return user_postcode;
	}



	public void setUser_postcode(String user_postcode) {
		this.user_postcode = user_postcode;
	}



	public String getUser_address() {
		return user_address;
	}



	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}



	public String getUser_address_detail() {
		return user_address_detail;
	}



	public void setUser_address_detail(String user_address_detail) {
		this.user_address_detail = user_address_detail;
	}



	public Timestamp getUser_joindate() {
		return user_joindate;
	}



	public void setUser_joindate(Timestamp user_joindate) {
		this.user_joindate = user_joindate;
	}



	public String getUser_joindate_string() {
		return user_joindate_string;
	}



	public void setUser_joindate_string(String user_joindate_string) {
		this.user_joindate_string = user_joindate_string;
	}




	
	
}//UserInfoDto
