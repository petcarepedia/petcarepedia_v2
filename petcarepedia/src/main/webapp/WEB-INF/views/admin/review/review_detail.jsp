<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/admin1.css">
	<link rel="stylesheet" href="http://localhost:9000/mycgv_jsp/css/am-pagination.css">
	<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
	<script src="http://localhost:9000/petcarepedia/js/petcarepedia_jquery_serin.js"></script>
	<link href="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" rel="shortcut icon" type="image/x-icon">
	<title>펫캐어피디아 | 관리자</title>
</head>
<body>
<!-- header -->
	<jsp:include page="../admin_header.jsp"></jsp:include>
	<div class="d1">
		<section class="review_detail">
			<section id = "section1">
				<div>
					<nav>
						<ul>
							<li>신고리뷰관리</li>
							<li><a href = "http://localhost:9000/petcarepedia/hospital_list.do">병원 관리</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/member_list.do">회원 관리</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/reserve_list.do">예약 관리</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/review_list.do">신고 리뷰 관리</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/admin_notice.do">공지 사항 관리</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/login.do">나가기</a></li>
						</ul>
					</nav>
				</div>
			</section>
			<div>
				<button type="button" class="button">삭제</button>
				<section id = "section3">
					<img src="http://localhost:9000/animal/css/cat.png">
					<p>과카몰리 강아지</p>
				</section>
				<button type="button" class="button4">이전으로</button>
			</div>
		</section>
	</div>
<!-- footer -->
	<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>