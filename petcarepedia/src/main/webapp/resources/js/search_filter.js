$(document).ready(function() {
/////// 진료중 버튼

var today = new Date();
var hours = ('0' + today.getHours()).slice(-2);
var minutes = ('0' + today.getMinutes()).slice(-2);

var nowTime = hours + minutes;


$('ul#dataList li').each(function() {
    var startTime = $(this).find('input#startTime').val().replace(':', '');
    var endTime = $(this).find('input#endTime').val().replace(':', '');

     if (parseInt(nowTime) > parseInt(endTime) || parseInt(nowTime) < parseInt(startTime)) {
        $(this).find('span#htime').hide();
        var dataFilter = $(this).attr('data-filter');
        dataFilter = dataFilter.replace(' time', '');
        $(this).attr('data-filter', dataFilter);
    }
});

//console.log(nowTime);





////////////////////////
	//gloc 하나만 선택
	$('input[type="checkbox"][name="gloc"]').click(function(){
		  if($(this).prop('checked')){
		     $('input[type="checkbox"][name="gloc"]').prop('checked',false);
		     $(this).prop('checked',true);
		    }
	});
	
  	// time 하나만 선택
	$('input[type="checkbox"][name="time"]').click(function(){
		  if($(this).prop('checked')){
		     $('input[type="checkbox"][name="time"]').prop('checked',false);
		     $(this).prop('checked',true);
		    }
	});

  // 검색 필터링 기능
  function applyFilters() {
    var filters = [];
    var checkboxes = document.querySelectorAll('input[type="checkbox"]:checked');

    checkboxes.forEach(function(checkbox) {
      filters.push(checkbox.value);
    });

    var items = document.querySelectorAll('#dataList li');

    items.forEach(function(item) {
      var itemFilters = item.getAttribute('data-filter').split(' ');
	
      if (filters.every(function(filter) {
        return itemFilters.includes(filter);
      })) {
        item.style.display = 'block';
      } else {
        item.style.display = 'none';
      }
    });
  }

  var checkboxes = document.querySelectorAll('input[type="checkbox"]');
  checkboxes.forEach(function(checkbox) {
    checkbox.addEventListener('change', applyFilters);
  });
  
  



  




}); //document 