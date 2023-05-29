<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>review main</title>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/kang_style.css">
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/petcarepedia_song.css">
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/am-pagination.css">
<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/petcarepedia/js/petcarepedia_jsp_jquery_kang.js"></script>
<script src="http://localhost:9000/petcarepedia/js/am-pagination.js"></script>
<script>
	$(document).ready(function(){
		var filter_location = '${filter_location}';
		var pager = jQuery('#ampaginationsm').pagination({
		
		    maxSize: '${maxSize}',	    		// max page size
		    totals: '${totals}',	// total pages	
		    page: '${page}',		// initial page		
		    pageSize: '${pageSize}',			// max number items per page
		
		    // custom labels		
		    lastText: '&raquo;&raquo;', 		
		    firstText: '&laquo;&laquo;',		
		    prevText: '&laquo;',		
		    nextText: '&raquo;',
				     
		    btnSize:'sm'	// 'sm'  or 'lg'		
		});
		jQuery('#ampaginationsm').on('am.pagination.change',function(e){
		   jQuery('.showlabelsm').text('The selected page no: '+e.page);
           $(location).attr('href', "http://localhost:9000/petcarepedia/review_main.do?page="+e.page);
   		 });
 	});
</script> 
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp"></jsp:include>
		<div id="brbox" class="review">
			<jsp:include page="/best_review_list.do"></jsp:include>
		</div>
		<section id="filter">	
		<div id="filter_page" class="review">
			<p>상세검색</p>
			<form name="ReviewSearchForm" action="review_main_search.do" method="get">
				<table id="filter_lo" class="filter">
					<tr>
						<th rowspan='3'>지역구분</th>
						<td><input type="checkbox" name="filter_location" checked="checked"> 서울전체</td>
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
			</form>
		</div>
		</section>
		<section id="review">
		<div id="review" class="review">
			<div id="title">
				<span>리뷰</span>
				<c:choose>
					<c:when test="${mid == null }">
						<span><a href="login.do">리뷰쓰기 ></a></span>
					</c:when>
					<c:otherwise>
						<span><a href="review_write.do?mid=${mid }">리뷰쓰기 ></a></span>
					</c:otherwise>
				</c:choose>
			</div>
			<ul>
				<c:forEach var="list" items="${list }">
					<li class="review_list">
						<ul>
							<li id="list_left" class="list">
								<p><img src="http://localhost:9000/petcarepedia/images/cat.png">${list.mid }</p>
								<div id="star">
									<div id="avg">
										⭐ ${list.rstar } / 5.0
									</div>
								</div>
							</li>
								<li id="list_middle" class="list">
									<a href="review_content.do?rid=${list.rid }&&page=${page}">
										<div id="review_hname">${list.hname }</div>
										<div>
											${list.rcontent }
										</div>
									</a>
								</li>
							<li id="list_right" class="list">
								<div>
									도움이 되었어요
									<span>
										♥️
									</span>
									${list.rlike }
								</div>
								<table>
									<tr>
										<td>작성일자</td>
										<td>${list.rdate }</td>
									</tr>
								</table>
							</li>
						</ul>
					</li>
				</c:forEach>
				<li><div id="ampaginationsm"></div></li>
			</ul>
		</div>
		</section>
	<!-- </form> -->
	
	<!-- footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>