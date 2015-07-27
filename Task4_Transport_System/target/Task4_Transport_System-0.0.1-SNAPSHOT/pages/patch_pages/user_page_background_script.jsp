<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script src="pages/user_pages/js/vendor/jquery-1.10.1.min.js"></script>
<script>
	window.jQuery
			|| document
					.write('<script src="pages/user_pages/js/vendor/jquery-1.10.1.min.js"><\/script>')
</script>
<script src="pages/user_pages/js/jquery.easing-1.3.js"></script>
<script src="pages/user_pages/js/bootstrap.js"></script>
<script src="pages/user_pages/js/plugins.js"></script>
<script src="pages/user_pages/js/main.js"></script>
<script type="text/javascript">
	jQuery(function($) {

		$.supersized({

			// Functionality
			slide_interval : 3000, // Length between transitions
			transition : 1, // 0-None, 1-Fade, 2-Slide Top, 3-Slide Right, 4-Slide Bottom, 5-Slide Left, 6-Carousel Right, 7-Carousel Left
			transition_speed : 700, // Speed of transition

			// Components                           
			slide_links : 'blank', // Individual links for each slide (Options: false, 'num', 'name', 'blank')
			slides : [ // Slideshow Images
			{
				image : 'pages/user_pages/images/templatemo-slide-1.jpg'
			}, {
				image : 'pages/user_pages/images/templatemo-slide-2.jpg'
			}, {
				image : 'pages/user_pages/images/templatemo-slide-3.jpg'
			}, {
				image : 'pages/user_pages/images/templatemo-slide-4.jpg'
			}, {
				image : 'pages/user_pages/images/templatemo-slide-5.jpg'
			}, {
				image : 'pages/user_pages/images/templatemo-slide-6.jpg'
			}, {
				image : 'pages/user_pages/images/templatemo-slide-7.jpg'
			} ]

		});
	});
</script>