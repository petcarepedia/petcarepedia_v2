<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<script>
		$().ready(function () {
	        Swal.fire({
	            icon: 'warning',                         // Alert 타입
	            /* title: 'Alert가 실행되었습니다.',   */       // Alert 제목
	            text: '삭제할 리뷰가 맞는 지 확인해주세요',  // Alert 내용
	            
	            confirmButtonColor:'#98dfff',
	      	  	confirmButtonText:'확인'
	        });
		});
	</script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../admin_header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="d1">
		<section id="review_delete2">
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
						<form name="deleteForm" action="review_delete_proc2.do" method="post">
						<input type = "hidden" name = "rid" value = "${reviewVo.rid}">
							<table class="table">
								<tr>
									<th>병원이름</th>
									<td>
										${reviewVo.hname }
									</td>
								</tr>
								<tr>
									<th>작성자</th>
									<td><img src="http://localhost:9000/petcarepedia/images/cat.png"><p>${reviewVo.nickname}</p></td>
								</tr>
								<tr>
									<th>상세내용</th>
									<td colspan='3'>
										${reviewVo.rcontent }
									</td>
								</tr>
								<tr>
									<td colspan="5"> 
										<button type="submit" class="button5" id="btn_update">삭제완료</button>
										<button type="button" class="button5" id="btn_delete"><a href="admin_review_detail.do?rid=${reviewVo.rid}">이전으로</a></button>
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