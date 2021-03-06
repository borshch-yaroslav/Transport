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
html, body, #map {
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

    <script src="http://api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>

<script type="text/javascript">
function init () {
    /**
     * Create multiroute.
     */
    var multiRoute = new ymaps.multiRouter.MultiRoute({
        referencePoints: []
    }, {
        // Type of permissible waypoints.
        editorMidPointsType: "via",
        // Allowed wdraing over map objects.
        editorDrawOver: false
        
    });

    multiRoute.editor.start({
    	addReferencePoints: true,
        addWayPoints: true,
        removeWayPoints: true
    });

    // Create map with edit button and center on Lviv.
    var lviv = [49.838889, 24.029230];
    
    var myMap = new ymaps.Map('map', {
        center: lviv,
        zoom: 12,

    });

    // Add multiroute on map.
    myMap.geoObjects.add(multiRoute);
}

ymaps.ready(init);
</script>

</head>
<body>

	<form action="controller" method="post">
		<div id="control_panel"
			style="float: right; width: 30%; text-align: center; padding-top: 12em; font-size: 1.5em">

			<div style="margin: 20px; border-width: 2px" align="left">

				<c:forEach var="i" begin="1" end="10" step="1">
					<input disabled type="text" id="Station ${i}" name="Station ${i}" placeholder="Station ${i}" style="font-size:1em; margin-bottom:0.5em"/> 	
				<!--	Station ${i}:<label id="station ${i}"  style="font-size:1em; margin-bottom:0.5em"></label>
					<br>-->
				</c:forEach>
				
			</div>

			<div id="directions_panel"
				style="margin: 20px; background-color: #FFEE77;"></div>
		</div>

		<div id="formal"
			style="float: bottom; width: 100%; text-align: center; padding-top: 10px; borders: 1px dashed red; background-color: #FFEE77"> 

			<div>
				<div style="display: inline-block; margin: 0em 2em 0em 2em">
					<h2>Number</h2>
					<input id="routeNumber" type="number" name="routeNumber" value="${number}" required max=300/>
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

			<button id="route-confirm-btn"  type="submit"  name="command" value="route.ConfirmRouteCreate" 
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
	<div id="map" style="float: left; width: 70%; height: 100%"></div>
	
</body>
</html>