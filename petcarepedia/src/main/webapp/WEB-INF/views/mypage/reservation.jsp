<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/mypage.css">
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/petcarepedia_song.css">
<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/petcarepedia/js/petcarepedia_jquery_song.js"></script>
<script src="http://localhost:9000/petcarepedia/js/petcarepedia_jquery_yeol.js"></script>
<body>
	<!-- header -->
	 <jsp:include page="../header.jsp"></jsp:include>
	<div id = "content2">
		<section id = "reservation">
			<div id = "btn_box">
				<h1 id = "title">예약 내역</h1>
				<div id = "btn_reservation">
					<button type = "button" id = "btn1">예약중</button>
					<button type = "button" id = "btn2">진료 완료</button>
				</div>
				<hr>
			</div>
			<section id = "section1">
				<div>
					<nav>
						<ul>
							<li>마이페이지</li>
							<li><a href = "http://localhost:9000/petcarepedia/information.do?mid=${bookingVo.mid}">회원 정보</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/reservation.do?mid=${bookingVo.mid}">예약 내역</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/my_review.do?mid=${bookingVo.mid}">내가 쓴 리뷰</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/bookmark.do?mid=${bookingVo.mid}">즐겨찾기</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/signout.do?mid=${bookingVo.mid}">회원 탈퇴</a></li>
						</ul>
					</nav>
				</div>
			</section>
			<div id = "aside">
				<section id = "section2">
					<c:forEach var = "bookingVo" items = "${list}">
						<div id = "aside1">
							<img src = "http://localhost:9000/petcarepedia/images/hos.png">
							<div>
								<span>${bookingVo.gloc}</span>
								<span>${bookingVo.hname}</span>
								<span></span>
								<img src = "http://localhost:9000/petcarepedia/images/위치.png">
								<span>${bookingVo.loc}</span>
								<img src = "http://localhost:9000/petcarepedia/images/홈.png">
								<a href = "http://localhost:9000/petcarepedia/mypage/information.do">병원 홈페이지 가기</a>
								<img src = "http://localhost:9000/petcarepedia/images/전화.png">
								<span>${bookingVo.tel}</span>
								<span>예약 날짜 : ${bookingVo.vdate}</span>
								<span>예약 시간 : ${bookingVo.vtime}</span>
							</div>
						</div>
						<button type = "button" id = "btn_cancle1">예약취소</button>
					</c:forEach>
				</section>
			</div>
		</section>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>