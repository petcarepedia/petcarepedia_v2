<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/admin1.css">
	<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/am-pagination.css">
	<script src="http://localhost:9000/pecarepedia/js/jquery-3.6.4.min.js"></script>
	<script src="http://localhost:9000/petcarepedia/js/mycgv_jsp_jquery.js"></script>
	<script src="http://localhost:9000/petcarepedia/js/am-pagination.js"></script>
	<link href="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" rel="shortcut icon" type="image/x-icon">
	<script>
	$(document).ready(function(){
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
	           $(location).attr('href', "http://localhost:9000/petcarepedia/admin_notice.do?page="+e.page);         
	    });
		
 	});
</script> 
</head>
<body>

<!-- header -->
	<jsp:include page="../admin_header.jsp"></jsp:include>	
	<div class="d1">
		<section class="member">
			<section id = "section1">
					<div>
						<nav>
							<ul>
								<li>회원관리</li>
								<li><a href = "http://localhost:9000/petcarepedia/hospital_list.do">병원 관리</a></li>
								<li><a href = "http://localhost:9000/petcarepedia/member_list.do">회원 관리</a></li>
								<li><a href = "http://localhost:9000/petcarepedia/reserve_list.do">예약 관리</a></li>
								<li><a href = "http://localhost:9000/petcarepedia/review_list.do">신고 리뷰 관리</a></li>
								<li><a href = "http://localhost:9000/petcarepedia/admin_notice.do">공지 사항 관리</a></li>
								<li><a href = "http://localhost:9000/petcarepedia/login.do">나가기</a></li>
							</ul>
						</nav>
					</div>
				</section>
			<section id="section2">
				<div class="d2" id = "d2">
					<input type="text"  class="search_bar" id ="member_search_bar"placeholder="회원아이디 입력">
					<button type="submit" class="button1" id="member_search_btn">
						<img src="http://localhost:9000/petcarepedia/images/foot_sky.png">
					</button>
				</div>
				<table class="table">
					<tr>
						<td colspan="6">
							<button type="button" class="button"><a href="http://localhost:9000/petcarepedia/member_detail">수정</a></button>
							<button type="button" class="button">삭제</button>
						</td>
					</tr>
					<tr>
						<th>번호</th>
						<th>아이디</th>
						<th>성명</th>
						<th>이메일</th>
						<th>전화번호</th>
						<th>가입일자</th>
					</tr>
					<c:forEach var="memberVo" items="${list}">
					<tr>
						<td>${memberVo.rno}</td>
						<td><a href="member_detail.do?mid=${memberVo.mid}">${memberVo.mid}</a></td>
						<td>${memberVo.name}</td>
						<td>${memberVo.email}</td>
						<td>${memberVo.phone}</td>
						<td>${memberVo.mdate}</td>
					</tr>
					</c:forEach>
					<tr>
						<td colspan="5"><div id="ampaginationsm"></div></td>
					</tr>
				</table>
				
				<button type="button" class="button4"><a href="http://localhost:9000/petcarepedia/hospital_list.do">이전으로</a></button>
			</section>
		</section>
	</div>
	<!-- footer -->
		<jsp:include page="../../footer.jsp"></jsp:include>
	
</body>
</html>