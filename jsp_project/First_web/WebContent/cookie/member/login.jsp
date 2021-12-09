<%@page import="util.CookieBox"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String id = request.getParameter("id");	
	String pw = request.getParameter("pw");
	
	if(id.equals(pw)){
		response.addCookie(CookieBox.createCookie("LOGIN", "SUCCESS",-1,"/"));
		response.addCookie(CookieBox.createCookie("ID", id, -1, "/"));
	
	
	
%>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>로그인 되었습니다.</h1>
	<h3><a href="/first/cookie/member/mypage.jsp">mypage</a></h3>
</body>
</html>
<% } else {%>
<script>
	alert("로그인실패");
	history.go(-1);
</script>

<%} %>
