<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<fmt:requestEncoding value="utf-8" />
<fmt:setLocale value="EN" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="pages/user_pages/buttons_css3/buttons.css" />

<title>Transport system</title>

</head>
<body style="background-color: #FFEE77">

	<h1 align="center">TRANSPORT TO BUY</h1>

	<table style="text-align: center" border="1" width="100%">
		<col span=4 width="25%">
		<tr style="font-size: 24px">
			<td>TYPE</td>
			<td>CAPACITY</td>
			<td>MODEL</td>
			<td>YEAR</td>
			<td>UPKEEP</td>
			<td>VALUE</td>
		</tr>
		<c:forEach var="transport" items="${transports}">
			<col>
			<tr style="font-size: 18px">
				<td><c:out value="${transport.type}" /></td>
				<td><c:out value="${transport.capacity}" /></td>
				<td><c:out value="${transport.model}" /></td>
				<td><c:out value="${transport.year}" /></td>
				<td><c:out value="${transport.upkeep}" /></td>
				<td><c:out value="${transport.value}" /></td>

				<td>
					<form action="controller" method="post">
						<input type="hidden" name="type" value="${transport.type}" /> <input
							type="hidden" name="capacity" value="${transport.capacity}" /> <input
							type="hidden" name="model" value="${transport.model}" /> <input
							type="hidden" name="year" value="${transport.year}" /> <input
							type="hidden" name="upkeep" value="${transport.upkeep}" /> <input
							type="hidden" name="value" value="${transport.value}" />
						<button type="submit" name="command" value="transport.ConfirmBuyTransport">Buy</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>


	<form action="controller" method="post">
		<input type="hidden" name="pagename" value="table_of_drivers_for_hire" />
		<button class="button medium blue" type="submit" name="command" value="MainDispatch">Back
			to Your Page</button>
		<button class="button medium blue" type="submit" name="command" value="MainPage">Back to
			Main Page</button>
	</form>
</body>
</html>