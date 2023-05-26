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