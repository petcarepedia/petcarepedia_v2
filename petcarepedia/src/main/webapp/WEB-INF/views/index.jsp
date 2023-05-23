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
<script>
	let login_result = "${login_result}";
	if(login_result=="success"){
		alert("로그인에 성공하셨습니다.");
	}
</script>
</head>
<body>
	<!-- header -->
	<jsp:include page="header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="content">
		<div class="main-door">
			<p>내 <span>반려동물</span>의 <span>건강</span>을 위한 올바른 선택!</p>
			<div>
				<p>우리 동네 동물병원 리뷰 사전 <span><span>펫</span><span>캐어</span><span>피디아</span></span></p>
				<img src="http://localhost:9000/petcarepedia/images/logo_blue.png" width="70px" height="70px">
			</div>
		</div>
		
		<form name="indexSearchForm" action="searchProc.jsp" method="post">
			<div class="main-search">
				<input type="text" placeholder="찾고싶은 동물병원과 관련된 키워드를 검색해보세요!">
				<button type="button"><img src="http://localhost:9000/petcarepedia/images/foot_white.png" width="30px" height="30px"></button>
			</div>
		</form>
		
		<div id="brbox">
			<jsp:include page="/best_review_list.do"></jsp:include>
		</div>
		
		<jsp:include page="/main_map.do"></jsp:include>
		
	</div>
	
	<!-- footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>