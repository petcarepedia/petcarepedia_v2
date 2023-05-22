$(document).ready(function(){
	

/*******************************************************************************
		수정하기  - 주소찾기 : daum API
******************************************************************************/
	$("#btnSearchAddr").click(function(){
		new daum.Postcode({
	        oncomplete: function(data) {
	        	$("#address").val("(" + data.zonecode + ") " + data.address);
	        	$("#address").focus();
	        	//data = {zonecode:"12345", address:"서울시 강남구...,}
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	        }
		}).open();	
	});

/*******************************************************************************
		mypage - 수정하기페이지 버튼
******************************************************************************/
	$("#revise form #section3 #btn_style1").click(function(){
		alert("test");
		updateForm.submit();
	})




/*******************************************
		mypage - 예약내역페이지
********************************************/
	$("#btn1").click(function(){
		location.href = "http://localhost:9000/petcarepedia/reservation.do";
	});
	$("#btn2").click(function(){
		location.href = "http://localhost:9000/petcarepedia/reservation2.do";
	});
	$("#btn3").click(function(){
		location.href = "http://localhost:9000/petcarepedia/reservation.do";
	});
	$("#btn4").click(function(){
		location.href = "http://localhost:9000/petcarepedia/reservation2.do";
	});
	

	$("#btn_write_review").click(function(){
		location.href = "http://localhost:9000/petcarepedia/review_write.do";
	})


/*******************************************************************************
		예약내역페이지 - 리뷰쓰기
******************************************************************************/
	$("#cancle").click(function(){
		location.href = "http://localhost:9000/petcarepedia/reservation2.do";
	})
	

/*******************************************************************************
	내가쓴리뷰 - 리뷰수정
******************************************************************************/
	$("#btnReview_revise").click(function(){
		location.href = "http://localhost:9000/petcarepedia/review_revise.do";
	})


/*******************************************
		mypage - 북마크해제
********************************************/
	$("#bookmark1").click(function(){
		var result = confirm('즐겨찾기를 해제하시겠습니까?');
		if(result) {
			$("#bookmark #section2").hide();
		}
	});
	$("#bookmark2").click(function(){
		var result = confirm('즐겨찾기를 해제하시겠습니까?');
		if(result) {
			$("#bookmark #section2").hide();
		}
	});










});