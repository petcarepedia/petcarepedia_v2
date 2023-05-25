	
$(document).ready(function(){
  $("#search_btn").click(function(){
  	//alert("병원");
  	if($("#search_bar").val() ==""){
			alert("병원명을 입력해주세요"); 
			$("#search_bar").focus();
			return false;
		}else{
			$.ajax({
				url:"hospital_list_data.do?hname="+$("#search_bar").val(), 
					success:function(hname){
						//alert(hname);
						if(hname == ""){
							alert("등록되지 않은 병원입니다. 다른 병원명을 입력해주세요");	
						}else{
							location.href ="http://localhost:9000/petcarepedia/hospital_list_detail.do?hname=${hospitalVo.hname}";
						}	
					}
			});
		}
  	});
  
  
  
});//ready
	
