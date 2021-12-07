<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String title2 = "News"; // 에러발생 예상!
%>
<div>
	<h3><%= title2 %></h3>
	<hr>
	<ul>
		<%
			for(int i=0 ; i < 5; i++){
				out.println("<li>"+i+"</li>");
			}
		%>
	</ul>
</div>