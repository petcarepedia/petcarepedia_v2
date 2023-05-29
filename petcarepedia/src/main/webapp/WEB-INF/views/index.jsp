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
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script>
	$().ready(function (){
		let login_result = "${login_result}";
		if(login_result=="success"){
			Swal.fire({
	            icon: 'success',                         
	            title: '로그인 성공',         
	            text: '환영합니다!',  
	        });
		}
		
		$("#btnMainSearch-index").click(function(){
			if($("#hname-index").val()==""){
				Swal.fire({
		            icon: 'info',                         
		            title: '검색어 미입력',         
		            text: '찾고싶은 동물병원의 이름을 입력해주세요',  
		        });
			} else {
				indexSearchForm.submit();
			}
		})
	});
</script>
</head>
<body>
	<!-- header -->
	<jsp:include page="header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="content">
		<div class="main-door">
			<div class="inner-list">
		      <div class="inner"><img src="http://localhost:9000/petcarepedia/images/banner1.png"></div>
		      <div class="inner"><img src="http://localhost:9000/petcarepedia/images/banner2.png"></div>
		      <div class="inner"><img src="http://localhost:9000/petcarepedia/images/banner3.png"></div>
		      <div class="inner"><img src="http://localhost:9000/petcarepedia/images/banner4.png"></div>
		    </div>
		</div>
		<!-- <div class="main-door">
			<p>내 <span>반려동물</span>의 <span>건강</span>을 위한 올바른 선택!</p>
			<div>
				<p>우리 동네 동물병원 리뷰 사전 <span><span>펫</span><span>캐어</span><span>피디아</span></span></p>
				<img src="http://localhost:9000/petcarepedia/images/logo_blue.png" width="70px" height="70px">
			</div>
		</div> -->
		
		<form name="indexSearchForm" action="main_search_proc.do" method="get">
			<div class="main-search">
				<input type="text" placeholder="찾고싶은 동물병원의 이름을 검색해보세요!" name="hname" id="hname-index">
				<button type="button" id="btnMainSearch-index"><img src="http://localhost:9000/petcarepedia/images/foot_white.png" width="30px" height="30px"></button>
			</div>
		</form>
		
		<div id="brbox">
			<jsp:include page="/best_review_list.do"></jsp:include>
		</div>
		
		
		<jsp:include page="/main_map.do"></jsp:include>
		
	</div>
	
	<!-- footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	
	<script>
		/*
		  div사이즈 동적으로 구하기
		*/
		const outer = document.querySelector('.main-door');
		const innerList = document.querySelector('.inner-list');
		const inners = document.querySelectorAll('.inner');
		let currentIndex = 0; // 현재 슬라이드 화면 인덱스
		
		inners.forEach((inner) => {
		  inner.style.width = outer.clientWidth+'px'; // inner의 width를 모두 outer의 width로 만들기
		})
		
		innerList.style.width = (outer.clientWidth * inners.length)+'px'; // innerList의 width를 inner의 width * inner의 개수로 만들기
		/*
		  주기적으로 화면 넘기기
		*/
		const getInterval = () => {
		  return setInterval(() => {
		    currentIndex++;
		    currentIndex = currentIndex >= inners.length ? 0 : currentIndex;
		    innerList.style.marginLeft = (-outer.clientWidth * currentIndex)+'px';
		  }, 3000);
		}
		
		let interval = getInterval(); // interval 등록
	</script>
</body>
</html>