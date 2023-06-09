<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" rel="shortcut icon" type="image/x-icon">
<title>펫캐어피디아 | 내가 쓴 리뷰</title>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/mypage.css">
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/petcarepedia_song.css">
<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/petcarepedia/js/petcarepedia_jquery_yeol.js"></script>
</head>
<body>
	 <jsp:include page="../header.jsp"></jsp:include>
	<div id = "content2">
		<section id = "my_review">
			<h1 id = "title">내가 쓴 리뷰</h1>
			<hr>
			<section id = "section1">
				<div>
					<nav>
						<ul>
							<li>마이페이지</li>
							<li><a href = "mypage_member_information.do">회원 정보</a></li>
							<li><a href = "mypage_reservation.do">예약 내역</a></li>
							<li><a href = "mypage_my_review.do">내가 쓴 리뷰</a></li>
							<li><a href = "mypage_bookmark.do">즐겨찾기</a></li>
							<li><a href = "mypage_signout.do">회원 탈퇴</a></li>
						</ul>
					</nav>
				</div>
			</section>
			<div id = "aside">
				<section id = "section2">
					<c:choose>
						<c:when test = "${list.size() == 0}">
							<div class="review_card_no">
								<img id="review_img"
									src="http://localhost:9000/petcarepedia/images/review.png">
								<span>작성된 리뷰가 존재하지 않습니다.</span>
							</div>
						</c:when>
						<c:otherwise>
							<c:forEach var = "reviewVo" items = "${list}">
								<div id = "aside1">
									<a href = "http://localhost:9000/petcarepedia/search_result.do?hid=${reviewVo.hid}">
										<span>${reviewVo.hname}</span>
									</a>
									<span>${reviewVo.tel}</span>
									<span>
										<span>${reviewVo.gloc}</span>
									</span>
									<img src = "http://localhost:9000/petcarepedia/images/cat.png">
									<span>${reviewVo.nickname}</span>
								</div>
								<div id = "aside2">
									<img src = "http://localhost:9000/petcarepedia/upload/${reviewVo.hsfile}">
								</div>
								<div id = "aside3">
									<span>리뷰 내용</span>
									<span> ${reviewVo.rcontent}</span>
									<span><!-- 진료 일자 : 2023-04-26 --></span>
								</div>
								<div id = "aside4">
									<a href = "mypage_review_content.do?rid=${reviewVo.rid}">
										<button type = "button" id = "btnReview_content">상세보기</button>
									</a>
								</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</section>
			</div>
		</section>
	</div>	
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>