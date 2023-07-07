<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" rel="shortcut icon" type="image/x-icon">
<title>펫캐어피디아 | 나의 회원정보</title>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/mypage.css">
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/petcarepedia_song.css">
<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/petcarepedia/js/petcarepedia_jquery_yeol.js"></script>
</head>
<body>
	<!-- header -->
	 <jsp:include page="../header.jsp"></jsp:include>
	<div id = "content">
		<section id = "information">
			<h1 id = "title">나의 회원정보</h1>
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
					<div id = "update_info">
						<label>프로필</label>
					</div>
					<div id = "profileBoxOut">
						<div id = profileBox>
							<img src = "http://localhost:9000/petcarepedia/images/cat.png" id = "profile">
							<button><img src = "http://localhost:9000/petcarepedia/images/수정.png" id = "update_profile"></button>
						</div>
						<br>
						<label id = "lb_id">${sessionScope.svo.mid}</label>
						<br>
						<label id = "lb_name">${memberVo.name}</label>
					</div>
					<div id = "update_info">
						<label>선택정보</label>
					</div>
						<ul>
							<%-- <li>
								<label>아이디</label>
								<input type = "text" value = "${sessionScope.svo.mid}" name = "mid" disabled>
								<button><img src = "http://localhost:9000/petcarepedia/images/수정.png"></button>
							</li>
							<li>
								<label>성명</label>
								<input type = "text" value = "${memberVo.name}" name = "name" disabled>
								<button><img src = "http://localhost:9000/petcarepedia/images/수정.png"></button>
							</li> --%>
							<li>
								<label>별명</label>
								<input type = "text" value = "${memberVo.nickname}" name = "nickname"  id = "nickname" disabled>
								<button type = "button" id = "update_nickname"><img src = "http://localhost:9000/petcarepedia/images/편집2.png"></button>
							</li>
							<li>
								<label>생년월일</label>
								<input type = "text" value = "${memberVo.birth}" name = "birth" id = "birth" disabled>
								<button type = "button" id = "update_birth"><img src = "http://localhost:9000/petcarepedia/images/편집2.png"></button>
							</li>
							<li>
								<label>이메일</label>
								<input type = "text" value = "${memberVo.email}" name = "eamil" id = "email" disabled>
								<button type = "button" id = "update_email"><img src = "http://localhost:9000/petcarepedia/images/편집2.png"></button>
							</li>
							<li>
								<label>휴대폰</label>
								<input type = "text" value = "${memberVo.phone}" name = "phone" id = "phone" disabled>
								<button type = "button" id = "update_phone"><img src = "http://localhost:9000/petcarepedia/images/편집2.png"></button>
							</li>
							<li>
								<label>주소</label>
								<input type = "text" value = "${memberVo.addr}" name = "addr" id = "addr" disabled>
								<button type = "button" id = "update_addr"><img src = "http://localhost:9000/petcarepedia/images/편집2.png"></button>
							</li>
						</ul>
				</section>
				<section id = "section3">
					<a href = "mypage_member_revise.do">
						<button type = "button" id = "btn_style1">수정하기</button>
					</a>
				</section>
			</div>
		</section>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>