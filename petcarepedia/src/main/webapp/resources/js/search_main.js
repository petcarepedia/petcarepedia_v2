$(document).ready(function(){

/*******************************************
	지역구 체크박스 값 받기
********************************************/
	$('input[type="checkbox"][name="gloc"]').click(function(){
		  if($(this).prop('checked')){
		     $('input[type="checkbox"][name="gloc"]').prop('checked',false);
		     
		     $(this).prop('checked',true);
		    }
	}); // 지역구
	
	
	$('input[type="checkbox"][name="gloc"]').click(function() {
		    		    
		    // 변수로 다이렉트로 담을 경우에는 가장 위에 체크한 항목이 들어감
			var gloc = $("input[name='gloc']:checked").val();
		    
			// alert(gloc);
			
			 $.get('/submit', { gloc: gloc }, function(response) {
			      alert(response);
			    });
		  });
		  
		  
  $('input[type="checkbox"][name="gloc"]').on('change', function() {
  if ($(this).is(':checked')) { // 체크박스가 체크되었을 때
    var gloc = $(this).val(); // 체크된 체크박스의 값을 가져옴
    $.ajax({
      type: 'get',
      url: 'searchAreaProc.do',
      data: { gloc: gloc },
      success: function(response) {
        alert(gloc);
        
        // 선택한 값을 체크박스에 표시
        var selectedGloc = response; // 선택된 지역구 값

        $('input[type="checkbox"][name="gloc"]').each(function() {
          if ($(this).val() === selectedGloc) {
            $(this).prop('checked', true);
          } else {
            $(this).prop('checked', false);
          }
        });
      },
      error: function() {
        alert('오류가 발생했습니다.');
      }
    });
  }
  
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