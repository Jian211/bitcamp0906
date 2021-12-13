<%@page import="member.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
	List<Member> members = new ArrayList<>();
	members.add(new Member(null,20));
	members.add(new Member("이강인",15));
	members.add(new Member("손흥민",25));
	members.add(new Member("박지성",30));

	request.setAttribute("members", members);
	request.setAttribute("pageTotalCnt", 7);
	request.setAttribute("str", "손흥민,010-0000-0000,런던");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forTokens items="지명근,010-5015-3333" delims="," var="sel">
		${sel}
	</c:forTokens>
	
	
	<hr>

	<c:forEach var="member" items="${members}" varStatus="stat">
		<hr>
			<h6>${stat.index}</h6>
			<h6>${stat.count}</h6>
			<h6>${member.name}</h6>
			<h6>${member.age}</h6>
		<hr>
	</c:forEach>

	<hr>
	<h1>회원 리스트 출력</h1>
	<hr>
	
	<table border="1">
		<tr>
			<th> index </th>
			<th> Count </th>
			<th> 이름 </th>
			<th> 나이 </th>
		</tr>

		<c:forEach items="${members}" var="member" varStatus="stat" >
			<tr>
				<td>${stat.index}</td>
				<td>${stat.count}</td>
				<td>${member.name}</td>
				<td>${member.age}</td>
			</tr>
		</c:forEach>	
		<!--  숫자 나열 : 페이지 숫자	 -->
		<!--  페이지 넘버링 -->
	</table>
	<div>
	<c:forEach begin="1" end="${pageTotalCnt}" var="i" >
		[${i}]
	</c:forEach>
	</div>
	
	<hr>
	
	<c:forTokens items="${str}" delims=",-" var="info" varStatus="stat">
		<c:if test="${stat.index == 1}">
			${info} <br>
		</c:if>
		
	</c:forTokens>
		
	
	
</body>
</html>