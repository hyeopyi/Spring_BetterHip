package com.team1.betterhip.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import com.team1.betterhip.dao.LoginDao;
import com.team1.betterhip.dto.LoginDto;

public class LoginCommand implements BetterHipCommand {

	
	@Override
	public void excute(HttpServletRequest request, SqlSession sqlSession, Model model) {
		
		HttpSession session = request.getSession();		
		LoginDao dao = sqlSession.getMapper(LoginDao.class);		
		LoginDto dto = null;
		String message = "";
		String viewPage = "login";		
		String loginMethod = request.getParameter("loginMethod");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		int passwordCount = 0; // user_id에 해당하는 password가 있는지 확인용도  
		
		if(loginMethod.equals("kakao")) {
			// 카카오 회원
			if(user_id.equals("undefined")) {				
				message = "이메일 사용 동의를 하지않았습니다" ;
				
			}else {
				message = dao.kakaoLoingDao(user_id) > 0 ? "인증성공" : "가입하지 않았습니다";	
			}
			
		}else {
			// 일반회원 
			passwordCount = dao.passwordCountDao(user_id);		
		
			if(passwordCount > 0) {						
				dto = dao.loginCheckDao(user_id);
				message = dto.getUser_pw().equals(user_pw) == true ? (dto.getUser_leavedat() == 0 ? "인증성공" : "탈퇴회원 입니다") : "비밀번호가 틀립니다";
				
			}else {			
				message = "아이디가 틀립니다";			}
		}
		
		if(message.equals("인증성공")) {
			viewPage = "redirect:main";
			session.setAttribute("USER_ID", user_id);
		}
		
		model.addAttribute("message", message);		
		request.setAttribute("viewPage", viewPage);

	}

}
