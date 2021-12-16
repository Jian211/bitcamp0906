<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty dept}">
	<script>
		alert("잘못된 요청입니다. 이전페이지로 돌아갑니다.");
		history.go(-1);
	</script>
</c:if>
<c:if test="${not empty dept}">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	#content {
		padding : 20px;
	}
	
	#content > hr {
		border : 0;
		boder-top : 1px solid black;
		margin : 10px 0;
	}

</style>
<title>부서관리 프로그램</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/frame/header.jsp" %>
	<%@ include file="/WEB-INF/views/frame/navi.jsp" %>
	
	<div id="content">
		<h3>부서 정보 수정</h3>
		<hr>
		
		<form action="reg.do" method="post">
			<table>
				<tr>
					<td>부서 번호</td>
					<td><input type="text" name="deptno" value="${dept.deptno}" readonly></td>
				</tr>			
				<tr>
					<td>부서 이름</td>
					<td><input type="text" name="dname" value="${dept.dname}"></td>
				</tr>			
				<tr>
					<td>부서 위치</td>
					<td><input type="text" name="loc" value="${dept.loc}" ></td>
				</tr>			
				<tr>
					<td></td>
					<td>
						<input type="submit" value="수정">
						<input type="reset">
					</td>
				</tr>			
			</table>
		</form>
		
	</div>

</body>
</html>
</c:if>