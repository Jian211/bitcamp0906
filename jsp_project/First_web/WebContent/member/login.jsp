<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Login Form Data</h1>

	<% 
		// 스크립트릿 영역 : java 문법 코드를 작성
		String uid = request.getParameter("userId");	
		String uPw = request.getParameter("userPw");
	// request : 내장객체( 변수의 선언이 없고, 객체의 생성도 없다 )
	%>

	<h1>
		아이디 :
		<%=uid%></h1>
	<h1>
		아이디 :
		<%=uPw%></h1>

</body>
</html>