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

#report5 {
	border-collapse: collapse;
}

#report5 h4 {
	margin: 0px;
	padding: 0px;
}

#report5 img {
	float: right;
}

#report5 ul {
	margin: 10px 0 10px 40px;
	padding: 0px;
}

#report5 th {
	background: #7CB8E2 url(header_bkg.png) repeat-x scroll center left;
	color: #fff;
	padding: 7px 15px;
	text-align: left;
}

#report5 td {
	background: #C7DDEE none repeat-x scroll center left;
	color: #000;
	padding: 7px 15px;
}

#report5 tr.odd td {
	background: #fff url(row_bkg.png) repeat-x scroll center left;
	cursor: pointer;
}

#report5 div.arrow {
	background: transparent url(arrow.png) no-repeat scroll 0px -16px;
	width: 16px;
	height: 16px;
	display: block;
}

#report5 div.up {
	background-position: 0px 0px;
}
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#report5 tr:odd").addClass("odd");
		$("#report5 tr:not(.odd)").hide();
		$("#report5 tr:first-child").show();

		$("#report5 tr.odd").click(function() {
			$(this).next("tr").toggle();
			$(this).find(".arrow").toggleClass("up");
		});
		//$("#report").jExpand();
	});
</script>
</head>
<body>
	<table id="report5">
		<tr style="font-size:1.3em">
			<th><fmt:message key="table_of_routes.col1" /></th>
			<th><fmt:message key="table_of_routes.col2" /></th>
			<th><fmt:message key="table_of_routes.col3" /></th>
			<th><fmt:message key="table_of_routes.col4" /></th>
			<th><fmt:message key="table_of_routes.col5" /></th>
			<th></th>
		</tr>
		<c:forEach var="station" items="${stations}">
			<tr style="font-size:1.1em">
				<td><c:out value="${station.name}" /></td>
				<td><c:out value="${station.numberOfRoutes}" /></td>
				<td><c:out value="${station.latitude}" /></td>
				<td><c:out value="${station.longtitude}" /></td>
				<td><c:out value="${station.geographicName}" /></td>
				<td><div class="arrow"></div></td>
			</tr>
			<tr>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
