<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Hospital - List</title>
	<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/admin1.css">
</head>
<body>
<!-- header -->
	<iframe src="http://localhost:9000/petcarepedia/admin/admin_header.jsp" width="100%" height="100px" frameborder=0></iframe>
	<div class="d1">
		<section id="hospital_data">
			<section id = "section1">
				<div id="d2">
					<nav>
						<ul>
							<li>병원관리</li>
							<li><a href = "http://localhost:9000/petcarepedia/admin/hospital/hospital_list.jsp">병원 관리</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/admin/member/member_list.jsp">회원 관리</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/admin/reserve/reserve_list.jsp">예약 관리</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/admin/review/review_list.jsp">신고 리뷰 관리</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/admin/admin_notice/admin_notice.jsp">공지 사항 관리</a></li>
							<li><a href = "#">나가기</a></li>
						</ul>
					</nav>
				</div>
			</section>
			<section id="section2">
				<div id="d3">
					<table class="table">
						<tr>
							<th>병원명</th>
							<td><input type="text" name="name" id = "name" value="멍멍동물병원"></td>
						</tr>
						<tr>
							<th>위치</th>
							<td><input type="text" name="address" id="address" value="서울시 강남구 역삼동"></td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td><input type="text" name="phone" id="phone" value="02-1234-1234"></td>
						</tr>
						<tr>
							<th>영업시간</th>
							<td>
								<textarea name="time" id="time" placeholder="영업시간 : 00:00 ~ 00:00 
																			    야간근무시간 : 00:00 ~ 00:00"
																			></textarea>
							</td>
						</tr>
						<tr>
							<th>휴무일</th>
							<td><input type="text" name="close" id="close" placeholder ="매주  요일" value="알요일, 공휴일"></td>
						</tr>
						<tr>
							<th>취급 동물</th>
							<td><input type="text" name="animal" id="animal" value="강아지"></td>
						</tr>
						<tr>
							<th>강조사항(선택)</th>
							<td><textarea name="check" id="check"></textarea></td>
						</tr>
						<tr>
							<th>첨부파일<th>
							<input type="file" name="file" id="file">
						</tr>
						<tr>
							<td colspan="2"><button type="button" class="button4">저장하기</button></td>
						</tr>
					</table>
				</div>
			</section>
		</section>
	</div>
	<!-- footer -->
		<iframe src="http://localhost:9000/petcarepedia/footer.jsp" width="100%" height="350px" frameborder=0></iframe>
</body>
</html>