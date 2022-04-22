<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 변경</title>

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
<div style="float:left; margin-right:600px;">
	<h3>나의 쇼핑 내역</h3>
	<p><a href="purchaseList">주문 조회</a></p>
	<p><a href="refundList">취소/환불 조회</a></p>
	
	<br>
	<h3>회원 정보</h3>
	<p><a href="userInfoModifyView">회원정보 변경</a></p>
	<p><a href="userInfoDeleteView">회원 탈퇴</a></p>
</div>

<!--회원정보 수정 메인-->
	<div style="float:left;">
		<form action="userInfoModify" name="userInfoModifyForm" method="post">
			<table>
				<tr>
					<td class="main-title" align="center" colspan="2"><b>BETTER HIP</b></td>
				</tr>
				<tr>
					<td class="main-title" align="center"colspan="2"><b>회원정보 변경</b></td>
				</tr>
				<tr>
					<td style="font-size:20px">아이디</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="user_id" size="41" value="${userInfo.user_id }" readonly="readonly"></td>
				</tr>
				<tr>
					<td style="font-size:20px">이름</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="user_name" size="41" value="${userInfo.user_name }" onfocus="this.select()"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="hidden" name="user_pw" size="41" value="${userInfo.user_pw }"></td>
				</tr>
				<tr>
					<td style="font-size:20px">새 비밀번호</td>
				</tr>
				<tr>
					<td colspan="2"><input placeholder="비밀번호는 숫자로 5~10자만 입력해주세요!!" 
					type="password" name="new_user_pw" size="41" id="pw" onkeyup="checkPw()" onchange="checkPwRe()" maxlength="10"></td>
				</tr>
				<tr>
					<td colspan="2"><span id="checking"></span></td>
				</tr>
				<tr>
					<td style="font-size:20px">비밀번호 재확인</td>
				</tr>
				<tr>
					<td colspan="2"><input type="password" name="new_user_pw_re" size="41" id="pw2" onkeyup="checkPwRe()"></td>
				</tr>
				<tr>
					<td colspan="2"><span id="check"></span></td>
				</tr>
				<tr>
					<td style="font-size:20px">이메일</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="user_email" size="41" value="${userInfo.user_email }" onfocus="this.select()"></td>
				</tr>
				<tr>
					<td style="font-size:20px">휴대폰 번호</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="user_phone" size="41" value="${userInfo.user_phone }" oninput="autoHyphen2(this)" maxlength="13" placeholder="ex) 010-6603-0058" onfocus="this.select()"> 
				</tr>
				<tr>
					<td style="font-size:20px">주소</td>
				</tr>
				<tr>
					<td>
						<input type="text" onclick="sample6_execDaumPostcode()" id="sample6_postcode" name="user_postcode" size="41" value= "${userInfo.user_postcode } " onfocus="this.select()">
						<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호"><br>
						<input type="text" onclick="sample6_execDaumPostcode()" readonly="readonly" id="sample6_address" size="41" placeholder="기본주소" name="user_address" value= "${userInfo.user_address } " onfocus="this.select()"><br>
						<input type="text" id="sample6_detailAddress" size="41" placeholder="상세주소 입력" name="user_address_detail" value= "${userInfo.user_address_detail } " onfocus="this.select()">
						<br><br>
					</td>
				</tr>
			
				<tr>
					<!-- 수정버튼  -->
					<td align="center" colspan="2">
						<input type="button" value="회원 정보 수정" name="btnSubmit" size="41" onclick="userInfoModify()" class="buttonUserInfoModify">
						<br><br><br>
					</td>
				</tr>
			</table>
		</form>
	</div>

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
<script src="js/jquery-1.11.0.min.js"></script>
<script src="js/jquery-migrate-1.2.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/templatemo.js"></script>
<script src="js/custom.js"></script>
<!-- End Script -->
</body>

<!-- 전화번호 자동 하이픈 -->
<script type="text/javascript">
const autoHyphen2 = (target) => {
	 target.value = target.value
	   .replace(/[^0-9]/g, '')
	  .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
	}
</script>

<!-- 비밀번호 재확인용 -->
<script type="text/javascript">
	function checkPw() {
		var regExpPasswd = /[0-9]{5,10}$/
		if(!regExpPasswd.test(document.getElementById('pw').value)) {
			document.getElementById('checking').innerHTML='사용할 수 없는 비밀번호 입니다.'
			document.getElementById('checking').style.color='red'
		} else {
			document.getElementById('checking').innerHTML='사용가능한 비밀번호 입니다.'
			document.getElementById('checking').style.color='blue'
		}
	}
	function checkPwRe() {
		if(document.getElementById('pw').value !='' && document.getElementById('pw2').value!=''){
            if(document.getElementById('pw').value==document.getElementById('pw2').value){
                document.getElementById('check').innerHTML='비밀번호가 일치합니다.'
                document.getElementById('check').style.color='blue';
            }
            else{
                document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
                document.getElementById('check').style.color='red';
            }
        }
	}
</script>


<!-- 유효성 검사 -->
<script type="text/javascript">
	function userInfoModify() {
		
		//숫자만 5~10자
		var regExpPasswd = /[0-9]{5,10}$/
		var regExpName = /^[가-힣]*$/
		var regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/
		var regExpEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i
		
		var form = document.userInfoModifyForm
		
		// 이름 확인
		var user_name = form.user_name.value
		if(user_name == "") {
			alert("이름을 입력해주세요")
			return
		}else {
			if (!regExpName.test(user_name)) {
				alert("이름은 한글만 입력해주세요")
				form.user_name.select()
				return
			}
		}
		
		
		// 비밀번호 확인(정보수정에서 필수로 하지 않을 거기 때문에 주석처리) 
/* 		var new_user_pw = form.new_user_pw.value
		var new_user_pw_re = form.new_user_pw_re.value
		 if(new_user_pw == "") {
			alert("비밀번호를 입력해주세요")
			return
		}else { 
		if (!regExpPasswd.test(new_user_pw)) {
				alert("사용할 수 없는 비밀번호 입니다.")
				form.new_user_pw.select()
				return
			}
			
		} 
		if(new_user_pw != new_user_pw_re) {
			alert("비밀번호 재확인이 잘못되었습니다.")
			return
		}
 */		
		//이메일 확인
		var user_email = form.user_email.value
		if(user_email == "") {
			alert("이메일을 입력해주세요")
			return
		}else {
			if (!regExpEmail.test(user_email)) {
				alert("이메일 입력을 확인해 주세요")
				form.user_email.select()
				return
			}
		}
		
		// 주소 확인
		var user_address = form.user_address.value
		if(user_address == "") {
			alert("주소를 입력해주세요")
			return
		}
		
		var user_address_detail = form.user_address_detail.value
		if(user_address_detail = "") {
			alert("상세주소를 입력해주세요")
			return
		}
		
		//핸드폰 번호 입력 확인 
		var user_phone = form.user_phone.value
		if(user_phone == "") {
			alert("핸드폰 번호를 입력해주세요")
			return
		}
		
		/* 위 유효성 검사 모두 통과 후 수정 완료 ALERT */
		if(confirm("수정이 완료 되었습니다.")){
			location.href = "userInfoModifyView";
		}
		
		document.userInfoModifyForm.submit();

	}
	
</script>

<!-- 주소 api 불러오기 -->
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    //document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    //document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr+extraAddr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>
</html>