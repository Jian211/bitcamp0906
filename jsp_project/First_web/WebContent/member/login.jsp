<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Date now = new Date();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	String nowDate = format.format(now);	//	오늘 날짜 문자열 2021-12-08 

// 	if(nowDate.endsWith("08")){
// 		// 다른 페이지로 이동
// 		response.sendRedirect("undeCheck.jsp");
// 		return;
// 	}
	
	////////////////////////////////////////////////////
	// 로그인 처리 
	// 사용자 입력데이터 id/pw를 확인 
	// 성공시 세션에 사용자 정보를 저장
	// 이번 테스트의 로그인 성공 : ID와 PW가 같을 때 성공으로 한다.
	// 실패시 다시 로그인페이지로 
	
	// 스크립트릿 영역 : java 문법 코드를 작성
	String uid = request.getParameter("userId");	
	String uPw = request.getParameter("userPw");
	// request : 내장객체( 변수의 선언이 없고, 객체의 생성도 없다 )
	
	if(uid.equals(uPw)){
		// 로그인 성공
		// sesstion 객체 속성에 로그인 정보를 저장 : id만 저장하는 것으로 
		session.setAttribute("id", uid);
	
	
		request.setAttribute("num1", 1);
		application.setAttribute("num2", 2);
	
		// 세션에 저장 후 mypage.jsp로 이동하자
		response.sendRedirect("mypage.jsp");
		
	} else {
		// 로그인 실패 : loginForm.html > login.jsp 다시 로그인 폼으로
		%>
		<script>
			alert('로그인 실패! 로그인 페이지로 이동합니다.');
			//location.href='';
			history.go(-1); // == history.back();
		</script>
		<%
		return;
	}
	
%>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Login Form Data</h1>

	<h1>
		아이디 :
		<%=uid%></h1>
	<h1>
		아이디 :
		<%=uPw%></h1>
	<%= new Date() %><br>
	<%= nowDate %>

</body>
</html>