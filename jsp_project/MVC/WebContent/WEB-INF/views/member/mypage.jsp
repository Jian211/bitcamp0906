<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not loginChk}">
	<script>
		alert("로그인이 필요한 페이지입니다.");
		location.href = '${pageContext.request.contextPath}/member/loginForm.do';
	</script>
</c:if>
<c:if test="${loginChk}">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css">
<title>Insert title here</title>
</head>
<body>
	<h1> My Page 입니다.</h1>
	<hr>
	<h3>${msg}</h3>
	<h3>${loginInfo.name}(${loginInfo.nic}) 님</h3>
</body>
</html>
</c:if>