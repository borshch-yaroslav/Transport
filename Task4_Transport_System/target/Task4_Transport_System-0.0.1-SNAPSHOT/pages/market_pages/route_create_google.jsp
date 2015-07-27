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
html, body, #map-canvas {
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
		map = new google.maps.Map(document.getElementById('map-canvas'),
				mapOptions);
		directionsDisplay.setMap(map);
		
		var transitLayer = new google.maps.TransitLayer();
		transitLayer.setMap(map);
	}

	function calcRoute() {
		var start = document.getElementById('start').value;
		var end = document.getElementById('end').value;
		
		var waypts = [];
		
		for (var i = 0; i < checkboxArray.length; i++) {
			if (checkboxArray.options[i].selected == true) {
				waypts.push({
					location : checkboxArray[i].value,
					stopover : true
				});
			}
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
	<form action="controller" method="post">
		<div id="control_panel"
			style="float: right; width: 30%; text-align: center; padding-top: 12em; font-size: 1.5em">

			<div style="margin: 20px; border-width: 2px">


				<b>Start:</b> <select style="font-size: 0.8em" id="start"
					name="startStation" onchange="calcRoute();">
					<option></option>
					<c:forEach items="${stations}" var="station">
						<option value="${station.geographicName}">${station.name}</option>
					</c:forEach>
				</select>


				<div>
					<br> <b>Waypoints:</b> <br> <i>(Ctrl-Click for
						multiple selection)</i> <br> <select
						style="font-size: 0.8em; width: 15em; height: 15em" multiple
						id="waypoints" name="waypoints" onchange="calcRoute();">
						<c:forEach items="${stations}" var="station">
							<option value="${station.geographicName}">${station.name}</option>
						</c:forEach>
					</select>
				</div>


				<br> <b>End:</b> <select onchange="calcRoute();"
					style="font-size: 0.8em" id="end" name="endStation">
					<option></option>
					<c:forEach items="${stations}" var="station">
						<option value="${station.geographicName}">${station.name}</option>
					</c:forEach>
				</select> <br>

		<!-- 		<a onclick="calcRoute();" class="button small orange">Show</a>  -->
			</div>

			<div id="directions_panel"
				style="margin: 20px; background-color: #FFEE77;"></div>
		</div>

		<div id="formal"
			style="float: bottom; width: 100%; text-align: center; padding-top: 10px; borders: 1px dashed red; background-color: #FFEE77">

			<div>
				<div style="display: inline-block; margin: 0em 2em 0em 2em">
					<h2>Number</h2>
					<input type="text" name="number" value="${number}" required />
				</div>

				<div style="display: inline-block; margin: 0em 2em 0em 2em">
					<h2>Transport type</h2>
					<select name="transportType">
						<option value="tram">Bus</option>
						<option value="tram">Trolley</option>
						<option value="tram">Tram</option>
					</select>
				</div>
			</div>

			<div>
				<div style="display: inline-block; margin: 0em 2em 0em 2em">
					<h3>Interval</h3>
					<select name="interval">
						<option value="00:10">00:10</option>
						<option value="00:15">00:15</option>
						<option value="00:20">00:20</option>
						<option value="00:25">00:25</option>
						<option value="00:30">00:30</option>
					</select>
				</div>

				<div style="display: inline-block; margin: 0em 2em 2em 2em">
					<h3>Start time</h3>
					<select name="startTime">
						<option value="06:00">06:00</option>
						<option value="06:30">06:30</option>
						<option value="07:00">07:00</option>
						<option value="07:30">07:30</option>
						<option value="08:00">08:00</option>
						<option value="08:30">08:30</option>
						<option value="09:00">09:00</option>
					</select>
				</div>

				<div style="display: inline-block; margin: 1em 2em 2em 2em">
					<h3>End time</h3>
					<select name="endTime">
						<option value="20:00">20:00</option>
						<option value="20:30">20:30</option>
						<option value="21:00">21:00</option>
						<option value="21:30">21:30</option>
						<option value="22:00">22:00</option>
						<option value="22:30">22:30</option>
						<option value="23:00">23:00</option>
						<option value="23:30">23:30</option>
					</select>
				</div>
			</div>

			<button type="submit" name="command" value="route.ConfirmRouteCreate"
				class="button medium blue"
				style="margin: 2em 2em 2m 2em; float: center">Confirm
				creation</button>

			<a href="controller?command=MainDispatch"
				class="button small green" style="margin-right: 2em; float: right">Back
				to Your Page</a>

			<a href="controller?command=MainPage"
				class="button small green" style="margin-left: 2em; float: left">Back
				to Main Page</a>

		</div>
	</form>
	<div id="map-canvas" style="float: left; width: 70%; height: 100%"></div>
</body>
</html>