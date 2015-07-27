<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="menu" />
<fmt:requestEncoding value="utf-8" />


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
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
		//$("#report").jExpand();
	});
</script>
</head>
<body>
	<table id="report">
		<tr style="font-size: 1.3em">
			<th><fmt:message key="table_of_transport.col1" /></th>
			<th><fmt:message key="table_of_transport.col2" /></th>
			<th><fmt:message key="table_of_transport.col3" /></th>
			<th><fmt:message key="table_of_transport.col4" /></th>
			<th><fmt:message key="table_of_transport.col5" /></th>
			<th><fmt:message key="table_of_transport.col6" /></th>
			<th><fmt:message key="table_of_transport.col7" /></th>
			<th><fmt:message key="table_of_transport.col8" /></th>
			<th><fmt:message key="table_of_transport.col9" /></th>
			<th></th>
		</tr>
		<c:forEach var="transport" items="${transports}">
			<tr style="font-size: 1.1em">
				<td><c:out value=" ${transport.id}" /></td>
				<td><c:out value=" ${transport.type}" /></td>
				<td><select name="routeForAssign">

						<c:if test="${transport.routeNumber ne 0}">
							<option value=" ${transport.routeNumber}">
								${transport.routeNumber}</option>
						</c:if>
						
						<c:if test="${transport.routeNumber eq 0}">
							<option></option>
						</c:if>


						<c:if test="${transport.type eq 'bus'}">
							<c:forEach items="${busRoutes}" var="busRoute">
								<option value="${busRoute.id}">${busRoute.routeNumber}</option>
							</c:forEach>
						</c:if>

						<c:if test="${transport.type eq 'tram'}">
							<c:forEach items="${tramRoutes}" var="tramRoute">
								<option value="${tramRoute.id}">${tramRoute.routeNumber}</option>
							</c:forEach>
						</c:if>

						<c:if test="${transport.type eq 'trolley'}">
							<c:forEach items="${trolleyRoutes}" var="trolleyRoute">
								<option value="${trolleyRoute.id}">${trolleyRoute.routeNumber}</option>
							</c:forEach>
						</c:if>
				</select></td>
				<td><c:out value=" ${transport.capacity}" /></td>
				<td><c:out value=" ${transport.year}" /></td>
				<td><c:out value=" ${transport.upkeep}" /></td>
				<td><c:out value=" ${transport.value}" /></td>

				<td><select name="driverForAssign" style="width:3em">

						<c:if test="${transport.driverId ne 0}">
							<option value=" ${transport.driverId}">${transport.driverId}</option>
						</c:if>

						<c:if test="${transport.driverId eq 0}">
							<option></option>
						</c:if>

						<c:if test="${transport.type eq 'bus'}">
							<c:forEach items="${freeBusDrivers}" var="freeBusDriver">
								<option value="${freeBusDriver.id}">${freeBusDriver.name}</option>
							</c:forEach>
						</c:if>

						<c:if test="${transport.type eq 'tram'}">
							<c:forEach items="${freeTramDrivers}" var="freeTramDriver">
								<option value="${freeTramDriver.id}">${freeTramDriver.name}</option>
							</c:forEach>
						</c:if>

						<c:if test="${transport.type eq 'trolley'}">
							<c:forEach items="${freeTrolleyDrivers}" var="freeTrolleyDriver">
								<option value="${freeTrolleyDriver.id}">${freeTrolleyDriver.name}</option>
							</c:forEach>
						</c:if>

				</select></td>
				<td>
					<form action="controller" method="post">
						<input type="hidden" name="sellId" value="${transport.id}" />
						<button type="submit" name="command"
							value="transport.SellTransport">
							<em><fmt:message key="table_of_transport.sell" /></em>
						</button>
					</form>
				</td>
				<td><div class="arrow"></div></td>
			</tr>

			<tr></tr>

		</c:forEach>
	</table>
</body>
</html>
