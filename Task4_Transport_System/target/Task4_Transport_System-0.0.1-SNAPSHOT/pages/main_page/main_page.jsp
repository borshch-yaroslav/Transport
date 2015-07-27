<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="menu" />
<fmt:requestEncoding value="utf-8" />

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Transport system</title>

<link href='http://fonts.googleapis.com/css?family=Armata'
	rel='stylesheet' type='text/css'>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="pages/main_page/bootstrap/css/bootstrap.min.css">
<!-- CSS -->
<link rel="stylesheet" href="pages/main_page/css/style1.css">
<!-- Javascript -->
<script src="pages/main_page/js/jquery-1.8.2.min.js"></script>
<script src="pages/main_page/bootstrap/js/bootstrap.min.js"></script>
<script src="pages/main_page/js/jquery.backstretch.min.js"></script>
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript"
	src="pages/main_page/js/jquery.gmap.min.js"></script>
<script src="pages/main_page/js/excanvas.js"></script>
<script src="pages/main_page/js/jquery.knob.js"></script>
<script src="pages/main_page/js/jquery.knob.script.js"></script>
<script src="pages/main_page/js/jquery.ccountdown.js"></script>
<script src="pages/main_page/js/init.js"></script>
<script src="pages/main_page/js/scripts.js"></script>

<link rel="stylesheet" type="text/css"
	href="pages/user_pages/buttons_css3/buttons.css" />



</head>

<body>

	<div class="coming-soon">
		<div class="inner-bg">
			<div class="container">
				<div class="row">
					<div class="span12">
						<div class="logo">
							<a href="controller?command=MainDispatch"><img
								src="pages/main_page/images/logo1.png" width="600" height="110"
								border="0"></a>
						</div>
						<br> <br> <br>
						<h1>
							<strong>Stranger, our transport company welcomes you!</strong>
							${locale}
							<fmt:message key="main.title1"/>
						</h1>
						
						<h2>
							<strong>You can watch all the city routes, buy tickets
								and send wishes to shy administrators.</strong>
						</h2>
						<div class="span12 counter">
							<div class="ccounter">
								<input class="knob days" data-id="days" data-readOnly="true"
									data-width="162" data-displayPrevious=true
									data-fgColor="#ffffff" data-skin="tron" data-thickness=".2"
									data-min="0" data-max="365" value="75" /> <input
									class="knob hour" data-id="hours" data-readOnly="true"
									data-width="162" data-min="0" data-max="24"
									data-displayPrevious=true data-fgColor="#ffffff"
									data-skin="tron" data-thickness=".2" value="75" /> <input
									class="knob minute" data-id="minutes" data-readOnly="true"
									data-width="162" data-min="0" data-max="60"
									data-displayPrevious=true data-fgColor="#ffffff"
									data-skin="tron" data-thickness=".2" value="75" /> <input
									class="knob second" data-id="seconds" data-readOnly="true"
									data-width="162" data-min="0" data-max="60"
									data-displayPrevious=true data-fgColor="#ffffff"
									data-skin="tron" data-thickness=".2" value="75" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- Page Content -->
	<div style="background-color:#FFEE77">
	<div class="container"
		style="min-height: 65em; min-width=:100%; background:  url(pages/main_page/images/backgrounds/background.jpg) no-repeat center">

		<c:if test="${isRegistered eq 'false'}">
			<div class="row">
				<div class="span12 newsletter">
					<p style="color: black; border-radius: 25%; font-size:2em">
						<strong>Enter this space and stay free-runner!</strong>
					</p>
					<form class="form-inline" action="controller" method="post">
					

						<p style="color: red">
							<c:out value="${warning_login}" />
						</p>



						<input type="text" id="loginLogin" name="txtLogin"
							value="${txtLogin}" required placeholder="Login"
							onchange="responseLogin();"> <input id="logPassword"
							type="password" name="txtPassword" required
							placeholder="Password">

						<button type="submit" class="btn" name="command" value="Login">Login</button>
					</form>
					<div class="success-message"></div>
					<div class="error-message"></div>
				</div>
			</div>
		</c:if>

		<div style="margin-top:10em">
			<c:if test="${isRegistered eq 'true'}">
				<form action="controller" method="post">
					<button class="button big orange" type="submit" name="command"
						value="Logout" style="margin-right:30em">Logout</button>
					<button class="button big green" type="submit" name="command"
						value="MainDispatch" style="margin-right:10em; margin-top:10em">Cabinet</button>
				</form>
			</c:if>
		</div>

	</div>
	
</div>

	<!-- Content For Map and contact form -->
	<div id="mapContact">
		<div class="container">
			<div id="contact-status"></div>

			<c:if test="${isRegistered eq 'false'}">
				<form action="controller" name="registration" method="post"
					id="contactform">

					<div id="resultAjax"></div>
					<input name="releLogin" type="hidden">


					<div id=registrationWarning></div>
					<p>
						<input type="text" id="txtLoginR" name="txtLogin"
							value="${txtLogin}" required class="input" placeholder="Login">
					</p>

					<p>
						<input type="password" id="txtPassword" name="txtPassword"
							required class="input" placeholder="Password">
					</p>
					<p>
						<input type="text" id="nameR" name="txtName" value="${txtName}"
							class="input" placeholder="Name">
					</p>
					<p>
						<input id="UserEmail" type="text" name="txtEmail"
							value="${txtEmail}" class="input" placeholder="Email">
					</p>
					<p style="color: white">
						<input type="radio" name="txtLocale" value="en"> English <input
							type="radio" name="txtLocale" value="ua"> Ukrainian
					</p>

					<p>
						<input type="reset" value="Clean" onclick="resetRegForm();">
					</p>

					<button id="btn-submit" type="submit" name="command"
						value="Register" class="button">Register</button>
				</form>
			</c:if>
		</div>
	</div>

	<jsp:include page="../patch_pages/register_validation.jsp" />


	<div>
		<h4 align=center>2015 Borshch On 'EPAM'</h4>
	</div>
</body>

</html>

