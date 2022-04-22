package com.team1.betterhip.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.team1.betterhip.dao.PurchaseDao;

public class PurchaseCancelCommand implements MyPageCommand {

	@Override
	public void execute(HttpServletRequest request, HttpSession session) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute1(HttpServletRequest request, HttpSession session, Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute2(HttpServletRequest request, HttpSession session, SqlSession sqlSession) {
		// TODO Auto-generated method stub

		//purchase_id 받기 
		int purchase_id = Integer.parseInt(request.getParameter("purchase_id")); 
		PurchaseDao dao = sqlSession.getMapper(PurchaseDao.class); 
		dao.purchaseCancel(purchase_id);
		
	}

	@Override
	public void execute3(HttpServletRequest request, HttpSession session, SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub

	}

}
