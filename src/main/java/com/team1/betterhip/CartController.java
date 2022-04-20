package com.team1.betterhip;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	private BetterHipCommand cartDelete = null;
	private BetterHipCommand cartOrder = null;
	
	
	@Autowired
	public void cartList(BetterHipCommand cartList) {
		this.cartList = cartList;
	}
	
	@Autowired
	public void cartDelete(BetterHipCommand cartDelete) {
		this.cartDelete = cartDelete;
	}
 
	@Autowired
	public void cartOrder(BetterHipCommand cartOrder) {
		this.cartOrder = cartOrder;
	}

	
	@RequestMapping("/list")
	public String test(HttpServletRequest request, Model model) {		
		return "listTest";

	}
	
	@RequestMapping("/cartList")
	public String cartlist(HttpServletRequest request, Model model) {			
		model.addAttribute("request", request);	
		cartList.excute(sqlSession, model);
		return "list";
	}
	
	@RequestMapping("/cartDelete") 
	public String cartDelete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		cartDelete.excute(sqlSession, model);
		return "test";
	}
	
	
	@RequestMapping("/cartOrder")
	public String cartOrder(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		cartOrder.excute(sqlSession, model);
		return "test";
	}

}
