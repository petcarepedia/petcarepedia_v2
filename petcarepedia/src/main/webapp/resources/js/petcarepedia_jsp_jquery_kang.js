$(document).ready(function(){

	/*******************************************
		리뷰 - 더보기
	 ********************************************/	
	 /*
	$(function(){
	    $("div#review ul li.review_list").slice(0, 4).show(); // 초기갯수
	    $("#load").click(function(e){ // 클릭시 more
	        e.preventDefault();
	        if($("div#review ul li.review_list:hidden").length == 0){ // 컨텐츠 남아있는지 확인
	        	alert("게시물의 끝입니다."); // 컨텐츠 없을시 alert 창 띄우기 
	        	return false;
	        }
	        $("div#review ul li.review_list:hidden").slice(0, 3).show(); // 클릭시 more 갯수 지저정
	    });
	});	
	*/
	
	
	/*******************************************
		공지사항 - 등록 폼
	 ********************************************/	
	$("#btnNTW").click(function() {
		if($("#title").val() == "") {
			alert("제목을 입력해주세요.");
			$("#title").focus();
			return false;
		}
		if($("#ncontent").val() == "") {
			alert("내용을 입력해주세요.");
			$("#ncontent").focus();
			return false;
		}
		else {
			writeForm.submit();
		}
	});
	
	
	
	
	/*******************************************
		공지사항 - 수정 폼
	 ********************************************/	
	$("#BTN_update").click(function() {
		if($("#title").val() == "") {
			alert("제목을 입력해주세요.");
			$("#title").focus();
			return false;
		}
		else if($("#ncontent").val() == "") {
			alert("내용을 입력해주세요.");
			$("#ncontent").focus();
			return false;
		}
		else {
			updateForm.submit();
		}
	});
	

	/*******************************************
		리뷰 - 신고
	 ********************************************/	
	$("#btnReport").click(function() {
		$.ajax({
			url : "review_report_check.do?rid="+$("#rid").val(),
			success : function(result) {
				if(result == 1) {
					alert("이미 신고된 리뷰 입니다.");
					history.back()
				}
				else if(result == 0){
					alert("신고되었습니다.");
					reportForm.submit();
				}
			}
		});
	});




	/*******************************************
		리뷰 필터 클릭
	********************************************/	
	$('input[name="filter_location"]').click(function(){
		if($(this).prop('checked')){
			$('input[name="filter_location"]').prop('checked',false);
			$(this).prop('checked',true);
		}
	});
	 

	$('input[name="filter_location"]').on('change', function() {
		if ($(this).is(':checked')) { 
			if($(this).val() == "on") {
				location.href='review_main.do'
			}
			else {
				ReviewSearchForm.submit();
			}  
		}
	});
	
	
	if($("#count").val() == 0 ) {
		return false;
	}
	else {
		$('html, body').animate({
			scrollTop: $('#filter_lo').offset().top
		}, 'slow');
	}


	

	
}); //ready





