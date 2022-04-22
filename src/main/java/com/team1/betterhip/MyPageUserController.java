package com.team1.betterhip;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team1.betterhip.command.MyPageCommand;
import com.team1.betterhip.util.Constant;

@Controller
public class MyPageUserController {

//Jdbctemplate
	
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template; 
	}
	
//Command 
	
	private MyPageCommand UserInfoViewCommand = null;
	private MyPageCommand UserInfoModifyCommand = null; 
	private MyPageCommand UserInfoDeleteCommand = null; 

	@Autowired
	public void auto(MyPageCommand userInfoView,
					 MyPageCommand userInfoModify,
					 MyPageCommand userInfoDelete) {
		
		this.UserInfoViewCommand = userInfoView;
		this.UserInfoModifyCommand = userInfoModify;
		this.UserInfoDeleteCommand = userInfoDelete;
		
	}
	
	
//---------------RequestMapping---------------------
	

	
	@RequestMapping("/userInfoModifyView")
	public String userInfoModifyView(HttpServletRequest request, HttpSession session, Model model) {
		UserInfoViewCommand.execute1(request, session, model); 
		return "userInfoModifyView"; 
	}
	
	@RequestMapping("/userInfoModify")
	public String userInfoModify(HttpServletRequest request, HttpSession session, Model model) {
		UserInfoModifyCommand.execute1(request, session, model); 
		return "redirect:userInfoModifyView";
	}
	
	@RequestMapping("/userInfoDeleteView")
	public String userInfoDeleteView(HttpServletRequest request, HttpSession session, Model model) {
		UserInfoViewCommand.execute1(request, session, model); 
		return "userInfoDeleteView";
	}
	
	@RequestMapping("/userInfoDelete")
	public String userInfoDelete(HttpServletRequest request, HttpSession session) {
		UserInfoDeleteCommand.execute(request, session);
		return "goodbye";
	}
	
}//MyPaageUserController
