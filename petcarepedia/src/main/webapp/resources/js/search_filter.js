$(document).ready(function() {
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

  var checkboxes = document.querySelectorAll('input[type="checkbox"][name="gloc"]');
  checkboxes.forEach(function(checkbox) {
    checkbox.addEventListener('change', applyFilters);
  });
  
  



  




}); //document 