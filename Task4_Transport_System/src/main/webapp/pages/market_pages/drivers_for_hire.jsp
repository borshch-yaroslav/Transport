<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="menu" />
<fmt:requestEncoding value="utf-8" />


<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="pages/user_pages/buttons_css3/buttons.css" />

<title>Transport system</title>

</head>
<body style="background-color: #FFEE77">

	<h1 align="center"><fmt:message key="drivers_for_hire.title" /></h1>

		<table style="text-align: center" border="1" width="100%">
			<col span=4 width="25%">
			<tr style="font-size: 24px">
				<td><fmt:message key="drivers_for_hire.col1" /></td>
				<td><fmt:message key="drivers_for_hire.col2" /></td>
				<td><fmt:message key="drivers_for_hire.col3" /></td>
				<td><fmt:message key="drivers_for_hire.col4" /></td>
				<td><fmt:message key="drivers_for_hire.col5" /></td>
				<td><fmt:message key="drivers_for_hire.col6" /></td>
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
						<button class="button small green" type="submit" name="command" value="hr.ConfirmHireDriver">Hire</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>


	<form action="controller" method="post">
		<button class="button medium blue" type="submit" name="command" value="MainDispatch"><fmt:message key="general.back_to_your" /></button>
		<button class="button medium blue" type="submit" name="command" value="MainPage"><fmt:message key="general.back_to_main" /></button>
	</form>
</body>
</html>