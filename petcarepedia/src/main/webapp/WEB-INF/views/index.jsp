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
						<p class="gloc"><%= loclist[i] %></p>
					<% } %>
				</div>
				<div class="map" id="map">
					
				</div>
			</div>
		</div>
	</div>
	
	<!-- footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	
	<script type="text/javascript">
		var areaArr = new Array();
		areaArr.push(
			{location:'강남구', lat:'37.4959854', lng:'127.0664091'},
			{location:'강동구', lat:'37.5492077', lng:'127.1464824'},
			{location:'강북구', lat:'37.6469954', lng:'127.0147158'},
			{location:'강서구', lat:'37.5657617', lng:'127.8226561'},
			{location:'관악구', lat:'37.4603732', lng:'127.9536086'},
			{location:'광진구', lat:'37.5574120', lng:'127.0796211'},
			{location:'구로구', lat:'37.4954856', lng:'127.858121'},
			{location:'금천구', lat:'37.4600969', lng:'127.9001546'},
			{location:'노원구', lat:'37.6377533', lng:'127.0754623'},
			{location:'도봉구', lat:'37.6658609', lng:'127.0317674'},
			{location:'동대문구', lat:'37.5838012', lng:'127.0507003'},
			{location:'동작구', lat:'37.4965037', lng:'127.9443073'},
			{location:'마포구', lat:'37.5676507', lng:'127.8854549'},
			{location:'서대문구', lat:'37.5820369', lng:'127.9356665'},
			{location:'서초구', lat:'37.4769528', lng:'127.0378103'},
			{location:'성동구', lat:'37.5506753', lng:'127.0409622'},
			{location:'성북구', lat:'37.606991', lng:'127.0232185'},
			{location:'송파구', lat:'37.5177941', lng:'127.1127078'},
			{location:'양천구', lat:'37.5270616', lng:'127.8561534'},
			{location:'영등포구', lat:'37.520641', lng:'127.9139242'},
			{location:'용산구', lat:'37.5311008', lng:'127.9810742'},
			{location:'은평구', lat:'37.6176125', lng:'127.9227004'},
			{location:'종로구', lat:'37.5990998', lng:'127.9861493'},
			{location:'중구', lat:'37.5579452', lng:'127.9941904'},
			{location:'중랑구', lat:'37.598031', lng:'127.092931'},
		);
		
		$(document).on("click", ".gloc", function() {
			console.log($(this).text());
			for(var i=0; i<areaArr.length; i++){
				if($(this).text()==areaArr[i].location){
					var map = new naver.maps.Map('map', {
						center: new naver.maps.LatLng(areaArr[i].lat, areaArr[i].lng),
						zoom: 12
					});
					
					i=areaArr.length;
				}
			}
		});
	
		$(function() {
			initMap();
		});
		
		function initMap() {
				
			let markers = new Array();
			let infoWindows = new Array();
			
			var map = new naver.maps.Map('map', {
				center: new naver.maps.LatLng(37.552758094502494, 126.98732600494576),
				zoom: 12
			});
			
			/*db-병원데이터 연결해서 marker 표시하기*/
			for(var i=0; i<areaArr.length; i++){
				var marker = new naver.maps.Marker({
					map: map,
					title: areaArr[i].location,
					position: new naver.maps.LatLng(areaArr[i].lat, areaArr[i].lng)
				});
				
				var contentString = [
			        '<div class="iw_inner" style="padding:10px;">',
			        '   <h3 style="font-size:18px;">'+areaArr[i].location+'</h3>',
			        '   <p style="font-size:12px;">'+areaArr[i].location+'</p>',
			        '</div>'
			    ].join('');

				var infowindow = new naver.maps.InfoWindow({
				    content: contentString,
				    maxWidth: 250,
				    backgroundColor: "white",
				    borderColor: "#98dfff",
				    borderWidth: 3,
				    pixelOffset: new naver.maps.Point(0, 10)
				});
				
				markers.push(marker);
				infoWindows.push(infowindow);
			}
			

			function getClickHandler(seq){
				return function(e) {
					var marker = markers[seq],
						infowindow = infoWindows[seq];
					
					if (infowindow.getMap()) {
				        infowindow.close();
				    } else {
				        infowindow.open(map, marker);
				    }
				}
			}
			
			for (var i=0, ii=markers.length; i<ii; i++) {
				/* console.log(markers[i], getClickHandler(i)); */
				naver.maps.Event.addListener(markers[i],'click',getClickHandler(i));
			}
		}

	</script>
</body>
</html>