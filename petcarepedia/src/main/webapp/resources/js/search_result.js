$(document).ready(function(){
/*******************************************
	좋아요 버튼
********************************************/    
  $('.gloc').on('change', function() {
        $('.gloc').not(this).prop('checked', false); // 선택된 체크박스 이외의 체크박스를 해제합니다.
        $('.gloc').parent().removeClass('selected'); // 모든 체크박스의 선택 스타일을 제거합니다.

        if ($(this).is(':checked')) {
          $(this).parent().addClass('selected'); // 선택된 체크박스에 선택 스타일을 적용합니다.
        } else {
          $(this).parent().removeClass('selected'); // 선택이 해제된 체크박스의 선택 스타일을 제거합니다.
        }

        filterResults(); // 필터링 함수 호출
      });

      function filterResults() {
        var selectedOption = $('.gloc:checked').val(); // 선택된 체크박스의 값 가져오기
        // 필터링에 대한 추가 로직 구현
        console.log('Selected Option:', selectedOption);
        // 선택된 옵션을 이용하여 필터링된 결과를 표시하거나 다른 작업을 수행합니다.
      }

------------------------------------------


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
	찜하기
********************************************/

	
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