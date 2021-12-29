<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/guestBook/guestBookListView.css">
<title>Guest Book List View </title>
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
		
		<div class="listView-container">
			
			<div class="listView_subtitle">
				<h2> ${guestBook.subject}</h2>	
				<h2 hidden="">${guestBook.idx}</h2>
			</div>
			
			<div class="listView_userInfo">
				<img style="width: 30px; border-radius: 50%;" src="${pageContext.request.contextPath}/uploadfile/${guestBook.photo}"> 
				<h3>${guestBook.writer}</h3>
				<h3>${guestBook.regdate}</h3>
				
				<c:if test="${guestBook.memberidx eq loginInfo.idx}">
					<h3 class="userInfo-deleteAndEdit"><a href="edit.do?guestBook=${guestBook}">수정</a></h3>
					<h3 class="userInfo-deleteAndEdit"><a href="delete.do?idx=${guestBook.idx}">삭제</a></h3>
				</c:if>
				
			</div>
			
			<div class="listView_content-form">
				<h3>${guestBook.content}</h3>
			</div>
			
			<hr>
			
			<div class="listView_reply-container">
				<h3>?개의 댓글</h3>
				<div class="replyWrite">
					<form id="replyWriteForm" method="POST" action="reply/write.do">
						<h4>${loginInfo.userId}</h4>
						<textarea name="message" id="message"  rows="5" cols="30"></textarea>
						<input type="text" name="memberIdx" value="${loginInfo.idx}">
						<input type="text" name="guestBookIdx" value="${guestBook.idx}">
						<button type=submit >댓글작성</button>
						<!-- GuestBookListViewCommandImpl여기로 넘어가진다  -->
						<!-- GuestBookReplyWriteCommandImpl여기로 안가진다  -->
						
						<br>
						
					</form>
				</div>
				
				<hr>
				<div id="replyList">
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
				</div>
			</div>
		</div>
	</div>

	<!--  content 시작	-->

	<!--  js 추가  -->
	<%@ include file="/WEB-INF/views/frame/footerSet.jsp" %>
	<script>
// 		function deleteList(idx,memberidx){
// 			if(confirm("해당 게시글을 삭제하시겠습니까?")){
// 				location.href = 'delete.do?idx='+idx+'&memberidx='+memberidx;
// 			};
		
			
		function deleteReply(idx){
			if(confirm("해당 댓글을 삭제하시게습니까?")){
				$.ajax({
					url : 'delete.do',
					type : 'POST',
					data : { 
						idx : idx
					},
					success : function(data){
						if(data == '1'){
							$('reply'+idx).remove();
						}
					},
					error : function(){
						console.log("오류발생 ㅜ")
					}
				});
			}
			
		}
	</script>
	<script>
		$('#replyWriteForm').submit(function(event){
			event.preventdefault();
			
			$('#message').val('');
			
			$.ajax({
				url : 'reply/write3.do',//'reply/write.do',
				type : 'POST',
				data : $(this).serialize(),
				success : function(data){
					console.log(data);
		
					$('#replyList').html('');
					// 현재 data -> 자바스크립트의 객체  *json이니까
					$.each(data,function(index,item){
						var html = '';
						
						html += '<div id="reply'+item.idx+'" class="reply-writeForm">';
						html += '	<div class="reply-img">';
						html +=	'		<img src="/op/uploadfile/'+item.photo+'">';
						html += '	</div>';
						html += '	<div class="reply-content">';
						html +=	'		<h4>'+item.userName+'</h4>';
						html +=	'		<div>';
						html +=	'			<pre>'+item.content+'</pre>';
						html +=	'		</div>';
						html += '		<div>'+item.regDate+'</div>';
						html += '	</div>';
						html += '	<div class="reply-close">';
						html += '		<div onclick="deleteReply('+item.idx+')">X</div>';
						html += ' 	</div>';
						html += '</div>';
						
						$('#replyList').append(html);
						
					})
					
					// 화면에 출력할 html 응답
 				//	$('#replyList').html(data);
					
					
					
					// 입력처리 여부만 판단 -> view.do
// 					if(data == '1'){
// 						alert('등록 성공');
// 						location.href = 'guestbookListView.do?idx='+${guestBook.idx};
// 						// 화면에 출력할 데이터 JSON받고 파싱
						
// 					} else {
// 						alert('등록 실패');
// 					}
				},
				error : function(){
					console.log('통신에러!');
				}
				
			});			
		
		});
		
	
		
		
	</script>
</body>
</html>