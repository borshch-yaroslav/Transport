<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<fmt:requestEncoding value="utf-8" />
<fmt:setLocale value="EN" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<title>Transport system</title>

<link rel="stylesheet" type="text/css"
	href="pages/user_pages/buttons_css3/buttons.css" />

<style>
html, body, #map-canvas2 {
	height: 100%;
	margin: 0px;
	padding: 0px
}

#panel {
	position: absolute;
	top: 5px;
	left: 50%;
	margin-left: -180px;
	z-index: 5;
	background-color: #fff;
	padding: 5px;
	border: 1px solid #999;
}
</style>

<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAi37csPvhF671p4SIpPN_md10t2ODVP48">
	
</script>

<script type="text/javascript">
	var directionsDisplay;
	var directionsService = new google.maps.DirectionsService();
	var map;

	function initialize() {

		var rendererOptions = {
			draggable : true
		};

		directionsDisplay = new google.maps.DirectionsRenderer(rendererOptions);

		var lviv = new google.maps.LatLng(49.838889, 24.029230);
		var mapOptions = {
			zoom : 12,
			center : lviv
		}
		map = new google.maps.Map(document.getElementById('map-canvas2'),
				mapOptions);
		directionsDisplay.setMap(map);
	}

	function calcRoute() {

		var way = document.getElementById('route').value;

		var start = way[0];
		var end = way[way.length - 1];

		var waypts = [];

		for (var i = 1; i < way.length - 1; i++) {
			waypts.push({
				location : way[i],
				stopover : true
			});
		}

		var request = {
			origin : start,
			destination : end,
			waypoints : waypts,
			optimizeWaypoints : true,
			travelMode : google.maps.TravelMode.DRIVING
		};
		directionsService.route(request, function(response, status) {
			if (status == google.maps.DirectionsStatus.OK) {
				directionsDisplay.setDirections(response);
				var route = response.routes[0];
				var summaryPanel = document.getElementById('directions_panel');
				summaryPanel.innerHTML = '';
				// For each route, display summary information.
				for (var i = 0; i < route.legs.length; i++) {
					var routeSegment = i + 1;
					summaryPanel.innerHTML += '<b>Segment №: ' + routeSegment
							+ '</b><br><strong> -> from </strong>';
					summaryPanel.innerHTML += route.legs[i].start_address
							+ '<br><strong> -> to </strong>';
					summaryPanel.innerHTML += route.legs[i].end_address
							+ '<br>';
					summaryPanel.innerHTML += route.legs[i].distance.text
							+ '<br><br>';
				}
			}
		});
	}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>

</head>
<body>

	<div id="control_panel"
		style="float: right; width: 30%; text-align: center; padding-top: 12em; font-size: 1.5em">
		<form action="controller" method="post">
			<div style="margin: 20px; border-width: 2px">


				<b>Route:</b> <select style="font-size: 0.8em" id="route"
					name="Route" onchange="calcRoute();">
					<option></option>
					<c:forEach items="${routes}" var="route">
						<option value="${route.stations}">${route.transportType}
							№ ${route.routeNumber}</option>
					</c:forEach>
				</select>
			</div>

			<div id="formal"
				style="float: bottom; width: 100%; text-align: center; padding-top: 10px; borders: 1px dashed red; background-color: #FFEE77">

				<a href="controller?command=MainDispatch" class="button small green"
					style="margin-right: 2em; float: right">Back to Your Page</a> <a
					href="controller?command=MainPage" class="button small green"
					style="margin-left: 2em; float: left">Back to Main Page</a>

			</div>
		</form>

		<div id="directions_panel"
			style="margin: 20px; background-color: #FFEE77;"></div>
	</div>

	<div id="map-canvas2" style="float: left; width: 70%; height: 100%"></div>
</body>
</html>