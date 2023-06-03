$(document).ready(function(){
	
	var areaArr = new Array();
	areaArr.push(
		{location:'강남구', lat:'37.505960656964', lng:'127.0484988055'},
		{location:'강동구', lat:'37.5492077', lng:'127.1464824'},
		{location:'강북구', lat:'37.634959117129', lng:'127.02502604151'},
		{location:'강서구', lat:'37.551111918342', lng:'126.84930138784'},
		{location:'관악구', lat:'37.471077623795', lng:'126.93920205178'},
		{location:'광진구', lat:'37.545472646114', lng:'127.07054709734'},
		{location:'구로구', lat:'	37.489306326281', lng:'126.88422896601'},
		{location:'금천구', lat:'37.463871812586', lng:'126.90344531019'},
		{location:'노원구', lat:'37.648541766142', lng:'127.06075433614'},
		{location:'도봉구', lat:'37.6658609', lng:'127.0317674'},
		{location:'동대문구', lat:'37.5838012', lng:'127.0507003'},
		{location:'동작구', lat:'37.516291679743', lng:'126.94443586224'},
		{location:'마포구', lat:'37.554518043302', lng:'126.94083563143'},
		{location:'서대문구', lat:'37.577430256146', lng:'126.93285393198'},
		{location:'서초구', lat:'37.4769528', lng:'127.0378103'},
		{location:'성동구', lat:'37.5506753', lng:'127.0409622'},
		{location:'성북구', lat:'37.606991', lng:'127.0232185'},
		{location:'송파구', lat:'37.5177941', lng:'127.1127078'},
		{location:'양천구', lat:'37.529793854473', lng:'126.8357692676'},
		{location:'영등포구', lat:'37.493651061842', lng:'126.90107552315'},
		{location:'용산구', lat:'37.520414423517', lng:'126.99467359691'},
		{location:'은평구', lat:'37.599509831424', lng:'126.91953950927'},
		{location:'종로구', lat:'37.570720803038', lng:'127.01007513209'},
		{location:'중구', lat:'37.566872021939', lng:'127.02338431986'},
		{location:'중랑구', lat:'37.598031', lng:'127.092931'}
	);
	
	$(function() {
		initGlocMap('강남구');
	});
	
	function initGlocMap(gloc) {
		$.ajax({
			url : "main_map_data.do?gloc="+gloc,
			success : function(result){
					let jdata = JSON.parse(result);
					
					let markers = new Array();
					let infoWindows = new Array();
					
					for(var i=0; i<areaArr.length; i++){
						if(gloc==areaArr[i].location){
							var map = new naver.maps.Map('map', {
								center: new naver.maps.LatLng(areaArr[i].lat, areaArr[i].lng),
								zoom: 14
							});
							
							i=areaArr.length;
						}
					}
					
					/*db-병원데이터 연결해서 marker 표시하기*/
					for(obj of jdata.jlist){
						var marker = new naver.maps.Marker({
							map: map,
							title: obj.hname,
							position: new naver.maps.LatLng(obj.x, obj.y)
						});
						
						var contentString = [
					        '<div class="iw_inner" style="padding:10px;">',
					        '   <div style="clear:both;margin-bottom:5px;">',
					        '	<img src="http://localhost:9000/petcarepedia/images/foot_98DFFF.png" width="20px" height="20px">',
					        '	<a href="http://localhost:9000/petcarepedia/search_result.do?hid='+obj.hid,
					        '" style="font-size:18px;text-decoration:none;color:#3d3d3d;font-weight:bold;">'+obj.hname+'</a></div>',
					        '   <p style="font-size:12px;color:darkgray;margin-bottom:5px">Time | '+obj.htime+'<br>Tel | '+obj.tel+'</h3>',
					        '   <p style="font-size:13px;color:#636363">'+obj.loc+'</p>',
					        '</div>'
					    ].join('');
			
						var infowindow = new naver.maps.InfoWindow({
						    content: contentString,
						    maxWidth: 250,
						    backgroundColor: "white",
						    borderColor: "#98dfff",
						    borderWidth: 3,
						    pixelOffset: new naver.maps.Point(0, 10)
						});
						
						markers.push(marker);
						infoWindows.push(infowindow);
					};
					
					function getClickHandler(seq){
						return function(e) {
							var marker = markers[seq],
								infowindow = infoWindows[seq];
							
							if (infowindow.getMap()) {
						        infowindow.close();
						    } else {
						        infowindow.open(map, marker);
						    }
						}
					}
					
					for (var i=0, ii=markers.length; i<ii; i++) {
						naver.maps.Event.addListener(markers[i],'click',getClickHandler(i));
					}
				}
		});
	}
	
	
	
	
	$(document).on("click", ".gloc", function() {
		initGlocMap($(this).val());
	});


}); //ready