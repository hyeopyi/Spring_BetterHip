package com.team1.betterhip.command;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import org.springframework.ui.Model;

import com.team1.betterhip.dao.CartDao;
import com.team1.betterhip.dto.CartDto;

public class CartListCommand implements BetterHipCommand {

	@Override
	public void excute(HttpServletRequest request, SqlSession sqlSession, Model model) {
		
		HttpSession session = request.getSession();
		String user_id = session.getAttribute("USER_ID").toString();	
		CartDao dao = sqlSession.getMapper(CartDao.class);
		ArrayList<CartDto> dtos = dao.CartListDao(user_id);
		HashMap<byte[], Object> map = null;
		int cake_id = -1;
		int purchase_id = -1;
		
		for(int i=0; i<dtos.size(); i++) {
			purchase_id = dtos.get(i).getPurchase_id();
			cake_id = dtos.get(i).getPurchase_cake_id();
			map = dao.cakeImageGet(cake_id);
			String cakeImage = Base64.getEncoder().encodeToString((byte[]) map.get("cake_img"));
			dtos.get(i).setCake_img_base64(cakeImage);
			
			if(dao.customImageCheck(purchase_id) > 0) {
				map = dao.customImageGet(purchase_id);
				String customImage = Base64.getEncoder().encodeToString((byte[]) map.get("purchase_img"));
				dtos.get(i).setCustom_img_base64(customImage);
			}else {
				dtos.get(i).setCustom_img_base64("xxx");
			}
		
		}
		
		model.addAttribute("CartList", dtos);

	} // excute_end

}
