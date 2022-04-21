package com.team1.betterhip.dao;

import com.team1.betterhip.dto.LoginDto;

public interface LoginDao {
	
	public int kakaoLoingDao(String user_id);
	public LoginDto loginCheckDao(String user_id);
	public int passwordCountDao(String user_id);

}
