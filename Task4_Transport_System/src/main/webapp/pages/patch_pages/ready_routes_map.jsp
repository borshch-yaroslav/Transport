<script src="http://api-maps.yandex.ru/2.1/?lang=uk"
	type="text/javascript"></script>

<script>
	var myMap;

	var multiRoute;
	
	function init() {
			
		// Create map with edit button and center on Lviv.
		var lviv = [ 49.838889, 24.029230 ];

		myMap = new ymaps.Map('map', {
			center : lviv,
			zoom : 12,
		});
	
	};
	
	function clean(){
		myMap.geoObjects.remove(multiRoute);
		for(var j = 0; j<10; j++){
			document.getElementById("station"+(j+1)).value = " ";
		}
	}
	
	function addRoute(){
		
		clean();
		
		var num = document.getElementById("routing").value;
		
		var leng = document.getElementById("len_"+num).value;
		
		var array = [];
		
		for(var i = 0; i < leng; i++){
			var pairs = [];
			pairs[0] = document.getElementById("coo"+(i+1)+"0_"+num).value
			pairs[1] = document.getElementById("coo"+(i+1)+"1_"+num).value
			
			document.getElementById("station"+(i+1)).value = document.getElementById("stations"+(i+1)+"_"+num).value;
			
			array[i] = pairs;
		}	
	
		
	    multiRoute = new ymaps.multiRouter.MultiRoute({
	        referencePoints: array
	    });
	    
	    myMap.geoObjects.add(multiRoute);
	}

	ymaps.ready(init);
</script>