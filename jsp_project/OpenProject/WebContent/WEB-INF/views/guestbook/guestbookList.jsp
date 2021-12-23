<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.guestBook-container {
		border: 1px solid #aaa;
		margin : 0;
		padding : 0;	
		max-width: 800px;
	}
	.guestBook_title{
		display: flex;
		justify-content: space-between;
		align-content: center;
	}
	.guestBook_title a{
		text-decoration: none;
		border-radius: 5px;
		padding: 10px;
		background-color: aqua;
	}
	
	.guestBook_header{
		text-align: center;
		border : 2px solid #aaa;
		padding : 10px 0;
	}
	.guestBook_header span{
		padding : 20px;
	}
	.guestBook-body_titles{
		display :flex;
		justify-content: space-between;
	}
	.guestBook-body_titles span{
		width: 250px;
		padding : 10px 0;
		border : 1px solid #aaa;
		text-align: center;
	}
	.guestBook_page-nav{
		display: flex;
		justify-content: center;
	}
	.guestBook_page-nav a{
		display : block;
		margin : 10px 10px;
		padding: 10px;
		border: 2px solid gray;
		border-radius: 5px;
		text-decoration: none;
	}
	.guestBook_page-nav a:hover {
		background-color: pink;
	}
}

</style>
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
	<c:if test="${empty listView}">
		<h1> 게시글이 없습니다! </h1>
	</c:if>
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
					<span>내용</span>
					<span>작성 일시</span>
					<span>작성자</span>
				</div>
				<c:forEach items="${listView.list}" var="guestbook">
					<div class="guestBook-body_titles">
						<span>${guestbook.idx}</span>
						<span>${guestbook.subject}</span>
						<span>${guestbook.content}</span>
						<span>${guestbook.regdate}</span>
						<span>${guestbook.writer}</span>
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