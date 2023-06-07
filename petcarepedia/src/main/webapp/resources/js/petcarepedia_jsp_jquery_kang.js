$(document).ready(function(){


	
	
	/*******************************************
		공지사항 - 등록 폼
	 ********************************************/	
	$("#btnNTW").click(function() {
		if($("#title").val() == "") {
			Swal.fire({
				  title: '타이틀을 입력해주세요',
				  text: '',
				  icon: 'warning',
            }).then(function(){
					$("#title").focus();
				});
		}
		else if($("#ncontent").val() == "") {
			Swal.fire({
				  title: '내용을 입력해주세요',
				  text: '',
				  icon: 'warning',
            }).then(function(){
					$("#ncontent").focus();
				});
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
			Swal.fire({
				  title: '타이틀을 입력해주세요',
				  text: '',
				  icon: 'warning',
            }).then(function(){
					$("#title").focus();
				});
		}
		else if($("#ncontent").val() == "") {
			Swal.fire({
				  title: '내용을 입력해주세요',
				  text: '',
				  icon: 'warning',
            }).then(function(){
					$("#ncontent").focus();
				});
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
						  title: '신고 접수된 리뷰입니다.',
						  text: '관리자 확인중 입니다. 잠시만 기다려주세요',
						  icon: 'info',
						  confirmButtonColor: '#FFB3BD',
	                }).then(function(){
							history.back();
						});
					
				}
				else if(result == 0){
					Swal.fire({
						  title: '신고되었습니다.',
						  text: '관리자 확인 후 처리하겠습니다.',
						  icon: 'success',
						  confirmButtonColor: '#FFB3BD',
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
	


	

	

	
}); //ready





