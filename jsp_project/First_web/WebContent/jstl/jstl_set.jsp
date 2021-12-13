<%@page import="member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Member member = new Member("이강인",30);
	request.setAttribute("member", member);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${param}<br>
	${param.name}<br>
	${param.age}<br>
	<c:set value="리퀘스트 값입니다." var="val" scope="request"></c:set>
	<c:set var="sess" value="${param.name }" scope="session"/>
	${requestScope}
	<c:out value="${val}"></c:out>
	<hr>

	<c:set var="appName" value="JSP Program" scope="application"> </c:set>
	1. application 영역에 appName이라는 속성이 있는지 확인.
	2. 속성 생성 또는 덮어 쓰는 처리
	
	<hr>
	어플리케이션 값 확인 : ${applicationScope.appName} <br>
	리퀘스트       값 확인 : ${requestScope.val} <br>
	세션 값 확인: ${sessionScope.sess}<br>
	<hr>
	
	<c:set var="name" value="JSP" scope="session"/> 
	<hr>
	저장된 속성의 변수 값을 변경<br>
	
	setName("손흥민");<br>
		
	<c:set value="손흥민" target="${member}" property="name"/> 

	<c:remove var="sess" scope="session"/>	
	세션 값 확인: ${sessionScope.sess}<br>
	
	
</body>
</html>