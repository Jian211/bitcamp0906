<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setAttribute("now", new java.util.Date());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:timeZone value="HongKong">
		<h1>${now}</h1>
		<hr>
		<h2>날짜</h2>
		<fmt:formatDate value="${now}"/> <br>
		<fmt:formatDate value="${now}" type="date" /> <br>
		<fmt:formatDate value="${now}" type="date" dateStyle="full" /> <br>
		<fmt:formatDate value="${now}" type="date" dateStyle="short" /> <br>
		
		<h2>시간</h2>
		<fmt:formatDate value="${now}" type="time" /> <br>
		<fmt:formatDate value="${now}" type="time" timeStyle="full" /> <br>
		<fmt:formatDate value="${now}" type="time" timeStyle="short" /> <br>
	
		<h2>both</h2>
		<fmt:formatDate value="${now}" type="both"  /> <br>
		<fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short" /> <br>
	
		<h2>pattern</h2>
		<fmt:formatDate value="${now}"  pattern="z a h:mm" /> <br>
		<fmt:formatDate value="${now}"  pattern="a h:mm" /> <br>
		<fmt:formatDate value="${now}"  pattern="hh:mm:ss" /> <br>
		<fmt:formatDate value="${now}"  pattern="yyyy-MM-dd hh:mm:ss" /> <br>
		<fmt:formatDate value="${now}"  pattern="yyyy.MM.dd hh:mm" timeZone="UK" /> <br>
		
	</fmt:timeZone>
	
	
</body>
</html>