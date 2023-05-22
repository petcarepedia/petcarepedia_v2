<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/kang_style.css">
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="content">
		<section class="review_content">
			<div id="title_l">
				<h1 class="title">리뷰상세</h1>
			</div>
			<div class="review_detail">
				<table class="rv_detail_menu">
					<tr>
						<th>병원이름</th>
						<td>${reviewVo.hname }</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><img src="http://localhost:9000/petcarepedia/images/cat.png">${reviewVo.mid }</td>
					</tr>
					<tr>
						<th>상세내용</th>
						<td colspan='3'>
							${reviewVo.rcontent }
						</td>
					</tr>
				</table>
				<div class="table_right">
					<div id="right_top">
						<button>
							<span class="review_like">
								♥️
							</span>
							${reviewVo.rlike }
						</button>
						<button>
							<img src = "http://localhost:9000/petcarepedia/images/bookmark2.png">
						</button>
					</div>
					<div id="star">
						<div class="score" id="score_l">
							평점
						</div>
						<div id="avg" class="score">
							⭐ ${reviewVo.rstar } / 5
						</div>
					</div>
					<table>
						<tr>
							<td>작성일자</td>
							<td>${reviewVo.rdate }</td>
						</tr>
					</table>
				</div>
				<button type="button" class="report">신고하기</button>
			</div>
			<div class="rc_button_r">
				<a href="review_update.do?rid=${reviewVo.rid }"><button type="button" class="button">수정</button></a>
				<a href="review_delete.do?rid=${reviewVo.rid }"><button type="button" class="button">삭제</button></a>
				<a href="review_main.do"><button type="button" class="button">목록</button></a>
			</div>
		</section>
	</div>
	<!-- footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>