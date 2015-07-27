<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="menu" />
<fmt:requestEncoding value="utf-8" />


<!DOCTYPE html>

<html lang="en">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" type="text/css"
	href="pages/user_pages/buttons_css3/buttons.css" />

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

	<table id="report" style="margin:auto">
		<tr>
			<th><fmt:message key="table_of_routes.col1" /></th>
			<th><fmt:message key="table_of_routes.col2" /></th>
			<%if(request.getSession().getAttribute("role").equals("commander")){ %>
				<th style="font-size:1.2em"><fmt:message key="table_of_routes.col3" /></th>
			<% ;} %>
			<th><fmt:message key="table_of_routes.col4" /></th>
			<th><fmt:message key="table_of_routes.col5" /></th>
			<th><fmt:message key="table_of_routes.col6" /></th>
			<th><fmt:message key="table_of_routes.col7" /></th>
			<th><fmt:message key="table_of_routes.col8" /></th>
			<%if(request.getSession().getAttribute("role").equals("commander")){ %>
				<th style="font-size:1.2em"><fmt:message key="table_of_routes.col9" /></th>
			<% ;} %>
			<th></th>
		</tr>
		<c:forEach var="route" items="${routes}">
			<tr >
				<td style="font-size:1em"><c:out value="${route.routeNumber}" /></td>
				<td style="font-size:1em"><c:out value="${route.transportType}" /></td>
				<%if(request.getSession().getAttribute("role").equals("commander")){ %>
					<td style="font-size:1em"><c:out value="${route.numberOfCars}" /></td>
				<% ;} %>
				<td style="font-size:1em"><c:out value="${route.terminalStation1}" /></td>
				<td style="font-size:1em"><c:out value="${route.terminalStation2}" /></td>
				<td style="font-size:1em"><c:out value="${route.intervalTime}" /></td>
				<td style="font-size:1em"><c:out value="${route.startTime}" /></td>
				<td style="font-size:1em"><c:out value="${route.endTime}" /></td>
				<%if(request.getSession().getAttribute("role").equals("commander")){ %>
					<td style="font-size:1em"><c:out value="${route.profitability}" /></td>
				<% ;} %>
				<td><div class="arrow"></div></td>
			</tr>
			<tr>
				<td colspan="5">
					<h4><fmt:message key="table_of_routes.stations" /></h4> <c:forEach var="station"
						items="${route.stations}">
						<p style="font-size:1.5em"><c:out value="${station}" /></p>
					</c:forEach>
					<%if(request.getSession().getAttribute("role").equals("commander")){ %>
						<button class="button small orange" style="width:5em; height:3em" type="submit" name="command" value="route.DeleteRoute"><em>delete</em></button>
					<% ;} %>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
