<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="http://localhost:9000/petcarepedia/admin/images/foot_blue.png" rel="shortcut icon" type="images/x-icon">
<title>reservation</title>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/search_reservation.css">

<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/locale/ko.min.js"></script>
<script src="http://localhost:9000/petcarepedia/js/search_reservation.js"></script>
<script>
$(".hservation").click(function() {
	 $("#hmodal").css("display", "block");
	 $('input[name="hid"]').val($(this).val());
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
		
		 <!-- <div class="time">
	        <span id="stime"><input type="hidden" name="time" value="11:00">11:00</span>
	        <span id="stime"><input type="hidden" name="time" value="11:30">11:30</span>
	        <span id="stime"><input type="hidden" name="time" value="12:00">12:00</span>
	        <span id="stime"><input type="hidden" name="time" value="14:00">14:00</span>
	        <span id="stime"><input type="hidden" name="time" value="14:30">14:30</span>
	        <span id="stime"><input type="hidden" name="time" value="15:00">15:00</span>
	        <span id="stime"><input type="hidden" name="time" value="15:30">15:30</span>
	        <span id="stime"><input type="hidden" name="time" value="16:00">16:00</span>
	        <span id="stime"><input type="hidden" name="time" value="16:30">16:30</span>
	        <span id="stime"><input type="hidden" name="time" value="17:00">17:00</span>
	    </div> -->
	    <div id="timeContainer"></div>
		   
	    <form name="reservation" action="#" method="get">
			<input type="text" name="hid" value="${hospital.hid}">
		    <input type="text" id="selectedDate" name="selectedDate" value="date">
			<input type="text" id="selectedTime" name="selectedTime" value="time">
			<button id="check">확인</button>
		</form>
	</div>
</body>
</html>