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

	<c:forEach var="item" items="${CartList}">

     <p>번호 : ${item.purchase_id}</p>

     <p>수량 : ${item.purchase_quantity}</p>


</c:forEach>






</body>
</html>