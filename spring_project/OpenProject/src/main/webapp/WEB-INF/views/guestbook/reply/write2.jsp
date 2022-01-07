<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty replyList}">
	<c:forEach items="${replyList}" var="reply" >
		
		<div id="reply${reply.idx}" class="reply-writeForm">
			<div class="reply-img">
				<img src="/op/uploadfile/${reply.photo}">
			</div>
			
			<div class="reply-content">
				<h4>${reply.userName} 유저이름</h4>
				<div>
					<pre>${reply.content} 컨텐츠</pre>
				</div>
				<div>${reply.regDate}</div>
			</div>
			
			<div class="reply-close">
				<div onclick="deleteReply(${reply.idx})">X</div>
			</div>
		</div>

	</c:forEach>
</c:if>