<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
<%@ include file="/WEB-INF/views/frame/pageSet.jsp" %>

</head>
<body>

	<!--  네비 시작	-->
	<%@ include file="/WEB-INF/views/frame/nav.jsp" %>
	<!--  네비 끝	-->
	
	<!--  content 시작	-->
	<div class="main-contanier">
		<!--  헤더 시작	 -->
		<%@ include file="/WEB-INF/views/frame/header.jsp" %>
		<!--  헤더 끝	-->
	
		<h3>회원 리스트</h3>
		<hr>
		<div id="listInfo">
			전체 회원 수 : ${listView.totalCount}명, 현재 페이지 : ${listView.currentPage}/${listView.pageTotalCount}, 
		</div>
		<table>
			<tr>
				<th>idx</th>
				<th>user ID</th>
				<th>password</th>
				<th>user Name</th>
				<th>photo</th>
				<th>regdate</th>
				<th>manage</th>
			</tr>
			<c:if test="${empty listView.list}">
				<tr>
					<td colspan="7">등록된 회원 데이터가 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty listView.list}">
				<c:forEach items="${listView.list}" var="member">
					<tr>
						<td>${member.idx}</td>
						<td>${member.userid}</td>
						<td>${member.pw}</td>
						<td>${member.username}</td>
						<td>${member.photo}</td>
						<td>${member.regDate}</td>
						<td>
							<a href="edit.do?idx=${member.idx}">수정</a>
							<a href="javasript:delMember(${member.idx})">삭제</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<div id="paging">
			<c:if test="${listView.pageTotalCount > 0}">
				<c:forEach begin="1" end="${listView.pageTotalCount}" var="pnum">
					<a href="list.do?p=${pnum}">${pnum}</a>
				 </c:forEach>
			</c:if>
		</div>		
	</div>
	<!--  content 시작	-->

	<!--  js 추가	-->
	<%@ include file="/WEB-INF/views/frame/footerSet.jsp" %>
	
	<script>
		function delMember(idx){
			if(confirm("해당 회원 정보를 삭제하시겠습니까?")){
				location.href = 'delete.do?idx='+idx;
			};
		}
	</script>
</body>
</html>