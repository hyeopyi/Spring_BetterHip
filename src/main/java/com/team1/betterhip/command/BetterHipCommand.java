package com.team1.betterhip.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface BetterHipCommand {
	
	public void excute(SqlSession sqlSession, Model model);

}
