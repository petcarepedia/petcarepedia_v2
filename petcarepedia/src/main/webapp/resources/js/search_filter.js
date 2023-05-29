$(document).ready(function() {
	const hospital = {
	  "gloc": [
	    {
	      "name": "서울 전체",
	      "value": "",
	      "selected": false
	    },
	    {
	      "name": "강남구",
	      "value": "강남구",
	      "selected": false
	    },
	    {
	      "name": "강동구",
	      "value": "강동구",
	      "selected": false
	    },
	    {
	      "name": "강북구",
	      "value": "강북구",
	      "selected": false
	    },
	    {
	      "name": "강서구",
	      "value": "강서구",
	      "selected": false
	    },
	    {
	      "name": "관악구",
	      "value": "관악구",
	      "selected": false
	    },
	    {
	      "name": "광진구",
	      "value": "광진구",
	      "selected": false
	    },
	    {
	      "name": "구로구",
	      "value": "구로구",
	      "selected": false
	    },
	    {
	      "name": "금천구",
	      "value": "금천구",
	      "selected": false
	    },
	    {
	      "name": "노원구",
	      "value": "노원구",
	      "selected": false
	    },
	    {
	      "name": "도봉구",
	      "value": "도봉구",
	      "selected": false
	    },
	    {
	      "name": "동대문구",
	      "value": "동대문구",
	      "selected": false
	    },
	    {
	      "name": "동작구",
	      "value": "동작구",
	      "selected": false
	    },
	    {
	      "name": "마포구",
	      "value": "마포구",
	      "selected": false
	    },
	    {
	      "name": "서대문구",
	      "value": "서대문구",
	      "selected": false
	    },
	    {
	      "name": "서초구",
	      "value": "서초구",
	      "selected": false
	    },
	    {
	      "name": "성동구",
	      "value": "성동구",
	      "selected": false
	    },
	    {
	      "name": "성북구",
	      "value": "성북구",
	      "selected": false
	    },
	    {
	      "name": "송파구",
	      "value": "송파구",
	      "selected": false
	    },
	    {
	      "name": "양천구",
	      "value": "양천구",
	      "selected": false
	    },
	    {
	      "name": "영등포구",
	      "value": "영등포구",
	      "selected": false
	    },
	    {
	      "name": "용산구",
	      "value": "용산구",
	      "selected": false
	    },
	    {
	      "name": "은평구",
	      "value": "은평구",
	      "selected": false
	    },
	    {
	      "name": "종로구",
	      "value": "종로구",
	      "selected": false
	    },
	    {
	      "name": "중구",
	      "value": "중구",
	      "selected": false
	    },
	    {
	      "name": "중랑구",
	      "value": "중랑구",
	      "selected": false
	    }
	  ]
	}, 
	
		{
	  "time": [
	    {
	      "id": "time1",
	      "value": "O",
	      "selected": false
	    },
	    {
	      "id": "time2",
	      "value": "O",
	      "selected": false
	    },
	    {
	      "id": "time3",
	      "value": "O",
	      "selected": false
	    }
	  ]
	}, 
		{
	  "animal": [
	    {
	      "id": "animal",
	      "value": "O",
	      "selected": false
	    }
	  ]
	}
}

function applyFilters() {
    var filters = [];
    var checkboxes = document.querySelectorAll('input[name="gloc"]:checked');

    checkboxes.forEach(function(checkbox) {
      filters.push(checkbox.value);
    });

    var items = document.querySelectorAll('#dataList');

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

  var checkboxes = document.querySelectorAll('input[name="gloc"]');
  checkboxes.forEach(function(checkbox) {
    checkbox.addEventListener('change', applyFilters);
  });




}); //document 