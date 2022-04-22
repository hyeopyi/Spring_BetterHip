package com.team1.betterhip.dao;

import java.util.ArrayList;
import com.team1.betterhip.dto.PurchaseListDto;
import com.team1.betterhip.dto.PurchaseListImgPopupDto;

public interface PurchaseDao {
	
	//주문 상태 별 카운트 다오 
	public int purchase_status_count_3(String USER_ID);
	public int purchase_status_count_101(String USER_ID);
	public int purchase_status_count_103(String USER_ID);
	
	//주문 상태 별 카운트 다오 - 날짜 쿼리 
	public int purchase_status_count_3_query(String USER_ID, String queryStartDate, String queryEndDate);
	public int purchase_status_count_101_query(String USER_ID, String queryStartDate, String queryEndDate);
	public int purchase_status_count_103_query(String USER_ID, String queryStartDate, String queryEndDate);
	
	
	//주문 조회 리스트 다오 
	public ArrayList<PurchaseListDto> purchaseList(String USER_ID);
	
	//취소 주문 조회 리스트 다오 
	public ArrayList<PurchaseListDto> cancelList(String USER_ID);
	
	//환불 주문 조회 리스트 다오 
	public ArrayList<PurchaseListDto> refundList(String USER_ID);
	
	//주문 조회 리스트 다오 - 날짜 쿼리
	public ArrayList<PurchaseListDto> purchaseList_query(String USER_ID, String queryStartDate, String queryEndDate);
	
	//취소 주문 조회 리스트 다오 - 날짜 쿼리
	public ArrayList<PurchaseListDto> cancelList_query(String USER_ID, String queryStartDate, String queryEndDate);
		
	//환불 주문 조회 리스트 다오 - 날짜 쿼리
	public ArrayList<PurchaseListDto> refundList_query(String USER_ID, String queryStartDate, String queryEndDate);
	
	//주문 내역의 첨부파일 이미지 팝업 다오 
	public PurchaseListImgPopupDto purchaseListImgPopup(int purchase_id); 
	
	//주문 취소 다오 
	public void purchaseCancel(int purchase_id);

}
