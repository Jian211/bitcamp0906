<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>

<%@ include file="/WEB-INF/views/frame/pageSet.jsp" %>

</head>
<body>

	<!--  네비 시작	-->
	<%@ include file="/WEB-INF/views/frame/nav.jsp" %>
	<!--  네비 끝	-->
	
	<!--  content 시작	-->
	<div class="main-contanier"> 
		<!--  헤더 시작	 -->
		<%@ include file="/WEB-INF/views/frame/header.jsp" %>
		<!--  헤더 끝	-->

		<h3>회원가입</h3>
		<hr>
		<table>
			<tr>
				<td>아이디</td>
				<td>${member.userid}</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>${member.pw}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${member.username}</td>
			</tr>
			<tr>
				<td>사진</td>
				<td><img src="${pageContext.request.contextPath}/uploadfile/${member.photo}"></td>
			</tr>
			<tr>
				<td>가입일</td>
				<td>${member.regDate}</td>
			</tr>
		</table>
		
	</div>
	<!--  content 시작	-->

	<!--  js 추가	-->
	<%@ include file="/WEB-INF/views/frame/footerSet.jsp" %>
</body>
</html>
