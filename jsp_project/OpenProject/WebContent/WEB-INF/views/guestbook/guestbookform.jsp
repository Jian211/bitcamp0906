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
		<h3>게시글</h3>
		<hr>
		<form method="post">
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="subject"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><input type="text" name="content"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="등록">
						<input type="reset">
					</td>
				</tr>
			</table>
		</form>
		
	</div>
	<!--  content 시작	-->

	<!--  js 추가	-->
	<%@ include file="/WEB-INF/views/frame/footerSet.jsp" %>
</body>
</html>