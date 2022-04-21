package com.team1.betterhip;

import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainController {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@RequestMapping("/main")
	public String mainPage(HttpServletRequest request, Model model) {
		return "main";
	}

}
