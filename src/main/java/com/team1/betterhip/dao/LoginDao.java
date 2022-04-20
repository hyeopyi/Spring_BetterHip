package com.team1.betterhip.dao;

import com.team1.betterhip.dto.LoginDto;

public interface LoginDao {
	
	public int kakaoLoingDao(String user_id);
	public LoginDto logincheckDao(String user_id);
	
	public String testDao(String usr_id);

}
