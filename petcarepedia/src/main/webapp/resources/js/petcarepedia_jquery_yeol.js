$(document).ready(function(){

/*******************************************************************************
		리뷰쓰기 - 글자수 카운팅
******************************************************************************/
	$("#rcontent").on("keyup", function(){
		$('#test_cnt').html("("+$(this).val().length+" / 50)");
		if($(this).val().length > 50) {
			alert("50글자 이하로 작성해주세요");
            $(this).val($(this).val().substring(0, 50));
            $('#test_cnt').html("(50 / 50)");
        }
	})

	

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
		if($("#nickname").val() == "") {
			alert("별명을 입력해주세요");
			$("#nickname").focus();
			return false;
		} else if($("#year").val() == "") {
			alert("생년월일을 입력해주세요");
			$("#year").focus();
			return false;
		} else if($("#month").val() == "") {
			alert("생년월일을 입력해주세요");
			$("#month").focus();
			return false;
		} else if($("#date").val() == "") {
			alert("생년월일을 입력해주세요");
			$("#date").focus();
			return false;
		} else if($("#email").val() == "") {
			alert("이메일을 입력해주세요");
			$("#email").focus();
			return false;
		} else if($("#phone1").val() == "") {
			alert("휴대폰 번호를 선택해주세요");
			$("#phone1").focus();
			return false;
		} else if($("#phone2").val() == "") {
			alert("휴대폰 번호를 선택해주세요");
			$("#phone2").focus();
			return false;
		} else if($("#phone3").val() == "") {
			alert("휴대폰 번호를 선택해주세요");
			$("#phone3").focus();
			return false;
		} else if($("#address").val() == "") {
			alert("변경하실 주소를 입력해주세요");
			$("#address").focus();
			return false;
		} else {
			updateForm.submit();
		}
	
		
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
		let content = $("#rcontent").val().length;
		if(content < 30) {
			alert("30글자 이상을 입력해주세요");
			return false;
		} else {
			writeForm.submit();
		}
	})
/*******************************************************************************
		예약내역페이지 - 리뷰쓰기 취소버튼
******************************************************************************/
	$("#cancle").click(function(){
		location.href = "http://localhost:9000/petcarepedia/reservation2.do?mid=hong";
	})
	

/*******************************************************************************
	내가쓴리뷰 - 리뷰수정
******************************************************************************/
	$("#btnReviewUpdate").click(function(){
	let content = $("#rcontent").val().length;
		if(content < 30) {
			alert("30글자 이상을 입력해주세요");
			return false;
		} else {
			updateForm.submit();
		}
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