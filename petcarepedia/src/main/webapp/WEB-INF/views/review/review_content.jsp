<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" rel="shortcut icon" type="image/x-icon">
<title>펫캐어피디아 | 리뷰 상세보기</title>
<link rel="stylesheet" href="http://localhost:9000/petcarepedia/css/kang_style.css">
<script src="http://localhost:9000/petcarepedia/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/petcarepedia/js/petcarepedia_jsp_jquery_kang.js"></script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="content">
		<section class="review_content">
			<div id="title_l">
				<h1 class="title">리뷰상세</h1>
			</div>
			<div class="review_detail">
				<table class="rv_detail_menu">
					<tr>
						<th>병원이름</th>
						<td>
							<a href="search_result.do?hid=${reviewVo.hid }">
								${reviewVo.hname }
							</a>
						</td>
						
					</tr>
					<tr>
						<th>작성자</th>
						<td><img src="http://localhost:9000/petcarepedia/images/cat.png"><p>${reviewVo.nickname }</p></td>
					</tr>
					<tr>
						<th>상세내용</th>
						<td colspan='3'>
							${reviewVo.rcontent }
						</td>
					</tr>
				</table>
				<div class="table_right">
					<div id="right_top">
						<c:choose>
							<c:when test="${reviewVo.mid eq mid || mid eq '' || mid eq null}">
								<button type="button" id="btnLike" disabled>
									<span class="review_like">
										♥️
									</span>
									${reviewVo.rlike }
								</button>
							</c:when>
							<c:otherwise>
								<form name="reviewLikeForm" action="review_like_Proc.do" method="post">
									<input type="hidden" id="rid" name="rid" value="${reviewLikeVo.rid }">
									<input type="hidden" id="mid" name="mid" value="${mid }">
									<input type="hidden" id="page" name="page" value="${page }">
									<input type="hidden" id="filter_location" name="filter_location" value="${filter_location }">
									<button type="submit" id="btnLikeProc">
										<c:choose>
											<c:when test="${likeCheck eq 1 }">
												<span class="review_like">
													♥️
												</span>
											</c:when>
											<c:otherwise>
												<span class="review_like">
													♡
												</span>
											</c:otherwise>
										</c:choose>
										${reviewVo.rlike }
									</button>
								</form>							
							</c:otherwise>
						</c:choose>
					</div>
					<div id="star">
						<div class="score" id="score_l">
							평점
						</div>
						<div id="avg" class="score">
							⭐ ${reviewVo.rstar } / 5.0
						</div>
					</div>
					<table>
						<tr>
							<td>작성일자</td>
							<td>${reviewVo.rdate }</td>
						</tr>
					</table>
				</div>
				<c:choose>
					<c:when test="${reviewVo.mid eq mid }">
					</c:when>
					<c:otherwise>
						<a href="review_report.do?rid=${reviewVo.rid }&&page=${page }&&filter_location=${filter_location}&&mid=${mid}"><button type="button" class="report">신고하기</button></a>
					</c:otherwise>
				</c:choose>
			</div>
			<c:choose>
				<c:when test="${reviewVo.mid eq mid }">
					<div class="rc_button_r">
						<a href="review_revise.do?rid=${reviewVo.rid }"><button type="button" class="button">수정</button></a>
						<a href="review_delete.do?rid=${reviewVo.rid }&&page=${page }&&filter_location=${filter_location}&&mid=${mid}"><button type="button" class="button">삭제</button></a>
						<c:choose>
							<c:when test="${page eq null }">
								<a href="review_main.do?mid=${mid}"><button type="button" class="button">목록</button></a>
							</c:when>
							<c:when test="${filter_location eq null }">
								<a href="review_main.do?page=${page }&&mid=${mid}"><button type="button" class="button">목록</button></a>
							</c:when>
							<c:otherwise>
								<a href="review_main_search.do?page=${page }&&filter_location=${filter_location}&&mid=${mid}"><button type="button" class="button">목록</button></a>
							</c:otherwise>
						</c:choose>
					</div>
				</c:when>
				<c:otherwise>
					<div class="rc_button_r">
						<c:choose>
							<c:when test="${page eq null }">
								<a href="review_main.do?mid=${mid}"><button type="button" class="button">목록</button></a>
							</c:when>
							<c:when test="${filter_location eq null }">
								<a href="review_main.do?page=${page }&&mid=${mid}"><button type="button" class="button">목록</button></a>
							</c:when>
							<c:otherwise>
								<a href="review_main_search.do?page=${page }&&filter_location=${filter_location}&&mid=${mid}"><button type="button" class="button">목록</button></a>
							</c:otherwise>
						</c:choose>
					</div>
				</c:otherwise>
			</c:choose>
		</section>
	</div>
	<!-- footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>