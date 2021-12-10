<%@page import="member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
	request.setAttribute("member", new Member("소능민",12));

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${false}">  
		참일때 보여집니다~~
	</c:if>

	<c:if test="${member.age > 19}">  
		${member.name}(${member.age})
	</c:if>

	<c:if test="${member.age > 20}" var="chk" scope="session" />
	
</body>
</html>