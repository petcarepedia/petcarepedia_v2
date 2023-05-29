	
$(document).ready(function(){

	/*************************
	 * 병원 - 수정
	 **************************/
	$("#btn_save").click(function(){
			if($("#hname").val()==""){
				alert("병원명을 입력해주세요");
				$("#hname").focus();
				return false;
			}else if($("#gloc").val()==""){
				alert("주소를 입력해주세요");
				$("#gloc").focus();
				return false;
			}else if($("#loc").val()==""){
				alert("주소를 입력해주세요");
				$("#loc").focus();
				return false;
			}else if($("#tel").val()==""){
				alert("전화번호를 입력해주세요");
				$("#tel").focus();
				return false;
			}else if($("#htime").val()==""){
				alert("영업시간을 입력해주세요");
				$("#htime").focus();
				return false;
			}else if($("#animal").val()==""){
				alert("특수동물 진료 여부을 입력해주세요");
				$("#animal").focus();
				return false;
			}else if($("#ntime").val()==""){
				alert("야간 진료 여부을 입력해주세요");
				$("#ntime").focus();
				return false;
			}else if($("#holiday").val()==""){
				alert("공휴일 진료 여부을 입력해주세요");
				$("#holiday").focus();
				return false;
			}else{
				updateForm.submit();
			}
		});
	
	
	/*************************
	 * 병원 - 등록 
	 **************************/	
	$("#btn_save").click(function(){
			if($("#hname").val()==""){
				alert("병원명을 입력해주세요");
				$("#hname").focus();
				return false;
			}else if($("#gloc").val()==""){
				alert("주소를 입력해주세요");
				$("#gloc").focus();
				return false;
			}else if($("#loc").val()==""){
				alert("주소를 입력해주세요");
				$("#loc").focus();
				return false;
			}else if($("#tel").val()==""){
				alert("전화번호를 입력해주세요");
				$("#tel").focus();
				return false;
			}else if($("#htime").val()==""){
				alert("영업시간을 입력해주세요");
				$("#htime").focus();
				return false;
			}else if($("#animal").val()==""){
				alert("특수동물 진료 여부을 입력해주세요");
				$("#animal").focus();
				return false;
			}else if($("#ntime").val()==""){
				alert("야간 진료 여부을 입력해주세요");
				$("#ntime").focus();
				return false;
			}else if($("#holiday").val()==""){
				alert("공휴일 진료 여부을 입력해주세요");
				$("#holiday").focus();
				return false;
			}else{
				writeForm.submit();
			}
		});
	
	/*************************
	 * 회원 - 회원 아이디 검색창
	 **************************/
  $("#search_btn").click(function(){
  	if($("#search_bar").val() ==""){
			alert("회원명을 입력해주세요"); 
			$("#search_bar").focus();
			return false;
		}else{	
				$.ajax({
					url:"http://localhost:9000/petcarepedia/member_list_data.do?mid="+$("#search_bar").val(), 
					success:function(result){
					let jdata = JSON.parse(result);
					//alert(result);
						let output = "<table class='table'>";
						output += "<tr><td colspan ='6'>";						
						output += "<button type='button' class='button5'><a href='http://localhost:9000/petcarepedia/member_detail'>수정</a></button>";						
						output += "<button type='button' class='button'>삭제</button>";						
						output += "</td></tr>";						
						output += "<tr><th>번호</th><th>아이디</th><th>성명</th><th>이메일</th><th>전화번호</th><th>가입일자</th></tr>";						
						for(obj of jdata.jlist){
							output += "<tr>";
							output += "<td>"+ obj.rno +"</td>";
							output += "<td>"+ obj.mid +"</td>";
							output += "<td>"+ obj.name +"</td>";
							output += "<td>"+ obj.email +"</td>";
							output += "<td>"+ obj.phone +"</td>";
							output += "<td>"+ obj.mdate +"</td>";
							output += "</tr>";						
							}//for
							
						output +="<tr><td colspan='6' class= 'text'><br><br></td></tr>";
						output +="<tr><td colspan='6' class='number'>  1  2  3  4  5  6  7  8  9  10  </td></tr>";
						output +="<tr><td colspan='6'> <button type='button' class='button4'>";
						output += "<a href='http://localhost:9000/petcarepedia/hospital_list.do'>이전으로</a></button></td></tr>";
						output +="</table>";
						
						$("table.table").remove();
						$("#d2").after(output);
						
					}//success
					
				});//ajax
		}//else
  	});//function
	/*************************
	 * 병원 - 검색창
	 **************************/
  $("#search_btn").click(function(){
  	if($("#search_bar").val() ==""){
			alert("병원명을 입력해주세요"); 
			$("#search_bar").focus();
			return false;
		}else{	
				$.ajax({
					url:"http://localhost:9000/petcarepedia/hospital_list_data.do?hname="+$("#search_bar").val(), 
					success:function(result){
					let jdata = JSON.parse(result);
					//alert(result);
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
							
						output +="<tr><td colspan='5' class= 'text'><br><br></td></tr>";
						output +="<tr><td colspan='5' class='number'>  1  2  3  4  5  6  7  8  9  10  </td></tr>";
						output +="</table>";
						
						
						$("table.table").remove();
						$("#d2").after(output);
						
						
					}//success
					
				});//ajax
		}//else
  	});//function
  	
  	
});//ready	
