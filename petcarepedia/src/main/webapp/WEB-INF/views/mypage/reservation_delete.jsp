<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/mypage.css">
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/petcarepedia_song.css">
<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/petcarepedia/js/petcarepedia_jquery_song.js"></script>
<script src="http://localhost:9000/petcarepedia/js/petcarepedia_jquery_yeol.js"></script>
</head>
<body>
	<!-- header -->
	<!-- <iframe src="http://localhost:9000/mycgv_jsp/header.jsp"
			scrolling="no" width="100%" height="149px" frameborder=0></iframe> -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- content -->
	<div id = "content2">
		<section id = "reservation">
			<h1 id = "title">예약 내역</h1>
			<hr>
			<form name="deleteForm" action="reservation_delete_proc.do" method="post">
				<input type = "hidden" name = "bid" value = "${bid}">
				<table id = "table">
					<tr>
						<td><img id = "trash" src="http://localhost:9000/petcarepedia/images/trash.jpg"></td>
					</tr>
					<tr>					
						<td>예약을 취소하시겠습니까?</td>
					</tr>				
					<tr>
						<td colspan="2">
							<button type="button" class="btn_style" id = "btnReservationDelete">삭제완료</button>
							<a href="reservation.do?mid=${mid}">
							<button type="button" class="btn_style">이전페이지</button></a>
						</td>				
					</tr>
				</table>
			</form>
		</section>
	</div>
	
	<!-- footer -->
	<!-- <iframe src="http://localhost:9000/mycgv_jsp/footer.jsp"
			scrolling="no" width="100%" height="500px" frameborder=0></iframe> -->	
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
















