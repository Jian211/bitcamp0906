<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css">
<title>Insert title here</title>
</head>
<body>
<!-- 	<h1>Index.jsp</h1> -->
<!-- 	<h3> -->
<%-- 		<a href="${pageContext.request.contextPath}/member/loginForm.do">로그인</a> --%>
<%-- 		<a href="${pageContext.request.contextPath}/member/mypage.do">My Page</a> --%>
<!-- 	</h3> -->
	
	<form action="#" method="post">
		ID : <input type="text" name="uId">
		PW : <input type="password" name="uPw">
		Name : <input type="text" name="uName">
		Date : <input type="text" name="uDate">
	</form>
	
</body>
</html>