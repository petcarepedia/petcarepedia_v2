<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" rel="shortcut icon" type="image/x-icon">
<title>우리 동네 동물병원 리뷰 사전, 펫캐어피디아</title>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/petcarepedia_song.css">
<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/petcarepedia/js/petcarepedia_jquery_song.js"></script>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=krftgsruiz"></script>
<script>
	$(document).ready(function(){
		let page=Number($("#page").val());		// initial page
		
		if(page==1) $("#btnPrev").hide();
		if(page==3) $("#btnNext").hide();
		
		jQuery('#btnPrev').on('click',function(e){
			$("#btnNext").show();
			if(page>1){
				page -= 1;
				$.ajax({
					url : "best_review_list.do?page="+page,
					success : function(list){
							$("#brbox").html(list);
						}
				})
			}
                    
	    });
	    
	    jQuery('#btnNext').on('click',function(e){
	    	$("#btnPrev").show();
			if(page<3){
				page += 1;
				$.ajax({
					url : "best_review_list.do?page="+page,
					success : function(list){
							$("#brbox").html(list);
						}
				})
			}
                    
	    });
	});
</script>
</head>
<body>
	<div class="main-review">
		<div class="sub">
			<p>신뢰도 검증! <span>사용자 추천 리뷰</span></p>
			<a href="http://localhost:9000/petcarepedia/review_main.do">더 많은 리뷰 보러가기 ></a>
		</div>
		<div class="slide">
			<div class="btnPrev">
				<button type="button" id="btnPrev"><img src="http://localhost:9000/petcarepedia/images/prev.png" width="30" height="30"></button>
			</div>
			<div class="review-list">
				<input type="hidden" value="${page}" id="page">
				<c:forEach var="reviewVo" items="${list}">
					<div id="brcontent" href="http://localhost:9000/petcarepedia/review_main.do" class="review-card">
							<div>
								<a>${reviewVo.hname}</a>
								<p>⭐ ${reviewVo.rstar}.0</p>
							</div>
							<div>
								<div>${reviewVo.gloc}</div>
								<!-- <div>강아지</div> -->
							</div>
							<div>
								${reviewVo.rcontent}
							</div>
							<div>
								<p>❤️ ${reviewVo.rlike}</p>
								<p>${reviewVo.rdate}</p>
							</div>
						
					</div>
				</c:forEach>
			</div>
			<div class="btnNext">
				<button type="button" id="btnNext"><img src="http://localhost:9000/petcarepedia/images/next.png" width="30" height="30"></button>
			</div>
		</div>
	</div>
</body>
</html>
