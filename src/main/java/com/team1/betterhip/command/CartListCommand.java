package com.team1.betterhip.command;

import java.util.ArrayList;
import java.util.Base64;
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
		int purchase_id = -1;
		
		for(int i=0; i<dtos.size(); i++) {
			purchase_id = dtos.get(i).getPurchase_id();				
			dtos.get(i).setCake_img_base64(Base64.getEncoder().encodeToString(dtos.get(i).getCake_img()));
			
			if(dao.customImageCheck(purchase_id) > 0) {			
				dtos.get(i).setCustom_img_base64(Base64.getEncoder().encodeToString(dao.CustomImageDao(purchase_id).getCustom_img()));
			}
		
		}
		
		model.addAttribute("CartList", dtos);

	} // excute_end

}
