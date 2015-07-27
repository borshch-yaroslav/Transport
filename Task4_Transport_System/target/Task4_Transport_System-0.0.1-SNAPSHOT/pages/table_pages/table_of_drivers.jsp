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

#report1 {
	border-collapse: collapse;
}

#report1 h4 {
	margin: 0px;
	padding: 0px;
}

#report1 img {
	float: right;
}

#report1 ul {
	margin: 10px 0 10px 40px;
	padding: 0px;
}

#report1 th {
	background: #7CB8E2 url(header_bkg.png) repeat-x scroll center left;
	color: #fff;
	padding: 7px 15px;
	text-align: left;
}

#report1 td {
	background: #C7DDEE none repeat-x scroll center left;
	color: #000;
	padding: 7px 15px;
}

#report1 tr.odd td {
	background: #fff url(row_bkg.png) repeat-x scroll center left;
	cursor: pointer;
}

#report1 div.arrow {
	background: transparent url(arrows.png) no-repeat scroll 0px -16px;
	width: 16px;
	height: 16px;
	display: block;
}

#report1 div.up {
	background-position: 0px 0px;
}
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#report1 tr:odd").addClass("odd");
		$("#report1 tr:not(.odd)").hide();
		$("#report1 tr:first-child").show();

		$("#report1 tr.odd").click(function() {
			$(this).next("tr").toggle();
			$(this).find(".arrow").toggleClass("up");
		});
		//$("#report").jExpand();
	});
</script>
</head>
<body>
	<table id="report1">
		<tr style="">
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
			<th>Experience level</th>
			<th>Transport mastery</th>
			<th>Salary</th>
			<th>Transport ID</th>
			<th>Telephone number</th>
			<th>Fire</th>
			<th></th>
		</tr>
		<c:forEach var="driver" items="${drivers}">
			<tr style="font-size:1.1em">
				<td><c:out value="${driver.id}" /></td>
				<td><c:out value="${driver.name}" /></td>
				<td><c:out value="${driver.age}" /></td>
				<td><c:out value="${driver.experienceLevel}" /></td>
				<td><c:out value="${driver.transportMastery}" /></td>
				<td><c:out value="${driver.salary}" /></td>
				<td><c:out value="${driver.transportId}" /></td>
				<td><c:out value="${driver.telephoneNumber}" /></td>
				<td>
					<form action="controller" method="post">
						<input type="hidden" name="fireId" value="${driver.id}" />
						<button type="submit" name="command" value="hr.FireDriver">
							<em>fire</em>
						</button>
					</form>
				</td>
				<td><div class="arrow"></div></td>
			</tr>
			
			<tr>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
