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

	<h1 align="center">DRIVERS FOR HIRE</h1>

		<table style="text-align: center" border="1" width="100%">
			<col span=4 width="25%">
			<tr style="font-size: 24px">
				<td>NAME</td>
				<td>AGE</td>
				<td>EXPERIENCE LEVEL</td>
				<td>TEL. NUMBER</td>
				<td>TRANSPORT MASTERY</td>
				<td>SALARY</td>
			</tr>
			<c:forEach var="driver" items="${drivers}">
				<col>
				<tr style="font-size: 18px">
					<td><c:out value="${driver.name}" /></td>
					<td><c:out value="${driver.age}" /></td>
					<td><c:out value="${driver.experienceLevel}" /></td>
					<td><c:out value="${driver.telephoneNumber}" /></td>
					<td><c:out value="${driver.transportMastery}" /></td>
					<td><c:out value="${driver.salary}" /></td>
					
					<td>
						<form action="controller" method="post">
	 				<input type="hidden" name="name" value="${driver.name}" />  
	 				<input type="hidden" name="age" value="${driver.age}" /> 
	 				<input type="hidden" name="exp" value="${driver.experienceLevel}"/> 
	 				<input type="hidden" name="telNum" value="${driver.telephoneNumber}"/> 
	 				<input type="hidden" name="tranMast" value="${driver.transportMastery}" /> <input type="hidden" name="salary" value="${driver.salary}" />
						<button type="submit" name="command" value="hr.ConfirmHireDriver">Hire</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>


	<form action="controller" method="post">
		<button class="button medium blue" type="submit" name="command" value="MainDispatch">Back
			to Your Page</button>
		<button class="button medium blue" type="submit" name="command" value="MainPage">Back to
			Main Page</button>
	</form>
</body>
</html>