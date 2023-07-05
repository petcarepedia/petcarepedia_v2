<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" rel="shortcut icon" type="image/x-icon">
<title>펫캐어피디아 | 로그인</title>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/petcarepedia_song.css">
<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/petcarepedia/js/petcarepedia_jquery_song.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script>
	$().ready(function (){
		let login_result = "${login_result}";
		let join_result = "${join_result}";
		let pwupdate_result = "${pwupdate_result}";
		
		if(login_result=="fail"){
			Swal.fire({
	            icon: 'error',                         
	            title: '로그인 실패',         
	            text: '아이디와 비밀번호를 다시 확인해주세요.',  
	            confirmButtonColor:'#98dfff',
	            confirmButtonText:'확인'
	        });
		}
		
		if(join_result=="success"){
			Swal.fire({
	            icon: 'success',                         
	            title: '회원가입 완료',         
	            text: '회원가입이 완료되었습니다. 로그인해주세요.',  
	            confirmButtonColor:'#98dfff',
	            confirmButtonText:'확인'
	        });
		}
		
		if(pwupdate_result=="success"){
			Swal.fire({
	            icon: 'success',                         
	            title: '비밀번호 재설정 완료',         
	            text: '다시 로그인해주세요.',  
	            confirmButtonColor:'#98dfff',
	            confirmButtonText:'확인'
	        });
		}
	});
</script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="content">
		<div class="login-content">
			<div class="content-logo">
				<img src="http://localhost:9000/petcarepedia/images/contentlogo.png" width="300px">
			</div>
			
			<form name="loginForm" action="login_proc.do" method="post">
				<ul>
					<li><input type="text" name="mid" id="id" placeholder="아이디"></li>
					<li><input type="password" name="pass" id="pass" placeholder="비밀번호"></li>
					<li><input type="checkbox" name="rememberId" id="rememberId"><span class="rememberId">아이디 기억하기</span></li>
					<li><button type="submit" id="btnLogin" class="btn-submit" disabled>로그인</button></li>
					<li>
						<a href="http://localhost:9000/petcarepedia/join.do">회원가입</a>
						<a href="http://localhost:9000/petcarepedia/login_idfind.do">아이디 / 비밀번호 찾기</a>
					</li>
				</ul>
			</form>
		</div>
	</div>
	
	<!-- footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>