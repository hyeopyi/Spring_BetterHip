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
							<tr>
							   
							   <td width="200" align="center"><a href="cakeChoice.do?cake_id=${item.purchase_cake_id }">
							   <img src="data:cake_img/png;base64, ${item.purchase_cake_img }" width="150" height="150"></a></td>
							   <td width="600" align="left"><h3><c:out value = "${item.purchase_cake_name }"/></h3><br>		   					
							</tr>   
						 </c:forEach>






</body>
</html>