<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guest Book List </title>
<%@ include file="/WEB-INF/views/frame/pageSet.jsp" %>


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

		<h3>게시글</h3>
		<hr>
		<form method="post" id="writeForm">
			<table>
				<tr>
					<td>유저</td>
					<td><input type="hidden" name="memberIdx" id="memberIdx" value="${loginInfo.idx}"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="subject" id="subject"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><input type="text" name="content" id="content"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="등록">
						<input type="reset">
						<input type="button" id="btnAjax" value= "ajax로 게시물 입력">
					</td>
				</tr>
			</table>
		</form>
		
	</div>
	<!--  content 시작	-->

	<!--  js 추가	-->
	<%@ include file="/WEB-INF/views/frame/footerSet.jsp" %>
<script>
// 	$(document).ready(function(){});
	$('#btnAjax').click(function(){
		
		var params = {
				subject : $('#subject').val(),
				content : $('#content').val()
			}
		
		// 비동기 통신
		$.ajax({
			url	: 'writeAjax.do',
			type : 'POST',
			data : $('#writeForm').serialize(),//params,
			success : function(data){
				console.log(data);
				
				if(data == '1'){
					alert('게시글이 등록되었습니다.');
					location.href = 'list.do';
				} else {
					alert('게시글 등록이 실패되었습니다.');
				}
			},
			error : function(request){
				console.log(request);
			}
			
		});
		
	});
</script>
</body>
</html>