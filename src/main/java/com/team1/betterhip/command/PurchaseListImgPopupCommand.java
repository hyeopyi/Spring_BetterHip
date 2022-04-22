package com.team1.betterhip.command;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.team1.betterhip.dao.PurchaseDao;
import com.team1.betterhip.dto.PurchaseListImgPopupDto;

public class PurchaseListImgPopupCommand implements MyPageCommand {

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

	}

	@Override
	public void execute3(HttpServletRequest request, HttpSession session, SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub

		int purchase_id = Integer.parseInt(request.getParameter("purchase_id"));

		PurchaseDao dao = sqlSession.getMapper(PurchaseDao.class); 
		PurchaseListImgPopupDto dto = dao.purchaseListImgPopup(purchase_id);
		//purchase_img 유무에 따라 다른 이미지 출력  
		
				if(dto.getPurchase_img_fileName() == null) {
					//없을 경우 "NO IMAGE"
					dto.setPurchase_img_base64Image("NO IMAGE");
				}else {
					//있을 경우 Byte [] -> base64 String 변환 
					Byte[] purchase_img = (Byte[]) dto.getPurchase_img();
					byte[] purchase_img_byte = new byte[purchase_img.length]; 
					for(int i=0; i<purchase_img_byte.length; i++) {
						purchase_img_byte[i] = purchase_img[i]; 
					}
					String purchase_img_base64 = Base64.getEncoder().encodeToString(purchase_img_byte);
					dto.setPurchase_img_base64Image(purchase_img_base64);
					
				}
				
				model.addAttribute("Purchase_Img", dto);
			
	}//execute3 

}
