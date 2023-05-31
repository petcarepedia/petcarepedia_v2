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
				<c:forEach var = "reviewVo" items = "${list}">
					<section id = "section2">
						<div id = "aside1">
							<span>${reviewVo.hname}</span>
							<span>${reviewVo.tel}</span>
							<span>
								<span>${reviewVo.gloc}</span>
							</span>
							<img src = "http://localhost:9000/petcarepedia/images/cat.png">
							<span>${reviewVo.nickname}</span>
						</div>
						<div id = "aside2">
							<img src = "${reviewVo.img}">
						</div>
						<div id = "aside3">
							<span>리뷰 내용</span>
							<span> ${reviewVo.rcontent}</span>
							<span><!-- 진료 일자 : 2023-04-26 --></span>
						</div>
						<div id = "aside4">
						<a href = "review_revise.do?rid=${reviewVo.rid}">
							<button type = "button" id = "btnReview_revise">리뷰수정</button>
						</a>
						<a href = "my_review_delete.do?rid=${reviewVo.rid}">
							<button type = "button" id = "btnReview_delete">리뷰삭제</button>
						</a>
						</div>
					</section>
				</c:forEach>
			</div>
		</section>
	</div>	
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>