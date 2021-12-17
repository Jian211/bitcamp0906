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
	<h3> title       : ${title } </h3>
	<h3> userName    : ${username} </h3>
	<h3> fileName    : ${fileName} </h3>
	<h3> contentType : ${contentType} </h3>
	<h3> fileSize    : ${fileSize} </h3>
	
	<img alt="" src="${pageContext.request.contextPath }/uploadFile/${fileName}" width="100">
	
	
</body>
</html>