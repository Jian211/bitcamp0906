<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/guestBook/guestBookListView.css">
<title>Guest Book Edit</title>
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

		<div class="listView-container">
			<form method="post" >
				<div class="listView_subtitle">
					<input type="text" name="editedGuestBook" value="${guestBook.subject}">
					<input type="hidden" name="editedGuestBook" value="${guestBook.idx}">
				</div>
				<div class="listView_userInfo">
					<img style="width: 30px; border-radius: 50%;" src="${pageContext.request.contextPath}/uploadfile/${guestBook.photo}"> 
					<h3>${guestBook.writer}</h3>
					<h3>${guestBook.regdate}</h3>
					<c:if test="${guestBook.writer eq loginInfo.userName}">
						<input type="submit" value="수정완료" >
						<h3 class="userInfo-deleteAndEdit"><a href="javascript:editCancle()">수정취소</a></h3>
					</c:if>
				</div>
				<div class="listView_content-form">
					<input type="text" name="editedGuestBook" value="${guestBook.content}">
				</div>
			</form>
		</div>
	</div>

	<!--  content 시작	-->

	<!--  js 추가	-->	
	<%@ include file="/WEB-INF/views/frame/footerSet.jsp" %>
	<script>
	
		function editCancle(){
			if(confirm("수정을 취소하시겠습니까?")){
				history.go(-1);
// 				location.href = 'delete.do?idx='+idx;
			};
		}
	</script>
</body>
</html>