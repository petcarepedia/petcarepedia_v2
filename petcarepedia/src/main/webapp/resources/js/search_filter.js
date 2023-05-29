$(document).ready(function() {

	$('input[type="checkbox"][name="gloc"]').click(function(){
		  if($(this).prop('checked')){
		     $('input[type="checkbox"][name="gloc"]').prop('checked',false);
		     $(this).prop('checked',true);
		    }
	});

  // JavaScript
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