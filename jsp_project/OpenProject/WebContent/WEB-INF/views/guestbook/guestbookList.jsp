<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guest Book List </title>

<%@ include file="/WEB-INF/views/frame/pageSet.jsp" %>

</head>
<body>
	<!--  헤더 시작	 -->
	<%@ include file="/WEB-INF/views/frame/header.jsp" %>
	<!--  헤더 끝	-->

	<!--  네비 시작	-->
	<%@ include file="/WEB-INF/views/frame/nav.jsp" %>
	<!--  네비 끝	-->
	
	<!--  content 시작	-->
	<div>
		<div class="questBook-container">
			<div class="questBook_subject-form">
				<h3></h3>
				<div class="questBook_subject-form_userInfo">
					<img alt="" src="">
					<div>
						<h6>USER ID</h6>
						<h6>CREATE DATE</h6>
					</div>
				</div>
			</div>
			
			
		</div>
		
	</div>
	<!--  content 시작	-->

	<!--  js 추가	-->
	<%@ include file="/WEB-INF/views/frame/footerSet.jsp" %>
</body>
</html>