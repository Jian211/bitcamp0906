<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 내장객체의 속성은 데이터의 공유를 위해서 사용한다!!
	// 
	
	request.setAttribute("name", "SON");
	session.setAttribute("name", "LEE");
	application.setAttribute("name", "HWANG");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>
		request 영역의 name :
		<%= request.getAttribute("name")%>/
		${requestScope.name} / ${name}
	</h3>
	<h3>
		Session 영역의 name :
		<%= session.getAttribute("name")%>/
		${sessionScope.name} / ${name}
	</h3>
	<h3>
		application 영역의 name :
		<%= application.getAttribute("name")%>/
		${applicationScope.name} / ${name}
	</h3>

</body>
</html>