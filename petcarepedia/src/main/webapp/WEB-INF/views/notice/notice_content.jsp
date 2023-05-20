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
		<section class="notice">
			<div id="title_l">
				<h1 class="title">관리자 - 공지사항</h1>
			</div>
			<table class="notice_content" id="nct">
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
				<a href="notice.do?nid=${noticeVo.nid }"><button type="button" class="button">목록</button></a>
			</div>
		</section>
	</div>
	<!-- footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>