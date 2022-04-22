package com.team1.betterhip.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.team1.betterhip.dao.UserInfoDao;

public class UserInfoModifyCommand implements MyPageCommand {

	@Override
	public void execute(HttpServletRequest request, HttpSession session) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute1(HttpServletRequest request, HttpSession session, Model model) {
		// TODO Auto-generated method stub

		//USER_ID 세션으로 받기 
		HttpSession userIdSession = request.getSession();
		String USER_ID = (String) userIdSession.getAttribute("USER_ID"); 
		
		//사용자가 수정 입력한 데이터 받기 
		String new_user_pw = request.getParameter("new_user_pw");
		String user_pw = request.getParameter("user_pw"); 
			//새 비밀번호 입력하지 않았을 경우 기존 비밀번호 유지 
			if(new_user_pw == "") {
				new_user_pw = user_pw;
			}
		String user_name = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");
		String user_phone = request.getParameter("user_phone");
		String user_postcode = request.getParameter("user_postcode");
		String user_address = request.getParameter("user_address");
		String user_address_detail = request.getParameter("user_address_detail");
		
		//회원 정보 수정 다오 실행 
		UserInfoDao dao = new UserInfoDao();
		dao.userInfoModifyDao(USER_ID, new_user_pw, user_name, user_email, user_phone, user_postcode, user_address, user_address_detail);
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
