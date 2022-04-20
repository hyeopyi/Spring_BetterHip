<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>넘어옴</h1>
						<c:forEach var="item" items="${Img}">
							<tr>
					
						 <td width="600" align="left">  <img src="data:cake_img/png;base64, ${item}" width="150" height="150"><br>
							   
					
							   
							   							   					
							</tr>   
						 </c:forEach>






</body>
</html>