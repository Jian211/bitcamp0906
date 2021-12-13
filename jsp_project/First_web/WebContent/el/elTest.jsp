<%@page import="member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("id", "지명근");

	Member member = new Member("이강인", 20);
	request.setAttribute("member", member);

	Cookie cookie = new Cookie("coo","칙촉");
	response.addCookie(cookie);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	${pageContext.request.requestURI}		<br>  <!-- url주소 값을 가져온다. -->
	request의 name 속성: ${requestScope.id}	<br>  <!-- request의 key값을 보다 쉽게 가져온다. -->
	code 파라미터 : ${param}					<br>  <!-- 아직모르겠다  -->
	
	
	<h3> 수칙 연산자 </h3>

	${member.name}<br>
	
	param : ${param.type} / <%= request.getParameter("type") %> <br>
	cookie : ${cookie.JSESSIONID.value}  <br>
	header : ${header.host}
	
	<hr>
	<%= request.getContextPath() %> <br>
	<%= ((HttpServletRequest)pageContext.getRequest()).getContextPath()%><br>
	${pageContext.request.contextPath} <br>
	${pageContext.request.requestURL} <br>
	${pageContext.request.requestURI}

	<hr>
	
<%-- 	${pageContext}<br>   --%>
<%-- 	${pageScope}<br>	 --%>
<%-- 	${requestScope}<br>  --%>
<%-- 	${sessionScope}<br>  --%>
<%-- 	${applicationScope } --%>
<%-- 	${param}   			 --%>
<%-- 	${paramValues}		 --%>
<%-- 	${header} 			 --%>
<%-- 	${headerValues}		 --%>
<%-- 	${cookie.coo.value}	 --%>

		
	 
	
	
	
	
	

	
</body>
</html>