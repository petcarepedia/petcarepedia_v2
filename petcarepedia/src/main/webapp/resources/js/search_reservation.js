$(document).ready(function() {

/*******************************************
	날짜 값 받기
********************************************/	
	  $('span').click(function() {
    var date = $(this).find('input[name="date"]').val();
    $(this).css("border", "1px solid #98DFFF");
    $(this).css("border-left", "10px solid #98DFFF");
    $(this).css("color-weight", "bold");
    alert(date); // 클릭한 시간 값을 알림창으로 표시
  });

/*******************************************
	시간 값 받기
********************************************/	
	  $('span').click(function() {
    var time = $(this).find('input[name="time"]').val();
    alert(time); // 클릭한 시간 값을 알림창으로 표시
  });

/*******************************************
	시간 넘기기
********************************************/
  $("#scheck").click(function() {
    $.get($("#reservation-form").attr("action"), $("#reservation-form").serialize(), function(data) {
      // 서버에서 반환한 응답 처리
    });
  });
});

$('span').click(function() {
    $(this).toggleClass('bold');
  });