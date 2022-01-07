<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<header>
	<h1>Open Project</h1>
	<div id="loginInfoArea">
		<c:if test="${empty loginInfo}">
			<a href="${pageContext.request.contextPath}/member/login.do">login</a>
		</c:if>

<%-- 		<c:if test="${not empty loginInfo}"> --%>
<%-- 			<img src="${pageContext.request.contextPath}/uploadfile/${loginInfo.photo}"> --%>
<%-- 			${loginInfo.userName}(${loginInfo.userId})			 --%>
<%-- 			<a href="${pageContext.request.contextPath}/member/logout.do">logout</a> --%>
<%-- 		</c:if> --%>
	</div>
</header>