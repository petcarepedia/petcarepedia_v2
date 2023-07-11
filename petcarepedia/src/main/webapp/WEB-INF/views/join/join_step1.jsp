<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" rel="shortcut icon" type="image/x-icon">
<title>펫캐어피디아 | 회원가입</title>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/petcarepedia_song.css">
<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/petcarepedia/js/petcarepedia_jquery_song.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://kit.fontawesome.com/4ed285928f.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.2.1/css/fontawesome.min.css" integrity="sha384-QYIZto+st3yW+o8+5OHfT6S482Zsvz2WfOzpFSXMF9zqeLcFV0/wlZpMtyFcZALm" crossorigin="anonymous">
<script>
$(document).ready(function(){
	$('#loading').hide(); //첫 시작시 로딩바를 숨겨준다.
})
.ajaxStart(function(){
	$('#loading').show(); //ajax실행시 로딩바를 보여준다.
})
.ajaxStop(function(){
	$('#loading').hide(); //ajax종료시 로딩바를 숨겨준다.
});
</script>
</head>
<body>
	<div class="back"></div>
	<div class="term-box">
		<div class="term-modal">
			<div class="title">
				
			</div>
			<div class="term-btn">
				<button class="btn-yes" id="btnModalAgree">동의</button>
				<button class="btn-no" id="btnModalClose">닫기</button>
			</div>
		</div>
	</div>
	<img src="http://localhost:9000/petcarepedia/images/loading.gif" id="loading">
	
	<!-- header -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="content">
		<div class="join-container">
			<div class="content-logo">
				<img src="http://localhost:9000/petcarepedia/images/contentlogo.png" width="300px">
			</div>
			
			<div class="step-box">
				<div class="step active">
					<div>
						<p>Step 1</p>
						<div></div>
						<p>회원 유형 선택</p>
					</div>
				</div>	
				<i class="fa-solid fa-chevron-right fa-2xl" style="color:#d8d8d8"></i>
				<div class="step">
					<div>
						<p>Step 2</p>
						<div></div>
						<p>약관 동의</p>
					</div>
				</div>
				<i class="fa-solid fa-chevron-right fa-2xl" style="color:#d8d8d8"></i>
				<div class="step">
					<div>
						<p>Step 3</p>
						<div></div>
						<p>본인 인증</p>
					</div>
				</div>
				<i class="fa-solid fa-chevron-right fa-2xl" style="color:#d8d8d8"></i>
				<div class="step">
					<div>
						<p>Step 4</p>
						<div></div>
						<p>정보 입력</p>
					</div>
				</div>
				<i class="fa-solid fa-chevron-right fa-2xl" style="color:#d8d8d8"></i>
				<div class="step">
					<div>
						<p>Step 5</p>
						<div></div>
						<p>가입 완료</p>
					</div>
				</div>
			</div>
			
			<div class="join-content grade-content">
				<div class="grade-container">
					<div class="grade-box user" id="user">
						<i class="fa-solid fa-hospital-user fa-7x" style="color: #98dfff;"></i>
						<h1>개인회원</h1>
						<p>개인회원 가입을 원하시면 선택해주세요</p>
					</div>
				</div>
				
				<div class="grade-container">
					<div class="grade-box manager" id="manager">
						<i class="fa-solid fa-hospital fa-7x" style="color: #ffb3bd;"></i>
						<h1>사업자회원</h1>
						<p>사업자회원 가입을 원하시면 선택해주세요</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- footer -->
	<%-- <jsp:include page="../footer.jsp"></jsp:include> --%>
</body>
</html>