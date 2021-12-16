<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	#content > table {
		border : 0;
		border-collapse: collapse;
		width : 500px;
	}
	
	#content > table td, #content > table th {
		border : 1px solid #aaa;
	}

</style>
<title>부서관리 프로그램</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css">
<script>
function deleteDept(deptno){
	if(confirm('삭제하시겠습니까?')){
		// 삭제처리 할 수 있는 링크 url
		// http://localhost:8080/jdbc/dept/delete.do?deptno=?
		alert("삭제");
		location.href = 'delete.do?deptno='+deptno;
	}
}
</script>

</head>
<body>
	<%@ include file="/WEB-INF/views/frame/header.jsp" %>
	<%@ include file="/WEB-INF/views/frame/navi.jsp" %>
	
	<div id="content">
		<h3>부서리스트</h3>
		<hr>
		<table>
			<tr>
				<th>부서 번호</th>
				<th>부서 이름</th>
				<th>부서 위치</th>
				<th>관리</th>
			</tr>
			
			<c:if test="${not empty deptList}">
				<c:forEach items="${deptList}" var="dept" >
					<tr>
						<td>${dept.deptno}</td>
						<td>${dept.dname}</td>
						<td>${dept.loc}</td>
						<td>
							<a href="edit.do?deptno=${dept.deptno}">수정</a> 
							|
							<a href="javascript:deleteDept(${dept.deptno})">삭제</a>
						 </td>
					</tr>
				</c:forEach>
			</c:if>

			<c:if test="${empty deptList}">
				<td colspan="4">등록된 부서정보가 없스빈다.</td>
			</c:if>

		</table>
	
		부서 리스트가 보여집니다.
	</div>

</body>
</html>