<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" rel="shortcut icon" type="image/x-icon">
<title>펫캐어피디아 | 리뷰 신고</title>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/kang_style.css">
<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/petcarepedia/js/petcarepedia_jsp_jquery_kang.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.7.10/dist/sweetalert2.all.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/sweetalert2@11.7.10/dist/sweetalert2.min.css" rel="stylesheet">
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
				<input type="hidden" name="rid" id="rid" value="${rid }">
				<table class="notice_delete">
					<tr>					
						<td>정말로 신고 하시겠습니까?</td>
					</tr>				
					<tr>
						<td colspan="2">
							<button type="button" class="rp_button" id="btnReport">확인</button>
							<c:choose>
								<c:when test="${page eq null || page eq ''}">
									<a href="review_content.do?rid=${rid }"><button type="button" class="rp_button">취소</button></a>
								</c:when>
								<c:when test="${filter_location eq null || filter_location eq ''}">
									<a href="review_content.do?rid=${rid }&&page=${page }"><button type="button" class="rp_button">취소</button></a>
								</c:when>
								<c:otherwise>
									<a href="review_content.do?rid=${rid }&&page=${page }&&filter_location=${filter_location}"><button type="button" class="rp_button">취소</button></a>
								</c:otherwise>
							</c:choose>
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