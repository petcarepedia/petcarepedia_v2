<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hospital- List</title>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/admin1.css">
</head>
<body>
<!-- header -->
	<jsp:include page="../admin_header.jsp"></jsp:include>
	
	<div class="d1">
		<section class="hospital_detail">
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
			<section class="section2">
				<div class="d2">
					<input type="text" class="search_bar" placeholder="병원명 입력">
					<button class="button1"><img src="http://localhost:9000/petcarepedia/admin/images/foot_sky.png"></button>
				</div>
				<div class="d3">
					<table class="table">
						<tr>
							<td colspan="5">
								<button type="button" class="button"><a href="http://localhost:9000/petcarepedia/admin/hospital/hospital_detail.do">등록</a></button>
								<button type="button" class="button"><a href="http://localhost:9000/petcarepedia/admin/hospital/hospital_update.do">수정</a></button>
								<button type="button" class="button">삭제</button>
							</td>
						</tr>
						<tr>
							<th>번호</th>
							<th>병원명</th>
							<th>상태</th>
							<th>등록일</th>
							<th>수정일</th>
						</tr>
						<tr>
							<td>1</td>
							<td><a href="hospital_list_detail.jsp">멍멍동물병원</a></td>
							<td>영업중</td>
							<td>2023-01-01</td>
							<td>2023-04-23</td>
						</tr>
						<tr>
							<td colspan="5">
								<br>
							</td>
						</tr>
						<tr>
							<td colspan="5">
								<button type="button" class="button4"><a href="http://localhost:9000/petcarepedia/admin/hospital/hospital_list.jsp">이전으로</a></button>
							</td>
						</tr>
					</table>
				</div>
			</section>
		</section>
	</div>
<!-- footer -->
	<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>