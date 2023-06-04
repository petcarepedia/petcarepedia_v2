$(document).ready(function(){


/*******************************************
	좋아요 버튼
********************************************/    
var scrollPositions = {}; // 버튼의 위치 정보를 저장할 객체

$('#like').click(function(e) {
    e.preventDefault();

    var button = $(this);
    var rid = button.data('rid');
    var mid = 'hong';

    // 스크롤 위치 저장
    //scrollPositions[rid] = $('html, body').scrollTop();
    scrollPositions[rid] = $(window).scrollTop();
    

    // 좋아요 처리 Ajax 호출
    $.ajax({
        url: 'likeProc.do',
        method: 'POST',
        data: {
            hid: $('input[name="hid"]').val(),
            rid: rid,
            mid: mid
        },
        success: function(response) {
            if (response == "success") {
                // 성공 처리 로직 작성
                // 클라이언트에서 버튼의 카운팅 증가 또는 감소
                var count = parseInt(button.find('.like-count').text());
                count++; // 또는 count--;
                button.find('.like-count').text(count);
                $('html, body').scrollTop(scrollPositions[rid]);
            } else if (response == "fail") {
                // 성공 처리 로직 작성
                // 클라이언트에서 버튼의 카운팅 증가 또는 감소
                var count = parseInt(button.find('.like-count').text());
                count--; // 또는 count--;
                button.find('.like-count').text(count);
                $('html, body').scrollTop(scrollPositions[rid]);
            }
            
            // 페이지 로드 시 스크롤 위치 복원
            $('html, body').scrollTop(scrollPositions[rid]);
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