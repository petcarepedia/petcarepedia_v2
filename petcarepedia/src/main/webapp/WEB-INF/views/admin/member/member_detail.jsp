<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/admin1.css">
	<link rel="stylesheet" href="http://localhost:9000/mycgv_jsp/css/am-pagination.css">
	<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
	<script src="http://localhost:9000/petcarepedia/js/petcarepedia_jquery_serin.js"></script>
	<link href="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" rel="shortcut icon" type="image/x-icon">
	<title>펫캐어피디아 | 관리자</title>
</head>
<body>

<!-- header -->
	<jsp:include page="../admin_header.jsp"></jsp:include>
	<div class="d1">
	  <section class="member_detail">
	    <section id="section1">
	      <div>
	        <nav>
	          <ul>
				<li>회원관리</li>
				<li><a href = "http://localhost:9000/petcarepedia/hospital_list.do">병원 관리</a></li>
				<li><a href = "http://localhost:9000/petcarepedia/member_list.do">회원 관리</a></li>
				<li><a href = "http://localhost:9000/petcarepedia/reserve_list.do">예약 관리</a></li>
				<li><a href = "http://localhost:9000/petcarepedia/review_list.do">신고 리뷰 관리</a></li>
				<li><a href = "http://localhost:9000/petcarepedia/admin_notice.do">공지 사항 관리</a></li>
				<li><a href = "http://localhost:9000/petcarepedia/login.do">나가기</a></li>
			</ul>
	        </nav>
	      </div>
	    </section>
	    <section id="section2">
	      <div>
	     	 <form name="MemberDetailForm" action="member_detail_proc.do" method="post">
		        <ul>
		          <li>
		            <label>아이디</label>
		            <input type="text" name="mid" id="mid" value="${memberVo.mid}" disalble>
		          </li>
		          <li>
		            <label>성명</label>
		            <input type="text" name="name" id="name" value="${memberVo.name}">
		          </li>
		          <li>
		            <label>생년월일</label>
		            <input type="text" name="birth" id="birth" value="${memberVo.birth}">
		          </li>
		          <li>
		            <label>이메일</label>
		            <input type="text" name="email" id="email" value="${memberVo.email}">
		          </li>
		          <li>
		            <label>휴대폰</label>
		            <input type="text" name="phone" id="phone" value="${memberVo.phone}">
		          </li>
		          <li>
		            <label>주소</label>
		            <input type="text" name="addr" id="addr" value="${memberVo.addr}">
		          </li>
		          <li>
		            <label>가입일</label>
		            <input type="text" name="mdate" id="mdate" value="${memberVo.mdate}">
		          </li>
		          <li>
		            <label>휴면 계정 전환</label>
		            <input type="radio" name="human" id="human" value = yes >예
		            <input type="radio" name="human" id="human" value = no >아니오
		          </li>
		        </ul>
		        <div id="d4">
	      		 <button type="button" class="button4" id="btn_member">수정완료</button>	
	       	 	 <button type="button" class="button5"><a href="http://localhost:9000/petcarepedia/member_list.do">이전으로</a></button>
		        </div>
	      	  </form>
	      </div>
	    </section>
	  </section>
	</div>

	<!-- footer -->
	<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>