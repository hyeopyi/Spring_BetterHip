package com.team1.betterhip.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.team1.betterhip.dao.CartDao;

public class CartOrderCommand implements BetterHipCommand {

	@Override
	public void excute(HttpServletRequest request, SqlSession sqlSession, Model model) {
		
		String[] orderList = request.getParameterValues("chk");
		CartDao dao = sqlSession.getMapper(CartDao.class);
		String viewPage = "fail";
		
		try {
			
			for(String purchase_id : orderList) {
				dao.CartOrderDao(purchase_id);
			}
			
			viewPage = "paymentList";
			
		}catch (Exception e) {
			System.out.println(e.toString());
		}		
		
		request.setAttribute("viewPage", viewPage);

	} // excute_end

}
