package com.team1.betterhip.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface MyPageCommand {

	void execute(HttpServletRequest request, HttpSession session);
	void execute1(HttpServletRequest request, HttpSession session, Model model);
	void execute2(HttpServletRequest request, HttpSession session, SqlSession sqlSession);
	void execute3(HttpServletRequest request, HttpSession session, SqlSession sqlSession, Model model);
	
	
}
