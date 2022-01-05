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
		
		
		
		
		
		$('#ajaxBtn').click(function(){
			// 비동기 통신을 이용하여 파일을 업로드 하는 경우
			// FormData 객체를 이용해야한다.
			// 파라미터 이름과 전송할 데이터를 설정해준다.
			
			var formData = new FormData();
			formData.append('userId',$('#userId').val());
			formData.append('pw',$('#pw').val());
			formData.append('userName',$('#userName').val());
			
			// 사진처리는 
			var photoFile = $('#photo');
			var file = photoFile[0].files[0];
			formData.append('photo',file);
			
			$.ajax({
				url : 'reg2.do',
				type : 'POST',
				enctype : 'multipart/form-data',
				processData : false,
				contentType : false,
				cash : false,
				data : formData,
				success : function(data){
					if(data == '1'){
						alert('회원가입 성공');
						location.href = 'login.do';
					} else {
						alert('회원가입 실패!');
						history.go(-1);
					}
				},
				error : function(req){
					console.log(req);
				}
				
			});
			
		});
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
					<td><input type="text" name="userId" id="userId" ></td>
					<div id="msg"></div>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" id="pw"></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="userName" id="userName"></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="photo" id="photo"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="회원가입">
						<input type="reset">
						<input type="button" id="ajaxBtn" value="ajax로 회원가입">
<!-- 						<button type="submit">ajax로 회원가입</button> -->
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