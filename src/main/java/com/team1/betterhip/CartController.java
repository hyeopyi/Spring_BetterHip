package com.team1.betterhip;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team1.betterhip.command.BetterHipCommand;

@Controller
public class CartController {
	
	
	@Autowired
	private SqlSession sqlSession;
	
	private BetterHipCommand cartList = null;
	
	@Autowired
	public void cartList(BetterHipCommand cartList) {
		this.cartList = cartList;
	}
 
	

	
	@RequestMapping("/list")
	public String list(Model model) {		
		cartList.excute(sqlSession, model);
		return "list";
	}
	

}
