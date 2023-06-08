$(document).ready(function(){
	var mid = $("input[name='loginId']").val(); // 로그인 확인


	/** 북마크 버튼 **/
	$("#bookmark").click(function(event) { // 북마크
		event.preventDefault(); // 페이지 바로넘어감 방지
		
		var hid = $("input[name='hid']").val();
		
		 if(mid == "") { // 미로그인시
			 Swal.fire({
				 icon: 'warning',
				 title: '로그인 확인',
				 text: '로그인을 먼저 해주세요.',
				 showConfirmButton: true, // 확인 버튼 표시
				 confirmButtonColor:'#98dfff',
				 confirmButtonText: '확인'
			 });
		 } else { // 로그인시
			$.ajax({
				url: "bookmarkProc.do",
				type: "POST",
				data: {
					hid: hid,
					mid: mid
				},
				success: function(bookmark_result) {
					if (bookmark_result === "fail") { // 이미 북마크 함	
						Swal.fire({
							icon: 'error',
							title: '즐겨찾기 해제',
							text: '즐겨찾기에서 해제했습니다.',
							showConfirmButton: true, // 확인 버튼 표시
							confirmButtonColor:'#98dfff',
							confirmButtonText: '확인'
						}).then(function() {
							location.reload(); // 확인 버튼 클릭 시 페이지 새로고침
						});
					} else if (bookmark_result === "success") { // 북마크 처리
						Swal.fire({
							icon: 'success',
							title: '즐겨찾기 추가',
							text: '즐겨찾기에 추가했습니다.',
							showConfirmButton: true, // 확인 버튼 표시
							confirmButtonColor:'#98dfff',
							confirmButtonText: '확인'
						}).then(function() {
							location.reload(); // 확인 버튼 클릭 시 페이지 새로고침
						});
					}
				}
			});
		 }
	});
	
	
	/** 예약  버튼 **/
	$("#reservation").click(function() { // 예약 버튼
		if(mid == "") { // 미로그인시
			 Swal.fire({
				 icon: 'warning',
				 title: '로그인 확인',
				 text: '로그인을 먼저 해주세요.',
				 showConfirmButton: true, // 확인 버튼 표시
				 confirmButtonColor:'#98dfff',
				 confirmButtonText: '확인'
			 });
		 } else { // 로그인시
			 var hid = $(this).val();
			var iframeSrc = "search_reservation.do?hid=" + hid;
			var modal = $("#hmodal");
			var iframe = $("#reservation-iframe");
			iframe.attr("src", iframeSrc);
			modal.css("display", "block");
		}
	});
	
	
	/* 모달 닫기 */
	$(".close").click(function() {
		$("#hmodal").css("display", "none");
	});


	/** 좋아요 버튼 **/
	var scrollPositions = {}; // 버튼의 위치 정보를 저장할 객체
	
	$('.non').click(function(e) {
		e.preventDefault();
		
		var button = $(this);
		var rid = button.data('rid');
		
		// 스크롤 위치 저장
		scrollPositions[rid] = $(window).scrollTop();
		
		 if (button.hasClass('non')) {
			Swal.fire({
				 icon: 'warning',
				 title: '로그인 확인',
				 text: '로그인을 먼저 해주세요.',
				 showConfirmButton: true, // 확인 버튼 표시
				 confirmButtonColor:'#98dfff',
				 confirmButtonText: '확인'
			 });
		}
	});
	
	$('.like').click(function(e) {
		e.preventDefault();
		
		var button = $(this);
		var rid = button.data('rid');
		
		// 스크롤 위치 저장
		scrollPositions[rid] = $(window).scrollTop();
		
		 if (button.hasClass('non')) {
			Swal.fire({
				 icon: 'warning',
				 title: '로그인 확인',
				 text: '로그인을 먼저 해주세요.',
				 showConfirmButton: true, // 확인 버튼 표시
				 confirmButtonColor:'#98dfff',
				 confirmButtonText: '확인'
			 });
		} else {
			
			// 좋아요 처리 Ajax 호출
			if(mid == "") { // 미로그인시
				 Swal.fire({
					 icon: 'warning',
					 title: '로그인 확인',
					 text: '로그인을 먼저 해주세요.',
					 showConfirmButton: true, // 확인 버튼 표시
					 confirmButtonColor:'#98dfff',
					 confirmButtonText: '확인'
				 });
			 } else { // 로그인시
				$.ajax({
					url: 'likeProc.do',
					method: 'POST',
					data: {
						hid: $('input[name="hid"]').val(),
						rid: rid,
						mid: mid
					},
					success: function(response) {
						if (response == "success") { // 좋아요 처리
							var count = parseInt(button.find('.like-count').text());
							count++;
							button.find('.like-count').text(count);
							$('html, body').scrollTop(scrollPositions[rid]);
						} else if (response == "fail") { // 좋아요 있을 때
							var count = parseInt(button.find('.like-count').text());
							count--;
							button.find('.like-count').text(count);
							$('html, body').scrollTop(scrollPositions[rid]);
						}
						
						// 페이지 로드 시 스크롤 위치 복원
						$('html, body').scrollTop(scrollPositions[rid]);
					}
				});
			}
		}
	});
	
	
	/** 신고하기 버튼 **/
	$(".rstate").click(function() { // 신고하기
		var rid = $("input[name='rid']").val();
		var hid = $("input[name='hid']").val();
		
		if(mid == "") { // 미로그인시
			 Swal.fire({
				 icon: 'warning',
				 title: '로그인 확인',
				 text: '로그인을 먼저 해주세요.',
				 showConfirmButton: true, // 확인 버튼 표시
				 confirmButtonColor:'#98dfff',
				 confirmButtonText: '확인'
			 });
		 } else { // 로그인시
			Swal.fire({
				title: '정말로 신고 하시겠습니까?',
				icon: 'warning',
				showCancelButton: true,
				confirmButtonColor: '#FFB3BD',
				cancelButtonColor: '#98DFFF',
				confirmButtonText: '신고',
				cancelButtonText: '취소',
				reverseButtons: true,
			}).then((result) => {
				if (result.isConfirmed) {
					$.ajax({
						url: "rstateProc.do",
						type: "POST",
						data: {	
							rid: rid,
							hid: hid
						},
						success: function(rstate_result) {
							if (rstate_result === "fail") {
								Swal.fire({
									icon: 'error',
									title: '신고 접수된 리뷰입니다',
									text: '관리자 확인중 입니다. 잠시만 기다려 주세요.',
									showConfirmButton: true,
									confirmButtonText: '확인',
									confirmButtonColor:'#98dfff'
								}).then(function() {
									location.reload();
								});
							} else if (rstate_result === "success") {
								Swal.fire({
									icon: 'success',
									title: '신고되었습니다',
									text: '관리자 확인 중입니다.',
									showConfirmButton: true,
									confirmButtonText:'확인',
									confirmButtonColor:'#98dfff'
								}).then(function() {
									location.reload();
								});
							}
						}
					});
				}
			});
		}
	});

	
	/** 네비게이션 **/
	$("#info_s").click(function() {
		var offsetTop = $(".api_info").offset().top - 100;
		$('html, body').animate({
			scrollTop: offsetTop
		}, 500);
	});
	
	$("#review_s").click(function() {
		var offsetTop2 = $(".review").offset().top - 100;
		$('html, body').animate({
			scrollTop: offsetTop2
		}, 500);
	});
	
	
	/** 하트효과**/
	$(function() {
		$('.like').click(function() {
			$(this).toggleClass('active');
			
			if ($(this).hasClass('active')) {
				$(this).find('img').attr({
					'src': 'https://cdn-icons-png.flaticon.com/512/803/803087.png',
					alt: '찜하기 완료'
				});
			} else {
				$(this).find('img').attr({
					'src': 'https://cdn-icons-png.flaticon.com/512/812/812327.png',
					alt: '찜하기'
				});
			}
		});
	});


});