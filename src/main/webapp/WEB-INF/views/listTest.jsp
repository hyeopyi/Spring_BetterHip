<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%

	session = request.getSession();
	session.setAttribute("USER_ID", "test11");


%>


<body>


	<form action="cartList">
	
	<input type="submit" value="ok">

	
	</form>

</body>
</html>