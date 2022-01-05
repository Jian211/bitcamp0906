<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	<h3>${title}</h3>
	<form method="post" action="${pageContext.request.contextPath}/getParam1">
		ID <input type="text" name="userId">
		PW <input type="password" name="userPw">
		<input type="submit">
	</form>
</body>
</html>