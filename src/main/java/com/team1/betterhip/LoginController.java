package com.team1.betterhip;

import javax.servlet.http.HttpServletRequest;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team1.betterhip.command.BetterHipCommand;

@Controller
public class LoginController {
	
	String viewPage = "";
	
	@Autowired
	private SqlSession sqlSession;
	
	private BetterHipCommand login = null;
	
	@Autowired
	public void setLogin(BetterHipCommand login) {
		this.login = login;
	}
	
	
	@RequestMapping("/loginForm")
	public String loginForm(HttpServletRequest request, Model model) {
		return "login";
	}
	
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);	
		login.excute(request, sqlSession, model);	

		viewPage = request.getAttribute("viewPage").toString();
		
		return viewPage;
	}

}
