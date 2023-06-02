$(document).ready(function(){

	/** 찜하기 버튼 **/
//    $("#bookmark").click(function () {
//		bookmarkForm.submit();
//    });



	/** 신고하기 버튼 **/
	$(".rstate").click(function () {
		Swal.fire({
		   title: '정말로 신고 하시겠습니까?',
		   text: '',
		   icon: 'warning',
		   
		   showCancelButton: true, // cancel버튼 보이기. 기본은 원래 없음
//		   confirmButtonColor: '#3085d6', // confrim 버튼 색깔 지정
		   confirmButtonColor: '#FFB3BD', // confrim 버튼 색깔 지정
//		   cancelButtonColor: '#d33', // cancel 버튼 색깔 지정
		   cancelButtonColor: '#98DFFF', // cancel 버튼 색깔 지정
		   confirmButtonText: '신고', // confirm 버튼 텍스트 지정
		   cancelButtonText: '취소', // cancel 버튼 텍스트 지정
		   
		   reverseButtons: true, // 버튼 순서 거꾸로
		   
		}).then(result => {
		   // 만약 Promise리턴을 받으면,
		   if (result.isConfirmed) { // 만약 모달창에서 confirm 버튼을 눌렀다면
		      Swal.fire('신고 되었습니다.', '관리자 확인 중입니다.', 'success');
		      rstateForm.submit();
		   }
		});
	});









    



/*******************************************
	좋아요 버튼
********************************************/    
  var scrollPositions = {}; // 버튼의 위치 정보를 저장할 객체

  $('.like').click(function(e) {
    e.preventDefault();

    var button = $(this);
    var rid = button.data('rid');

    // 스크롤 위치 저장
    scrollPositions[rid] = $(window).scrollTop();

    // 좋아요 처리 Ajax 호출
    $.ajax({
      url: 'likeProc.do',
      method: 'GET',
      data: {
        hid: $('input[name="hid"]').val(),
        rid: rid
      },
      success: function(result) {
        // 성공 처리 로직 작성
        // 클라이언트에서 버튼의 카운팅 증가
        var count = parseInt(button.find('.like-count').text());
        count++; // 카운트 증가
        button.find('.like-count').text(count);

        // 페이지 로드 시 스크롤 위치 복원
        $(window).scrollTop(scrollPositions[rid]);
      },
      error: function() {
        alert('오류가 발생했습니다.');
      }
    });
  });

/*******************************************
	예약 버튼
********************************************/

	
$("#reservation").click(function() {
  var hid = $(this).val();
  var iframeSrc = "search_reservation.do?hid=" + hid;
  
 

  var modal = $("#hmodal");
  var iframe = $("#reservation-iframe");

  iframe.attr("src", iframeSrc);
  modal.css("display", "block");
  
});
		  
		  // 모달 닫기
		  $(".close").click(function() {
		    $("#hmodal").css("display", "none");
		  });
	
/*******************************************
	리뷰작성
********************************************/
 $("#like").click(function() {
 	likeForm.submit();
 
 });
	

	
/*******************************************
	네비게이션
********************************************/
	 $("#info_s").click(function() {
	 	var offsetTop = $(".api_info").offset().top - 100;
		    $('html, body').animate({
		      scrollTop: offsetTop
		    }, 500);
		  });
		  
		  $("#review_s").click(function() {
		  var offsetTop2 = $(".review").offset().top - 100;
		    $('html, body').animate({
		      scrollTop: offsetTop2
		    }, 500);
		  });






}); //ready