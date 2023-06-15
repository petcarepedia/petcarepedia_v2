<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/petcarepedia_song.css">
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
</body>
</html>