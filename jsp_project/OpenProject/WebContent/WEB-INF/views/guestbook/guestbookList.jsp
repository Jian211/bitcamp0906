<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/guestBook/guestBookStyle.css">
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
	<c:if test="${not empty listView}">
		<div class="guestBook-container">
			<div class="guestBook_title">
				<h2> Guest Book List</h2>
				<a href="write.do">작성하기</a>
			</div>
			<div class="guestBook_header"> 
				<span>전체 리스트 : ${listView.totalCount}</span>
				<span>현재 페이지 : ${listView.currentPage}/${listView.pageTotalCount}</span>
			</div>
			<div class="guestBook-body">
				<div class="guestBook-body_titles">
					<span>idx</span>
					<span>제목</span>
				<!-- <span>내용</span> -->
					<span>작성 일시</span>
					<span>작성자</span>
				</div>
				<c:forEach items="${listView.list}" var="guestbookInfo">
					<div class="guestBook-body_titles">
						<span>${guestbookInfo.idx}</span>
						<span><a href="listView.do?listView=${guestbookInfo}">${guestbookInfo.subject}</a></span>
				<%-- 	<span>${guestbookInfo.content}</span> --%>
						<span>${guestbookInfo.regdate}</span>
						<span>${guestbookInfo.writer}</span>
					</div>
				</c:forEach>
			</div>
			<div class="guestBook_page-nav">
				<c:forEach begin="1" var="cnt" end="${listView.pageTotalCount}"> 
					<a href="list.do?pNum=${cnt}">${cnt}</a>
				</c:forEach>
			</div>
		</div>
	</c:if>
	<!--  content 시작	-->

	<!--  js 추가	-->
	<%@ include file="/WEB-INF/views/frame/footerSet.jsp" %>
	
</body>
</html>