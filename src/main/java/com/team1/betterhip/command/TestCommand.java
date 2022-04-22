package com.team1.betterhip.command;


import java.util.Base64;

import javax.servlet.http.HttpServletRequest;


import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.team1.betterhip.dao.TestDao;
import com.team1.betterhip.dto.TestDto;


public class TestCommand implements BetterHipCommand {

	@Override
	public void excute(HttpServletRequest request, SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub

		TestDao dao = sqlSession.getMapper(TestDao.class);
		TestDto dto = dao.imageGet("1");
		String x = Base64.getEncoder().encodeToString(dto.getCake_img());
		model.addAttribute("img", x);
		
		
	}

}
