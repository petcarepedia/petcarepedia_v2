$(document).ready(function(){
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
	$("#review").click(function() {
		 window.location.href = 'http://localhost:9000/petcarepedia/search_main.do';
	});
	
	
/*******************************************
	찜하기
********************************************/
	$("#like").click(function() {
		 window.location.href = 'http://localhost:9000/petcarepedia/search_main.do';
	});
	
	
/*******************************************
	네비게이션
********************************************/
	 $("#info_s").click(function() {
		    $('html, body').animate({
		      scrollTop: $(".api_info").offset().top
		    }, 500);
		  });
		  $("#review_s").click(function() {
		    $('html, body').animate({
		      scrollTop: $(".review").offset().top
		    }, 500);
		  });






}); //ready