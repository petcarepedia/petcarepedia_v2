<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/kang_style.css">
<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/petcarepedia/js/petcarepedia_jsp_jquery_kang.js"></script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp"></jsp:include>
<!-- 	<form name="reviewForm" action="#" method="get" id=reviewForm> -->		
		<div id="best_review" class="review">
			<jsp:include page="../best_review_list.jsp"></jsp:include>	
		</div>
		<div id="filter_page" class="review">
		<p>상세검색</p>
			<table id="filter_lo" class="filter">
				<tr>
					<th rowspan='3'>지역구분</th>
					<td><input type="checkbox" name="filter_location" value="서울전체"> 서울전체</td>
					<td><input type="checkbox" name="filter_location" value="강남구"> 강남구</td>
					<td><input type="checkbox" name="filter_location" value="강북구"> 강북구</td>
					<td><input type="checkbox" name="filter_location" value="강서구"> 강서구</td>
					<td><input type="checkbox" name="filter_location" value="관악구"> 관악구</td>
					<td><input type="checkbox" name="filter_location" value="광진구"> 광진구</td>
					<td><input type="checkbox" name="filter_location" value="구로구"> 구로구</td>
					<td><input type="checkbox" name="filter_location" value="금천구"> 금천구</td>
					<td><input type="checkbox" name="filter_location" value="노원구"> 노원구</td>
					<td><input type="checkbox" name="filter_location" value="도봉구"> 도봉구</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="filter_location" value="동대문구"> 동대문구</td>
					<td><input type="checkbox" name="filter_location" value="동작구"> 동작구</td>
					<td><input type="checkbox" name="filter_location" value="마포구"> 마포구</td>
					<td><input type="checkbox" name="filter_location" value="서대문구"> 서대문구</td>
					<td><input type="checkbox" name="filter_location" value="서초구"> 서초구</td>
					<td><input type="checkbox" name="filter_location" value="성동구"> 성동구</td>
					<td><input type="checkbox" name="filter_location" value="성북구"> 성북구</td>
					<td><input type="checkbox" name="filter_location" value="송파구"> 송파구</td>
					<td><input type="checkbox" name="filter_location" value="양천구"> 양천구</td>
					<td><input type="checkbox" name="filter_location" value="영등포구"> 영등포구</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="filter_location" value="용산구"> 용산구</td>
					<td><input type="checkbox" name="filter_location" value="은평구"> 은평구</td>
					<td><input type="checkbox" name="filter_location" value="종로구"> 종로구</td>
					<td><input type="checkbox" name="filter_location" value="중구"> 중구</td>
					<td><input type="checkbox" name="filter_location" value="중량구"> 중량구</td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
				</tr>
			</table>
		</div>
		<div id="review" class="review">
			<div id="title">
				<span>리뷰</span>
				<span><a href="review_write.do">리뷰쓰기 ></a></span>
			</div>
			<ul>
				<li id="result_sort">
					<span>2개의 결과</span>
				</li>
				<c:forEach var="list" items="${reviewList }">
					<li class="review_list">
						<ul>
							<li id="list_left" class="list">
								<p><img src="http://localhost:9000/petcarepedia/images/cat.png">${list.mid }</p>
								<div id="star">
									<div id="avg">
										⭐ ${list.rstar } / 5
									</div>
								</div>
							</li>
								<li id="list_middle" class="list">
									<a href="review_content.do?rid=${list.rid }">	
										<p>동물 종류 : 고양이</p>
										<div>
											${list.rcontent }
										</div>
									</a>
								</li>
							<li id="list_right" class="list">
								<table>
									<tr>
										<td>작성일자</td>
										<td>${list.rdate }</td>
									</tr>
									<tr>
										<td>진료일자</td>
										<td>2023/4/28</td>
									</tr>
								</table>
								<button type="button">
									도움이 되었어요
									<span>
										♥️
									</span>
									${list.rlike }
								</button>
								<button type="button" class="report">신고하기</button>
								<table id="main_hits">
									<tr>
										<td>조회수</td>
										<td>150</td>
									</tr>
								</table>
							</li>
						</ul>
					</li>
				</c:forEach>
				<li><a href="#" id="load">더 보기</a></li>
			</ul>
		</div>
	<!-- </form> -->
	
	<!-- footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>