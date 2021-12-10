<%@page import="member.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
	List<Member> members = new ArrayList<>();
	members.add(new Member(null,20));
	members.add(new Member("이강인",15));
	members.add(new Member("손흥민",25));
	members.add(new Member("박지성",30));

	request.setAttribute("members", members);

%>
<style>
	.no_name {
		color
	}
</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${members[0].name}" escapeXml="falses">
		<span style="color:red">입력된 이름 정보가 없습니다.(출력 값이 Null일때 기본값 )</span>
	</c:out><br>
	
	<c:out value="${members[0].name}" default="NO NAME"/><br>

	<c:out value="${members[1].name}">
	</c:out><br>

	<hr>
	
	이 름 : 나 이<br>
	<!-- 회원 정보 리스트 출력 -->
	<c:forEach var="member" items="${members}" begin="" end="" >
		<c:out value="${member.name}" escapeXml="falses">
			<span class="no_name">no name </span>
		</c:out>
	</c:forEach>	
	
		
	
</body>
</html>