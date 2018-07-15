<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    <%@ page isELIgnored = "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>registerPage</title>
<script type="text/javascript">
var validUserName=false;
$("#LoginButton").on('click',function(){
	var uname=$("#uname").val();
	var pwd=$("#password").val();
	if(uname === ""){
		alert("Enter Username");
		$("#uname").focus();
		return false;
	}
	if(pwd === ""){
		alert("Enter Password");
		$("#password").focus();
		return false;
	}
	return true;
	
})

$("#RegisterButton").on('click',function(){
	var fullname=$("#fullname").val();
	var uname=$("#uname").val();
	var emailId=$("#emailId").val();
	var pwd=$("#password").val();
	if(fullname === ""){
		alert("Enter Fullname");
		$("#fullname").focus();
		return false;
	}
	if(uname === ""){
		alert("Enter Username");
		$("#uname").focus();
		return false;
	}
	if(emailId === ""){
		alert("Enter EmailID");
		$("#emailId").focus();
		return false;
	}
	if(pwd === ""){
		alert("Enter Password");
		$("#password").focus();
		return false;
	}
	if(!validUserName){
		alert("Please Enter the valid Username");
		return false;
	}
	
	return true;;
	
})

function checkUserValidation() {
	var uname=$("#uname").val();
	var a=uname!=""?(uname.split(" ").length>1?true:false):true;
	if(a){
		alert("space is not allowed");
		return false;
	}
	$.ajax({
		url:"checkUserValidation.bapp?uname="+uname,
		success: function(data) {
			if(data==false){
				alert("Username already present! Try another one.");
				validUserName=false;
			}else{
				validUserName=true;
			}
		}
	})
}
</script>
</head>
<body>
<c:choose>
<c:when test="${isRegisterPage eq 'YES' }">
<p style="text-align: center;"><strong>Register Page</strong></p>
<p style="text-align: center;"><strong>${message }</strong></p>
<form action="registerUser.bapp" method="post">
<table style="width: 504px;" align="center">
<tbody>
<tr style="height: 12px;">
<td style="height: 12px; width: 250px;">FullName</td>
<td style="height: 12px; width: 262px;"><input type="text" name="fullname" id="fullname"> </td>
</tr>
<tr style="height: 12px;">
<td style="height: 12px; width: 250px;">Username</td>
<td style="height: 12px; width: 262px;"><input type="text" name="uname" id="uname" onblur="checkUserValidation();"> </td>
</tr>
<tr style="height: 18px;">
<td style="height: 18px; width: 250px;">Email Address</td>
<td style="height: 18px; width: 262px;"><input type="text" name="emailId" id="emailId"></td>
</tr>
<tr style="height: 18px;">
<td style="height: 18px; width: 250px;">Password</td>
<td style="height: 18px; width: 262px;"><input type="password" name="password" id="password"></td>
</tr>

<tr style="height: 18px;">
<td style="height: 18px; width: 250px;">Bank</td>
<td style="height: 18px; width: 262px;">
<select name="bankName">
<c:forEach items="${bankName }" var="entry">
<option value="${entry.key }">${entry.value }</option>
</c:forEach>
</select>
</td>
</tr>
<tr style="height: 18px;">
<td style="height: 18px; width: 250px;" colspan="2" align="center"><input type="submit" value="Register" id="RegisterButton"></td>
</tr>
</tbody>
</table>
</form>
</c:when>

<c:when test="${isLoginPage eq 'YES' }">
<p style="text-align: center;"><strong>Login Page</strong></p>
<p style="text-align: center;"><strong>${message }</strong></p>
<form action="LoginUser.bapp" method="post">
<table style="width: 504px;" align="center">
<tbody>
<tr style="height: 12px;">
<td style="height: 12px; width: 250px;">Username</td>
<td style="height: 12px; width: 262px;"><input type="text" name="uname" id="uname"> </td>
</tr>
<tr style="height: 18px;">
<td style="height: 18px; width: 250px;">Password</td>
<td style="height: 18px; width: 262px;"><input type="password" name="password" id="password"></td>
</tr>

<tr style="height: 18px;">
<td style="height: 18px; width: 250px;">Bank</td>
<td style="height: 18px; width: 262px;">
<select name="bankName">
<c:forEach items="${bankName }" var="entry">
<option value="${entry.key }">${entry.value }</option>
</c:forEach>
</select>
</td>
</tr>
<tr style="height: 18px;">
<td style="height: 18px; width: 250px;" colspan="2" align="center"><input type="submit" value="Login" id="LoginButton"></td>
</tr>
</tbody>
</table>
</form>
</c:when>
</c:choose>


</body>
</html>