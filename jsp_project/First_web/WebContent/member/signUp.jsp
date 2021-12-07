<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>User ID : <%= request.getParameter("userId") %></h1>
	<h1>User PW : <%= request.getParameter("userPw") %></h1>
	<h1>User Name : <%= request.getParameter("userName") %></h1>
	<h1>Comment : <%= request.getParameter("comment") %></h1>
	<h1>Gender : <%= request.getParameter("gender") %></h1>
	<% 
		String [] interests = request.getParameterValues("interest");
		if(interests == null){
			out.println("<h1>interset : 선택된 관심사가 없습니다.  </h1>");
		} else {
			for(int i=0; i< interests.length;i++){
				out.println("<h1>interset : "+ interests[i] +"</h1>");
			}
		}
	%>
	
	<h1>byear : <%= request.getParameter("byear") %></h1>
</body>
</html>