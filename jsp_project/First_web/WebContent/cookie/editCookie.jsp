<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie [] cookies = request.getCookies();
	CookieBox cookieBox = new CookieBox(request);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>쿠키 값 수정</h1>
	<hr>
	<h3>
	<%
		// 쿠키 검색  > 쿠키 수정 ( 같은 이름의 쿠키를 저장하는 것 )
		if(cookies != null ){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("kName")){
					// 변경하고자 하는 값을 가지는 쿠키 객체를 생성
					response.addCookie(new Cookie("kName","이강인"));
					out.println(cookie.getName()+"="+cookie.getValue()+"<br>");				
					break;
				}
			}
		}

		// cookiebox를 이용한 수정
		// 존재 유무확인 쿠키생성 응답에 추가
		if(cookieBox.exists("uid")){
			// static 메소드도 참조변수를 통한 호출이 가능하다
			response.addCookie(CookieBox.createCookie("uid","HOTT"));
		}
		
	%>
	<a href="viewCookie.jsp">쿠키 보기 </a>
	
	</h3>

</body>
</html>