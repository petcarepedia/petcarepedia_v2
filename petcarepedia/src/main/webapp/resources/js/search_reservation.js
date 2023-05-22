$(document).ready(function() {

/*******************************************
	시간 값 받기
********************************************/	
	  $('span').click(function() {
    var value = $(this).find('input[name="time"]').val();
    alert(value); // 클릭한 시간 값을 알림창으로 표시
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