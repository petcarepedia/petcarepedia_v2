<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script src="http://localhost:9000/petcarepedia/js/petcarepedia_jquery_song_mainmap.js"></script>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=krftgsruiz"></script>
</head>
<body>
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
		
	<script type="text/javascript">
		

	</script>
</body>
</html>
