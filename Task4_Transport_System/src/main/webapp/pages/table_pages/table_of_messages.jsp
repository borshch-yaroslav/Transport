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

#report9 {
	border-collapse: collapse;
}

#report9 h4 {
	margin: 0px;
	padding: 0px;
}

#report9 img {
	float: right;
}

#report9 ul {
	margin: 10px 0 10px 40px;
	padding: 0px;
}

#report9 th {
	background: #7CB8E2 url(header_bkg.png) repeat-x scroll center left;
	color: #fff;
	padding: 7px 15px;
	text-align: left;
}

#report9 td {
	background: #C7DDEE none repeat-x scroll center left;
	color: #000;
	padding: 7px 15px;
}

#report9 tr.odd td {
	background: #fff url(row_bkg.png) repeat-x scroll center left;
	cursor: pointer;
}

#report9 div.arrow {
	background: transparent url(arrows.png) no-repeat scroll 0px -16px;
	width: 16px;
	height: 16px;
	display: block;
}

#report9 div.up {
	background-position: 0px 0px;
}
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#report9 tr:odd").addClass("odd");
		$("#report9 tr:not(.odd)").hide();
		$("#report9 tr:first-child").show();

		$("#report9 tr.odd").click(function() {
			$(this).next("tr").toggle();
			$(this).find(".arrow").toggleClass("up");
		});
		//$("#report").jExpand();
	});
</script>
</head>
<body>
	<table id="report9">
		<tr style="font-size:2em">
			<th><fmt:message key="table_of_messages.col1" /></th>
			<th><fmt:message key="table_of_messages.col2" /></th>
			<th><fmt:message key="table_of_messages.col3" /></th>
			<th><fmt:message key="table_of_messages.col4" /></th>
			<th></th>
		</tr>
		<c:forEach var="message" items="${messages}">
			<tr style="font-size:1.5em">
				<td><c:out value=" ${message.id}" /></td>
				<td><c:out value=" ${message.senderLogin}" /></td>
				<td><c:out value=" ${message.type}" /></td>
				<td>
					<form action="controller" method="post">
						<input type="hidden" name="pagename" value="table_of_messages" />
						<input type="hidden" name="txtId" value="${message.id}" />
						<button type="submit" name="command" value="hr.DeleteMessage">
							<em><fmt:message key="table_of_messages.delete" /></em>
						</button>
					</form>
				</td>
				<td><div class="arrow"></div></td>
			</tr>
			<tr>
				<td colspan="5">
					<h4><fmt:message key="table_of_messages.message" /></h4>
					
						<div style="font-size:2em"><c:out value=" ${message.message}" /></div>
					</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
