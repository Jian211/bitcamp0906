<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println("mypagesfd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>마이페이지</h1>
	<h1> Mypage : ${pageContext.request.requestURI}</h1>
	<h1> Mypage : ${pageContext.request.requestURL}</h1>
</body>
</html>