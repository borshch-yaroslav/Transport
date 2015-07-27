<script>
	var request;
	function sendInfo() {
		var v = document.registration.txtLoginR.value;
		var url = "UserExistsAjaxServlet?login=" + v;

		if (window.XMLHttpRequest) {
			request = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}

		try {
			request.onreadystatechange = getInfo;
			request.open("GET", url, true);
			request.send();
		} catch (e) {
			alert("Unable to connect to server");
		}
	}

	function getInfo() {
		if (request.readyState == 4) {
			var val = request.responseText;

			if (val === "Login reserved.") {

				document.getElementById('btn-submit').disabled = true;
			} else
				document.getElementById('btn-submit').disabled = false;
			document.getElementById('regWarn').innerHTML = val;
		}
	}
</script>
