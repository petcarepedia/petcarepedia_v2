$(document).ready(function(){

/*******************************************
	지역구 체크박스 값 받기
********************************************/
  // 폼이 제출되었을 때의 처리
  $('form[name="search_area"]').submit(function(e) {
    e.preventDefault(); // 폼의 기본 제출 동작을 막습니다.

    var selected = "";
    $('.gloc:checked').each(function() {
      selected = $(this).val();
    });

    // 선택된 체크박스 값을 보여줄 요소 선택
    var showFilter = $('#showFilter');
    showFilter.val(selected); // 선택된 체크박스 값을 보여줄 요소에 설정

    // 폼 제출
    this.submit();
  });
  



	
/*******************************************
	체크박스 하나만 선택
********************************************/

	
	$('input[type="checkbox"][name="time"]').click(function(){
		  if($(this).prop('checked')){
		     $('input[type="checkbox"][name="time"]').prop('checked',false);
		     $(this).prop('checked',true);
		    }
	});
	
	$('input[type="checkbox"][name="animal"]').click(function(){
		  if($(this).prop('checked')){
		     $('input[type="checkbox"][name="animal"]').prop('checked',false);
		     $(this).prop('checked',true);
		    }
	});
	
	
/*******************************************
	체크박스 값 받기
********************************************/	
	 /**/
	 
	 /*  */
	 
	 
	 $('input[type="checkbox"][name="time"]').click(function() {
		    
		    // 변수로 다이렉트로 담을 경우에는 가장 위에 체크한 항목이 들어감
			var time = $("input[name='time']:checked").val();
		    
			alert(time);
		  });
	 
	 $('input[type="checkbox"][name="animal"]').click(function() {
		    
		    // 변수로 다이렉트로 담을 경우에는 가장 위에 체크한 항목이 들어감
			var animal = $("input[name='animal']:checked").val();
		    
			alert(animal);
		  });
	
	
 $('input[type="checkbox"]').click(function() {
    $('form[name="search_area"]').submit();
  });	
	
	
	
	
	
	
	
	
	
/*******************************************
	예약 버튼
********************************************/

	/* $("#hservation").click(function() {
		 $("#hmodal").css("display", "block");
		 
	  });*/
	  
	  
	  
	  
	  // 모달 닫기
	  $(".close").click(function() {
	    $("#hmodal").css("display", "none");
	  });



	
	
	
	









}); //ready