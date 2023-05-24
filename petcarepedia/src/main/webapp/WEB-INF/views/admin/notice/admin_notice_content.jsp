<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펫캐어피디아 | 관리자 공지사항</title>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/kang_style.css">
<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../admin_header.jsp"></jsp:include>
	<div class="content">
		<section class="notice">
			<div id="title_l">
				<h1 class="title">공지사항 상세보기</h1>
			</div>
			<table class="notice_content">
				<tr>
					<td>${noticeVo.title }</td>
				</tr>
				<tr>
					<td>
						${noticeVo.ncontent }
					</td>
				</tr>
			</table>
			<div id="date">${noticeVo.ndate }</div>
			<div class="nc_button_r">
				<a href="admin_notice_update.do?nid=${noticeVo.nid }"><button type="button" class="ad_button">수정</button></a>
				<a href="admin_notice_delete.do?nid=${noticeVo.nid }"><button type="button" class="ad_button">삭제</button></a>
				<a href="admin_notice.do"><button type="button" class="ad_button">목록</button></a>
			</div>
		</section>
	</div>
	<!-- footer -->
	<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>