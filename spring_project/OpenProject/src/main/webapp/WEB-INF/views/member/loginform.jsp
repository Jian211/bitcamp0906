<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<%@ include file="/WEB-INF/views/frame/pageSet.jsp"%>

</head>
<body>
	<%-- 	<%@ include file="/WEB-INF/views/frame/nav.jsp"%> --%>

	<!-- content 시작 -->
	<div class="main-contanier">
	
		<!-- Header -->
		<%@ include file="/WEB-INF/views/frame/header.jsp"%>
		
		
		<form method="post" class="form-signin">
			<input type="hidden" name="url" value="${param.referer}">
			<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
			
			<label for="inputEmail" class="sr-only">ID</label>
			<input type="text" id="inputEmail" name="userid" class="form-control"  placeholder="your ID" value="${cookie.saveId != null ? cookie.saveId.value : ''}"  required autofocus>
			<label for="inputPassword"  class="sr-only">Password</label>
			<input type="password" id="inputPassword" name="pw" class="form-control" placeholder="Password" required>
			<div class="checkbox mb-3">
				<label>
				    <input type="checkbox" name="saveid" value="on" ${cookie.saveId != null ? 'checked' : ''}> Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			<button class="btn btn-lg btn-primary btn-block" type="reset">reset</button>
			<p class="mt-5 mb-3 text-muted">&copy; 2022-{{< year >}}</p>
	
		</form>
	
	</div>
	<!-- content 끝 -->


	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerSet.jsp" %>

</body>
</html>