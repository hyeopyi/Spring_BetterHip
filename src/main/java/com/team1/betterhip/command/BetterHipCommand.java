package com.team1.betterhip.command;



import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface BetterHipCommand {
	
	public void excute(HttpServletRequest request, SqlSession sqlSession, Model model);

}
