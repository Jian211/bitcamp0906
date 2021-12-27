<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/frame/pageSet.jsp" %>
<style>

#msg{
	display: none;
}
</style>
<script>

	$(document).ready(function(){
		
		$("#userid").focusin(function(){
			$('#msg').css('display','none');
			$('#msg').removeClass('text_blue');
			$('#msg').removeClass('text_red');
			$('#msg').text('');
				
		});
		
		$("#userid").focusout(function(){
			
			$.ajax({
				url : 'checkid.do',
				type : 'get',
				data : {
					userid : $('#userid').val()
				},
				success : function(data){
					// Y or N
					if(data == 'Y'){
						// 사용 가능한 아이디
						$('#msg').css('display','block');
						$('#msg').text('멋진 아이디 입니다.');
						$('#msg').addClass('text_blue');
					} else {
						// 사용 불가능한 아이디 	
						$('#msg').css('display','block');
						$('#msg').text('사용 불가능한 아이디입니다.');
						$('#msg').addClass('text_red');
						
					}
				},
				error : function(){
					console.log("비동기 통신 오류");
				},
			});
		})
		
		
	});

</script>
<meta charset="UTF-8">
<title>Insert title here</title>



</head>
<body>
	<!--  네비 시작	-->
	<%@ include file="/WEB-INF/views/frame/nav.jsp" %>
	<!--  네비 끝	-->

	<!--  content 시작	-->
	<div class="main-contanier">
		<!--  헤더 시작	 -->
		<%@ include file="/WEB-INF/views/frame/header.jsp" %>
		<!--  헤더 끝	-->
		
		<h3>회원가입</h3>
		<hr>
		<!-- form 경로와 처리 경로가 동일 > method로 구분 -->
		<form action="reg.do" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userid" id="userid" ></td>
					<div id="msg"></div>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw"></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="photo"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="회원가입">
						<input type="reset">
					</td>
				</tr>
			</table>
		</form>
		
	</div>
	<!--  content 시작	-->

	<!--  js 추가	-->
	<%@ include file="/WEB-INF/views/frame/footerSet.jsp" %>
</body>
</html>