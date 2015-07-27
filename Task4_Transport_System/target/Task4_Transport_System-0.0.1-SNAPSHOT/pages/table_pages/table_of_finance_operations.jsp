<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
body {
	font-family: Arial, Helvetica, Sans-Serif;
	font-size: 0.8em;
}

.report2 {
	border-collapse: collapse;
}

.report2 h4 {
	margin: 0px;
	padding: 0px;
}

.report2 img {
	float: right;
}

.report2 ul {
	margin: 10px 0 10px 40px;
	padding: 0px;
}

.report2 th {
	background: #7CB8E2 url(header_bkg.png) repeat-x scroll center left;
	color: #fff;
	padding: 7px 15px;
	text-align: left;
}

.report2 td {
	background: #C7DDEE none repeat-x scroll center left;
	color: #000;
	padding: 7px 15px;
}

.report2 tr.odd td {
	background: #fff url(row_bkg.png) repeat-x scroll center left;
	cursor: pointer;
}

.report2 div.arrow {
	background: transparent url(arrows.png) no-repeat scroll 0px -16px;
	width: 16px;
	height: 16px;
	display: block;
}

.report2 div.up {
	background-position: 0px 0px;
}
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#report2 tr:odd").addClass("odd");
		$("#report2 tr:not(.odd)").hide();
		$("#report2 tr:first-child").show();

		$("#report2 tr.odd").click(function() {
			$(this).next("tr").toggle();
			$(this).find(".arrow").toggleClass("up");
		});
		//$("#report").jExpand();
	});
</script>
</head>
<body>
<h1 style="margin-left:5em; color:white">Finance operations</h1>
	<table class="report2" style="margin: auto">
		<tr style="font-size:2em">
			<th>ID</th>
			<th>Description</th>
			<th>Finance change</th>
			<th>Date</th>
			<th></th>
		</tr>
		<c:forEach var="financeOperation" items="${financeOperations}">
			<tr style="font-size:1.5em">
				<td><c:out value=" ${financeOperation.id}" /></td>
				<td><c:out value=" ${financeOperation.description}" /></td>
				<td><c:out value=" ${financeOperation.financeChange}" /></td>
				<td><c:out value=" ${financeOperation.date}" /></td>
				<td><div class="arrow"></div></td>
			</tr>
			<tr>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
