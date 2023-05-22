<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Hospital- List </title>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/kang_admin.css">
</head>
<body>
	<!-- header -->
	<jsp:include page="../../header.jsp"></jsp:include>
	
	<div class="d1">
		<section class="hospital">
			<section id = "section1">
					<div>
						<nav>
							<ul>
								<li>공지관리</li>
								<li><a href = "admin_notice.do">공지관리</a></a></li>
								<li><a href = "hospital_list.do">병원 관리</a></li>
								<li><a href = "http://localhost:9000/animal/admin/member/member_list.jsp">회원 관리</a></li>
								<li><a href = "http://localhost:9000/animal/admin/review/review_list.jsp">신고 리뷰 관리</a></li>
								<li><a href = "http://localhost:9000/animal/admin/reserve/reserve_list.jsp">예약 관리</a></li>
								<li><a href = "#">나가기</a></li>
							</ul>
						</nav>
					</div>
				</section>
		<section id="section2">
			<div class="d2">
				<input type="text" class="search_bar" placeholder="병원명 입력">
				<button class="button1"><img src="http://localhost:9000/petcarepedia/images/foot_sky.png"></button>
			</div>
			
				<table class="table" id=ad_nt_list>
					<tr>
						<td colspan="5" >
							<button type="button" class="button"><a href="admin_notice_write.do">등록</a></button>
						</td>
					</tr>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성일자</th>
						<th>조회수</th>
					</tr>
					<c:forEach var="list" items="${noticeList }">
						<tr>
							<td>${list.rno }</td>
							<td><a href="admin_notice_content.do?nid=${list.nid }">${list.title }</a></td>
							<td>${list.ndate }</td>
							<td>${list.nhits }</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan ="5" class="text">
						</td>
					</tr>
					<tr>
						<td colspan="5" class="number"><<  1  2  3  4  5  6  7  8  9  10  >></td>
					</tr>
				</table>
			</section>
		</section>
	</div>
	<!-- footer -->
	<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>