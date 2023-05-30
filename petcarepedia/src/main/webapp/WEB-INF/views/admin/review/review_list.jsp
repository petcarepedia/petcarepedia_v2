<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/admin1.css">
	<link rel="stylesheet" href="http://localhost:9000/mycgv_jsp/css/am-pagination.css">
	<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
	<script src="http://localhost:9000/petcarepedia/js/petcarepedia_jquery_serin.js"></script>
	<link href="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" rel="shortcut icon" type="image/x-icon">
	<title>펫캐어피디아 | 관리자</title>
</head>
<body>
<!-- header -->
	<jsp:include page="../admin_header.jsp"></jsp:include>
	
	<div class="d1">
		 <section class="review">
			 <section id = "section1">
					<div>
						<nav>
							<ul>
								<li>신고리뷰관리</li>
								<li><a href = "http://localhost:9000/petcarepedia/hospital_list.do">병원 관리</a></li>
								<li><a href = "http://localhost:9000/petcarepedia/member_list.do">회원 관리</a></li>
								<li><a href = "http://localhost:9000/petcarepedia/reserve_list.do">예약 관리</a></li>
								<li><a href = "http://localhost:9000/petcarepedia/review_list.do">신고 리뷰 관리</a></li>
								<li><a href = "http://localhost:9000/petcarepedia/admin_notice.do">공지 사항 관리</a></li>
								<li><a href = "http://localhost:9000/petcarepedia/login.do">나가기</a></li>
							</ul>
						</nav>
					</div>
				</section>
				<section id = "section2">
					<div id="d3">
						<table class="table">
								<tr>
									<th>번호</th>
									<th>아이디</th>
									<th>병원명</th>
									<th>내용</th>
									<th>작성일</th>
								</tr>
							<c:forEach var="reviewVo" items="${list}">
								<tr>
									<td>${reviewVo.rno}</td>
									<td>${reviewVo.mid}</td>
									<td>${reviewVo.hname}</td>
									<td><a href="review.detail.do?${reviewVo.rid}">${reviewVo.rcontent}</a></td>
									<td>${reviewVo.rdate}</td>
								</tr>
							</c:forEach>
								<tr>
									<td colspan="5" class="number">< 1  2  3  4  5  6  7  8  9  10  </td>
								</tr>
								<tr>
						</table>
						<button type="button" class="button4" ><a href="http://localhost:9000/petcarepedia/hospital_list.do">이전으로</a></button>
					</div>
				</section>
			</section>
		</div>
	<!-- footer -->
		<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>