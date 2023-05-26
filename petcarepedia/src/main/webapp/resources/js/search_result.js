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
		    $('html, body').animate({
		      scrollTop: $(".link").offset().top
		    }, 500);
		  });
		  $("#review_s").click(function() {
		    $('html, body').animate({
		      scrollTop: $(".review").offset().top
		    }, 500);
		  });






}); //ready