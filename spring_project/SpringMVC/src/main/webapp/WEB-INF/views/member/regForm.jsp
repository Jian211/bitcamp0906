<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<h1>회원가입 폼</h1>
 	<hr>
 	<form method="post">
 		<table>
 			<tr>
 				<td>아이디</td>
 				<td><input type="text" name="userId"></td>
 			</tr>
 			<tr>
 				<td>비밀번호</td>
 				<td><input type="text" name="userPw"></td>
 			</tr>
 			<tr>
 				<td>이름</td>
 				<td><input type="text" name="userName"></td>
 			</tr>
 			<tr>
 				<td>사진</td>
 				<td><input type="file" name="photo"></td>
 			</tr>
 			<tr>
 				<td></td>
 				<td>
	 				<input type="submit" value="회원가입">
	 				<input type="reset" value="리셋">
 				</td>
 			</tr>
 		
 		</table>
 		<a href="login">Login</a>
 	</form>
</body>
</html>