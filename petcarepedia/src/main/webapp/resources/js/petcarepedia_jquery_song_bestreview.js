$(document).ready(function(){
	let rpage=Number($("#rpage").val());		// initial page
	
	if(rpage==1) $("#btnPrev").hide();
	if(rpage==3) $("#btnNext").hide();
	
	$('#btnPrev').on('click',function(e){
		$("#btnNext").show();
		if(rpage>1){
			rpage -= 1;
			$.ajax({
				url : "best_review_list.do?rpage="+rpage,
				success : function(list){
						$("#brbox").html(list);
					}
			})
		}
                
    });
    
    $('#btnNext').on('click',function(e){
    	$("#btnPrev").show();
		if(rpage<3){
			rpage += 1;
			$.ajax({
				url : "best_review_list.do?rpage="+rpage,
				success : function(list){
						$("#brbox").html(list);
					}
			})
		}
                
    });
    
});