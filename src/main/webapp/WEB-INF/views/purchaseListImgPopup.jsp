<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첨부이미지 팝업</title>
</head>
<body>


	<c:choose>
		<c:when test="${Purchase_Img.purchase_img_base64Image eq 'NO IMAGE'}">
			<img src = "/betterhip/resources/noimage.jpg" width = "150" height="200">
		</c:when>
		<c:otherwise>
			<img src="data:purchase_img/png;base64, ${Purchase_Img.purchase_img_base64Image }" width = "350" height="400">
		</c:otherwise>
	</c:choose>


</body>
</html>