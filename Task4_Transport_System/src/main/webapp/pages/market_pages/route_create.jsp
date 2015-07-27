<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>

<html>
<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="menu" />
<fmt:requestEncoding value="utf-8" />


<head>


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


<jsp:include page="../patch_pages/creation_map.jsp" />
<jsp:include page="../helper/transport_number_ajax.jsp" />
</head>

<body style="background: #e2edff">

	<form action="controller" method="post" name="createForm">
		<div id="control_panel"
			style="float: right; width: 30%; text-align: center; padding-top: 12em; font-size: 1.5em">

			<div style="margin: 20px; border-width: 2px" align="left">

				<c:forEach var="i" begin="1" end="10" step="1">

					<input type="hidden" id="latitude${i}" name="latitude${i}">
					<input type="hidden" id="longtitude${i}" name="longtitude${i}">
					<input type="hidden" id="geographic_name${i}"
						name="geographic_name${i}">

					<input type="text" id="station${i}" name="station${i}"
						placeholder="Station ${i}"
						style="font-size: 1em; margin-bottom: 0.5em; width: 15em" />

				</c:forEach>

				<label id="wrn"></label>
			</div>

			<div id="directions_panel"
				style="margin: 20px; background-color: #FFEE77;"></div>
		</div>

		<div id="formal"
			style="float: bottom; width: 100%; text-align: center; padding-top: 10px; borders: 1px dashed red; background-color: #FFEE77">

			<div>
				<div style="display: inline-block; width:20em">
				
				</div>
				<div style="display: inline-block; margin: 0em 2em 0em 2em">
					<h2>Number</h2>
					<input id="routeNumber" type="number" name="routeNumber"
						value="${number}" required min=1 max=300 onkeyup="sendInfo()" onclick="sendInfo()"/>
				</div>
				 
			
				<div style="display: inline-block; margin: 0em 0em 0em 2em">
					<h2>Transport type</h2>
					<select name="transportType" onchange="sendInfo()">
						<option value="bus">Bus</option>
						<option value="trolley">Trolley</option>
						<option value="tram">Tram</option>
					</select>
				</div>

				<div style="display: inline-block; margin: 0em 2em 0em 2em">
					<h1><em>Create new route!</em></h1>
					<br>
					<span style="color:red" id="amit"> </span> 
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

			<button id="route-confirm-btn" type="submit" name="command"
				value="route.ConfirmRouteCreate" class="button medium blue"
				style="margin: 2em 2em 2m 2em; float: center">Confirm
				creation</button>

			<a href="controller?command=MainDispatch" class="button small green"
				style="margin-right: 2em; float: right"><fmt:message key="general.back_to_your"/></a> <a
				href="controller?command=MainPage" class="button small green"
				style="margin-left: 2em; float: left"><fmt:message key="general.back_to_main" /></a>

		</div>
	</form>
	<div id="map" style="float: left; width: 70%; height: 100%"></div>

</body>
</html>