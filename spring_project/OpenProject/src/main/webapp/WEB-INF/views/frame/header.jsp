<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<header>
	
</header>


<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
  <a class="navbar-brand mr-auto mr-lg-0" href="${pageContext.request.contextPath}/">Open Project</a>
  <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
<!--       <li class="nav-item active"> -->
<!--         <a class="nav-link" href="#">Dashboard <span class="sr-only">(current)</span></a> -->
<!--       </li> -->
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/member/reg">회원 가입</a>
      </li>
      <li class="nav-item">
    	 <a class="nav-link" href="${pageContext.request.contextPath}/member/manager/list">회원 리스트</a>
      </li>
      <li class="nav-item">
    	<a class="nav-link" href="${pageContext.request.contextPath}/member/my/mypage">마이페이지</a>
      </li>
      <li class="nav-item">
      	<a class="nav-link" href="${pageContext.request.contextPath}/guestbook/list">게시판</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-expanded="false">Settings</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li class="nav-item" id="loginInfoArea">
		<c:if test="${empty loginInfo}">
			<a class="nav-link" href="${pageContext.request.contextPath}/member/login">LOGIN</a>
		</c:if>
		<c:if test="${not empty loginInfo}">
			<a class="nav-link" href="${pageContext.request.contextPath}/member/logout">LOGOUT</a>
		</c:if>
	</li>
    </ul>
  </div>
</nav>