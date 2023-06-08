$(document).ready(function(){
	
	jQuery.fn.center = function () {
	    this.css("position","absolute");
	    this.css("top", Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) + $(window).scrollTop()) + "px");
	    this.css("left", Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) + $(window).scrollLeft()) + "px");
	    return this;
	}
	
	/**************
	 * 회원가입 - 아이디 중복 체크
	 */
	$("#btnCheckId").click(function(){
		$.ajax({
				url : "id_check.do?mid="+$("#id").val(),
				success : function(result){
					if(result == 1){
						$("#idcheck_msg").text("중복된 아이디입니다.").css("color","red")
						.css("font-size","12px").css("display","block").css("clear","both")
						.css("padding-top","5px")
						.prepend("<img src='http://localhost:9000/petcarepedia/images/info_red.png' width='13px' style='padding-right:5px; vertical-align:middle'>");
						
						$("form[name='joinForm'] #id").val("").focus();
					}else if(result == 0){
						$("#idcheck_msg").text("사용 가능한 아이디입니다.").css("color","#7AB2CC")
						.css("font-size","12px").css("display","block").css("clear","both")
						.css("padding-top","5px")
						.prepend("<img src='http://localhost:9000/petcarepedia/images/check.png' width='13px' style='padding-right:5px; vertical-align:middle'>");
						
						$("form[name='joinForm'] #pass").focus();
					}
				}
			});
	});
	
	/**************
	 * 회원가입 - 유효성 체크
	 */
	let reg_id = /^(?=.*?[a-z])(?=.*?[0-9]).{4,20}$/;
	let reg_pw = /^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$/;
	let reg_phone = /^\d{4}$/;
	let reg_nick = /^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$/;
	
	//아이디 정규식 체크
	$("form[name='joinForm'] #id").keyup(function(){
		if(!reg_id.test($("form[name='joinForm'] #id").val())){
			$("#idcheck_msg").text("4~20자의 영문, 숫자를 포함하여 입력하세요.").css("color","red")
			.css("font-size","12px").css("display","block").css("clear","both")
			.css("padding-top","5px")
			.prepend("<img src='http://localhost:9000/petcarepedia/images/info_red.png' width='13px' style='padding-right:5px; vertical-align:middle'>");
			
			$("#btnCheckId").attr("disabled",true).css("background","#D9D9D9").css("cursor","not-allowed");
		} else {
			$("#idcheck_msg").text("").css("display","none");
			
			$("#btnCheckId").attr("disabled",false).css("background","#98dfff").css("cursor","pointer");
		}
	});
	//비밀번호 정규식 체크
	$("#pass").keyup(function(){
		if(!reg_pw.test($("#pass").val())){
			$("#pwcheck_msg").text("8~16자의 영문, 숫자, 특수문자로 입력하세요.").css("color","red")
			.css("font-size","12px").css("display","block").css("clear","both")
			.css("padding-top","5px")
			.prepend("<img src='http://localhost:9000/petcarepedia/images/info_red.png' width='13px' style='padding-right:5px; vertical-align:middle'>");
		} else {
			$("#pwcheck_msg").text("안전한 비밀번호입니다.").css("color","#7AB2CC")
			.css("font-size","12px").css("display","block").css("clear","both")
			.css("padding-top","5px")
			.prepend("<img src='http://localhost:9000/petcarepedia/images/check.png' width='13px' style='padding-right:5px; vertical-align:middle'>");
		}
	});
	//비밀번호 확인 유효성 체크
	$("#cpass").keyup(function(){
		if($("#cpass").val() == $("#pass").val()){
			$("#cpwcheck_msg").text("비밀번호가 일치합니다.").css("color","#7AB2CC")
			.css("font-size","12px").css("display","block").css("clear","both")
			.css("padding-top","5px")
			.prepend("<img src='http://localhost:9000/petcarepedia/images/check.png' width='13px' style='padding-right:5px; vertical-align:middle'>");
		} else {
			$("#cpwcheck_msg").text("비밀번호가 일치하지 않습니다.").css("color","red")
			.css("font-size","12px").css("display","block").css("clear","both")
			.css("padding-top","5px")
			.prepend("<img src='http://localhost:9000/petcarepedia/images/info_red.png' width='13px' style='padding-right:5px; vertical-align:middle'>");
		}
	});
	//성명 유효성 체크
	$("form[name='joinForm'] #name").blur(function(){
		if($("form[name='joinForm'] #name").val() == ""){
			$("#namecheck_msg").text("성명을 입력하세요.").css("color","red")
			.css("font-size","12px").css("display","block").css("clear","both")
			.css("padding-top","5px")
			.prepend("<img src='http://localhost:9000/petcarepedia/images/info_red.png' width='13px' style='padding-right:5px; vertical-align:middle'>");
		} else {
			$("#namecheck_msg").text("").css("display","none");
		}
	});
	//휴대폰 유효성 체크
	$("form[name='joinForm'] #phone1,form[name='joinForm'] #phone2,form[name='joinForm'] #phone3").blur(function(){
		if($("form[name='joinForm'] #phone1").val() == "default" || !reg_phone.test($("#phone2").val()) || !reg_phone.test($("#phone3").val())){
			$("#phonecheck_msg").text("올바른 휴대폰 번호를 입력하세요.").css("color","red")
			.css("font-size","12px").css("display","block").css("clear","both")
			.css("padding-top","5px")
			.prepend("<img src='http://localhost:9000/petcarepedia/images/info_red.png' width='13px' style='padding-right:5px; vertical-align:middle'>");
		} else {
			$("#phonecheck_msg").text("").css("display","none");
		}
	});
	//별명 유효성 체크
	$("#nickname").keyup(function(){
		if(!reg_nick.test($("#nickname").val())){
			$("#nickcheck_msg").text("특수문자와 초성 및 모음 제외 2~16자로 입력하세요.").css("color","red")
			.css("font-size","12px").css("display","block").css("clear","both")
			.css("padding-top","5px")
			.prepend("<img src='http://localhost:9000/petcarepedia/images/info_red.png' width='13px' style='padding-right:5px; vertical-align:middle'>");
		} else {
			$("#nickcheck_msg").text("").css("display","none");
		}
	});
	
	//약관동의 전체체크
	$("#termAll").click(function(){
		if($("#termAll").is(':checked')){
			$("form[name='joinForm'] input:checkbox").prop('checked',true);
		} else {
			$("form[name='joinForm'] input:checkbox").prop('checked',false);
		}
	});
	$("form[name='joinForm'] input:checkbox,.term-modal").click(function(){
		if($("#term1").is(':checked')&&$("#term2").is(':checked')&&$("#term3").is(':checked')&&$("#term4").is(':checked')){
			$("#termAll").prop('checked',true);
		} else {
			$("#termAll").prop('checked',false);
		}
	});
	
	//약관동의 유효성 체크
	$(".terms,.term-modal").click(function(){
		if($("#term1").is(':checked') && $("#term2").is(':checked')){
			$("#termcheck_msg").text("").css("display","none");
		} else {
			$("#termcheck_msg").text("필수 약관에 모두 동의해주세요.").css("color","red")
			.css("font-size","12px").css("display","block").css("clear","both")
			.css("padding-top","5px")
			.prepend("<img src='http://localhost:9000/petcarepedia/images/info_red.png' width='13px' style='padding-right:5px; vertical-align:middle'>");
		}
	});
	//이용약관 모달
	$(".btnModalOpen").click(function(){
		let val = $(this).attr("id");
		$.ajax({
					url : "join_term_data.do?term="+val,
					success : function(result){
							let name = JSON.parse(result).name;
							let content = JSON.parse(result).content;
							
							$(".title").html("<p id='tname'>"+name+"</p><input type='hidden' id='termNum' value='"+val+"'>");
							$(".title").after("<div class='termcont' id='tcontent'>"+content+"</div>");
							
							$(".term-box").show();
							$(".back").show();
						}
				})
	})
	
	$("#btnModalClose").click(function(){
		$("#tname").remove();
		$("#tcontent").remove();
		$(".term-box").hide();
		$(".back").hide();
	})
	$("#btnModalAgree").click(function(){
		let termNum = $("#termNum").val();
		$("#term"+termNum).prop("checked",true);
		$("#tname").remove();
		$("#tcontent").remove();
		$(".term-box").hide();
		$(".back").hide();
	})
	
	$.joinValidationCheck = function() {
		if($("#idcheck_msg").text() == "사용 가능한 아이디입니다."
			&& $("#pwcheck_msg").text() == "안전한 비밀번호입니다."
			&& $("#cpwcheck_msg").text() == "비밀번호가 일치합니다."
			&& $("form[name='joinForm'] #name").val() != ""
			&& $("form[name='joinForm'] #phone1").val() != "default"
			&& $("form[name='joinForm'] #phone2").val() != ""
			&& $("form[name='joinForm'] #phone3").val() != ""
			&& $("#phonecheck_msg").text() != "올바른 휴대폰 번호를 입력하세요."
			&& $("form[name='joinForm'] #nickname").val() != ""
			&& $("#nickcheck_msg").text() != "특수문자와 초성 및 모음 제외 2~16자로 입력하세요."
			&& $("#term1").is(':checked') && $("#term2").is(':checked')){
			$("#btnJoin").attr("disabled",false);
		} else {
			$("#btnJoin").attr("disabled",true);
		}
	}
	//회원가입 버튼 abled
	$("form[name='joinForm'] input").on({
		blur: function(){$.joinValidationCheck();},
		focus: function(){$.joinValidationCheck();},
		click: function(){$.joinValidationCheck();},
		keyup: function(){$.joinValidationCheck();}
	});
	$(".term-modal").click(function(){
		$.joinValidationCheck();
	});
	
	
	/**************
	 * 비밀번호 재설정 - 유효성 체크
	 */
	$.pwUpdateValidationCheck = function() {
		if($("#pwcheck_msg").text() == "안전한 비밀번호입니다."
			&& $("#cpwcheck_msg").text() == "비밀번호가 일치합니다."){
			$("#btnPwUpdate").attr("disabled",false);
		} else {
			$("#btnPwUpdate").attr("disabled",true);
		}
	}
	//재설정 버튼 abled
	$("form[name='pwUpdateForm'] input").on({
		blur: function(){$.pwUpdateValidationCheck();},
		keyup: function(){$.pwUpdateValidationCheck();}
	});
	
	/**************
	 * 아이디찾기 - 유효성 체크
	 */
	$.idFindValidationCheck = function() {
		if($("#name").val() != "" 
			&& $('#phone1').val() != "default"
			&& $('#phone2').val() != ""
			&& $('#phone3').val() != ""){
			$("#btnIdFind").attr("disabled",false);
		} else {
			$("#btnIdFind").attr("disabled",true);
		}
	}
	//찾기 버튼 abled
	$("form[name='idFindForm'] input").on({
		blur: function(){$.idFindValidationCheck();},
		focus: function(){$.idFindValidationCheck();},
		click: function(){$.idFindValidationCheck();},
		keyup: function(){$.idFindValidationCheck();}
	});
	
	/**************
	 * 비밀번호찾기 - 유효성 체크
	 */
	$.pwFindValidationCheck = function() {
		if($("#id").val() != "" 
			&& $('#name').val() != ""
			&& $('#phone1').val() != "default"
			&& $('#phone2').val() != ""
			&& $('#phone3').val() != ""){
			$("#btnPwFind").attr("disabled",false);
		} else {
			$("#btnPwFind").attr("disabled",true);
		}
	}
	//찾기 버튼 abled
	$("form[name='pwFindForm'] input").on({
		blur: function(){$.pwFindValidationCheck();},
		focus: function(){$.pwFindValidationCheck();},
		click: function(){$.pwFindValidationCheck();},
		keyup: function(){$.pwFindValidationCheck();}
	});
	
	/**************
	 * 로그인 - 유효성 체크
	 */
	$.loginValidationCheck = function() {
		if($("#id").val() != "" 
			&& $('#pass').val() != ""){
			$("#btnLogin").attr("disabled",false);
		} else {
			$("#btnLogin").attr("disabled",true);
		}
	}
	//로그인 버튼 abled
	$("form[name='loginForm'] input").on({
		blur: function(){$.loginValidationCheck();},
		focus: function(){$.loginValidationCheck();},
		click: function(){$.loginValidationCheck();},
		keyup: function(){$.loginValidationCheck();}
	});
	
	/**************
	 * 회원가입 - 다음 주소 찾기 API
	 */
	$("#btnSearchAddr").click(function(){
		new daum.Postcode({
	        oncomplete: function(data) {
	        	$("#addr").val("("+data.zonecode+") "+ data.address);
	        	$("#term1").focus();
	        }
	    }).open();
		
	}); //search address
	
	/**************
	 * 로그인 - 아이디, 비밀번호 찾기
	 */
	$('#btnBackLogin').click(function(){
		location.href = "login.do";
	})
	$('#btnBackJoin').click(function(){
		location.href = "http://localhost:9000/petcarepedia/join.do";
	})
	
	$('#btnMenuIdFind').click(function(){
		location.href = "login_idfind.do";
	})
	$('#btnMenuPwFind').click(function(){
		location.href = "login_pwfind.do";
	})
	
	//검색바 alert
	$("#btnMainSearch-index").click(function(){
		if($("#hname-index").val()==""){
			Swal.fire({
	            icon: 'info',                         
	            title: '검색어 미입력',         
	            text: '찾고싶은 동물병원의 이름을 입력해주세요', 
	            confirmButtonColor:'#98dfff',
	  			confirmButtonText:'확인' 
	        });
		} else {
			indexSearchForm.submit();
		}
	});
	
}); //ready





