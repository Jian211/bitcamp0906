<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie [] cookies = request.getCookies();
	
	// 2021.12.09
	CookieBox cookieBox = new CookieBox(request);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>쿠키 리스트</h1>
	<hr>
	<h3>
	<%
		// 전체 쿠기 출력
		if(cookies != null ){
			for(Cookie cookie : cookies){
				out.println(cookie.getName()+"="+cookie.getValue()+"<br>");				
				System.out.println(cookie.getName()+"="+cookie.getValue());
			}
		}

		// 쿠키 검색 
		if(cookies != null ){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("kname")){
					out.println(cookie.getName()+"="+cookie.getValue()+"<br>");				
					break;
				}
			}
		}
		
	%>
	<h3>
		<%= cookieBox.exists("uid") %>
	</h3>

	<h3>
		<%
			if(cookieBox.exists("uid")){
				Cookie c = cookieBox.getCookie("uid");
				out.println(c.getName() +"="+ cookieBox.getValue("uid"));
			}
		%>
	</h3>
	
		<a href="editCookie.jsp">쿠키 값 수정 </a>
		<a href="deleteCookie.jsp">쿠키 값 삭제 </a>
	
	</h3>

</body>
</html>