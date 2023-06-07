<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" rel="shortcut icon" type="image/x-icon">
	<title>펫캐어피디아 | 검색 결과</title>
	<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/search_main.css">
	
	<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
	<!-- <script src="http://localhost:9000/petcarepedia/js/search_main.js"></script> -->
	<script src="http://localhost:9000/petcarepedia/js/search_filter.js"></script>
	<script src="http://localhost:9000/petcarepedia/js/search_map.js"></script>
	
	<script>
	$(document).ready(function(){
		let shname = "${shname}";
		let output = "<p style='margin-top:15px; font-size:14px; display:inline-block'><strong>'${shname}'</strong> 검색 결과 <strong>${size}</strong>건</p>";
		output += "<a href='http://localhost:9000/petcarepedia/search_main.do' style='margin-left:10px; ";
		output += "font-size:12px; color:lightgray;'>병원목록 새로고침</a>";
		if(shname!=""){
			$("h1.title").after(output);
		}
	});
</script>
	
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
		
			<!-- <form name="search_area" action="searchAreaProc.do" method="get"> -->
				<div class="area">
					<div class="text_area">
						<span>지역구분</span>
					</div>
					
					<div class="check_area">
						<ul>
							<!-- <li><input type="checkbox" name="gloc" value="서울전체" checked="checked"><span>서울 전체</span></li> -->
							<li><input type="checkbox" class="gloc" name="gloc" value="*" checked="checked"><span>서울 전체</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="강남구" data-filter="강남구"><span>강남구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="강동구" data-filter="강동구"><span>강동구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="강북구" data-filter="강북구"><span>강북구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="강서구" data-filter="강서구"><span>강서구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="관악구" data-filter="관악구"><span>관악구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="광진구" data-filter="광진구"><span>광진구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="구로구" data-filter="구로구"><span>구로구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="금천구" data-filter="금천구"><span>금천구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="노원구" data-filter="노원구"><span>노원구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="도봉구" data-filter="도봉구"><span>도봉구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="동대문구" data-filter="동대문구"><span>동대문구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="동작구" data-filter="동작구"><span>동작구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="마포구" data-filter="마포구"><span>마포구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="서대문구" data-filter="서대문구"><span>서대문구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="서초구" data-filter="서초구"><span>서초구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="성동구" data-filter="성동구"><span>성동구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="성북구" data-filter="성북구"><span>성북구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="송파구" data-filter="송파구"><span>송파구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="양천구" data-filter="양천구"><span>양천구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="영등포구" data-filter="영등포구"><span>영등포구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="용산구" data-filter="용산구"><span>용산구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="은평구" data-filter="은평구"><span>은평구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="종로구" data-filter="종로구"><span>종로구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="중구" data-filter="중구"><span>중구</span></li>
							<li><input type="checkbox" class="gloc" name="gloc" value="중랑구" data-filter="중랑구"><span>중랑구</span></li>
							<!-- <input type="text" id="showFilter" value=""/> -->
						</ul>
					</div>
				</div>
			<!-- </form> -->
			
				
				<div class="time">
					<div class="text_time">
						<span>진료시간</span>
					</div>
					
					<div class="check_time">
						<ul>
							<li><input type="checkbox" name="time" id="time" value="time"><span>진료중</span></li>
							<li><input type="checkbox" name="time" id="holiday" value="휴O"><span>휴일진료</span></li>
							<li><input type="checkbox" name="time" id="ntime" value="야O"><span>야간진료</span></li>
						</ul>
					</div>
				</div>
					
					<div class="animal">
						<div class="text_animal">
							<span>특수 동물</span>
						</div>
						
						<div class="check_animal">
							<ul>
								<li><input type="checkbox" name="animal" id="animal" value="동O"><span>취급</span></li>
								<!-- <li><input type="checkbox" name="animal" id="animal" value="고양이"><span>고양이</span></li>
								<li><input type="checkbox" name="animal" id="animal" value="파충류"><span>파충류</span></li>
								<li><input type="checkbox" name="animal" id="animal" value="조류"><span>조류</span></li>
								<li><input type="checkbox" name="animal" id="animal" value="기타"><span>기타</span></li> -->
							</ul>
						</div>
					</div>
			<!-- </form> -->
		</section>
		
		<div class="s2">
		<!-- 검색리스트 -->
			<section class="list">
				<div class="hlist">
				
					<c:forEach var="list" items="${list}">
					<ul id="dataList">
						<li data-filter="${list.gloc} * 휴${list.holiday} time 야${list.ntime} 동${list.animal} ">
					
						<div class="list1">
							<div class="hinfo">
								
									<span>${list.hname}</span>
									<span>${list.tel}</span>
									<span id="rstar" name="rstar" class="rstar">⭐ ${list.rstar}</span>
									<input type="hidden" id="hid" name="hid" value="${list.hid}">
									<input type="hidden" id="startTime" name="startTime" value="${list.starttime}">
									<input type="hidden" id="endTime" name="endTime" value="${list.endtime}">
									<input type="hidden" id="holiday" name="holiday" value="휴일: ${list.holiday}" data-filter="${list.holiday}">
									<input type="hidden" id="ntime" name="ntime" value="야간: ${list.ntime}" data-filter="${list.ntime}">
							
								<span id="harea" value="${list.gloc}">${list.gloc}</span>
								<span id="htime">진료 중</span>
								<a href="http://localhost:9000/petcarepedia/search_result.do?hid=${list.hid}&mid=hong">
									<button type="button" class="hservation" id="${list.hid}">병원 상세보기
									&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
									&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp></button>
								</a>
									
								<%--  <div id="hmodal" class="modal">
								  <div class="modal-content">
								    <span class="close">&times;</span>
								      <jsp:include page="search_reservation.jsp"></jsp:include>	
								  </div>
								</div> --%>
							</div>
							
							<div class="himg">
								<c:choose>
								    <c:when test="${list.img != null && list.img != 'X'}">	
								        <img src="${list.img}" width="122px" height="122px">
								    </c:when>
								</c:choose>						
							</div>
						</div>
						</li>
						</ul>
						
					</c:forEach>
					
				</div>
			</section>
			
			<!-- 지도API -->
			<section class="api">
			<div class="hapi">
				<!-- <iframe width="100%" height="100px"></iframe> -->
				<!-- <iframe src="http://localhost:9000/petcarepedia/search_map.do"
					scrolling="no" width="100%" height="1000px" frameborder=0></iframe> -->
				<jsp:include page="search_map.jsp"></jsp:include>	
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