<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<script type="text/javascript">
$(document).ready(function(){
	$('#loggedOutMessage').delay(2000).fadeOut();
	$("#login").click(function() {
		//var loggedInId=$("#loggedInId").val();
		//console.log("loggedInId : "+loggedInId);
		$("#loginDiv").load("login.bapp");
	})
	
	$("#register").click(function() {
		// var loggedInId=$("#loggedInId").val();
		// console.log("loggedInId : "+loggedInId);
		$("#loginDiv").load("register.bapp");
	})
	
	});
</script>
</head>
<body onload="$('#login').click();">
<p style="text-align: center;"><strong><img src="https://cmkt-image-prd.global.ssl.fastly.net/0.1.0/ps/1930247/1160/772/m1/fpnw/wm0/preview001-.jpg?1479808169&amp;s=4f3f8b8b27b99d16f6196c23f801ef18" alt="BankApp" width="100" height="100" /></strong></p>
<p style="text-align: center;"><strong>Welcome To BankApp</strong></p>
<p style="text-align: center;"><strong><a title="Login Here" href="#" style="text-decoration: none" id="login">Login</a>&nbsp; &nbsp; <a title="Register" href="#" style="text-decoration: none" id="register">Register</a></strong></p>
<div align="center" style="color: green;" id="loggedOutMessage">
${loggedOutMessage }
</div>
<hr/>
<div id="loginDiv"></div>
</body>
</html>
