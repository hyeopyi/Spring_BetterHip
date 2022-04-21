package com.team1.betterhip.dao;



import java.util.ArrayList;
import java.util.HashMap;

import com.team1.betterhip.dto.CartDto;



public interface CartDao {
	
	public ArrayList<CartDto> CartListDao(String user_id);
	public void CartOrderDao(String purchase_id);
	public void CartDeleteDao(String purchase_id);
	public HashMap<byte[], Object> cakeImageGet(int cake_id);
	public int customImageCheck(int purchase_id);
	public HashMap<byte[], Object> customImageGet(int purchase_id);

}
