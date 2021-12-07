<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie [] cookies =  request.getCookies();
		
		// 쿠키 데이터의 저장
		// 쿠키 이름 = 값
		
		if(cookies != null && cookies.length > 0) {
			for(Cookie cookie : cookies){
				out.println(cookie.getName()+"="+cookie.getValue());
			}
		}
	%>
	<hr>
	
	<h3>host : <%= request.getHeader("host") %></h3>
	<%
		Enumeration headers = request.getHeaderNames();
		while(headers.hasMoreElements()){
			String headerName = (String)headers.nextElement();
			String value = request.getHeader(headerName);
			out.println("<h4>"+headerName+"="+value+"</h4>");
		}
		
	%>
	
	
</body>
</html>