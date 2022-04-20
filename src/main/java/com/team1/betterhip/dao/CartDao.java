package com.team1.betterhip.dao;



import java.util.ArrayList;


import com.team1.betterhip.dto.CartDto;



public interface CartDao {
	
	public ArrayList<CartDto> CartListDao(String user_id);
	public ArrayList<byte[]> CartListImgDao(String user_id);
	

}
