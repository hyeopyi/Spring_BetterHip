package com.team1.betterhip.dao;


import java.util.HashMap;
import java.util.Map;

import com.team1.betterhip.dto.TestDto;

public interface TestDao {
	
	public HashMap<byte[], Object> blobImg(String id);
	
    public Map<String, Object> getByteImage();
    
    public TestDto getLog(String user_id);
    
    public TestDto imageGet(String id);
    
	


}
