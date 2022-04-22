package com.team1.betterhip.command;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.team1.betterhip.dao.PurchaseDao;
import com.team1.betterhip.dao.UserInfoDao;
import com.team1.betterhip.dto.PurchaseListDto;
import com.team1.betterhip.dto.UserInfoDto;

public class CancelRefundQueryListCommand implements MyPageCommand {

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

		
		//USER_ID 세션으로 받기 
		HttpSession session1 = request.getSession(); 
		String USER_ID = (String) session.getAttribute("USER_ID"); 
				
		//사용자 지정 쿼리 날짜 받기 
		String queryStartDate = request.getParameter("startDate").toString();
		String queryEndDate = request.getParameter("endDate").toString();
				
		//회원정보 가져오는 다오 실행 
		UserInfoDao dao = new UserInfoDao(); 
		UserInfoDto dto = dao.userInfoViewDao(USER_ID);
			//가입날짜 형변환 (Timestamp -> String) : 날짜 검색 시 String으로 쓰기 위해 
			String user_joindate = new SimpleDateFormat("yyyy-MM-dd").format(dto.getUser_joindate());
			dto.setUser_joindate_string(user_joindate);
				
		model.addAttribute("userInfo", dto); 
				
				
		//취소 주문 조회 리스트 다오 실행 
						
			PurchaseDao dao1 = sqlSession.getMapper(PurchaseDao.class); 
			ArrayList<PurchaseListDto> dtos = dao1.cancelList_query(USER_ID, queryStartDate, queryEndDate); 
						
				//데이터 정제 
				for(int i=0; i<dtos.size(); i++) {
					
					//구매 금액 포맷 설정 
					String purchase_price = String.format("%,d", dtos.get(i).getPurchase_price());
					dtos.get(i).setPurchase_price_string(purchase_price);
								
					//구매날짜 형변환 
					String purchase_date = new SimpleDateFormat("yyyy-MM-dd").format(dtos.get(i).getPurchase_date());
					dtos.get(i).setPurchase_date_string(purchase_date);
								
					//픽업날짜 형변환 
					String purchase_pickup_date = new SimpleDateFormat("yyyy-MM-dd").format(dtos.get(i).getPurchase_pickup_date());
					dtos.get(i).setPurchase_pickup_date_string(purchase_pickup_date);
								
					//주문상태 문구 설정
					if(dtos.get(i).getPurchase_status().equals("3")) {
						dtos.get(i).setPurchase_status("주문접수");
					}else if (dtos.get(i).getPurchase_status().equals("101")) {
						dtos.get(i).setPurchase_status("상품준비중");
					}else if (dtos.get(i).getPurchase_status().equals("102")) {
						dtos.get(i).setPurchase_status("픽업중");
					}else {
						dtos.get(i).setPurchase_status("픽업완료");
					}
								
					//케이크 옵션 구성 하나로 합치기 
					String cake_option = dtos.get(i).getCustomize_size() + "/" + dtos.get(i).getCustomize_taste() 
									     + "/" + dtos.get(i).getCustomize_cream_type() + "/" + dtos.get(i).getCustomize_cream_color();
								
					dtos.get(i).setCake_option(cake_option); 
								
					//cake_img 가져오기 
						//Blob 데이터 : Byte [] (Wrapper Class) -> byte [] (primitive type) 변환 
						Byte[] cake_img = (Byte[]) dtos.get(i).getCake_img();
						byte[] cake_img_byte = new byte[cake_img.length];
						for (int j = 0; j < cake_img_byte.length; j++) {
							cake_img_byte[j] = cake_img[j];
						}
						//byte -> base64 String 변환 
						String cake_img_base64 = Base64.getEncoder().encodeToString(cake_img_byte);
						dtos.get(i).setCake_img_base64Image(cake_img_base64);
					}
				//주문 조회 리스트 전달 
				model.addAttribute("cancelList", dtos);

		//환불 주문 조회 리스트 다오 실행 
				
			PurchaseDao dao2 = sqlSession.getMapper(PurchaseDao.class); 
			ArrayList<PurchaseListDto> dtos1 = dao2.refundList_query(USER_ID, queryStartDate, queryEndDate); 
							
				//데이터 정제 
				for(int i=0; i<dtos1.size(); i++) {
									
					//구매 금액 포맷 설정 
					String purchase_price = String.format("%,d", dtos1.get(i).getPurchase_price());
					dtos1.get(i).setPurchase_price_string(purchase_price);
					
					//구매날짜 형변환 
					String purchase_date = new SimpleDateFormat("yyyy-MM-dd").format(dtos1.get(i).getPurchase_date());
					dtos1.get(i).setPurchase_date_string(purchase_date);
									
					//픽업날짜 형변환 
					String purchase_pickup_date = new SimpleDateFormat("yyyy-MM-dd").format(dtos1.get(i).getPurchase_pickup_date());
					dtos1.get(i).setPurchase_pickup_date_string(purchase_pickup_date);
									
					//주문상태 문구 설정
					if(dtos1.get(i).getPurchase_status().equals("3")) {
						dtos1.get(i).setPurchase_status("주문접수");
					}else if (dtos1.get(i).getPurchase_status().equals("101")) {
						dtos1.get(i).setPurchase_status("상품준비중");
					}else if (dtos1.get(i).getPurchase_status().equals("102")) {
						dtos1.get(i).setPurchase_status("픽업중");
					}else {
						dtos1.get(i).setPurchase_status("픽업완료");
					}
									
					//케이크 옵션 구성 하나로 합치기 
					String cake_option = dtos1.get(i).getCustomize_size() + "/" + dtos1.get(i).getCustomize_taste() 
									     + "/" + dtos1.get(i).getCustomize_cream_type() + "/" + dtos1.get(i).getCustomize_cream_color();
									
					dtos1.get(i).setCake_option(cake_option); 
									
					//cake_img 가져오기 
						//Blob 데이터 : Byte [] (Wrapper Class) -> byte [] (primitive type) 변환 
						Byte[] cake_img = (Byte[]) dtos1.get(i).getCake_img();
						byte[] cake_img_byte = new byte[cake_img.length];
						for (int j = 0; j < cake_img_byte.length; j++) {
							cake_img_byte[j] = cake_img[j];
						}
						//byte -> base64 String 변환 
						String cake_img_base64 = Base64.getEncoder().encodeToString(cake_img_byte);
						dtos1.get(i).setCake_img_base64Image(cake_img_base64);
					}
				//주문 조회 리스트 전달 
				model.addAttribute("refundList", dtos1);
		
		
	
	}//execute3

}