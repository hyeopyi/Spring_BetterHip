package com.team1.betterhip.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.team1.betterhip.dao.UserInfoDao;
import com.team1.betterhip.dto.UserInfoDto;

public class UserInfoViewCommand implements MyPageCommand {

	@Override
	public void execute(HttpServletRequest request, HttpSession session) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute1(HttpServletRequest request, HttpSession session, Model model) {
		// TODO Auto-generated method stub
		
		//USER_ID 세션으로 받기 
		HttpSession session1 = request.getSession(); 
		String USER_ID = (String) session.getAttribute("USER_ID"); 
		
		//회원 정보 가져오기 
		UserInfoDao dao = new UserInfoDao(); 
		UserInfoDto dto = dao.userInfoViewDao(USER_ID);
		
		model.addAttribute("userInfo", dto); 
		
	}

	@Override
	public void execute2(HttpServletRequest request, HttpSession session, SqlSession sqlSession) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute3(HttpServletRequest request, HttpSession session, SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub

	}

}
