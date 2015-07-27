<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script>
	<script src="http://code.jquery.com/jquery-latest.js">
</script>


<script>
$(document).ready(function() { 
	 
	  $('#route-confirm-btn').click(function() {  
	 
	    $(".error").hide();
	    var hasError = false;
	    
	    var routeReg = /^\s*[a-zA-Z0-9\s\-]+\s*$/;
	    var routeVal = $("#routeNumber").val();
	    
	    
	    if(loginR== '') {
	      $("#routeNumber").after('<span class="error">Please enter your login.</span>');
	      hasError = true;
	    }
	 
	    else if(!loginReg.test(loginR)) {
	      $("#routeNumber").after('<span class="error">Enter a valid login.</span>');
	      hasError = true;
	    }
	 
	    

	    
	    
	    if(hasError == true) { return false; }
	 
	    });
	});
</script>