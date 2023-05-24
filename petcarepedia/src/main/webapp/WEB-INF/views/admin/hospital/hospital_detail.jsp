<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/admin1.css">
	<link href="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" rel="shortcut icon" type="image/x-icon">
	<title>펫캐어피디아 | 관리자</title>
</head>
<body>
<!-- header -->
	<jsp:include page="../admin_header.jsp"></jsp:include>
	<div class="d1">
		<section id="hospital_data">
			<form name="writeForm" action="hospital_detail_proc.do" method="post">
				<section id = "section1">
					<div id="d2">
						<nav>
							<ul>
								<li>병원관리</li>
								<li><a href = "http://localhost:9000/petcarepedia/hospital_list.do">병원 관리</a></li>
								<li><a href = "http://localhost:9000/petcarepedia/admin/member/member_list.do">회원 관리</a></li>
								<li><a href = "http://localhost:9000/petcarepedia/admin/reserve/reserve_list.do">예약 관리</a></li>
								<li><a href = "http://localhost:9000/petcarepedia/admin/review/review_list.do">신고 리뷰 관리</a></li>
								<li><a href = "http://localhost:9000/petcarepedia/admin/admin_notice/admin_notice.do">공지 사항 관리</a></li>
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
								<td><input type="text" name="name" id = "name"></td>
							</tr>
							<tr>
								<th>위치</th>
								<td><input type="text" name="address" id="address"></td>
							</tr>
							<tr>
								<th>전화번호</th>
								<td><input type="text" name="phone" id="phone"> </td>
							</tr>
							<tr>
								<th>영업시간</th>
								<td>
									<textarea name="htime" id="htime" placeholder="영업시간 : 00:00 ~ 00:00 
																				    야간근무시간 : 00:00 ~ 00:00"
																				></textarea>
								</td>
							</tr>
							<tr>
								<th>야간 근무 여부</th>
								<td><input type="text" name="ntime" id="ntime"> </td>
							</tr>
							<tr>
								<th>휴무일</th>
								<td><input type="text" name="close" id="close" placeholder ="매주  요일"> </td>
							</tr>
							<tr>
								<th>공휴일 진료 여부</th>
								<td><input type="text" name="holiday" id="holiday"> </td>
							</tr>
							<tr>
								<th>강조사항(선택)</th>
								<td><textarea name="intro" id="intro"></textarea></td>
							</tr>
							<tr>
								<th>첨부파일<th>
								<input type="file" name="file" id="file">
							</tr>
						</table>
					</div>
					<div id="d4">
						<button type="submit" class="button4">저장하기</button>
						<button type="button" class="button5"><a href="http://localhost:9000/petcarepedia/hospital_list.do"> 이전으로</a></button>
					</div>
				</section>
			</form>
		</section>
	</div>
	<!-- footer -->
		<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>