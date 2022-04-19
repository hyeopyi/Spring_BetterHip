package com.team1.betterhip.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.team1.betterhip.dao.CartDao;

public class CartListCommand implements BetterHipCommand {

	@Override
	public void excute(SqlSession sqlSession, Model model) {
		
		CartDao dao = sqlSession.getMapper(CartDao.class);
		model.addAttribute("list", dao.CartListDao("2"));
	}

}
