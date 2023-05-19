<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" rel="shortcut icon" type="images/x-icon">
	<title>main</title>
	<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/search_main.css">
	
	<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
	<script src="http://localhost:9000/petcarepedia/js/search_main.js"></script>
	
</head>

<body>
	<!-- header -->
	<!-- <iframe width="100%" height="100px"></iframe> -->
	<div class="header-wrapper">
		<jsp:include page="../header.jsp"></jsp:include>	
	</div>
	
	<!-- content -->
	<div class="search_main">
		<!-- 필터 -->
		<section class="filter">
		<h1 class="title">동물병원</h1>
		
			<form name="search" action="#" method="get">
				<div class="area">
					<div class="text_area">
						<span>지역구분</span>
					</div>
					
					<div class="check_area">
						<ul>
							<li><input type="checkbox" name="area" id="area" value="서울전체" checked="checked"><span>서울 전체</span></li>
							<li><input type="checkbox" name="area" id="area" value="강남구"><span>강남구</span></li>
							<li><input type="checkbox" name="area" id="area" value="강동구"><span>강동구</span></li>
							<li><input type="checkbox" name="area" id="area" value="강북구"><span>강북구</span></li>
							<li><input type="checkbox" name="area" id="area" value="강서구"><span>강서구</span></li>
							<li><input type="checkbox" name="area" id="area" value="관악구"><span>관악구</span></li>
							<li><input type="checkbox" name="area" id="area" value="광진구"><span>광진구</span></li>
							<li><input type="checkbox" name="area" id="area" value="구로구"><span>구로구</span></li>
							<li><input type="checkbox" name="area" id="area" value="금천구"><span>금천구</span></li>
							<li><input type="checkbox" name="area" id="area" value="노원구"><span>노원구</span></li>
							<li><input type="checkbox" name="area" id="area" value="도봉구"><span>도봉구</span></li>
							<li><input type="checkbox" name="area" id="area" value="동대문구"><span>동대문구</span></li>
							<li><input type="checkbox" name="area" id="area" value="동작구"><span>동작구</span></li>
							<li><input type="checkbox" name="area" id="area" value="마포구"><span>마포구</span></li>
							<li><input type="checkbox" name="area" id="area" value="서대문구"><span>서대문구</span></li>
							<li><input type="checkbox" name="area" id="area" value="서초구"><span>서초구</span></li>
							<li><input type="checkbox" name="area" id="area" value="성동구"><span>성동구</span></li>
							<li><input type="checkbox" name="area" id="area" value="성북구"><span>성북구</span></li>
							<li><input type="checkbox" name="area" id="area" value="송파구"><span>송파구</span></li>
							<li><input type="checkbox" name="area" id="area" value="양천구"><span>양천구</span></li>
							<li><input type="checkbox" name="area" id="area" value="영등포구"><span>영등포구</span></li>
							<li><input type="checkbox" name="area" id="area" value="용산구"><span>용산구</span></li>
							<li><input type="checkbox" name="area" id="area" value="은평구"><span>은평구</span></li>
							<li><input type="checkbox" name="area" id="area" value="종로구"><span>종로구</span></li>
							<li><input type="checkbox" name="area" id="area" value="중구"><span>중구</span></li>
							<li><input type="checkbox" name="area" id="area" value="중랑구"><span>중랑구</span></li>
						</ul>
					</div>
				</div>
				
				<div class="time">
					<div class="text_time">
						<span>진료시간</span>
					</div>
					
					<div class="check_time">
						<ul>
							<li><input type="checkbox" name="time" id="time" value="진료중"><span>진료중</span></li>
							<li><input type="checkbox" name="time" id="time" value="휴일진료"><span>휴일진료</span></li>
							<li><input type="checkbox" name="time" id="time" value="야간진료"><span>야간진료</span></li>
						</ul>
					</div>
				</div>
					
					<div class="animal">
						<div class="text_animal">
							<span>특수 동물</span>
						</div>
						
						<div class="check_animal">
							<ul>
								<li><input type="checkbox" name="animal" id="animal" value="O"><span>취급</span></li>
								<!-- <li><input type="checkbox" name="animal" id="animal" value="고양이"><span>고양이</span></li>
								<li><input type="checkbox" name="animal" id="animal" value="파충류"><span>파충류</span></li>
								<li><input type="checkbox" name="animal" id="animal" value="조류"><span>조류</span></li>
								<li><input type="checkbox" name="animal" id="animal" value="기타"><span>기타</span></li> -->
							</ul>
						</div>
					</div>
			</form>
		</section>
		
		<div class="s2">
		<!-- 검색리스트 -->
			<section class="list">
				<div class="hlist">
				
					<c:forEach var="list" items="${list}">
					
						<div class="list1">
							<div class="hinfo">
								<a href="http://localhost:9000/petcarepedia/search_result.do?=${list.hid}">
									<span>${list.hname}</span>
									<span>⭐ 5.0</span>
									<span>${list.tel}</span>
								</a>
							
								<span id="harea">${list.gloc}</span>
								<span id="htime">진료 중</span>
								<button type="button" id="hservation">예약하기
								&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
								&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp></button>
								<div id="hmodal" class="modal">
								  <div class="modal-content">
								    <span class="close">&times;</span>
								    <iframe src="http://localhost:9000/petcarepedia/search_reservation.do" 
								     width="500px" height="500px" frameborder=0></iframe>
								  </div>
								</div>
							</div>
							
							<div class="himg">
								<img src="http://localhost:9000/petcarepedia/images/search_main.png" width="122px" height="122px">
							</div>
						</div>
						
					</c:forEach>
					
				</div>
			</section>
			
			<!-- 지도API -->
			<section class="api">
			<div class="hapi">
				<!-- <iframe width="100%" height="100px"></iframe> -->
				<iframe src="http://localhost:9000/petcarepedia/search_map.do"
					scrolling="no" width="100%" height="1000px" frameborder=0></iframe>
				<!-- <img src="http://localhost:9000/petcarepedia/images/API.png"> -->
			</div>
			</section>
		</div>
	</div> 

	<!-- footer -->
	<!-- <iframe width="100%" height="100px"></iframe> -->
	<jsp:include page="../footer.jsp"></jsp:include>	
</body>
</html>