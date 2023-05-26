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
		updateForm.submit();
	})




/*******************************************
		mypage - reservation 예약취소버튼
********************************************/
$("#btnReservationDelete").click(function(){
	deleteForm.submit();
})


/*******************************************************************************
		mypage - 리뷰쓰기 버튼
******************************************************************************/
	$("#btnReviewWrite").click(function(){
		writeForm.submit();
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
	$("#btnReviewUpdate").click(function(){
		updateForm.submit();
	})

/*******************************************************************************
	내가쓴리뷰 - 리뷰삭제
******************************************************************************/
	$("#btnReviewDelete").click(function(){
		deleteForm.submit();
	})



/*******************************************
		mypage - 북마크해제
********************************************/
	$("#btnBookmarkDelete").click(function(){
		deleteForm.submit();
	})

/*******************************************
		mypage - 회원탈퇴
********************************************/
	$("#btnMemberDelete").click(function(){
		deleteForm.submit();
	});







});