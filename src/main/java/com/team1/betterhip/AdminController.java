package com.team1.betterhip;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team1.betterhip.command.BetterHipCommand;

@Controller
public class AdminController {
	
	
	@Autowired
	private SqlSession sqlSession;
	
	private BetterHipCommand revenue = null;
	
	
	@Autowired
	public void commandSet(BetterHipCommand revenue) {
		this.revenue = revenue;
	}
	
	@RequestMapping("/admin")
	public String admin(HttpServletRequest request, Model model) {
		return "admin";
	}
	
	
	@RequestMapping("/revenue")
	public String revenue(HttpServletRequest request, Model model) {
		revenue.excute(request, sqlSession, model);
		return "revenue";
	}

}
