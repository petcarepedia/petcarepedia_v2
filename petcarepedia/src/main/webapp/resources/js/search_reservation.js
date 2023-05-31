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
        $("#vdate").val(clickedDate);

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
  
  ///시간 선택
  
  
var today = new Date();
var hours = ('0' + today.getHours()).slice(-2);
var minutes = ('0' + today.getMinutes()).slice(-2);

var years = today.getFullYear().toString().slice(-2);
var months = ('0' + (today.getMonth() + 1)).slice(-2);
var days = ('0' + today.getDate()).slice(-2);

var nowTime = hours + minutes;
var nowDate = months + days;

console.log(nowTime);

$("input#nowdate").val(nowDate);
$("input#now").val(nowTime);

var currentDate2 = currentDate.format("MMDD");
console.log(currentDate2);

/*******************************************
	time 
********************************************/
 // 시작 시간과 끝 시간 가져오기
  var startTime = $("#startTime").val();
  var endTime = $("#endTime").val();

  // 시작 시간과 끝 시간을 Date 객체로 변환
  
var currentDate = new Date(); // 현재 날짜와 시간 가져오기
var currentYear = currentDate.getFullYear();
var currentMonth = currentDate.getMonth() + 1; // 월은 0부터 시작하므로 1을 더해줍니다.
var currentDay = currentDate.getDate();

var startDate = new Date(currentYear + "/" + currentMonth + "/" + currentDay + " " + startTime);
 var endDate = new Date(currentYear + "/" + currentMonth + "/" + currentDay + " " + endTime);

    	
 // 30분 간격으로 시간 슬롯 생성
  var currentTime = startDate;
  var timeSlots = [];

  while (currentTime <= endDate) {
    var formattedTime = currentTime.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });
    var formattedTime2 = currentTime.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit', hour12: false });
    //var timeWithoutColon = formattedTime2.replace(':', '');
    
    
      timeSlots.push(formattedTime);
  
    currentTime.setMinutes(currentTime.getMinutes() + 30);
  }
  
  // 시간 슬롯을 화면에 표시
  var timeContainer = $(".rtime");
  timeContainer.empty(); // 기존 내용 초기화
  
  for (var i = 0; i < timeSlots.length; i++) {
    var timeSlot = timeSlots[i];
  
    var timeElement = $("<span>", { class: "stime" }).append(
      $("<input>", { type: "hidden", name: "stime", value: timeSlot }),
      timeSlot
    );
    
    
    timeContainer.append(timeElement);
  }
  
  
  // 클릭이벤트
$(".rtime").on("click", ".stime", function() {
    // 선택된 시간 슬롯 요소에 스타일을 적용
    $(".stime").removeClass("selected");
    $(this).addClass("selected");
    
    // 선택된 시간 출력
    var selectedTime = $(this).text();
    $("#vtime").val(selectedTime);
  });
  
        //// 첫날 클릭시 클래스 추가
        // 첫 번째 페이지의 첫 번째 날짜 선택 --> 수정할 부분
        var isFirstPage = dateElements.eq(0).find("input");
        
var clickOne = $(".sdate:first");

clickOne.on("click", function() {
  alert("test");
  var clickedInput = $(this).children("input");
  
  $(".stime").each(function() {
    var timeElement = $(this).text(); // timeElement의 값 가져오기
    var timeWithoutColon = timeElement.replace(/[^0-9]/g, ''); // 시간 값을 변환하여 timeWithoutColon에 할당
    
    if (parseInt(nowTime) > parseInt(timeWithoutColon)) {
      //$(this).attr("id", "lastTime"); // id 설정
      $(this).css("background", "#D9D9D9"); 
      $(this).css({ "pointer-events": "none", "cursor": "no-drop" }); // 커서 클릭 금지 효과 추가
    }
  });
});

  
  //  console.log("콘솔: "+timeWithoutColon);


});