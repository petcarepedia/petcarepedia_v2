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
	time -> 수정 중
********************************************/
//SELECT HID, HNAME, SUBSTR(HTIME, 0,5 ) "START",  SUBSTR(HTIME, 7,6 ) "END"
//FROM PCP_HOSPITAL WHERE HID='H_0125'
//ORDER BY HID;



  var startTime = "10:00";  // 시작 시간
  var endTime = "18:00";    // 종료 시간
  var interval = 30;        // 간격 (분 단위)

  var currentTime = startTime;
  var timeContainer = $("#timeContainer");

  while (currentTime <= endTime) {
    var timeSlot = $('<span class="stime">' + currentTime + '</span>');
    timeSlot.append('<input type="hidden" name="time" value="' + currentTime + '">');
    timeContainer.append(timeSlot);
    
    var timeParts = currentTime.split(":");
    var hours = parseInt(timeParts[0]);
    var minutes = parseInt(timeParts[1]);

    // Add the interval to the current time
    minutes += interval;
    if (minutes >= 60) {
      minutes = 0;
      hours += 1;
    }
    currentTime = ("0" + hours).slice(-2) + ":" + ("0" + minutes).slice(-2);
  }
  
  
  

});