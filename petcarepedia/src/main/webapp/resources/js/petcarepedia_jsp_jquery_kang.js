$(document).ready(function(){


	
	
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
					Swal.fire({
						  title: '이미 신고된 리뷰입니다.',
						  text: '',
						  icon: 'info',
	                }).then(function(){
							history.back();
						});
					
				}
				else if(result == 0){
					Swal.fire({
						  title: '신고되었습니다.',
						  text: '',
						  icon: 'success',
	                }).then(function(){
							reportForm.submit();
						});
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





