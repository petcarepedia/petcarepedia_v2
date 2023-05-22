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
	<jsp:include page="../../header.jsp"></jsp:include>
	<div class="content">
		<section class="notice">
			<div id="title_l">
				<h1 class="title">관리자 - 공지사항</h1>
			</div>
			<form name="deleteForm" action="admin_notice_delete_proc.do" method="post">
				<input type="hidden" name="nid" value="${nid }">
				<table class="notice_delete">
					<tr>					
						<td>정말로 삭제 하시겠습니까?</td>
					</tr>				
					<tr>
						<td colspan="2">
							<button type="submit" class="ad_button">삭제</button>
							<a href="admin_notice_content.do?nid=${nid }"><button type="button" class="ad_button">취소</button></a>
							<a href="admin_notice.do"><button type="button" class="ad_button">목록</button></a>							
						</td>				
					</tr>
				</table>
			</form>
		</section>
	</div>
	<!-- footer -->
	<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>