$(document).ready(function() {

/*******************************************
	날짜 값 받기
********************************************/	
	$('span#sdate').click(function() {
	    $('span#sdate').css("font-weight", "normal"); // 모든 span에 대한 스타일 초기화
	    $(this).css("font-weight", "bold"); // 클릭된 span에 스타일 적용
	
	    var date = $(this).find('input[name="date"]').val();
	    alert(date); // 클릭한 날짜 값을 알림창으로 표시
	});
	  

/*******************************************
	시간 값 받기
********************************************/	
  $('span#stime').click(function() {
    if ($(this).hasClass('selected')) {
        $(this).removeClass('selected'); // 클릭된 span에서 'selected' 클래스 제거
        $(this).css("border", "1px solid #D9D9D9"); // 클릭된 span의 border 스타일 제거
        $(this).css("border-left", "10px solid #D9D9D9"); // 클릭된 span의 border 스타일 제거
        $(this).css("font-weight", "normal"); // 클릭된 span의 font-weight 스타일 제거
    } else {
        $('span#stime').removeClass('selected'); // 다른 span에서 'selected' 클래스 제거
        $('span#stime').css("border", "1px solid #D9D9D9"); // 다른 span의 border 스타일 제거
        $('span#stime').css("border-left", "10px solid #D9D9D9"); // 다른 span의 border 스타일 제거
        $('span#stime').css("font-weight", "normal"); // 다른 span의 font-weight 스타일 제거
        $(this).addClass('selected'); // 클릭된 span에 'selected' 클래스 추가
        $(this).css("border", "1px solid #98DFFF"); // 클릭된 span에 border 스타일 적용
        $(this).css("border-left", "10px solid #98DFFF"); // 클릭된 span에 border-left 스타일 적용
        $(this).css("font-weight", "bold"); // 클릭된 span에 font-weight 스타일 적용
    }

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