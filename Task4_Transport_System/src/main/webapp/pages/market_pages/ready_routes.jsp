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


<jsp:include page="../patch_pages/ready_routes_map.jsp" />

</head>
<body style="background: #e2edff">

	<div id="control_panel"
		style="float: right; width: 30%; text-align: center; padding-top: 1em; font-size: 1.5em">

		<div style="margin: auto; border-width: 2px" align="center">

			<select name="routing" id="routing" style="font-size: 24px; margin-bottom:1em">

				<option><fmt:message key="ready_routes.select" /></option>

				<c:forEach var="route" items="${routes}">
					<option value="${route.num}" onclick="addRoute();">${route.transportType}
						${route.routeNumber}</option>
				</c:forEach>
			</select>

			<c:forEach var="i" begin="1" end="10" step="1">
				<input disabled type="text" id="station${i}" name="station${i}"
					placeholder="Station ${i}"
					style="font-size: 1em; margin-bottom: 0.5em; width: 15em" />
			</c:forEach>


			<c:forEach var="route" items="${routes}">
				<c:forEach var="i" begin="1" end="${route.lngth}" step="1">
					<input type="hidden" id="coo${i}0_${route.num}"
						value="${route.coordinates[i-1][0]}" />
					<input type="hidden" id="coo${i}1_${route.num}"
						value="${route.coordinates[i-1][1]}" />
					<input type="hidden" id="len_${route.num}" value="${route.lngth}" />
					<input type="hidden" id="stations${i}_${route.num}"
						value="${route.stations[i-1]}" />
				</c:forEach>
			</c:forEach>

		 <label id="wrn"></label>
		</div>

		<div id="button_panel"
			style="margin: 20px; background-color: #FFEE77;">

			<a href="controller?command=MainDispatch" class="button small green"
				style="margin-right: 2em; float: right"><fmt:message key="general.back_to_your"/></a> <a
				href="controller?command=MainPage" class="button small green"
				style="margin-left: 2em; float: left"><fmt:message key="general.back_to_main" /></a>

		</div>

	</div>


	<div id="map" style="float: left; width: 70%; height: 100%"></div>

</body>
</html>