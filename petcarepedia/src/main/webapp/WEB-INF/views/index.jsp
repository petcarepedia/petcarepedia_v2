<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] loclist = {"강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", 
	                    "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구"};
%>
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
		
		<div class="main-map">
			<div class="sub">
				<p>가까운 병원 빠르게 찾고 싶다면? <span>지역구별 병원 검색</span></p>
				<a href="http://localhost:9000/petcarepedia/search_main.do">검색페이지 전체보기 ></a>
			</div>
			
			<div class="map-content">
				<div class="locsub">
					<img src="http://localhost:9000/petcarepedia/images/map.png" width="30px">
					<span>서울</span>
				</div>
				<div class="locbox">
					<% for(int i=0; i<loclist.length; i++){ %>
						<p><%= loclist[i] %></p>
					<% } %>
				</div>
				<div class="map" id="map">
					
				</div>
			</div>
		</div>
	</div>
	
	<!-- footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	
	<script>
		/* var mapOptions = {
		    center: new naver.maps.LatLng(37.3595704, 127.105399),
		    zoom: 10
		};
		
		var map = new naver.maps.Map('map', mapOptions); */
		var HOME_PATH = window.HOME_PATH || '.';
		var cityhall = new naver.maps.LatLng(37.5666805, 126.9784147),
		    map = new naver.maps.Map('map', {
		        center: cityhall,
		        zoom: 15
		    }),
		    marker = new naver.maps.Marker({
		        map: map,
		        position: cityhall
		    });

		var contentString = [
		        '<div class="iw_inner">',
		        '   <h3>서울특별시청</h3>',
		        '   <p>서울특별시 중구 태평로1가 31 | 서울특별시 중구 세종대로 110 서울특별시청<br />',
		        '       <img src="'+ HOME_PATH +'/img/example/hi-seoul.jpg" width="55" height="55" alt="서울시청" class="thumb" /><br />',
		        '       02-120 | 공공,사회기관 &gt; 특별,광역시청<br />',
		        '       <a href="http://www.seoul.go.kr" target="_blank">www.seoul.go.kr/</a>',
		        '   </p>',
		        '</div>'
		    ].join('');

		var infowindow = new naver.maps.InfoWindow({
		    content: contentString,
		    maxWidth: 140,
		    backgroundColor: "#eee",
		    borderColor: "#2db400",
		    borderWidth: 5,
		    anchorSize: new naver.maps.Size(30, 30),
		    anchorSkew: true,
		    anchorColor: "#eee",
		    pixelOffset: new naver.maps.Point(20, -20)
		});

		naver.maps.Event.addListener(marker, "click", function(e) {
		    if (infowindow.getMap()) {
		        infowindow.close();
		    } else {
		        infowindow.open(map, marker);
		    }
		});
	</script>
</body>
</html>