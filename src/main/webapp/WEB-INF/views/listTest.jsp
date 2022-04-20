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
<%

	session = request.getSession();
	session.setAttribute("USER_ID", "test11");

<<<<<<< HEAD

%>


	<form action="cartList">
	

=======
	<form action="cartList">
		
>>>>>>> 892107128af5bb44ff82d4ab9b89ee0505db6d0c
		<input type="submit" value="ok">
	
	
	</form>

</body>
</html>