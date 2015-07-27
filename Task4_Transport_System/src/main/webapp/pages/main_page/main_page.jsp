<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page import="org.apache.log4j.Logger"%>

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

<script src="pages/main_page/js/excanvas.js"></script>
<script src="pages/main_page/js/jquery.knob.js"></script>
<script src="pages/main_page/js/jquery.knob.script.js"></script>
<script src="pages/main_page/js/jquery.ccountdown.js"></script>
<script src="pages/main_page/js/it.js"></script>
<script src="pages/main_page/js/scripts.js"></script>

<link rel="stylesheet" type="text/css"
	href="pages/user_pages/buttons_css3/buttons.css" />

<jsp:include page="../helper/user_exists_ajax.jsp" />

</head>

<body>

	<%
		Logger LOG = Logger.getLogger(this.getClass().getName());
	%>

	<%
		LOG.warn("There's a new man in Town!");
	%>

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
							<strong><fmt:message key="main.title1" /></strong>

						</h1>

						<h2>
							<strong><fmt:message key="main.title2" /></strong>
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
	<div style="background-color: #FFEE77">
		<div class="container"
			style="min-height: 55em; min-width =: 100%; background: url(pages/main_page/images/backgrounds/background.jpg) no-repeat center">

			<c:if test="${isRegistered eq 'false'}">
				<div class="row">
					<div class="span12 newsletter">
						<p style="color: black; border-radius: 25%; font-size: 2em">
							<strong><fmt:message key="main.title3" /></strong>
						</p>
						<form class="form-inline" action="controller" method="post" name="loginForm">

							<input type="hidden" name="locale" value="${locale }"/>

							<p style="color: red" id="warnLogin">
								${warning_login}
							</p>

							<input type="text" id="loginLogin" name="txtLogin"
								value="${txtLogin}" required placeholder="Login"
								onchange="responseLogin();"> <input id="logPassword"
								type="password" name="txtPassword" required
								placeholder="Password">

							<button type="submit" class="btn" name="command" value="Login" id="logSubmit">
								<fmt:message key="main.login" />
							</button>
						</form>
						<div class="success-message"></div>
						<div class="error-message"></div>
					</div>
				</div>
			</c:if>

			<div style="margin-top: 10em">
				<form action="controller" method="post">
				
				<input type="hidden" name="page" value="main"/>
				
					<c:if test="${isRegistered eq 'true'}">

						<button class="button big orange" type="submit" name="command"
							value="Logout" style="margin-right: 10em; height:3em">
							<fmt:message key="main.logout" />
						</button>
						<button class="button big green" type="submit" name="command"
							value="MainDispatch" style="margin-right: 7em; height:3em; margin-top: 7em">
							<fmt:message key="main.cabinet" />
						</button>
					</c:if>
					<button class="button medium blue" type="submit" name="command"
						value="ChangeLanguage" style="margin-right: 10em;height:3em; margin-top: 0em">
						<fmt:message key="main.change_language" />
					</button>
				</form>
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
					<span id="regWarn" style="color:red"> </span>

					<div id="resultAjax"></div>
					<input name="releLogin" type="hidden">


					<div id=registrationWarning></div>
					<p>
						<input type="text" id="txtLoginR" name="txtLoginR"
							value="${txtLoginR}" required class="input" placeholder="Login" onkeyup="sendInfo();">
					</p>

					<p>
						<input type="password" id="regPassword" name="regPassword"
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
						<input type="radio" name="txtLocale" value="en">
						<fmt:message key="main.english" />
						<input type="radio" name="txtLocale" value="ua">
						<fmt:message key="main.ukrainian" />
					</p>

					<p>
						<input type="reset" value="Clean" onclick="resetRegForm(); sendInfo();">
					</p>

					<button id="btn-submit" type="submit" name="command"
						value="Register" class="button">
						<fmt:message key="main.register" />
					</button>
				</form>
			</c:if>
		</div>
	</div>

	<jsp:include page="../patch_pages/register_validation.jsp" />


	<div>
		<h4 align=center>
			<fmt:message key="cabinet.borshch" />
		</h4>
	</div>
</body>

</html>

