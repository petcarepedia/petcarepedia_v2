<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" rel="shortcut icon" type="image/x-icon">
<title>우리 동네 동물병원 리뷰 사전, 펫캐어피디아</title>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/petcarepedia_song.css">
<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/petcarepedia/js/petcarepedia_jquery_song.js"></script>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=krftgsruiz"></script>
</head>
<body>
	<div class="main-review">
		<div class="sub">
			<p>신뢰도 검증! <span>사용자 추천 리뷰</span></p>
			<a href="#">더 많은 리뷰 보러가기 ></a>
		</div>
		<div class="slide">
			<div class="btnPrev">
				<button type="button" id="btnPrev"><img src="http://localhost:9000/petcarepedia/images/prev.png" width="30" height="30"></button>
			</div>
			<div class="review-list">
				<% for(int i=1; i<=3; i++){ %>
					<div href="#" class="review-card">
						<div>
							<a href="#">더조은동물병원</a>
							<p>⭐ 5.0</p>
						</div>
						<div>
							<div>강남구</div>
							<div>강아지</div>
						</div>
						<div>
							친절하고 과잉진료 없는 병원이에요~ 벌써 몇 년간 믿고 다니는 병원입니다. 원장님부터 카운터 선생님들까지 모두 친절하시고 아이들도 좋아해주세요~ 동물병원 과잉진료 정말 심하잖아요? 여기 다니기 전에는 저도 바가지 참 많이 썼었는데... 원장님이 항상 진심을 가지고 진료를 봐주시는게 느껴져셔 항상 감사해요!
						</div>
						<div>
							<p>❤️ 100</p>
							<p>2023-04-20</p>
						</div>
					</div>
				<% } %>
			</div>
			<div class="btnNext">
				<button type="button" id="btnNext"><img src="http://localhost:9000/petcarepedia/images/next.png" width="30" height="30"></button>
			</div>
		</div>
	</div>
</body>
</html>
