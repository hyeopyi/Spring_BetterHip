package com.team1.betterhip;

import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.team1.betterhip.command.BetterHipCommand;

@Controller
public class TestController {

	
	@Autowired
	private SqlSession sqlSession;	
	
	private BetterHipCommand test = null;
	
	@Autowired
	public void test(BetterHipCommand test) {
		this.test = test;
	}
	
	@RequestMapping("/test")
	public String testfunctio(HttpServletRequest request, Model model) {
		test.excute(request, sqlSession, model);
		return "test";
	}
	
}
