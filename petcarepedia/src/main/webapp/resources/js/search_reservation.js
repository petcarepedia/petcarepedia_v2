$(document).ready(function() {
/*******************************************
	date
********************************************/
  moment.locale("ko"); // 한글 로케일 설정

  var currentDate = moment(); // moment.js를 사용하여 현재 날짜 생성
  var startDate = moment(currentDate); // 시작 날짜 설정

  var dateElements = $(".sdate");
  var prevButton = $("#prev");
  var nextButton = $("#next");

  var datesPerPage = 5; // 페이지당 출력되는 날짜 수
  var currentPage = 1; // 현재 페이지 번호
  var totalDates = 30; // 총 날짜 수

  var currentDateIndex = 0; // 현재 표시 중인 날짜 인덱스
  var selectedDate = ""; // 선택된 날짜 저장 변수

  // 초기 날짜 표시
  function generateDates() {
    for (var i = 0; i < dateElements.length; i++) {
      var formattedDate = startDate.format("MM.DD(ddd)");
      var inputElement = dateElements.eq(i).find("input");
      inputElement.val(formattedDate);

      // 날짜 클릭 이벤트 추가
      inputElement.on("click", function() {
        var clickedDate = $(this).val();
        $("#selectedDate").val(clickedDate);

        // 선택된 날짜 스타일 변경
        dateElements.find("input").removeClass("selected-date");
        $(this).addClass("selected-date");
        
        // 선택된 날짜 저장
        selectedDate = clickedDate;
      });

      startDate.add(1, "days");
    }
  }

  // 이전 버튼 클릭 이벤트
  prevButton.on("click", function() {
    if (currentPage > 1) {
      currentPage--;
      dateElements.find("input").removeClass("selected-date");
      updateDisplayedDates();
    }
  });

  // 다음 버튼 클릭 이벤트
  nextButton.on("click", function() {
    var totalPages = Math.ceil(totalDates / datesPerPage);
    var lastPageIndex = totalPages * datesPerPage - datesPerPage; // 마지막 페이지의 첫 번째 인덱스

    if (currentDateIndex < lastPageIndex) {
      currentPage++;
      dateElements.find("input").removeClass("selected-date");
      updateDisplayedDates();
    }
  });

  // 현재 표시되는 날짜 업데이트
  function updateDisplayedDates() {
    currentDateIndex = (currentPage - 1) * datesPerPage; // 현재 표시 중인 날짜의 인덱스 계산
    dateElements.find("input").val(""); // 모든 input 요소 초기화

    var currentDate = moment(); // 현재 날짜

    for (var i = 0; i < datesPerPage; i++) {
      var index = currentDateIndex + i;
      if (index >= 0 && index < totalDates) {
        var formattedDate = moment(currentDate).add(index, "days").format("MM.DD(ddd)");
        var inputElement = dateElements.eq(i).find("input");
        inputElement.val(formattedDate);
        
      // 선택된 날짜인 경우 스타일 변경
        if (formattedDate === selectedDate) {
          inputElement.addClass("selected-date");
        }
      }
    }
  }

  // 초기 날짜 표시
  generateDates();
  
/*******************************************
	time -> 수정 중 // 무한 루프에 빠졌다!!
********************************************/
//SELECT HID, HNAME, SUBSTR(HTIME, 0,5 ) "START",  SUBSTR(HTIME, 7,6 ) "END"
//FROM PCP_HOSPITAL WHERE HID='H_0125'
//ORDER BY HID;



  function generateTimeSlots() {
    const timeContainer = $('.time');
    const selectedTimeInput = $('#selectedTime');
    const startTime = '11:00'; // 첫 시간 (예: '11:00')
    const endTime = '17:00'; // 마지막 시간 (예: '17:00')

    // 시작 시간과 종료 시간을 Date 객체로 변환
    const startDate = new Date(`2000-01-01 ${startTime}`);
    const endDate = new Date(`2000-01-01 ${endTime}`);

    // 30분 간격으로 시간을 생성하여 출력
    let currentTime = startDate;
    while (currentTime <= endDate) {
      const timeSpan = $('<span>').addClass('stime');
      const timeValue = currentTime.toLocaleTimeString('en-US', { hour: '2-digit', minute: '2-digit', hour12: false });
      timeSpan.html(`<input type="hidden" name="time" value="${timeValue}">${timeValue}`);
      timeContainer.append(timeSpan);
      currentTime.setMinutes(currentTime.getMinutes() + 30);
    }

    // 시간 선택 시 해당 시간을 입력란에 출력
    $('.stime').click(function() {
      const selectedTime = $(this).find('input[name="time"]').val();
      selectedTimeInput.val(selectedTime);
    });

    // 날짜 입력란에 오늘 날짜를 기본값으로 설정
    const today = new Date();
    const dateString = today.toLocaleDateString('en-US', { year: 'numeric', month: '2-digit', day: '2-digit' });
    selectedTimeInput.val(dateString);
  }

  // 페이지 로드 시 시간 슬롯 생성
  generateTimeSlots();
  
  

});