<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> File upload </title>
</head>
<body>

	<h1>파일업로드</h1>
	<hr>
	
	<form method="post" enctype="multipart/form-data">
		이름 <input type="text" name="username" ><br>
		제목 <input type="text" name="title" ><br>
		파일 <input type="file" name="userfile" ><br>
		<input type="submit" value="제출">
	</form>
	
	
</body>
</html>