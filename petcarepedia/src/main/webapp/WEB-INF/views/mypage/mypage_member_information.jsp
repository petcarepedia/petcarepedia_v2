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
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
 <script>
 	var count1 = 1;
 	var count2 = 1;
 	var count3 = 1;
 	var count4 = 1;
 	var count5 = 1;
	function toggleImg1() {
	 	var img1 = document.getElementById("img1");
	 	const nickname = document.getElementById("nickname");
	 	if(count1 % 2 == 1) {
			img1.src = "http://localhost:9000/petcarepedia/images/finish.png";
			nickname.disabled = false;
	 	} else {
	 		img1.src = "http://localhost:9000/petcarepedia/images/편집2.png";
	 		nickname.disabled = true;
	 		
	 	}
	 	count1++;
	}
	function toggleImg2() {
	 	var img2 = document.getElementById("img2");
	 	const birth = document.getElementById("birth");
	 	if(count2 % 2 == 1) {
			img2.src = "http://localhost:9000/petcarepedia/images/finish.png";
			birth.disabled = false;
	 	} else {
	 		img2.src = "http://localhost:9000/petcarepedia/images/편집2.png";
	 		birth.disabled = true;
	 		
	 	}
	 	count2++;
	}
	function toggleImg3() {
	 	var img3 = document.getElementById("img3");
	 	const email = document.getElementById("email");
	 	if(count3 % 2 == 1) {
			img3.src = "http://localhost:9000/petcarepedia/images/finish.png";
			email.disabled = false;
	 	} else {
	 		img3.src = "http://localhost:9000/petcarepedia/images/편집2.png";
	 		email.disabled = true;
	 		
	 	}
	 	count3++;
	}
	function toggleImg4() {
	 	var img4 = document.getElementById("img4");
	 	const phone = document.getElementById("phone");
	 	if(count4 % 2 == 1) {
			img4.src = "http://localhost:9000/petcarepedia/images/finish.png";
			phone.disabled = false;
	 	} else {
	 		img4.src = "http://localhost:9000/petcarepedia/images/편집2.png";
	 		phone.disabled = true;
	 		
	 	}
	 	count4++;
	}
</script>
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
				<form name="updateForm" action="member_update_proc.do" method="post">
					<section id = "section2">
						<div id = "update_info">
							<label>프로필</label>
						</div>
						<div id = "profileBoxOut">
							<div id = profileBox>
								<img src = "http://localhost:9000/petcarepedia/images/cat.png" id = "profile">
								<button type = "button"><img src = "http://localhost:9000/petcarepedia/images/수정.png" id = "update_profile"></button>
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
									<input type = "hidden" value = "${sessionScope.svo.mid}" name = "mid" disabled>
									<button><img src = "http://localhost:9000/petcarepedia/images/수정.png"></button>
								</li>
								<li>
									<label>성명</label>
									<input type = "text" value = "${memberVo.name}" name = "name" disabled>
									<button><img src = "http://localhost:9000/petcarepedia/images/수정.png"></button>
								</li>  --%>
								<li>
									<label>별명</label>
									<input type = "text" value = "${memberVo.nickname}" name = "nickname"  id = "nickname" disabled>
									<button type = "button" id = "update_nickname1" onclick = "toggleImg1()"><img id = "img1" src = "http://localhost:9000/petcarepedia/images/편집2.png"></button>
								</li>
								<li>
									<label>생년월일</label>
									<input type = "text" value = "${memberVo.birth}" name = "birth" id = "birth" disabled>
									<button type = "button" id = "update_birth" onclick = "toggleImg2()"><img id = "img2" src = "http://localhost:9000/petcarepedia/images/편집2.png"></button>
								</li>
								<li>
									<label>이메일</label>
									<input type = "text" value = "${memberVo.email}" name = "eamil" id = "email" disabled>
									<button type = "button" id = "update_email" onclick = "toggleImg3()"><img id = "img3" src = "http://localhost:9000/petcarepedia/images/편집2.png"></button>
								</li>
								<li>
									<label>휴대폰</label>
									<input type = "text" value = "${memberVo.phone}" name = "phone" id = "phone" disabled>
									<button type = "button" id = "update_phone" onclick = "toggleImg4()"><img id = "img4" src = "http://localhost:9000/petcarepedia/images/편집2.png"></button>
								</li>
								<li>
									<label>주소</label>
									<input type = "text" value = "${memberVo.addr}" name = "addr" id = "address" disabled>
									<button type = "button" id = "update_addr"><img id = "img5" src = "http://localhost:9000/petcarepedia/images/편집2.png"></button>
								</li>
							</ul>
					</section>
					<section id = "section3">
						<!-- <a href = "mypage_member_revise.do"> -->
							<button type = "button" id = "btn_style1">수정완료</button>
						<!-- </a> -->
					</section>
					<input type = "hidden" name = "mid" value = "${sessionScope.svo.mid}">
					<input type = "hidden" name = "name" value = "${memberVo.name}">
				</form>
			</div>
		</section>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>