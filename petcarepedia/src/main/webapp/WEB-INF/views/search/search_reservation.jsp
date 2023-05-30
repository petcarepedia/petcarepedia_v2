<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" rel="shortcut icon" type="image/x-icon">
	<title>펫캐어피디아 | 예약</title>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/search_reservation.css">

<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/locale/ko.min.js"></script>
<script src="http://localhost:9000/petcarepedia/js/search_reservation.js"></script>
<script>
$(".hservation").click(function() {
	 $("#hmodal").css("display", "block");
	 $('input[name="hid"]').val($(this).val());
	 $('input[name="startTime"]').val($("#startTime").val());
	 $('input[name="endTime"]').val($("#endTime").val());
	$('span#rhname').text($(this).attr("id"));
 });
</script>


</head>
<body>
	<div class="reservation">
		<div class="title">
			<span id="rhname">${hospital.hname}</span>
			<span>원하는 날짜/시간 선택</span>
		</div>
		
		<hr>
		
	
		<div class="date">
		  <span><a id="prev">&lt;</a></span>
		  <span class="sdate"><input type="text" name="date" value="" readonly></span>
		  <span class="sdate"><input type="text" name="date" value="" readonly></span>
		  <span class="sdate"><input type="text" name="date" value="" readonly></span>
		  <span class="sdate"><input type="text" name="date" value="" readonly></span>
		  <span class="sdate"><input type="text" name="date" value="" readonly></span>
		  <span><a id="next">&gt;</a></span>
		</div>

		<hr>
	    
	    	<div class="rtime">
		</div>	
	    
	    
	    <!-- 영업시간 db연동 -->
	    <input type="text" id="now" name="now" value="">
	    <input type="text" id="startTime" name="startTime" value="${time.start}">
	    <input type="text" id="endTime" name="endTime" value="${time.end}">

	    <form name="reservationForm" action="reservationProc.do" method="post">
			<input type="hidden" name="hid" value="${hospital.hid}">
			<input type="hidden" name="mid" value="hong">
		    <input type="hidden" id="vdate" name="vdate" value="vdate">
			<input type="hidden" id="vtime" name="vtime" value="vtime">
			<button id="check">확인</button>
		</form>
	</div>
</body>
</html>