package com.team1.betterhip.command;

import javax.servlet.http.HttpServletRequest;


import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.team1.betterhip.dao.CartDao;

public class CartDeleteCommand implements BetterHipCommand {

	@Override
	public void excute(HttpServletRequest request, SqlSession sqlSession, Model model) {
		
		String[] orderList = request.getParameterValues("chk");
		CartDao dao = sqlSession.getMapper(CartDao.class);
		String viewPage = "fail";
		
		try {
			
			for(String purchase_id : orderList) {					
				dao.CartDeleteDao(purchase_id);
			}
			
			viewPage = "redirect:cartList";
			
		}catch (Exception e) {			
			System.out.println(e.toString());

		}
		
		request.setAttribute("viewPage", viewPage);		
		
	}  // excute_end

}
