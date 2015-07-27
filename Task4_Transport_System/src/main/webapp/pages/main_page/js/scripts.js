jQuery(document).ready(
		function() {

			/* ---------------------------------------------------------------------- */
			/*
			 * BACKGROUND SLIDESHOW /*
			 * ----------------------------------------------------------------------
			 */
			$('.coming-soon').backstretch(
					[ "pages/main_page/images/backgrounds/1.jpg", "pages/main_page/images/backgrounds/2.jpg",
							"pages/main_page/images/backgrounds/3.jpg" , "pages/main_page/images/backgrounds/4.jpg", "pages/main_page/images/backgrounds/5.jpg"], {
						duration : 3000,
						fade : 750
					});

			/* ---------------------------------------------------------------------- */
			/*
			 * COUNTDOWN INITIALIZER /*
			 * ----------------------------------------------------------------------
			 */

			$(".ccounter").ccountdown(2016, 01, 01);

		});
