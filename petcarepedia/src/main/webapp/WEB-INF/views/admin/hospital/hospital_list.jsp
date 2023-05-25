<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/admin1.css">
	<link rel="stylesheet" href="http://localhost:9000/mycgv_jsp/css/am-pagination.css">
	<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
	<script src="http://localhost:9000/petcarepedia/js/petcarepedia_jquery_serin.js"></script>
	<link href="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" rel="shortcut icon" type="image/x-icon">
	<title>펫캐어피디아 | 관리자</title>
</head>
<body>
<!-- header -->
	<jsp:include page="../admin_header.jsp"></jsp:include>
	
	<div class="d1">
		<section class="hospital">
			<section id = "section1">
				<div>
					<nav>
						<ul>
							<li>병원관리</li>
							<li><a href = "http://localhost:9000/petcarepedia/hospital_list.do">병원 관리</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/admin/member/member_list.do">회원 관리</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/admin/reserve/reserve_list.do">예약 관리</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/admin/review/review_list.do">신고 리뷰 관리</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/admin/admin_notice/admin_notice.do">공지 사항 관리</a></li>
							<li><a href = "http://localhost:9000/petcarepedia/login.do">나가기</a></li>
						</ul>
					</nav>
				</div>
			</section>
		<section id="section2">
			<div class="d2">
				<input type="text"  class="search_bar" id ="search_bar"placeholder="병원명 입력">
				<button type="submit" class="button1" id="search_btn">
					<img src="http://localhost:9000/petcarepedia/images/foot_sky.png">
				</button>
			</div>
				<table class="table">
					<tr>
						<td colspan="5" >
							<button type="button" class="button"><a href="http://localhost:9000/petcarepedia/hospital_detail.do">등록</a></button>
							<button type="button" class="button"><a href="http://localhost:9000/petcarepedia/hospital_update.do">수정</a></button>
							<button type="button" class="button">삭제</button>
						</td>
					</tr>
					<tr>
						<th>번호</th>
						<th>병원명</th>
						<th>기타 동물 여부</th>
						<th>야간 진료 여부</th>
						<th>등록일</th>
					</tr>
					<c:forEach var="hospitalVo" items="${list}">
					<tr>
						<td>${hospitalVo.rno}</td>
						<td><a href="hospital_update.do?hid=${hospitalVo.hid}">${hospitalVo.hname}</a></td>
						<td>${hospitalVo.animal}</td>
						<td>${hospitalVo.ntime}</td>
						<td>${hospitalVo.hid}</td>
					</tr>
					</c:forEach>
					
					<tr>
						<td colspan ="5" class="text">
							<br><br>
						</td>
					</tr>
					<tr>
						<!-- <td colspan="5" class="number"><<  1  2  3  4  5  6  7  8  9  10  >></td> -->
						<td colspan="5" class="number"><div id="ampaginationsm"></div></td> 
					</tr>
				</table>
			</section>
		</section>
	</div>
	<!-- footer -->
		<jsp:include page="../../footer.jsp"></jsp:include>

<script>
$(document).ready(function(){
	
	  $("#search_btn").click(function(){
	  	//alert("병원");
	  	if($("#search_bar").val() ==""){
				alert("병원명을 입력해주세요"); 
				$("#search_bar").focus();
				return false;
			}else{	
					$.ajax({
						url:"http://localhost:9000/petcarepedia/hospital_list_data.do?hname="+$("#search_bar").val(), 
						success:function(result){
							let jdata = JSON.parse(result);				
							let output = "<table class='table'>";
							output += "<tr><td colspan ='5'>";						
							output += "<button type='button' class='button'><a href='http://localhost:9000/petcarepedia/hospital_detail.do'>등록</a></button>";						
							output += "<button type='button' class='button'><a href='http://localhost:9000/petcarepedia/hospital_update.do'>수정</a></button>";						
							output += "<button type='button' class='button'>삭제</button>";						
							output += "</td></tr>";						
							output += "<tr><th>번호</th><th>병원명</th><th>기타 동물 여부</th><th>야간 진료 여부</th><th>등록일</th></tr>";						
							
							for(obj of jdata.jlist){
								output += "<tr>";
								output += "<td>"+ obj.rno +"</td>";
								output += "<td>"+ obj.hname +"</td>";
								output += "<td>"+ obj.animal +"</td>";
								output += "<td>"+ obj.ntime +"</td>";
								output += "<td>"+ obj.hid +"</td>";
								output += "</tr>";						
								}//for
							
							output +="<tr><td colspan='5' class= 'text'><br><br></td></tr>;
							output +="<tr><td colspan='5' class='number'><<  1  2  3  4  5  6  7  8  9  10  >></tr>";
							output +="</tr>";
							output +="</table>";
							
							
							$("table.table").remove(); //같이 출력되는 테이블 삭제 
							$("#d2").after(output);
						}//success
						
					});//ajax
			}//else
	  	});//function
	  
	  
	  
	});//ready
</script>
</body>
</html>