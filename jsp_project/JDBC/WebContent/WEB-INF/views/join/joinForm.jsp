<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome Join</h2>
	<form action="join.do" method="post">
		<input type="text" name="uId" placeholder="아이디를 입력해주세요.">
		<input type="password" name="uPw" placeholder="비밀번호를 입력해주세요.">
		<input type="text" name="uName" placeholder="이름을 입력해주세요.">
		<input type="submit" value="회원가입">
	</form>
</body>
</html>