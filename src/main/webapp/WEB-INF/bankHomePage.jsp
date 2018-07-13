<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored = "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$("#viewProfile").click(function() {
		var loggedInId=$("#loggedInId").val();
		console.log("loggedInId : "+loggedInId);
		$("#viewProfileDiv").load("viewProfile.bapp?loggedInId="+loggedInId);
	})
	
	$("#editProfile").click(function() {
		var loggedInId=$("#loggedInId").val();
		console.log("loggedInId : "+loggedInId);
		$("#viewProfileDiv").load("editProfile.bapp?loggedInId="+loggedInId);
	})
	
	$("#depositId").click(function() {
		var loggedInId=$("#loggedInId").val();
		console.log("loggedInId : "+loggedInId);
		$("#viewProfileDiv").load("deposit.bapp");
	})
	
	$("#accountsDetails").click(function() {
		var loggedInId=$("#loggedInId").val();
		console.log("loggedInId : "+loggedInId);
		$("#viewProfileDiv").load("accountsDetails.bapp");
	})
	
	$("#withdrawId").click(function() {
		var loggedInId=$("#loggedInId").val();
		console.log("loggedInId : "+loggedInId);
		$("#viewProfileDiv").load("withdraw.bapp");
	})
	
	$("#statementId").click(function() {
		var loggedInId=$("#loggedInId").val();
		console.log("loggedInId : "+loggedInId);
		$("#viewProfileDiv").load("viewStatements.bapp");
	})
	
	});
	

</script>
<title>Insert title here</title>
</head>
<body onload="<c:if test='${isUpdateProfilePage ne null }'>$('#viewProfile').click()</c:if><c:if test='${isDepositPage ne null }'>$('#accountsDetails').click()</c:if>">
${message}
<input type="hidden" value="${loggedInId}" id="loggedInId"/>
<h2 style="text-align: center;"><img src="https://cmkt-image-prd.global.ssl.fastly.net/0.1.0/ps/1930247/1160/772/m1/fpnw/wm0/preview001-.jpg?1479808169&amp;amp;s=4f3f8b8b27b99d16f6196c23f801ef18" alt="BankLogo" width="150" height="101" style="float: left;" caption="false" />&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Welcome to BankApp</h2>
<p style="text-align: right;">
<strong><a href="#" id="viewProfile">View Profile</a>&nbsp;</strong> &nbsp; &nbsp;&nbsp;
<strong><a href="#" id="editProfile">Edit Profile</a>&nbsp;</strong> &nbsp; &nbsp;&nbsp;
<strong><a href="#" id="accountsDetails">Accounts Details</a>&nbsp;</strong> &nbsp; &nbsp;&nbsp;
<strong>
<a href="#" id="withdrawId">Withdraw</a>&nbsp; &nbsp;&nbsp;
<a href="#" id="depositId">Deposit</a>&nbsp; &nbsp;&nbsp;
<a href="#" id="statementId">View Statements</a>&nbsp; &nbsp;&nbsp;
<a href="logout.bapp">Logout</a>
</strong>
</p>

<hr/>

<div id="viewProfileDiv"></div>


</body>
</html>