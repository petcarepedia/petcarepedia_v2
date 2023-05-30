<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" rel="shortcut icon" type="image/x-icon">
<title>펫캐어피디아 | 예약내역</title>
</head>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/mypage.css">
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/petcarepedia_song.css">
<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/petcarepedia/js/petcarepedia_jquery_yeol.js"></script>
<body>
	<!-- header -->
	 <jsp:include page="../header.jsp"></jsp:include>
	<div id = "content2">
		<section id = "reservation">
			<div id = "btn_box">
				<h1 id = "title">예약 내역</h1>
				<div id = "btn_reservation">
					<a href = "reservation.do?mid=hong"> 
						<button type = "button" id = "btn3">예약중</button>
					</a>
					<a href = "reservation2.do?mid=hong">
						<button type = "button" id = "btn4">진료 완료</button>
					 </a> 
				</div>
				<hr>
			</div>
			<section id = "section1">
				<div>
					<nav>
						<ul>
							<li>마이페이지</li>
							<li><a href = "http://localhost:9000/petcarepedia/information.do?mid=hong">회원 정보</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/reservation.do?mid=hong">예약 내역</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/my_review.do?mid=hong">내가 쓴 리뷰</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/bookmark.do?mid=hong">즐겨찾기</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/signout.do?mid=hong">회원 탈퇴</a></li>
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
								<span>서울시 > ${bookingVo.gloc}</span>
								<span>${bookingVo.hname}</span>
								<span></span>
								<img src = "http://localhost:9000/petcarepedia/images/위치.png">
								<span>${bookingVo.loc}</span>
								<img src = "http://localhost:9000/petcarepedia/images/홈.png">
								<c:choose>
								<c:when test = "${bookingVo.hrink eq 'X'}">
									<a href = "#" onclick = "alert('홈페이지가 존재하지 않습니다.')">병원 홈페이지 가기</a>
								</c:when>
								<c:otherwise>
									<a href = "${bookingVo.hrink}">병원 홈페이지 가기</a>
								</c:otherwise>
								</c:choose>
								<img src = "http://localhost:9000/petcarepedia/images/전화.png">
								<span>${bookingVo.tel}</span>
								<span>예약 날짜 : ${bookingVo.vdate}</span>
								<span>예약 시간 : ${bookingVo.vtime}</span>
							</div>
						</div>
						<div id = "btn_review">
							<a href = "review_write.do?mid=${bookingVo.mid}&hid=${bookingVo.hid}&bid=${bookingVo.bid}">
								<button type = "button" id = "btn_write_review">리뷰쓰기</button>
							</a>
<!-- 							<a href = "my_review.do?mid=hong">
							<button type = "button" id = "btn_watch_review">리뷰보기</button>
							</a> -->
						</div>
					</c:forEach>
					<c:forEach var = "bookingReview" items = "${list2}">
						<div id = "aside1">
							<img src = "http://localhost:9000/petcarepedia/images/hos.png">
							<div>
								<span>서울시 > ${bookingReview.gloc}</span>
								<span>${bookingReview.hname}</span>
								<span></span>
								<img src = "http://localhost:9000/petcarepedia/images/위치.png">
								<span>${bookingReview.loc}</span>
								<img src = "http://localhost:9000/petcarepedia/images/홈.png">
								<c:choose>
								<c:when test = "${bookingReview.hrink eq 'X'}">
									<a href = "#" onclick = "alert('홈페이지가 존재하지 않습니다.')">병원 홈페이지 가기</a>
								</c:when>
								<c:otherwise>
									<a href = "${bookingReview.hrink}">병원 홈페이지 가기</a>
								</c:otherwise>
								</c:choose>
								<img src = "http://localhost:9000/petcarepedia/images/전화.png">
								<span>${bookingReview.tel}</span>
								<span>예약 날짜 : ${bookingReview.vdate}</span>
								<span>예약 시간 : ${bookingReview.vtime}</span>
							</div>
						</div>
						<div id = "btn_review">
<%-- 							<a href = "review_write.do?mid=${bookingVo.mid}&hid=${bookingVo.hid}&bid=${bookingVo.bid}">
								<button type = "button" id = "btn_write_review">리뷰쓰기</button>
							</a> --%>
							<a href = "my_review.do?mid=hong">
								<button type = "button" id = "btn_watch_review">리뷰보기</button>
							</a> 
						</div>
					</c:forEach>
				</section>
			</div>
		</section>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>