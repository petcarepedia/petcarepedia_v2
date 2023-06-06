<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
							<img src = "${bookingVo.img}">
							<div>
								<span>서울시 > ${bookingVo.gloc}</span>
								<a href = "http://localhost:9000/petcarepedia/search_result.do?hid=${bookingVo.hid}"><span>${bookingVo.hname}</span></a>
								<span></span>
								<img src = "http://localhost:9000/petcarepedia/images/위치.png">
								<span>${bookingVo.loc}</span>
								<c:if test = "${bookingVo.hrink != 'X'}">
									<img src = "http://localhost:9000/petcarepedia/images/홈.png">
									<a href = "${bookingVo.hrink}">병원 홈페이지 가기</a>
								</c:if>
								<div class = "box">
									<img src = "http://localhost:9000/petcarepedia/images/전화.png">
									<span>${bookingVo.tel}</span>
									<span>예약 날짜 : ${bookingVo.vdate}</span>
									<span>예약 시간 : ${bookingVo.vtime}</span>
								</div>
							</div>
						</div>
						<jsp:useBean id="now" class="java.util.Date" />
						<fmt:parseDate value = "${bookingVo.vdate}" pattern="yyyy-MM-dd" var = "vdate" />
						<fmt:parseNumber value="${now.time / (1000*60*60*24)}" integerOnly="true" var="today"></fmt:parseNumber>
						<fmt:parseNumber value="${vdate.time / (1000*60*60*24)}" integerOnly="true" var="vdate"></fmt:parseNumber>
						<c:choose>
							<c:when test = "${today-vdate <= 3}">
								<div id = "btn_review">
									<a href = "review_write.do?mid=${bookingVo.mid}&hid=${bookingVo.hid}&bid=${bookingVo.bid}">
										<button type = "button" id = "btn_write_review">리뷰쓰기</button>
									</a>
								</div>
							</c:when>
							<c:otherwise>
								<div id = "btn_review">
									<span>리뷰작성기간 만료</span>
									<%-- <a href = "review_write.do?mid=${bookingVo.mid}&hid=${bookingVo.hid}&bid=${bookingVo.bid}">
										<button type = "button" id = "btn_write_review">리뷰쓰기</button>
									</a> --%>
								</div>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:forEach var = "bookingReview" items = "${list2}">
						<div id = "aside1">
							<img src = "${bookingReview.img}">
							<div>
								<span>서울시 > ${bookingReview.gloc}</span>
								<a href = "http://localhost:9000/petcarepedia/search_result.do?hid=${bookingReview.hid}"><span>${bookingReview.hname}</span></a>
								<span></span>
								<img src = "http://localhost:9000/petcarepedia/images/위치.png">
								<span>${bookingReview.loc}</span>
								<c:if test = "${bookingReview.hrink ne 'X'}">
									<img src = "http://localhost:9000/petcarepedia/images/홈.png">
									<a href = "${bookingReview.hrink}">병원 홈페이지 가기</a>
								</c:if>
								<div class = "box">
									<img src = "http://localhost:9000/petcarepedia/images/전화.png">
									<span>${bookingReview.tel}</span>
									<span>예약 날짜 : ${bookingReview.vdate}</span>
									<span>예약 시간 : ${bookingReview.vtime}</span>
								</div>
							</div>
						</div>
						<div id = "btn_review">
							<a href = "mypage_review_content.do?rid=${bookingReview.rid}">
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