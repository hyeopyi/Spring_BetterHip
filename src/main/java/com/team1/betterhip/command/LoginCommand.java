package com.team1.betterhip.command;

import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import com.team1.betterhip.dao.LoginDao;
import com.team1.betterhip.dto.LoginDto;

public class LoginCommand implements BetterHipCommand {

	// 로그인시 아이디, 비밀번호 확인 메서드
	// 아이디, 비밀번호 확인하여 리턴값 전달
	// 탈퇴회원은 아이디만 확인하고 리턴
	//  2 : 인증성공
	//  1 : 아이디 틀림
	// -1 : 비밀번호 틀림
	// -2 : 탈퇴회원
	//  0 : DB 연결안됨
	// -3 : 카카오를 사용하여 가입하지 않았거나 이메일 동의를 하지않은 회원
	
	
	@Override
	public void excute(HttpServletRequest request, SqlSession sqlSession, Model model) {

		LoginDao dao = sqlSession.getMapper(LoginDao.class);		
		
		String message = "";
		String viewPage = "";
		

		String loginMethod = request.getParameter("loginMethod");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		

		
		int loginResult = -10;
		
		if(loginMethod.equals("kakao")) {
			// 카카오 회원
			if(user_id.equals("undefined")) {				
				loginResult = -3;
				
			}else {
				loginResult = dao.kakaoLoingDao(user_id) > 0 ? 2 : -3;				
			}
			
		}else {
			// 일반회원 
			LoginDto dto = dao.logincheckDao(user_id);
			
			if(dto.getUser_pw() != null) {		
				
				loginResult = dto.getUser_pw().equals(user_pw) == true ? (dto.getUser_leavedate() == 0 ? 2 : -2) : -1;
				
			}else {
				loginResult = 1;
			}
		}
		
		
		System.out.println("loginResult : " + loginResult);
		
		switch(loginResult) {
		case 2 :
			message = "success";
			viewPage = "redirect:main";
			break;
			
		case 1 :
			message = "아이디가 틀렸습니다";
			viewPage = "login";
			break;
		
		case 0 : 
			message = "데이터베이스 연결에 실패하였습니다";
			viewPage = "login";
			break;
			
		case -1 :
			message = "비밀번호가 틀렸습니다";
			viewPage = "login";
			break;
			
		case -2 :
			message = "탈퇴회원 입니다 재가입 해주세요";
			viewPage = "login";
			break;
			
		case -3 :
			message = "가입하지 않았거나 이메일 동의를 하지 않으셨습니다";
			viewPage = "login";
			break;
		}


		
//		System.out.println("messgae : " + message);
//		System.out.println("viewpage : " + viewPage);
		
		model.addAttribute("message", message);		
		request.setAttribute("viewPage", viewPage);

	}

}
