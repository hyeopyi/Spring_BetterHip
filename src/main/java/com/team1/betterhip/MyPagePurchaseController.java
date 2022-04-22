package com.team1.betterhip;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team1.betterhip.command.MyPageCommand;

@Controller
public class MyPagePurchaseController {


//SqlSession 
	@Autowired
	private SqlSession sqlSession;
	
	
//Command 
	private MyPageCommand PurchaseListCommand = null; 
	private MyPageCommand PurchaseListImgPopupCommand = null; 
	private MyPageCommand PurchaseQueryListCommand = null; 
	private MyPageCommand CancelRefundListCommand = null; 
	private MyPageCommand CancelRefundQueryListCommand = null; 
	private MyPageCommand PurchaseCancelCommand = null; 

	
	@Autowired
	private void auto(MyPageCommand purchaseList,
					  MyPageCommand purchaseListImgPopup,
					  MyPageCommand purchaseQueryList,
					  MyPageCommand cancelrefundList,
					  MyPageCommand cancelrefundQueryList,
					  MyPageCommand purchaseCancel) {
		
		this.PurchaseListCommand = purchaseList;
		this.PurchaseListImgPopupCommand = purchaseListImgPopup; 
		this.PurchaseQueryListCommand = purchaseQueryList;
		this.CancelRefundListCommand = cancelrefundList;
		this.CancelRefundQueryListCommand = cancelrefundQueryList;
		this.PurchaseCancelCommand = purchaseCancel; 
	}
	
	
//RequestMapping
	
	@RequestMapping("/purchaseList")
	public String purchaseList(HttpServletRequest request, HttpSession session, Model model) {
		PurchaseListCommand.execute3(request, session, sqlSession, model); 
		return "purchaseList";
	}
	
	@RequestMapping("/purchaseListImgPopup")
	public String purchaseListImgPopup(HttpServletRequest request, HttpSession session, Model model) {
		PurchaseListImgPopupCommand.execute3(request, session, sqlSession, model);
		return "purchaseListImgPopup";
	}
	
	@RequestMapping("/purchaseQueryList")
	public String purchaseQueryList(HttpServletRequest request, HttpSession session, Model model) {
		PurchaseQueryListCommand.execute3(request, session, sqlSession, model); 
		return "purchaseList";
	}
	
	@RequestMapping("/refundList")
	public String refundList(HttpServletRequest request, HttpSession session, Model model) {
		CancelRefundListCommand.execute3(request, session, sqlSession, model);
		return "cancelrefundList";
	}
	
	@RequestMapping("/refundQueryList")
	public String refundQueryList(HttpServletRequest request, HttpSession session, Model model) {
		CancelRefundQueryListCommand.execute3(request, session, sqlSession, model);
		return "cancelrefundList";
	}
	
	@RequestMapping("/purchaseCancel")
	public String purchaseCancel(HttpServletRequest request, HttpSession session) {
		PurchaseCancelCommand.execute2(request, session, sqlSession);
		return "purchaseCancelResult";
	}
	
	
	
	
	
}//End 
