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
	<h1> 로그인 </h1>
	<h3>로그인 페이지 입니다.	</h3>
	<hr>
	<h6> 현재경로  :  http://localhost:8080/mvc/member/loginForm.do</h6>
	<h6> 응답경로  :  http://localhost:8080/mvc/member/login.do</h6>
	
	<form action="login.do" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="uid" id="uid"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="upw" id="upw"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="LOGIN"></td>
			</tr>
		</table>	
	</form>
		
</body>
</html>