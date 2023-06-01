<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" rel="shortcut icon" type="image/x-icon">
<title>펫캐어피디아 | 리뷰쓰기</title>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/mypage.css">
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/petcarepedia_song.css">
<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/petcarepedia/js/petcarepedia_jquery_yeol.js"></script>
</head>
<body>
		<!-- header -->
	 <jsp:include page="../header.jsp"></jsp:include>
	<div id = "content">
		<section id = "review_write">
			<h1 id = "title">리뷰쓰기</h1>
			<hr>
			<form name="writeForm" action="review_write_proc.do" method="post">
			<input type = "hidden" name = "mid" value = "${mid}">
			<input type = "hidden" name = "hid" value = "${hid}">
			<input type = "hidden" name = "bid" value = "${bid}">
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
					<section>
						<img src = "http://localhost:9000/petcarepedia/images/cat.png">
						<span>과테말라 냥이</span>
						<span>의사의 진료는 어떠셨나요?</span>
						<span>별점을 선택해주세요</span>
						<!-- <img src = "http://localhost:9000/petcarepedia//images/star.png">
						<img src = "http://localhost:9000/petcarepedia//images/star.png">
						<img src = "http://localhost:9000/petcarepedia//images/star.png">
						<img src = "http://localhost:9000/petcarepedia//images/star.png">
						<img src = "http://localhost:9000/petcarepedia//images/star.png"> -->
						<div id = "star">
							<fieldset>
								<input type="radio" name="rstar" value="5" id="rate1"><label
									for="rate1">★</label>
								<input type="radio" name="rstar" value="4" id="rate2"><label
									for="rate2">★</label>
								<input type="radio" name="rstar" value="3" id="rate3"><label
									for="rate3">★</label>
								<input type="radio" name="rstar" value="2" id="rate4"><label
									for="rate4">★</label>
								<input type="radio" name="rstar" value="1" id="rate5"><label
									for="rate5">★</label>
							</fieldset>
						</div>
						<!-- <span>치료에 대한 자세한 설명</span> -->
						<!-- <img src = "http://localhost:9000/petcarepedia//images/star.png">
						<img src = "http://localhost:9000/petcarepedia//images/star.png">
						<img src = "http://localhost:9000/petcarepedia//images/star.png">
						<img src = "http://localhost:9000/petcarepedia//images/star.png">
						<img src = "http://localhost:9000/petcarepedia//images/star.png"> -->
					</section>
					<textarea name="rcontent" id = "rcontent" placeholder="진료에 대한 경험을 진솔하게 작성해주세요(30~50자내)" maxlength="50"></textarea>
						<div id="test_cnt">(0 / 50)</div>
					<button type = "button" id = "cancle">취소</button>
					<button type = "button" id = "btnReviewWrite">작성완료</button>
				</div>
			</form>
		</section>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>