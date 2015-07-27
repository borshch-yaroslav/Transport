<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">
<head>

<fmt:requestEncoding value="utf-8" />
<fmt:setLocale value="EN" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<style type="text/css">
body {
	font-family: Arial, Helvetica, Sans-Serif;
	font-size: 0.8em;
}

#report {
	border-collapse: collapse;
}

#report h4 {
	margin: 0px;
	padding: 0px;
}

#report img {
	float: right;
}

#report ul {
	margin: 10px 0 10px 40px;
	padding: 0px;
}

#report th {
	background: #7CB8E2 url(header_bkg.png) repeat-x scroll center left;
	color: #fff;
	padding: 7px 15px;
	text-align: left;
}

#report td {
	background: #C7DDEE none repeat-x scroll center left;
	color: #000;
	padding: 7px 15px;
}

#report tr.odd td {
	background: #fff url(row_bkg.png) repeat-x scroll center left;
	cursor: pointer;
}

#report div.arrow {
	background: transparent url(arrows.png) no-repeat scroll 0px -16px;
	width: 16px;
	height: 16px;
	display: block;
}

#report div.up {
	background-position: 0px 0px;
}
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#report tr:odd").addClass("odd");
		$("#report tr:not(.odd)").hide();
		$("#report tr:first-child").show();

		$("#report tr.odd").click(function() {
			$(this).next("tr").toggle();
			$(this).find(".arrow").toggleClass("up");
		});

	});
</script>
</head>
<body>

	<table id="report">
		<tr>
			<th>Route number</th>
			<th>Transport type</th>
			<th>Number of cars</th>
			<th>Start</th>
			<th>End</th>
			<th>Interval</th>
			<th>Start time</th>
			<th>End time</th>
			<th>Profitability</th>
			<th></th>
		</tr>
		<c:forEach var="route" items="${routes}">
			<tr>
				<td><c:out value="${route.routeNumber}" /></td>
				<td><c:out value="${route.transportType}" /></td>
				<td><c:out value="${route.numberOfCars}" /></td>
				<td><c:out value="${route.terminalStation1}" /></td>
				<td><c:out value="${route.terminalStation2}" /></td>
				<td><c:out value="${route.intervalTime}" /></td>
				<td><c:out value="${route.startTime}" /></td>
				<td><c:out value="${route.endTime}" /></td>
				<td><c:out value="${route.profitability}" /></td>
				<td><div class="arrow"></div></td>
			</tr>
			<tr>
				<td colspan="5">
					<h4>Stations:</h4> <c:forEach var="station"
						items="${route.stations}">
						<c:out value="${station}" />
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
