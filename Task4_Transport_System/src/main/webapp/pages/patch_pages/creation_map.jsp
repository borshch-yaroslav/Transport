<script src="http://api-maps.yandex.ru/2.1/?lang=uk"
	type="text/javascript"></script>

<script>
	var myMap;
	var multiRoute;

	var coordinates = [];
	var names = [];
	
	var myReverseGeocoder;

	function init() {
		/**
		 * Create multiroute.
		 */
		multiRoute = new ymaps.multiRouter.MultiRoute({
			referencePoints : []
		}, {
			// Type of permissible waypoints.
			editorMidPointsType : "way",
			// Allowed wdraing over map objects.
			editorDrawOver : false

		});

		multiRoute.editor.start({
			addReferencePoints : true,
			addWayPoints : true,
			removeWayPoints : true,
			 dragWayPoints : false
		});

		multiRoute.editor.events
				.add(
						"waypointadd",
						function(e) {

							if (coordinates.length <= 10) {

								coordinates[coordinates.length] = e
										.get("coords");

								var x = e.get("coords")[0];
								var y = e.get("coords")[1];

								document.getElementById("latitude"
										+ coordinates.length).value = x;
								document.getElementById("longtitude"
										+ coordinates.length).value = y;

								myReverseGeocoder = ymaps.geocode([ x, y ],
										{
											prefLang : "uk"
										}, {
											results : 1
										});

								myReverseGeocoder
										.then(function(res) {

											names[name.length] = res.geoObjects
													.get(0);
											document.getElementById("station"
													+ coordinates.length).value = res.geoObjects
													.get(0).properties
													.get('name');
											document
													.getElementById("geographic_name"
															+ coordinates.length).value = res.geoObjects
													.get(0).properties
													.get('text');
										});
								
									
								if(coordinates.length ==10){
									multiRoute.editor.state.addReferencePoints = false;
									multiRoute.editor.state.addWayPoints = false;
								}	
								
								
							} else
								document.getElementById("wrn").value = "Too many stations";

						});

		multiRoute.editor.events.add("waypointremove", function(e) {
			
			multiRoute.editor.state.addWayPoints = true;
			multiRoute.editor.state.addReferencePoints = true;

			var index = e.get("wayPoint").properties.get('index');

			for (var j = 0; j < coordinates.length - index - 1; j++) {
				coordinates[index + j] = coordinates[index + j + 1];
				names[index + j] = names[index + j + 1];

				document.getElementById("latitude"+(index+j+1)).value = document.getElementById("latitude"+(index+j+2)).value;
				document.getElementById("longtitude"+(index+j+1)).value = document.getElementById("longtitude"+(index+j+2)).value;
				document.getElementById("station"+(index+j+1)).value = document.getElementById("station"+(index+j+2)).value;
				document.getElementById("geographic_name"+(index+j+1)).value = document.getElementById("geographic_name"+(index+j+2)).value;
			}

			document.getElementById("station"+(coordinates.length)).value = " ";
			document.getElementById("geographic_name"+(coordinates.length)).value = " ";
			coordinates.length = coordinates.length - 1;
			names.length = names.length - 1;
		});

		multiRoute.editor.events.add("waypointdragend",function (e) {
			
			var index = e.get("wayPoint").properties.get('index');
			
			var x = e.get("wayPoint").geometry.getCoordinates()[0];
			var y = e.get("wayPoint").geometry.getCoordinates()[1];
			

			coordinates[index] = e.get("wayPoint").geometry.getCoordinates();
			
			document.getElementById("latitude"+(index+1)).value = x
			document.getElementById("longtitude"+(index+j+1)).value = y;
			
			myReverseGeocoder = ymaps.geocode([x,y], { prefLang : "uk" }, {results: 1});
				
			myReverseGeocoder.then(function (res) {	
						
					names.index = res.geoObjects.get(0);

					document.getElementById("station"+(index+1)).value = res.geoObjects.get(0).properties.get('name');
					document.getElementById("geographic_name"+(index+1)).value = res.geoObjects.get(0).properties.get('text');
				}
			);
	
        });

		// Create map with edit button and center on Lviv.
		var lviv = [ 49.838889, 24.029230 ];

		myMap = new ymaps.Map('map', {
			center : lviv,
			zoom : 12,

		});

		// Add multiroute on map.
		myMap.geoObjects.add(multiRoute);
	}

	ymaps.ready(init);
</script>