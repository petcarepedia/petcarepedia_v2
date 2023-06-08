$(document).ready(function(){

/*******************************************************************************
		리뷰쓰기 - 글자수 카운팅
******************************************************************************/
	$("#rcontent").on("keyup", function(){
		$('#test_cnt').html("("+$(this).val().length+" / 200)");
		if($(this).val().length > 200) {
			alert("200글자 이하로 작성해주세요");
            $(this).val($(this).val().substring(0, 200));
            $('#test_cnt').html("(200 / 200)");
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
		} else if($("#phone1").val() == "") {
			alert("휴대폰 번호를 선택해주세요");
			$("#phone1").focus();
			return false;
		} else if($("#phone2").val() == "") {
			alert("휴대폰 번호를 입력해주세요");
			$("#phone2").focus();
			return false;
		} else if($("#phone3").val() == "") {
			alert("휴대폰 번호를 입력해주세요");
			$("#phone3").focus();
			return false;
		} else {
			 Swal.fire({
	            icon: 'success',
	            title: '수정 완료',
	            confirmButtonColor:'#98dfff',
	            confirmButtonText:'확인'
	        }).then(function() {
				updateForm.submit();
        	});
		}
	
		
	})




/*******************************************
		mypage - reservation 예약취소버튼
********************************************/
$("#btnReservationDelete").click(function(){
	Swal.fire({
	        title: '정말로 취소하시겠습니까?',
	        icon: 'warning',
	        showCancelButton: true,
	        confirmButtonColor: '#FFB3BD',
	        cancelButtonColor: '#98DFFF',
	        confirmButtonText: '승인',
	        cancelButtonText: '취소'
	    }).then((result) => {
	        if (result.isConfirmed) {
	            Swal.fire(
	                '취소가 완료되었습니다.'
	            ).then(() => {
	                deleteForm.submit();
	            });
	        }
	    });
	
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
			Swal.fire({
	            icon: 'success',
	            title: '작성 완료',
	            confirmButtonColor:'#98dfff',
	  			confirmButtonText:'확인'
	        }).then(function() {
				writeForm.submit();
        	});
		}
	})
/*******************************************************************************
		예약내역페이지 - 리뷰쓰기 취소버튼
******************************************************************************/

	

/*******************************************************************************
	내가쓴리뷰 - 리뷰수정
******************************************************************************/
	$("#btnReviewUpdate").click(function(){
	let content = $("#rcontent").val().length;
		if(content < 30) {
			alert("30글자 이상을 입력해주세요");
			return false;
		} else {
			Swal.fire({
	            icon: 'success',
	            title: '수정 완료',
	            confirmButtonColor:'#98dfff',
	 			 confirmButtonText:'확인'
	        }).then(function() {
				updateForm.submit();
        	});
		}
	})

/*******************************************************************************
	내가쓴리뷰 - 리뷰삭제
******************************************************************************/
	$("#btnReviewDelete").click(function(){
		Swal.fire({
	        title: '정말로 삭제하시겠습니까?',
	        icon: 'warning',
	        showCancelButton: true,
	        confirmButtonColor: '#FFB3BD',
	        cancelButtonColor: '#98DFFF',
	        confirmButtonText: '승인',
	        cancelButtonText: '취소'
	    }).then((result) => {
	        if (result.isConfirmed) {
	            Swal.fire(
	                '삭제가 완료되었습니다.'
	            ).then(() => {
	                deleteForm.submit();
	            });
	        }
	    });
	
	})


/*******************************************
		mypage - 북마크해제
********************************************/


/*******************************************
		mypage - 회원탈퇴
********************************************/
	$("#btnMemberDelete").click(function(){
	if($("#pass").val() == "") {
		alert("비밀번호를 입력해주세요");
		$("#pass").focus();
	} else {
				Swal.fire({
		        title: '정말로 탈퇴하시겠습니까?',
		        icon: 'warning',
		        showCancelButton: true,
		        confirmButtonColor: '#FFB3BD',
	        	cancelButtonColor: '#98DFFF',
		        confirmButtonText: '승인',
		        cancelButtonText: '취소'
		    }).then((result) => {
		        if (result.isConfirmed) {
		            Swal.fire(
		                '탈퇴가 완료되었습니다.'
		            ).then(() => {
		                deleteForm.submit();
		            });
		        }
		    });
	    }
	});







});