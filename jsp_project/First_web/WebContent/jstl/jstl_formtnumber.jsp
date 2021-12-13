<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="number" value="1000000"/>
	<h2>

		<fmt:formatNumber value="100000" /><br>
		<fmt:formatNumber value="${number}" /><br>
		<fmt:formatNumber value="${number}" groupingUsed="falses"/><br>  <!-- 그룹핑유즈드 falses 하게되면 콤마가 사라짐 -->
		<fmt:formatNumber value="${number}" var="num"/><br> 			 <!-- var변수에 값을 넣어 사용할 수 있게한다. -->
		
		숫자 : ${num} <br>	
		퍼센트 : <fmt:formatNumber value="${number/4000000}" type="percent" /><br>
		통화 : <fmt:formatNumber value="${number}" type="currency" currencySymbol="\\" /><br>      <!-- 원화 표현 -->
		패턴 : <fmt:formatNumber value="${number*10000}" pattern="000,000,000,000.00"/>
		


	</h2>
	
</body>
</html>