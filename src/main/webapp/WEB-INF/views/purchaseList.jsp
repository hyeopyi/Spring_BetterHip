<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Better Hip 나의 쇼핑 내역</title>

<style type="text/css">
#footer{clear: both;}
</style>

<link rel="stylesheet" href="css/aos.css">
<link rel="stylesheet" href="css/signupForm.css">
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">


<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/templatemo.css">
<link rel="stylesheet" href="css/custom.css">

<!-- Load fonts style after rendering the layout styles -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="css/fontawesome.min.css">

<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>

<body>
<!--Header-->
<div id="wrap">
	<header>
		<div class="top-header">
			<div class="container clearfix">
			<div class="member-area">
				<a href="logout">로그아웃</a>
				<span class="bar">|</span>
				<a href="userInfoModifyView">내 정보</a>
				<span class="bar">|</span>
				<a href="#!">장바구니</a>
				<span class="bar">|</span>
				<a href="purchaseList">My Page</a>
			</div>
			</div>
		</div>
		<div class="main-header">
			<div class="container clearfix">
			<h1 class="logo">
				<a href="#!">
				<img src="img/logo.png" alt="로고" width="120">
				</a>
			</h1>
			<h1 class="logo_text">
				<a href="main">Better Hip</a>
			</h1>
			<div class="gnb">
				<ul class="clearfix">
					<li class="nav-item info">
						<a href="#!" class="nav-link">이용안내</a>
						<div class="dropdown">
						<ul>
							<li>
							<a href="#!">케이크 안내</a>
							</li>
							<li>
							<a href="#!">픽업 방법</a>
							</li>
							<li>
							<a href="#!">이용 안내</a>
							</li>
						</ul>
						</div>
					</li>
					<li class="nav-item cake">
						<a href="main" class="nav-link">케이크 주문</a>
					</li>
					<li class="nav-item intro">
						<a href="#!" class="nav-link">소개</a>
					</li>
					<li class="nav-item notice">
						<a href="#!" class="nav-link">공지사항</a>
					</li>
				</ul>
			</div>
			</div>
		</div>
	</header>
</div>

<!--사이드 마이페이지 메뉴-->
<div style="float:left; margin-right:200px;">
<h3>나의 쇼핑 내역</h3>
<p><a href="purchaseList">주문 조회</a></p>
<p><a href="refundList">취소/환불 조회</a></p>

<br>
<h3>회원 정보</h3>
<p><a href="userInfoModifyView">회원정보 변경</a></p>
<p><a href="userInfoDeleteView">회원 탈퇴</a></p>
</div>

<!--주문조회 메인-->
<!--오늘 날짜 가져오는 자바 스크립트립-->
<%
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
Date date = new Date();
String currentDate = format.format(date);
%>

	<div class="purchaseList" style="margin-left: 434px">
		<div class="titlewrap" style="margin-left:400px">
		<div><h2 align="center" style="display: flex;margin-left: 130px;">나의 쇼핑 내역</h2></div>
		<div><h2 align="center"style="display: flex;margin-left: 165px;">주문 조회 </h2></div>
		</div>
		

		<!-- 주문접수 / 상품준비중 / 픽업완료 주문 수 count table  -->
		<table border="2" style="margin-left: 300px;">
			<tr>
				<th width="200" height="10" style="text-align: center;">주문접수</th>
				<th width="200" height="10" style="text-align: center;">상품준비중</th>
				<th width="200" height="10" style="text-align: center;">픽업완료</th>
			</tr>
			<tr>
				<td width="200" height="10" style="text-align: center;">${purchase_status_count_3 } </td>
				<td width="200" height="10" style="text-align: center;">${purchase_status_count_101 }</td>
				<td width="200" height="10" style="text-align: center;">${purchase_status_count_103 }</td>
			</tr>
		</table>
		<br>
 
		<!-- 주문내역 날짜별 조회 -->
		<form action="purchaseQueryList" method="post">
			<table>
				<tr>
					<td>
					<input type="date" name="startDate" value="${userInfo.user_joindate_string }" size="20" > 
					~ <input type="date" name="endDate" value="<%=currentDate%>" size="20" >
					<input type="submit" value="조회" size="10">
					<br>
					</td>
				</tr>
			</table>
		</form>

 		<!-- 주문내역 리스트 테이블  -->
		<table border="1">
			<tr>
				<th width="200" height="10" style="text-align: center;">주문번호</th>
				<th width="400" height="10" style="text-align: center;" colspan="2">상품정보</th>
				<th width="100" height="10" style="text-align: center;">수량</th>
				<th width="100" height="10" style="text-align: center;">주문금액</th>
				<th width="100" height="10" style="text-align: center;">주문상태</th>
				<th width="100" height="10" style="text-align: center;">픽업일자</th>
				<th width="100" height="10" style="text-align: center;">주문취소</th>
			</tr>
			
			<c:forEach items="${purchaseList }" var="dto">
			
				<tr>
					<td width="200" height="10" rowspan="2" style="text-align: center;">${dto.purchase_date_string }${dto.purchase_id }</td>
					<td width="150" height="200" rowspan="2"><img src="data:cake_img/png;base64, ${dto.cake_img_base64Image }" width = "120" height="150"></td>
					<td width="100" height="10" style="text-align: center;">${dto.cake_name }</td>
					<td width="100" height="10" rowspan="2" style="text-align: center;">${dto.purchase_quantity }</td>
					<td width="100" height="10" rowspan="2" style="text-align: center;">${dto.purchase_price_string }원</td>
					<td width="100" height="10" rowspan="2" style="text-align: center;">${dto.purchase_status }</td>
					<td width="100" height="10" rowspan="2" style="text-align: center;">${dto.purchase_pickup_date_string }</td>
					<td width="100" height="10" rowspan="2" style="text-align: center;">
						<c:choose>
							<c:when test="${dto.purchase_status eq '주문접수'}">
								<input type="button" value="취소하기" onclick="check(${dto.purchase_id })">
							</c:when>
							<c:otherwise>
								<input type="button" value="취소불가" readonly="readonly" style="background-color: darkgrey">
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td width="250" height="20" style="text-align: center;">
					옵션: ${dto.cake_option }<br> 
					레터링: ${dto.purchase_text }&nbsp;
					<button onclick = "window.open('purchaseListImgPopup?purchase_id=${dto.purchase_id}','window_name', 'width=500, height=500, location=no, status=no, scrollbars = yes');">
					첨부이미지</button>
					</td>
				</tr>
			
			</c:forEach>
			
		</table>	
	</div>
		<br><br>
	
	
<!-- Start Footer -->
    <footer class="bg-dark" id="footer">
        <div class="footer_container">

            <div class="row_footer">                        
                <div class="w-100 bg-black py-3">
                    <ul class="list-unstyled text-light footer-link-list">
                        <li><h5>Better Hip</h5></li>
                        <!-- <li><a class="text-decoration-none" href="#">이용약관      |      </a>
                        <a class="text-decoration-none" href="#">개인정보처리방침      |      </a>
                        <a class="text-decoration-none" href="#">이메일무단수집거부      |      </a></li> -->
                        <p class="text-center text-light">
                            <a class="text-decoration-none" href="#">이용약관      |      </a>
                            <a class="text-decoration-none" href="#">개인정보처리방침      |      </a>
                            <a class="text-decoration-none" href="#">이메일무단수집거부      |      </a>
                        </p>
                        <li><a>통신판매신고번호:2021-서울서초-0413</a></li>
                        <li><a>사업자등록번호: 000-00-00000 주식회사 배러힙</a></li>
                        <li><a>주소: 서울특별시 서초구 서초동 1305 서산빌딩</a></li>
                        <li><a>대표자: 원경호</a></li>
                        <li><a>전화번호: 02-000-0000</a></li>
                    </ul>
                </div>

            </div>
        </div>
        <div class="w-100 bg-black py-3">
            <div class="footer_2_container">
                <div class="row pt-2">
                    <div class="col-12">
                        <p class="text-left text-light">
                            Copyright &copy; 배러힙 2022 Better Hip
                            | Designed by <a rel="sponsored" href="https://betterhip.dothome.com" target="_blank">Betterhip</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>

    </footer>
    <!-- End Footer -->

    <!-- Start Script -->
    <script src="../BetterHip/assets/js/jquery-1.11.0.min.js"></script>
    <script src="../BetterHip/assets/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="../BetterHip/assets/js/bootstrap.bundle.min.js"></script>
    <script src="../BetterHip/assets/js/templatemo.js"></script>
    <script src="../BetterHip/assets/js/custom.js"></script>
    <!-- End Script -->
</body>
<!--주문 취소 컨펌 alert-->
<script type="text/javascript">

function check(purchase_id){
	if(confirm("주문을 취소하시겠습니까?")){
		location.href = "purchaseCancel?purchase_id="+purchase_id;
	}
}
</script>
</html>