<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<!-- content -->
	<div class="content">
		<section class="notice">
			<div id=title_l>
				<h1 class="title">공지사항</h1>
			</div>
			<table class="notice">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성일자</th>
					<th>조회수</th>
				</tr>
				<c:forEach var="list" items="${noticeList }">
					<tr>
						<td>${list.rno }</td>
						<td><a href="notice_content.do?nid=${list.nid }">${list.title }</a></td>
						<td>${list.ndate }</td>
						<td>${list.nhits }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4">1 2 3 4</td>
				</tr>
			</table>
		</section>
	</div>
	<!-- footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>