<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="menu" />
<fmt:requestEncoding value="utf-8" />

<!DOCTYPE html>
<html class="no-js">
<head>

<title>Transport system</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="">
<meta name="viewport" content="width=device-width">

<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet">

<link rel="stylesheet" href="pages/user_pages/css/bootstrap.min.css">
<link rel="stylesheet" href="pages/user_pages/css/normalize.min.css">
<link rel="stylesheet" href="pages/user_pages/css/font-awesome.min.css">
<link rel="stylesheet" href="pages/user_pages/css/animate.css">
<link rel="stylesheet" href="pages/user_pages/css/templatemo_misc.css">
<link rel="stylesheet" href="pages/user_pages/css/templatemo_style.css">


<link rel="stylesheet" type="text/css"
	href="pages/user_pages/buttons_css3/buttons.css" />

<script src="pages/user_pages/js/vendor/modernizr-2.6.2.min.js"></script>

</head>
<body>


	<div class="bg-overlay"></div>

	<div class="container-fluid">

		<form action="controller" method="post">
			<button class="button small blue" type="submit" name="command"
				value="ChangeLanguage" style="margin-right: 5em; margin-top: 0em">
				<fmt:message key="main.change_language" />
			</button>
		</form>

		<div class="row">

			<div class="col-md-4 col-sm-12">
				<div class="sidebar-menu">

					<div style="background-color: transparent" class="logo-wrapper">
						<h1 class="logo">
							<a rel="nofollow" href="controller?command=MainPage"><img
								src="pages/user_pages/images/logo.png" alt="Circle Template">
								<span style="color: white; font-size: 15px"><fmt:message
										key="cabinet.welcome" /></span></a>
						</h1>
					</div>
					<!-- /.logo-wrapper -->

					<div class="menu-wrapper">
						<ul class="menu">
							<li><a class="homebutton" href="#"><em
									style="font-size: 14px; color: grey"><fmt:message
											key="cabinet.hide" /></em></a></li>
							<li><a class="show-1" href="#"><fmt:message
										key="user_page.routes_tickets" /></a></li>
							<li><a rel="nofollow"
								href="controller?command=MapWithAllRoutes"><fmt:message
										key="user_page.map" /></a></li>
							<li><a class="show-3" href="#"><fmt:message
										key="cabinet.gallery" /></a></li>
							<li><a class="show-4" href="#"><fmt:message
										key="cabinet.messages" /></a></li>
							<li><a rel="nofollow" href="controller?command=Logout"><fmt:message
										key="cabinet.logout" /></a></li>
						</ul>
						<!-- /.menu -->
						<a href="#" class="toggle-menu"><i class="fa fa-bars"></i></a>
					</div>
					<!-- /.menu-wrapper -->

					<!--Arrow Navigation-->
					<a id="prevslide" class="load-item"><i class="fa fa-angle-left"></i></a>
					<a id="nextslide" class="load-item"><i
						class="fa fa-angle-right"></i></a>

				</div>
				<!-- /.sidebar-menu -->
			</div>
			<!-- /.col-md-4 -->

			<div class="col-md-8 col-sm-12">

				<div id="menu-container">

					<div id="menu-2" class="services content" style="margin-top: 5em">
						<div class="row"></div>
						<!-- /.row -->
					</div>
					<!-- /.about -->

					<div id="menu-1" class="about content" style="margin-top: 2em">
						<div class="row">
							<ul class="tabs">
								<li class="col-md-4 col-sm-4"><a href="#tab4"
									class="icon-item"> <i class="fa fa-cogs"></i>
								</a> <!-- /.icon-item --></li>
								<li class="col-md-4 col-sm-4"><a href="#tab5"
									class="icon-item"> <i class="fa fa-leaf"></i>
								</a> <!-- /.icon-item --></li>
							</ul>
							<!-- /.tabs -->
							<div class="col-md-12 col-sm-12">
								<div class="toggle-content text-center" id="tab4">
									<h1 style="color: black">
										<fmt:message key="user_page.routes" />
									</h1>
									<jsp:include page="../table_pages/table_of_routes.jsp" />
								</div>

								<div class="toggle-content text-center" id="tab5">
									<h1 style="color: black">
										<fmt:message key="user_page.have_tickets" />
									</h1>
									<ul>
										<li><h4>
												<fmt:message key="user_page.bus" />
												<c:out value="${user.busTickets}" />
											</h4></li>
										<li><h4>
												<fmt:message key="user_page.tram" />
												<c:out value="${user.tramTickets}" />
											</h4></li>
										<li><h4>
												<fmt:message key="user_page.trolley" />
												<c:out value="${user.trolleyTickets}" />
											</h4></li>
									</ul>


									<h2 style="color: black">
										<fmt:message key="user_page.buy_tickets" />
									</h2>

									<div>
										<form action="controller" method="post">
											<div style="display: inline-block">
												<h5>
													<fmt:message key="user_page.num_bus" />
												</h5>
												<h4>
													<input type="number" min=0 name="numberBus" value=0
														style="background-color: grey" required/>
												</h4>
											</div>
											<div style="display: inline-block">
												<h5>
													<fmt:message key="user_page.num_tram" />
												</h5>
												<h4>
													<input type="number" min=0 name="numberTram" value=0
														style="background-color: grey" required/>
												</h4>
											</div>

											<div style="display: inline-block">
												<h5>
													<fmt:message key="user_page.num_trolley" />
												</h5>
												<h4>
													<input type="number" min=0 name="numberTrolley" value=0
														style="background-color: grey" required/>
												</h4>
											</div>

											<button type="submit" name="command"
												value="hr.ConfirmBuyTickets" class="button small green">
												<fmt:message key="user_page.buy" />
											</button>
										</form>
									</div>
								</div>
							</div>
							<!-- /.col-md-12 -->
						</div>
						<!-- /.row -->
					</div>
					<!-- /.services -->


					<div id="menu-3" class="gallery content" style="margin-top: 2em">
						<jsp:include page="../patch_pages/gallery.jsp" />
					</div>


					<div id="menu-4" class="contact content" style="margin-top: 2em">
						<jsp:include page="../patch_pages/message_form.jsp" />
					</div>
					<!-- /.contact -->

				</div>
				<!-- /#menu-container -->

			</div>
			<!-- /.col-md-8 -->

		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12 footer">
				<p id="footer-text">
					<fmt:message key="cabinet.copyright" />
					&copy; 2015 <a href="#"><fmt:message key="cabinet.borshch" /></a>
				</p>
			</div>
			<!-- /.footer -->
		</div>
	</div>
	<!-- /.container-fluid -->

	<jsp:include page="../patch_pages/user_page_background_script.jsp" />

</body>
</html>