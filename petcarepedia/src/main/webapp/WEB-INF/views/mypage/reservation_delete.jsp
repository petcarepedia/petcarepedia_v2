<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" rel="shortcut icon" type="image/x-icon">
<title>펫캐어피디아 | 예약내역</title>
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
						<td><img class = "trash" src="https://cdn.pixabay.com/photo/2012/12/03/08/52/no-68481_1280.jpg"></td>
					</tr>
					<tr>					
						<td class = "re_cancle">예약을 취소하시겠습니까?</td>
					</tr>				
					<tr>
						<td class = "btnCancle" colspan="2">
							<button type="button" class="btn_style" id = "btnReservationDelete">취소완료</button>
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

















