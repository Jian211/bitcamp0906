<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/guestBook/guestBookListView.css">
<title>Guest Book List View </title>
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
	<div class="listView-container">
		<div class="listView_subtitle">
			<h2> ${guestBook.subject}</h2>	
			<h2 hidden="">${guestBook.idx}</h2>
		</div>
		<div class="listView_userInfo">
			<img alt="#" src="#"> 
			<h3>${guestBook.writer}</h3>
			<h3>${guestBook.regdate}</h3>
			<c:if test="${guestBook.writer eq loginInfo.userName}">
				<h3 class="userInfo-deleteAndEdit"><a href="edit.do?guestBook=${guestBook}">수정</a></h3>
				<h3 class="userInfo-deleteAndEdit"><a href="javascript:deleteList(${guestBook.idx})">삭제</a></h3>
			</c:if>
		</div>
		<div class="listView_content-form">
			<h3>${guestBook.content}</h3>
		</div>
		<hr>
		<div class="listView_reply-container">
			<div>
				<h2>?개의 댓글</h2>
				<form method="get">
					<input type="text" placeholder="댓글을 작성하세요.">
					<input type="submit" value="댓글 작성">
				</form>
			</div>
			<div>
				댓글들의 정보 
			</div>
			
		</div>
	</div>

	<!--  content 시작	-->

	<!--  js 추가  -->
	<%@ include file="/WEB-INF/views/frame/footerSet.jsp" %>
	<script>
		function deleteList(idx){
			if(confirm("해당 게시글을 삭제하시겠습니까?")){
				location.href = 'delete.do?idx='+idx;
			};
		}
	</script>
</body>
</html>