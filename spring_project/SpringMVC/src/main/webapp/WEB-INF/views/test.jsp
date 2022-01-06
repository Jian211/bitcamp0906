<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Index</title>
	<style>
		li {
			font-size: 1.5em;
			text-decoration: none;
		}
	</style>
</head>
<body>
	
	<h1>테스트중</h1>
	
	<form method="post">
		이름 : <input type="text" name="name"><br>
		나이 : <input type="number" name="age"><br>
		성별 : <input type="text" name="gender"><br>
		<input type="submit" value="제출">
	</form>

	<h1>${msg}</h1>
	
</body>
</html>