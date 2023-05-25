<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/admin1.css">
	<link rel="stylesheet" href="http://localhost:9000/mycgv_jsp/css/am-pagination.css">
	<script src="http://localhost:9000/pecarepedia/js/jquery-3.6.4.min.js"></script>
	<script src="http://localhost:9000/petcarepedia/js/mycgv_jsp_jquery.js"></script>
	<script src="http://localhost:9000/petcarepedia/js/am-pagination.js"></script>
		<link href="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" rel="shortcut icon" type="image/x-icon">
	<title>펫캐어피디아 | 관리자</title>

</head>
<body>
<!-- header -->
	<jsp:include page="../admin_header.jsp"></jsp:include>
	
	<div class="d1">
		<section class="hospital">
			<section id = "section1">
				<div>
					<nav>
						<ul>
							<li>병원관리</li>
							<li><a href = "http://localhost:9000/petcarepedia/hospital_list.do">병원 관리</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/admin/member/member_list.do">회원 관리</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/admin/reserve/reserve_list.do">예약 관리</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/admin/review/review_list.do">신고 리뷰 관리</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/admin/admin_notice/admin_notice.do">공지 사항 관리</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/login.do">나가기</a></li>
						</ul>
					</nav>
				</div>
			</section>
		<form name="hopitalForm" action="hospital_list_data.do" method="post">
		<section id="section2">
			<div class="d2">
				<input type="text" class="search_bar" placeholder="병원명 입력">
				<button type="button" class="button1">
					<a href="http://localhost:9000/petcarepedia/hospital_list_detail.do">
						<img src="http://localhost:9000/petcarepedia/images/foot_sky.png">
					</a>
				</button>
			</div>
				<table class="table">
					<tr>
						<td colspan="5" >
							<button type="button" class="button"><a href="http://localhost:9000/petcarepedia/hospital_detail.do">등록</a></button>
							<button type="button" class="button"><a href="http://localhost:9000/petcarepedia/hospital_update.do">수정</a></button>
							<button type="button" class="button">삭제</button>
						</td>
					</tr>
					<tr>
						<th>번호</th>
						<th>병원명</th>
						<th>기타 동물 여부</th>
						<th>야간 진료 여부</th>
						<th>등록일</th>
					</tr>
					<c:forEach var="hospitalVo" items="${list}">
					<tr>
						<td>${hospitalVo.rno}</td>
						<td><a href="hospital_list_detail.do?hid=${hospitalVo.hid}">${hospitalVo.hname}</a></td>
						<td>${hospitalVo.animal}</td>
						<td>${hospitalVo.ntime}</td>
						<td>${hospitalVo.hid}</td>
					</tr>
					</c:forEach>
					
					<tr>
						<td colspan ="5" class="text">
							<br><br>
						</td>
					</tr>
					<tr>
						<!-- <td colspan="5" class="number"><<  1  2  3  4  5  6  7  8  9  10  >></td> -->
						<td colspan="5" class="number"><div id="ampaginationsm"></div></td> 
					</tr>
				</table>
			</section>
		</form>
		</section>
	</div>
	<!-- footer -->
		<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>