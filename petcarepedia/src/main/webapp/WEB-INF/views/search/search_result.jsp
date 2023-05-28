<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" rel="shortcut icon" type="image/x-icon">
	<title>펫캐어피디아 | 검색 결과</title>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/search_result.css">

<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/petcarepedia/js/search_result.js"></script>
</head>

<body>
	<!-- header -->
	<!-- <iframe width="100%" height="100px"></iframe> -->
	<div class="header-wrapper">
		<jsp:include page="../header.jsp"></jsp:include>	
	</div>
	
	
	<!-- content -->
	<div class="result_main">
		<section class="info">
			<div class="info_d">
				<div class="images_d">
					<%-- <img src="${hospital.img}"> --%>
					<img src="http://localhost:9000/petcarepedia/images/hospital 1.png">
				</div>
				
				<div class="name_d">
					<div class="area_d">
						<a href="http://localhost:9000/petcarepedia/search_main.do">서울</a>
						<span>></span>
						<a href="http://localhost:9000/petcarepedia/search_main.do">${hospital.gloc}</a>
					</div>
					
					<span class="name">${hospital.hname}</span>
					
					<span class="grade">⭐  ${star.rstar} | 리뷰 ${fn:length(RM_select)}</span>
					
					<button type="button" id="reservation" value="${hospital.hid}"><img src="http://localhost:9000/petcarepedia/images/cal.png">간편 예약하기
								&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
								&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
								&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
								&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp></button>
					<div id="hmodal" class="modal">
					<div class="modal-content">
					    <span class="close">&times;</span>
					   <!-- <iframe id="reservation-iframe" src="" 
						width="500px" height="500px" frameborder=0 ></iframe> -->
					  <jsp:include page="search_reservation.jsp"></jsp:include>	
					  </div>
				  	</div>
					
					
					<div class="buttons">
						<a href="review_write.do?mid=${mid}">
							<button type="button" id="review"><img src="http://localhost:9000/petcarepedia/images/review.png">리뷰하기</button>
						</a>	
						<!-- <button type="button" id="share"><img src="http://localhost:9000/petcarepedia/images/share.png">공유하기</button> -->
						<form name="bookmarkForm" action="bookmarkProc.do" method="get">
							<a href="#" onclick = "alert('즐겨찾기에 추가되었습니다.')">
								<input type="hidden" name="hid" value="${hospital.hid}">
								<input type="hidden" name="mid" value="hong">
								<button type="button" id="bookmark"><img src="http://localhost:9000/petcarepedia/images/like.png">찜하기</button>
							</a>
						</form>
					</div>
				</div>
				
				<hr>
				
				<div class="link">
					<span><img src="http://localhost:9000/petcarepedia/images/loc.png">${hospital.loc}</span>
					<c:if test="${hospital.hrink != null}">
						<span><img src="http://localhost:9000/petcarepedia/images/home.png"><a href="${hospital.hrink}">병원 홈페이지 가기</a></span>
					</c:if>
					<span><img src="http://localhost:9000/petcarepedia/images/call.png">${hospital.tel}</span>
				</div>
				
				<hr>
				
				<div class="nav">
					<span id="info_s">병원정보</span>
					<span id="review_s">리뷰</span>
				</div>
				
				<hr>
				
				<div class="api_info">
					<div class="api">
						<span>병원정보</span>
						<span>위치 & 진료시간</span>
						<div class="map">
							<iframe class="map" src="http://localhost:9000/petcarepedia/search_map.do"
							scrolling="no" width="350px" height="285px" frameborder=0></iframe>
						</div>
						<span>${hospital.loc}</span>
					</div>
					
					<div class="time">
						<ul>
							<li>영업시간</li>
							<li>야간 휴진 여부</li>
							<li>휴일 휴진 여부</li>
							<li>특수동물 취급 여부</li>
							<li>소개</li>
						</ul>
						
						<ul>
							<li>${hospital.htime}</li>
							<li>${hospital.ntime}</li>
							<li>${hospital.holiday}</li>
							<li>${hospital.animal}</li>
							<c:if test="${! hospital.intro.equals('X')}">
								<li>${hospital.intro}</li>
							</c:if>
						</ul>
					</div>
				</div>
				
				<hr>
			</div>
		
		</section>
		
		<section class="review">
			<div class="list">
				<div class="grade">
					<span>리뷰 ${fn:length(RM_select)}</span>
					
					<div class="total">
						<span>${star.rstar} / 5</span>
						<span> ⭐ ⭐ ⭐ ⭐ ⭐</span>
					</div>
				</div>
				
				<!-- <div class="filter">
					<span>동물종류</span>
					<div class="dropdown-content">
						<p>기본정렬</p>
						<p>강아지</p>
						<p>고양이</p>
						<p>파충류</p>
						<p>기타</p> 
					</div>
					
					<span>기본정렬</span>
					<div class="dropdown-content">
						 <p>기본정렬</p>
						 <p>좋아요 많은 순서</p>
						 <p>평점 높은 순서</p>
						 <p>평점 낮은 순서</p>
					</div>
				</div> -->
				
				<c:forEach var="RM_select" items="${RM_select}"> 
				
				<div class="review_card">
					<div class="member">
						<div class="name">
							<img src="http://localhost:9000/petcarepedia/images/cat.png">
							<span>${RM_select.nickname}</span>
						</div>
						
						<hr class="member_hr">
						<span class="stext">⭐ <fmt:formatNumber type="number"  pattern="0" value="${RM_select.rstar}" /> / 5</span>
						<hr class="member_hr">
						<!-- <span>친절  ⭐⭐⭐⭐⭐</span>
						<span>위생  ⭐⭐⭐⭐⭐</span> -->
						<span class="stot">별점  ⭐⭐⭐⭐⭐</span>
					</div>
					
					<div class="write">
						<!-- <h3>동물 종류 : 고양이</h3> -->
						<p>${RM_select.rcontent}</p>
					</div>
					
					<div class="date">
						<span>작성 일자 : ${RM_select.rdate}</span>
						<span> </span>
						<form name="likeForm" action="likeProc.do" method="get">
							<input type="hidden" name="hid" value="${hospital.hid}">
							<input type="hidden" name="rid" value="${RM_select.rid}">
							<button id="like" class="like" data-rid="${RM_select.rid}">좋아요&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp❤️ <span class="like-count">${RM_select.rlike}</span></button>
						</form>
						
						<form name="rstateForm" action="rstateProc.do" method="post">
							<input type="hidden" name="rid" value="${RM_select.rid}">
							<input type="hidden" name="hid" value="${hospital.hid}">
							<a href="#" onclick="return confirm('정말로 신고하시겠습니까?')" id="rstateBtn">
								<button class="rstate" name="rstate">신고하기</button></a>
							<!-- <span>신고하기</span> -->
						</form>
					</div>
				</div>
				
				</c:forEach>
			</div>
		</section>	
	</div>	

	
	<!-- footer -->
	<!-- <iframe width="100%" height="100px"></iframe> -->
	<jsp:include page="../footer.jsp"></jsp:include>	
</body>
</html>