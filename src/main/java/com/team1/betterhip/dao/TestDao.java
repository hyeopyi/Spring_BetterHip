package com.team1.betterhip.dao;


import java.util.HashMap;
import java.util.Map;

public interface TestDao {
	
	public HashMap<byte[], Object> blobImg(String id);
	
    public Map<String, Object> getByteImage();
    
	


}
