package com.team1.betterhip;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public void cartList(BetterHipCommand cartList, BetterHipCommand cartDelete, BetterHipCommand cartOrder) {
		this.cartList = cartList;
		this.cartDelete = cartDelete;
		this.cartOrder = cartOrder;
	}


	@RequestMapping("/cartList")
	public String cartlist(HttpServletRequest request, Model model) {	
		cartList.excute(request, sqlSession, model);
		return "cartList";
	}
	
	@RequestMapping("/cartDelete") 
	public String cartDelete(HttpServletRequest request, Model model) {
		cartDelete.excute(request, sqlSession, model);
		return request.getAttribute("viewPage").toString();		
	}
	
	
	@RequestMapping("/cartOrder")
	public String cartOrder(HttpServletRequest request, Model model) {
		cartOrder.excute(request, sqlSession, model);
		return "test";
	}

}
