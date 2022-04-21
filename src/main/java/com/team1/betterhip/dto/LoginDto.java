package com.team1.betterhip.dto;


public class LoginDto {
	
	// Field
	String user_pw;
	int user_leavedat;
	

	
	// Constructor
	
	public LoginDto() {
		
	}



	public LoginDto(String user_pw, int user_leavedat) {
		super();
		this.user_pw = user_pw;
		this.user_leavedat = user_leavedat;
	}



	public String getUser_pw() {
		return user_pw;
	}



	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}



	public int getUser_leavedat() {
		return user_leavedat;
	}



	public void setUser_leavedat(int user_leavedat) {
		this.user_leavedat = user_leavedat;
	}




	

}
