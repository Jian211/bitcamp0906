<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>login Form</h1>
	<hr>
	<form method="post">
		<input type="hidden" name="rurl" value="${url}" >
		ID <input type="text" name="userId"><br>
		PW <input type="text" name="userPw"><br>
		<input type="submit" value="제출"><br>
	</form>
</body>
</html>