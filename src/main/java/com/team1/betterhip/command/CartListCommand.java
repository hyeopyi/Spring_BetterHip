package com.team1.betterhip.command;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import java.util.Base64;
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
	

		CartDao dao = sqlSession.getMapper(CartDao.class);		
		ArrayList<CartDto> dtos = dao.CartListDao(session.getAttribute("USER_ID").toString());
		
		for(int i=0; i<dtos.size(); i++) {
			// Blob to String
			try {
				
				InputStream inputStream = dtos.get(i).getCake_blob_img().getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int byteRead = -1;
				
				while((byteRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, byteRead);
				}			
				
				byte[] imageBytes = outputStream.toByteArray();
				
				dtos.get(i).setCake_img(Base64.getEncoder().encodeToString(imageBytes));				
				inputStream.close();
				outputStream.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			try {				
				
				InputStream inputStream = dtos.get(i).getPurchase_img().getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer1 = new byte[4096];
				int byteRead1 = -1;
				
				while((byteRead1 = inputStream.read(buffer1)) != -1) {
					outputStream.write(buffer1, 0, byteRead1);
				}			
	
				byte[] imageBytes1 = outputStream.toByteArray();
				dtos.get(i).setCake_custom_img(Base64.getEncoder().encodeToString(imageBytes1));
				
				inputStream.close();
				outputStream.close();
			
				
			}catch(Exception e) {
				dtos.get(i).setCake_custom_img("XXX");
		
			}
			
		}
		
		model.addAttribute("CartList", dtos);
	}

}
