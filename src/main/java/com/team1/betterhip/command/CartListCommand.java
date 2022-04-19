package com.team1.betterhip.command;





import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;


import com.team1.betterhip.dao.CartDao;
import com.team1.betterhip.dto.CartDto;

public class CartListCommand implements BetterHipCommand {

	@Override
	public void excute(SqlSession sqlSession, Model model) {
		
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		
		
		String user_id = session.getAttribute("USER_ID").toString();

		CartDao dao = sqlSession.getMapper(CartDao.class);
		
		ArrayList<CartDto> dtos = dao.CartListDao(user_id);

		model.addAttribute("CartList", dtos);
	}

}
