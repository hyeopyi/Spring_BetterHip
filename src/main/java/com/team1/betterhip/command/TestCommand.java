package com.team1.betterhip.command;




import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import org.springframework.ui.Model;

import com.team1.betterhip.dao.TestDao;

public class TestCommand implements BetterHipCommand {

	@Override
	public void excute(HttpServletRequest request, SqlSession sqlSession, Model model) {
	
		System.out.println("testCommand");
		
		TestDao dao = sqlSession.getMapper(TestDao.class);
		
		HashMap<byte[], Object> map = dao.blobImg("2");
		
		byte[] img = (byte[]) map.get("cake_img");
		String encorded = Base64.getEncoder().encodeToString(img);
		
		request.setAttribute("img", encorded);







		
		
	}

}
