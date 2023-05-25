	
/*$(document).ready(function(){
	
  $("#search_btn").click(function(){
  	//alert("병원");
  	if($("#search_bar").val() ==""){
			alert("병원명을 입력해주세요"); 
			$("#search_bar").focus();
			return false;
		}else{	
				$.ajax({
					url:"http://localhost:9000/petcarepedia/hospital_list_data.do?hname="+$("#search_bar").val(), 
					success:function(result){
						let jdata = JSON.parse(result);				
						let output = "<table class='table'>";
						output += "<tr><td colspan ='5'>";						
						output += "<button type='button' class='button'><a href='http://localhost:9000/petcarepedia/hospital_detail.do'>등록</a></button>";						
						output += "<button type='button' class='button'><a href='http://localhost:9000/petcarepedia/hospital_update.do'>수정</a></button>";						
						output += "<button type='button' class='button'>삭제</button>";						
						output += "</td></tr>";						
						output += "<tr><th>번호</th><th>병원명</th><th>기타 동물 여부</th><th>야간 진료 여부</th><th>등록일</th></tr>";						
						for(obj of jdata.jlist){
							output += "<tr>";
							output += "<td>"+ obj.rno +"</td>";
							output += "<td>"+ obj.hname +"</td>";
							output += "<td>"+ obj.animal +"</td>";
							output += "<td>"+ obj.ntime +"</td>";
							output += "<td>"+ obj.hid +"</td>";
							output += "</tr>";						
							}//for
							
						output +="<tr><td colspan='5' class= 'text'><br><br></td></tr>;
						output +="<tr><td colspan='5' class='number'><<  1  2  3  4  5  6  7  8  9  10  >></tr>";
						output +="</tr>";
						output +="</table>";
						
						
						$("table.table").remove(); //같이 출력되는 테이블 삭제 
						$("#d2").after(output);
						
					}//success
					
				});//ajax
		}//else
  	});//function
  
  
  
});//ready*/
	
