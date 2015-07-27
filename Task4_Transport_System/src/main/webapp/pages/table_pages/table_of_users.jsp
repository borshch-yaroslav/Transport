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
	font-size: 1.5em;
}

#report3 {
	margin: auto;
	border-collapse: collapse;
}

#report3 h4 {
	margin: 0px;
	padding: 0px;
}

#report3 img {
	float: right;
}

#report3 ul {
	margin: 10px 0 10px 40px;
	padding: 0px;
}

#report3 th {
	background: #7CB8E2 url(header_bkg.png) repeat-x scroll center left;
	color: #fff;
	padding: 7px 15px;
	text-align: left;
}

#report3 td {
	background: #C7DDEE none repeat-x scroll center left;
	color: #000;
	padding: 7px 15px;
}

#report3 tr.odd td {
	background: #fff url(row_bkg.png) repeat-x scroll center left;
	cursor: pointer;
}

#report3 div.arrow {
	background: transparent url(arrows.png) no-repeat scroll 0px -16px;
	width: 16px;
	height: 16px;
	display: block;
}

#report3 div.up {
	background-position: 0px 0px;
}
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#report3 tr:odd").addClass("odd");
		$("#report3 tr:not(.odd)").hide();
		$("#report3 tr:first-child").show();

		$("#report3 tr.odd").click(function() {
			$(this).next("tr").toggle();
			$(this).find(".arrow").toggleClass("up");
		});
		//$("#report").jExpand();
	});
</script>
</head>
<body>
	<table id="report3">
		<tr style="font-size:2em">
			<th><fmt:message key="table_of_users.col1" /></th>
			<th><fmt:message key="table_of_users.col2" /></th>
			<th><fmt:message key="table_of_users.col3" /></th>
			<th><fmt:message key="table_of_users.col4" /></th>
			<th></th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr style="font-size:1.5em">
				<td><c:out value=" ${user.login}" /></td>
				<td><c:out value=" ${user.name}" /></td>
				<td><c:out value=" ${user.email}" /></td>
				<td><c:out value=" ${user.role}" /></td>
				<td><div class="arrow"></div></td>
			</tr>
			<tr>
			</tr> 
		</c:forEach>
	</table>
</body>
</html>
