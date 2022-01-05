<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Logger Info</h1>
	ID <input type="text" name="userId" value="${userId}">
	PW <input type="password" name="userPw" value="${userPw}">
	
	<hr>
	${loginRequest}
</body>
</html>