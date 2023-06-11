<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/admin1.css">
	<link rel="stylesheet" href="http://localhost:9000/mycgv_jsp/css/am-pagination.css">
	<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
	<script src="http://localhost:9000/petcarepedia/js/petcarepedia_jquery_serin.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
	<link href="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" rel="shortcut icon" type="image/x-icon">
	<title>펫캐어피디아 | 관리자</title>
<!-- <script>
    $(document).ready(function(){
        $("#btn_update").click(function(event){
            event.preventDefault(); // 폼 전송을 막음
            // 수정 완료 버튼 클릭 시 실행되는 함수
            Swal.fire({
                icon: 'success',
                text: '수정이 완료되었습니다.',
                confirmButtonColor: '#7ab2cc',
                confirmButtonText: '확인'
            }).then((result) => {
                if (result.isConfirmed) {
                    // 확인 버튼을 눌렀을 경우 수정 처리
                    document.updateForm.submit(); // 폼 전송
                    // 수정 처리를 위한 코드 작성
                }
            });
        });
    });
</script> -->

</head>
<body>
<!-- header -->
	<jsp:include page="../admin_header.jsp"></jsp:include>
	<div class="d1">
		<section id="hospital_update">
				<section id = "section1">
					<div id="d2">
						<nav>
							<ul>
								<li>병원관리</li>
								<li><a href = "http://localhost:9000/petcarepedia/admin_hospital_list.do">병원 관리</a></li>
								<li><a href = "http://localhost:9000/petcarepedia/admin_member_list.do">회원 관리</a></li>
								<li><a href = "http://localhost:9000/petcarepedia/admin_reserve_list.do">예약 관리</a></li>
								<li><a href = "http://localhost:9000/petcarepedia/admin_review_list.do">신고 리뷰 관리</a></li>
								<li><a href = "http://localhost:9000/petcarepedia/admin_notice.do">공지 사항 관리</a></li>
							</ul>
						</nav>
					</div>
				</section>
				<section id="section2">
					<div id="d3">
						<form name="updateForm" action="hospital_update_proc.do" method="post" enctype="multipart/form-data">
						<input type = "hidden" name = "hid" value = "${hospitalVo.hid}">
						<input type = "hidden" name = "hsfile" value = "${hospitalVo.hsfile}">
							<table class="table">
								<tr>
									<th>병원명</th>
									<td><input type="text" name="hname" id = "hname" value="${hospitalVo.hname}"></td>
								</tr>
								<tr>
									<th>주소</th>
									<td><input type="text" name="gloc" id="gloc" value="${hospitalVo.gloc}"></td>
								</tr>
								<tr>
									<th>지역 구</th>
									<td><input type="text" name="loc" id="loc" value="${hospitalVo.loc}"></td>
								</tr>
								<tr>
									<th>전화번호</th>
									<td><input type="text" name="tel" id="tel" value="${hospitalVo.tel}"></td>
								</tr>
								<tr>
									<th>영업시간</th>
									<td>
										<input type="text" name="htime" id="htime" placeholder="영업시간 : 00:00 ~ 00:00" value="${hospitalVo.htime}">
									</td>
								</tr>
								<tr>
									<th>특수동물 진료 여부</th>
									<td><input type="text" name="animal" id="animal" placeholder="O / X " value="${hospitalVo.animal}"> </td>
								</tr>
								<tr>
									<th>야간 근무 여부</th>
									<td><input type="text" name="ntime" id="ntime" placeholder="O / X " value="${hospitalVo.ntime}"> </td>
								</tr>
								<tr>
									<th>공휴일 진료 여부</th>
									<td><input type="text" name="holiday" id="holiday" placeholder="O / X " value="${hospitalVo.holiday}"> </td>
								</tr>
								<tr>
									<th>홈페이지 링크</th>
									<td><input type="text" name="hrink" id="hrink" placeholder="O / X " value="${hospitalVo.hrink}"> </td>
								</tr>
								<tr>
									<th>강조사항(선택)</th>
									<td><textarea name="intro" id="intro" >${hospitalVo.intro}</textarea></td>
								</tr>
								<tr>
									<th>파일 업로드</th>
									<td>
										<input type="hidden" name="hfile" value="${hospitalVo.hfile}">
										<input type="hidden" name="hsfile" value="${hospitalVo.hsfile}">
										<input type="file" name="file1" id ="file1">
										<c:choose>
											<c:when test="${hospitalVo.hfile != null}">
												<span id="update_file">${hospitalVo.hfile}</span>
											</c:when>
											<c:otherwise>
												<span id="update_file">선택된 파일 없음</span>
											</c:otherwise>
										</c:choose>
									</td>
								</tr>
								<tr>
									<td colspan="5"> 
										<button type="button" class="button5" id="btn_update">수정완료</button>
										<button type="button" class="button5" id="btn_before">
											<a href="admin_hospital_content.do?hid=${hospitalVo.hid}&hsfile=${hospitalVo.hsfile}">이전으로</a>
										</button>
									</td>
								</tr>
							</table>
						</form>
					</div>
				</section>
		</section>
	</div>
	<!-- footer -->
	<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>