<%@page import="member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setAttribute("member", new Member("소능민",32));
	session.setAttribute("chk", "chk1");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>test</h1>
	<c:if test="${true}">  
		참일때 보여집니다~~
	</c:if>

	<c:if test="${member.age > 19 and member.age gt 19}">  
		${member.name}(${member.age})
	</c:if>

	<c:if test="${member.age > 20}" var="abc" scope="session" />
		${abc}
	<hr>
	<c:if test="${member.age gt 20}">
		<c:out value="그는 성인입니다." />
	</c:if>
	
	<c:if test="${member.age ge 20 }">
		<c:out value="그는 아직 성인이 아닙니다."/>
	</c:if>
	
	${param.sel }
</body>
</html>