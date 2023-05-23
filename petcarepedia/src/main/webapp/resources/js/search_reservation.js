$(document).ready(function() {

  var datesPerPage = 5; // 페이지당 출력되는 날짜 수
  var currentPage = 1; // 현재 페이지 번호
  var totalDates = 30; // 총 날짜 수

  generateDates();

  function generateDates() {
    var currentDate = new Date();
    var dateContainer = $("#dateContainer");
    var startIndex = (currentPage - 1) * datesPerPage; // 시작 인덱스
    var endIndex = startIndex + datesPerPage; // 종료 인덱스

    // 종료 인덱스를 총 날짜 수를 넘지 않도록 처리
    if (endIndex > totalDates) {
      endIndex = totalDates;
    }

    dateContainer.empty(); // 기존 날짜 초기화

    for (var i = startIndex; i < endIndex; i++) {
      var nextDate = new Date(currentDate.getFullYear(), currentDate.getMonth(), currentDate.getDate() + i);
      var formattedDate = formatDate(nextDate);
      var spanElement = $("<span></span>")
        .addClass("date-list")
        .attr("data-date", formattedDate)
        .text(formattedDate);
      dateContainer.append(spanElement);
    }

    generatePagination();
    attachDateClickEvent(); 
  }
  
	function attachDateClickEvent() {
  $("span.date-list").off("click").on("click", function() {
    var clickedDate = $(this).attr("data-date");
    alert(clickedDate); // 선택한 날짜 출력 (확인용)
    $("#selectedDate").val(clickedDate);
  });
}
  
  function formatDate(date) {
    var month = date.getMonth() + 1;
    var day = date.getDate();
    return padZero(month) + "." + padZero(day) + "(" + getDayOfWeek(date) + ")";
  }

  function padZero(number) {
    return number < 10 ? "0" + number : number;
  }

  function getDayOfWeek(date) {
    var daysOfWeek = ["일", "월", "화", "수", "목", "금", "토"];
    return daysOfWeek[date.getDay()];
  }

  // 이전 버튼 클릭 이벤트
  $("#previousButton").on("click", function() {
    if (currentPage > 1) {
      currentPage--;
      generateDates();
    }
  });

  // 다음 버튼 클릭 이벤트
  $("#nextButton").on("click", function() {
    var totalPages = Math.ceil(totalDates / datesPerPage);
    if (currentPage < totalPages) {
      currentPage++;
      generateDates();
    }
  });

  function generatePagination() {
    var totalPages = Math.ceil(totalDates / datesPerPage);
    var paginationContainer = $("#paginationContainer");
    paginationContainer.empty();

    if (totalPages > 1) {
      var previousButton = $("<a href='javascript:void(0);'>&lt;</a>");
      previousButton.on("click", function() {
        if (currentPage > 1) {
          currentPage--;
          generateDates();
        }
      });
      // paginationContainer.append(previousButton);

      var nextButton = $("<a href='javascript:void(0);'>&gt;</a>");
      nextButton.on("click", function() {
        if (currentPage < totalPages) {
          currentPage++;
          generateDates();
        }
      });
      // paginationContainer.append(nextButton);
    }
  }

/*******************************************
	날짜 값 받기
********************************************/	
	/*$('span#dateContainer1').click(function() {
    $('span#dateContainer').css("font-weight", "normal");
    $(this).css("font-weight", "bold");
    var clickedDate1 = $(this).attr("data-date");
    $('input[name="date"]').val(clickedDate1);
});*/
	  

/*******************************************
	시간 값 받기
********************************************/	
 $('span#stime').click(function() {
    if ($(this).hasClass('selected')) {
        $(this).removeClass('selected');
        $('input[name="time"]').val("");
    } else {
        $('span#stime').removeClass('selected');
        $('span#stime').css("border", "1px solid #D9D9D9");
        $('span#stime').css("border-left", "10px solid #D9D9D9");
        $('span#stime').css("font-weight", "normal");
        $(this).addClass('selected');
        $(this).css("border", "1px solid #98DFFF");
        $(this).css("border-left", "10px solid #98DFFF");
        $(this).css("font-weight", "bold");

        var time = $(this).find('input[name="time"]').val();
        $('input[name="time"]').val(time);
    }
});


/*******************************************
	시간 넘기기
********************************************/
$("#scheck").click(function() {
    $.get($("#reservation-form").attr("action"), $("#reservation-form").serialize(), function(data) {
        // 서버에서 반환한 응답 처리
    });
});
});

$('span1').click(function() {
    $(this).toggleClass('bold');
  });