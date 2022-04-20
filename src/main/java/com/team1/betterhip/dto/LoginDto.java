package com.team1.betterhip.dto;


public class LoginDto {
	
	// Field
	String user_pw;
	int user_leavedate;
	

	
	// Constructor
	
	public LoginDto() {
		
	}
	
	
	public LoginDto(String user_pw, int user_leavedate) {
		super();
		this.user_pw = user_pw;
		this.user_leavedate = user_leavedate;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public int getUser_leavedate() {
		return user_leavedate;
	}

	public void setUser_leavedate(int user_leavedate) {
		this.user_leavedate = user_leavedate;
	}
	
	

}
