<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>review report</title>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/kang_style.css">
<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="content">
		<section class="notice">
			<div id="title_l">
				<h1 class="title">리뷰신고</h1>
			</div>
			<form name="reportForm" action="review_report_proc.do" method="post">
				<input type="hidden" name="rid" value="${rid }">
				<table class="notice_delete">
					<tr>					
						<td>정말로 신고 하시겠습니까?</td>
					</tr>				
					<tr>
						<td colspan="2">
							<button type="submit" class="rp_button">확인</button>
							<a href="review_content.do?rid=${rid }"><button type="button" class="rp_button">취소</button></a>
							<a href="review_main.do"><button type="button" class="rp_button">목록</button></a>							
						</td>				
					</tr>
				</table>
			</form>
		</section>
	</div>
	<!-- footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>