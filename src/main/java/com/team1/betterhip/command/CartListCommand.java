package com.team1.betterhip.command;




import java.sql.Blob;
import java.util.ArrayList;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;

import org.springframework.ui.Model;
import com.team1.betterhip.dao.CartDao;
import com.team1.betterhip.dao.TestDao;
import com.team1.betterhip.dto.CartDto;

public class CartListCommand implements BetterHipCommand {

	@Override
	public void excute(HttpServletRequest request, SqlSession sqlSession, Model model) {
		
		

		
		
		
		TestDao dao = sqlSession.getMapper(TestDao.class);
		Blob img = dao.blobTestDao("1");
		System.out.println("dddddd");
		

	

//		CartDao dao = sqlSession.getMapper(CartDao.class);		
//	
//		ArrayList<CartDto> dtos = dao.CartListDao(session.getAttribute("USER_ID").toString());
//		ArrayList<byte[]> dtosB = dao.CartListImgDao(session.getAttribute("USER_ID").toString());
//
//
//
//		byte[] img = null;
//		for(int i=0; i<dtosB.size(); i++) {
//			img = Base64.getEncoder().encode(dtosB.get(i));
//		}
//
//		model.addAttribute("CartList", dtos);
//		model.addAttribute("Img", img);

	}

}
