	
$(document).ready(function(){
	
	/*************************
	 * 예약 - 상태 변경
	 **************************/
  	var currentDate = new Date();
	var Year = currentDate.getFullYear();
	var Month = currentDate.getMonth() + 1;
	var Day = currentDate.getDate();
	
	var current = new Date(Year, Month - 1, Day); // Date 객체로 변환
	
	$(".date").each(function() {
	  var currentTd = $(this).text();
	  var dateTd = new Date(currentTd); // Date 객체로 변환
	
	  if (dateTd < current) {
	    $(this).next(".state").text("진료완료");
	  } else {
	    $(this).next(".state").text("예약중");
	  }
	});
 	 
	/*************************
	 * 병원 - 파일 수정
	 **************************/
		$("#file1").change(function(){
			//alert("1111");
			if(window. FileReader) { //window객체 사용 ->  window가 가지고 있는 fileReader을 사용 
				let fname = $(this)[0].files[0].name;
				//alert(fname);
				$("#update_file").text(fname);
			}
		});
	 
	/*************************
	 * 병원 - 수정
	 **************************/
	$("#btn_update").click(function(){
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
	 * 예약 - 회원 아이디 검색창
	 **************************/
  $("#reserve_btn").click(function(){
  	if($("#reserve_bar").val() ==""){
			Swal.fire({
		        icon: 'warning',                         // Alert 타입
		        /* title: 'Alert가 실행되었습니다.',*/       // Alert 제목
		        text: '회원아이디를 입력해주세요',  		// Alert 내용
		        
		        confirmButtonColor:'#7ab2cc',
		  	  	confirmButtonText:'확인'
			});
			$("#reserve_bar").focus();
			return false;
		}else{	
			location.href = "http://localhost:9000/petcarepedia/admin_reserve_list.do?page=1&mid="+$("#reserve_bar").val();
				/*$.ajax({
					url:"http://localhost:9000/petcarepedia/reserve_list_data.do?mid="+$("#reserve_bar").val(), 
					success:function(result){
					let jdata = JSON.parse(result);
					alert(result);
					let output = "<table class='table'>";						
						output += "<tr><th>번호</th><th>병원명</th><th>아이디</th><th>예약일</th><th>상태</th></tr>";						
						for(obj of jdata.jlist){
							output += "<tr>";
							output += "<td>"+ obj.bid +"</td>";
							output += "<td>"+ obj.hname +"</td>";
							output += "<td>"+ obj.mid +"</td>";
							output += "<td>"+ obj.vdate +"</td>";
							output += "<td>"+ obj.bstate +"</td>";
							output += "</tr>";						
							}//for
							
						output +="<tr><td colspan='5'><div id='ampaginationsm'></div></</td></tr>";
						output +="</table>";
						
						$("table.table").remove();
						$("#d2").after(output);
						
					}//success
					
				});//ajax*/
		}//else
					
  	});//function
	/*************************
	 * 회원 - 회원 아이디 검색창
	 **************************/
  $("#member_search_btn").click(function(){
  	if($("#member_search_bar").val() ==""){
			Swal.fire({
		        icon: 'warning',                         // Alert 타입
		        /* title: 'Alert가 실행되었습니다.',*/       // Alert 제목
		        text: '회원아이디를 입력해주세요',  		// Alert 내용
		        
		        confirmButtonColor:'#7ab2cc',
		  	  	confirmButtonText:'확인'
			});
			$("#member_search_bar").focus();
			return false;
		}else{	
			location.href = "http://localhost:9000/petcarepedia/admin_member_list.do?page=1&mid="+$("#member_search_bar").val();
				/*$.ajax({
					url:"http://localhost:9000/petcarepedia/member_list_data.do?mid="+$("#member_search_bar").val(), 
					success:function(result){
					let jdata = JSON.parse(result);
					//alert(result);
					let output = "<table class='table'>";					
						output += "<tr><th>아이디</th><th>성명</th><th>이메일</th><th>전화번호</th><th>가입일자</th></tr>";						
						for(obj of jdata.jlist){
							output += "<tr>";
							output += "<td>"+ obj.mid +"</td>";
							output += "<td>"+ obj.name +"</td>";
							output += "<td>"+ obj.email +"</td>";
							output += "<td>"+ obj.phone +"</td>";
							output += "<td>"+ obj.mdate +"</td>"
							output += "</tr>";						
							}//for
							
						output +="<tr><td colspan='5'><div id='ampaginationsm'></div></tr>";
						output +="</table>";
						
						$("table.table").remove();
						$("#d2").after(output);
						
					}//success
					
				});//ajax*/
		}//else
					
  	});//function
	/*************************
	 * 병원 - 검색창
	 **************************/
  $("#search_btn").click(function(){
		if($("#search_bar").val() ==""){
			Swal.fire({
		        icon: 'warning',                         // Alert 타입
		        /* title: 'Alert가 실행되었습니다.',*/       // Alert 제목
		        text: '병원명을 입력해주세요',  		// Alert 내용
		        
		        confirmButtonColor:'#7ab2cc',
		  	  	confirmButtonText:'확인'
			});
			$("#search_bar").focus();
			return false;
		}else{	
			location.href = "http://localhost:9000/petcarepedia/admin_hospital_list.do?page=1&hname="+$("#search_bar").val();
				/*$.ajax({
					url:"http://localhost:9000/petcarepedia/hospital_list_data.do?hname="+$("#search_bar").val(), 
					success:function(result){
					let jdata = JSON.parse(result);
					//alert(result);
						let output = "<table class='table'>";					
						output += "<tr><th>병원 번호</th><th>병원명</th><th>기타 동물 여부</th><th>야간 진료 여부</th><th>공휴일 진료 여부</th></tr>";						
						for(obj of jdata.jlist){
							output += "<tr>";
							output += "<td>"+ obj.hid +"</td>";
							output += "<td>"+ obj.hname +"</td>";
							output += "<td>"+ obj.animal +"</td>";
							output += "<td>"+ obj.ntime +"</td>";
							output += "<td>"+ obj.holiday +"</td>";
							output += "</tr>";						
							}//for
							
						output +="<tr><td colspan='5'><div id='ampaginationsm'></div></td></tr>";
						output +="</table>";
						
						
						$("table.table").remove();
						$("#d2").after(output);
						
						
					}//success
					
				});//ajax*/
		}//else
  	});//function
  	
  	
});//ready	
