$(document).ready(function(){
	
/*******************************************
	체크박스 하나만 선택
********************************************/
	$('input[type="checkbox"][name="area"]').click(function(){
		  if($(this).prop('checked')){
		     $('input[type="checkbox"][name="area"]').prop('checked',false);
		     $(this).prop('checked',true);
		    }
	});
	
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
	 /*$('input[type="checkbox"][name="area"]').click(function() {
		    		    
		    // 변수로 다이렉트로 담을 경우에는 가장 위에 체크한 항목이 들어감
			var area = $("input[name='area']:checked").val();
		    
			alert(area);
			
			 $.get('/submit', { area: area }, function(response) {
			      alert(response);
			    });
		  });*/
	 
	 $('input[type="checkbox"][name="area"]').on('change', function() {
		  if ($(this).is(':checked')) { // 체크박스가 체크되었을 때
		    var area = $(this).val(); // 체크된 체크박스의 값을 가져옴
		    $.ajax({
		      type: 'get',
		      url: '#',
		      data: { area: area },
		      success: function(response) {
		        alert(area);
		      },
		      error: function() {
		        alert('오류가 발생했습니다.');
		      }
		    });
		  }
		});
	 
	 
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