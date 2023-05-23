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
	<jsp:include page="../admin_header.jsp"></jsp:include>
	<div class="d1">
		<section id="hospital_update">
			<form name="updateForm" action="hospital_update_proc.do" method="post">
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
								<li><a href = "http://localhost:9000/petcarepedia/login.do">나가기</a></li>
							</ul>
						</nav>
					</div>
				</section>
				<section id="section2">
					<div id="d3">
						<table class="table">
							<tr>
								<th>병원명</th>
								<td><input type="text" name="name" id="name" value="${hospitalVo.hname} "></td>
							</tr>
							<tr>
								<th>위치</th>
								<td><input type="text" name="address" id="address" value="${hospitalVo.gloc}${hospitalVo.loc}"></td>
							</tr>
							<tr>
								<th>전화번호</th>
								<td><input type="text" name="phone" id="phone" value="${hospitalVo.tel}"></td>
							</tr>
							<tr>
								<th>영업시간</th>
								<td>
									<input name="time" id="time" placeholder ="O" value="${hospitalVo.htime}"/>
								</td>
							</tr>
							<tr>
								<th>야간 근무 여부</th>
								<td>
									<input name="time" id="time" placeholder ="O" value="${hospitalVo.ntime}"/>
								</td>
							</tr>
							<tr>
								<th>공휴일 진료 여부</th>
								<td><input type="text" name="close" id="close" placeholder ="O" value="${hospitalVo.holiday}"></td>
							</tr>
							<tr>
								<th>특수 동물 진료 여부</th>
								<td><input type="text" name="animal" id="animal" value="${hospitalVo.animal}"></td>
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
			</form>
		</section>
	</div>
	<!-- footer -->
	<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>