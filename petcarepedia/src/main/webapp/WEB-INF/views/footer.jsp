<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/petcarepedia_song.css">
<script src="https://kit.fontawesome.com/4ed285928f.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.2.1/css/fontawesome.min.css" integrity="sha384-QYIZto+st3yW+o8+5OHfT6S482Zsvz2WfOzpFSXMF9zqeLcFV0/wlZpMtyFcZALm" crossorigin="anonymous">
<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.2.0/kakao.min.js"
  integrity="sha384-x+WG2i7pOR+oWb6O5GV5f1KN2Ko6N7PTGPS7UlasYWNxZMKQA63Cj/B2lbUmUfuC" crossorigin="anonymous"></script>
<script>
  Kakao.init('4351f19b17acd6bce964ba4b243a9a92'); // 사용하려는 앱의 JavaScript 키 입력
</script>
</head>
<body>
	<footer>
		<div class="footer-menu">
			<div class="footer-content">
				<div class="footer-nav">
					<ul>
						<li>
							<a href="https://forest-share-eb9.notion.site/PetCarePedia-1-0-b2139ee71cd042acbfe9b19e878a22fa" target="_blank">펫캐어피디아 소개</a>
						</li>
						<li>
							<a href="http://localhost:9000/petcarepedia/notice.do">이용약관</a>
						</li>
						<li>
							<a href="http://localhost:9000/petcarepedia/notice.do">개인정보취급방침</a>
						</li>
						<li>
							<a href="http://localhost:9000/petcarepedia/notice.do">위치기반서비스 이용약관</a>
						</li>
						<c:if test="${sessionScope.svo.mid == 'admin'}">
							<li>
								<a href="http://localhost:9000/petcarepedia/admin_hospital_list.do"
								style="color:#7AB2CC; font-weight:bold">관리자</a>
							</li>
						</c:if>
					</ul>
				</div>
				
				<div class="footer-contact">
					<ul>
						<li>
							<a href="mailto:petcarepediaofficial@gmail.com">
								<img src="http://localhost:9000/petcarepedia/images/footer_mail.png" width="25px" height="25px">
							</a>
						</li>
						<li>
							<a href="mailto:petcarepediaofficial@gmail.com">
								<img src="http://localhost:9000/petcarepedia/images/footer_chat.png" width="24px" height="24px">
							</a>
						</li>
						<li>
							<a href="https://github.com/petcarepedia/petcarepedia_v2.git" target="_blank">
								<img src="http://localhost:9000/petcarepedia/images/footer_github.png" width="27px" height="25px">
							</a>
						</li>
					</ul>
				</div>
				
				<div class="footer-hr"></div>
				
				<div class="footer-info">
					<p>PetCarePedia Inc.</p>
					<p>
						사업자 : 펫캐어피디아 주식회사 | 대표자: 김연주 | 사업자등록번호 : 561-81-00765<br>
						통신판매업신고 : 제2018-서울관악-0516호<br>
						주소 : 서울 강남구 테헤란로2길 27 1204호<br>
						일반문의 : info@petcarepedia.com<br>
						제휴문의 : doctor@petcarepedia.com<br>
					</p>
					<p>
						Copyright PetCarePedia Inc. All rights reserved<br>
						자사의 사이트에 게시된 모든 컨텐츠등 외 저작권은 펫캐어피디아에게 있습니다.<br>
						자사의 사이트의 무단적인 수집을 엄격히 금합니다.<br>
					</p>
				</div>
			</div>
		</div>
	</footer>
	
	<i class="fa-solid fa-circle-chevron-up fa-xl" id="btn-screenup"></i>
	<div id="chat-channel-button" class="cchat-btn"></div>
	<i class="fa-solid fa-circle-chevron-down fa-xl" id="btn-screendown"></i>

	<script>
	  Kakao.Channel.createChatButton({
	    container: '#chat-channel-button',
	    channelPublicId: '_VxaVAG',
	  });
	</script>
</body>
</html>