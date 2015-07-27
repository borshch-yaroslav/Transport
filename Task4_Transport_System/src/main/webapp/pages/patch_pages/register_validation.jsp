<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script>
	<script src="http://code.jquery.com/jquery-latest.js">
</script>


<script>
$(document).ready(function() { 
	 
	  $('#btn-submit').click(function() {  
	 
	    $(".error").hide();
	    var hasError = false;
	    
	    
	    var loginReg = /^\s*[a-zA-Z0-9\s_]+\s*$/;
	    var loginR = $("#txtLoginR").val();
	    
	    
	    var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
	    var emailblockReg =
	     /^([\w-\.]+@(?!gmail.com)(?!yahoo.com)(?!hotmail.com)([\w-]+\.)+[\w-]{2,4})?$/;
	    var emailaddressVal = $("#UserEmail").val();
	    
	    
	    var nameReg = /^\s*[a-zA-Z0-9\s\-]+\s*$/;
	    var nameVal = $("#nameR").val();
	   
	    
	    var passwordReg = /^\s*[a-zA-Z0-9,\s\-_!]+\s*$/; 
	    var passwordVal = $("#txtPassword").val();
	    
	    if(loginR== '') {
	      $("#txtLoginR").after('<span class="error">Please enter your login.</span>');
	      hasError = true;
	    }
	 
	    else if(!loginReg.test(loginR)) {
	      $("#txtLoginR").after('<span class="error">Enter a valid login.</span>');
	      hasError = true;
	    }
	 
	    
	    
	    else if(emailaddressVal == '') {
	      $("#UserEmail").after('<span class="error">Please enter your email address.</span>');
	      hasError = true;
	    }
	 
	    else if(!emailReg.test(emailaddressVal)) {
	      $("#UserEmail").after('<span class="error">Enter a valid email address.</span>');
	      hasError = true;
	    }
	 
	    else if(!emailblockReg.test(emailaddressVal)) {
	      $("#UserEmail").after('<span class="error">No yahoo, gmail or hotmail emails.</span>');
	      hasError = true
	    } 
	    
	    
	    

	    else if(nameVal== '') {
	      $("#nameR").after('<span class="error">Please enter your name.</span>');
	      hasError = true;
	    }
	 
	    else if(!nameReg.test(nameVal)) {
	      $("#nameR").after('<span class="error">Enter a valid name.</span>');
	      hasError = true;
	    }
	    
	    
	    

	    else  if(passwordVal== '') {
	      $("#txtPassword").after('<span class="error">Please enter password.</span>');
	      hasError = true;
	    }
	 
	    else if(!passwordReg.test(passwordVal)) {
	      $("#txtPassword").after('<span class="error">Enter a valid password.</span>');
	      hasError = true;
	    }
	    
	    
	    if(hasError == true) { return false; }
	 
	    });
	});
</script>