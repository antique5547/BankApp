<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>userEditPage</title>
<script type="text/javascript">
$("#userUpdateButton").on('click',function(){
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
	return true;
	
})
</script>
</head>
<body>

<c:choose>
<c:when test="${isEdit eq 'YES'}">
<h3 style="text-align: center;">Add/Edit Details</h3>
<form action="updateProfile.bapp">
<table style="width: 460px;" align="center">
<tbody>
<tr>
<td style="width: 175px;"><strong>Fullname</strong></td>
<td style="width: 293px;"><input type="text" value="${userDetails.fullName }" name="fullName" id="fullname"></td>
</tr>
<tr>
<td style="width: 175px;"><strong>Username</strong></td>
<td style="width: 293px;"><input type="text" value="${userDetails.userName }" name="userName" id="uname" readonly="readonly"></td>
</tr>
<tr>
<td style="width: 175px;"><strong>Password</strong></td>
<td style="width: 293px;"><input type="password" value="${userDetails.password }" name="password" id="password"></td>
</tr>
<tr>
<td style="width: 175px;"><strong>Email ID</strong></td>
<td style="width: 293px;"><input type="text" value="${userDetails.emailId }" name="emailId" id="emailId"></td>
</tr>
<tr>
<td style="width: 175px;"><strong>Bank Name</strong></td>
<td style="width: 293px;">
<select name="bankName" disabled="disabled">
<c:forEach items="${bankName }" var="entry">
<c:choose>
<c:when test="${entry.key eq userDetails.bankName}">
<option value="${entry.key }" selected="selected">${entry.value }</option>
</c:when>
<c:otherwise>
<option value="${entry.key }">${entry.value }</option>
</c:otherwise>
</c:choose>
</c:forEach>
</select>
</tr>
<tr>
<td style="width: 175px;"><strong>Country</strong></td>
<td style="width: 293px;"><input type="text" value="${userDetails.address.country }" name="country"></td>
</tr>
<tr>
<td style="width: 175px;"><strong>Locality</strong></td>
<td style="width: 293px;"><input type="text" value="${userDetails.address.locality }" name="locality"></td>
</tr>
<tr>
<td style="width: 175px;"><strong>District</strong></td>
<td style="width: 293px;"><input type="text" value="${userDetails.address.district }" name="district"></td>
</tr>
<tr>
<td style="width: 175px;"><strong>State</strong></td>
<td style="width: 293px;"><input type="text" value="${userDetails.address.state}" name="state"></td>
</tr>
<tr>
<td style="width: 175px;"><strong>Pin Code</strong></td>
<td style="width: 293px;"><input type="text" value="${userDetails.address.pinCode }" name="pinCode"></td>
</tr>
<tr>
<td style="width: 293px;" colspan="2"><input type="submit" value="UPDATE" id="userUpdateButton"></td>
</tr>
</tbody>
</table>
</form>
</c:when>

<c:when test="${viewUsers eq 'YES'}">
<h3 style="text-align: center;">Profile Details</h3>
<table style="width: 460px;" align="center">
<tbody>
<tr>
<td style="width: 175px;"><strong>Fullname</strong></td>
<td style="width: 293px;">${userDetails.fullName }</td>
</tr>
<tr>
<td style="width: 175px;"><strong>Username</strong></td>
<td style="width: 293px;">${userDetails.userName }</td>
</tr>
<tr>
<td style="width: 175px;"><strong>Password</strong></td>
<td style="width: 293px;">${userDetails.password }</td>
</tr>
<tr>
<td style="width: 175px;"><strong>Email ID</strong></td>
<td style="width: 293px;">${userDetails.emailId }</td>
</tr>
<tr>
<td style="width: 175px;"><strong>Bank Name</strong></td>
<td style="width: 293px;">${userDetails.bankName }</td>
</tr>
<tr>
<td style="width: 175px;"><strong>Country</strong></td>
<td style="width: 293px;">${userDetails.address.country }</td>
</tr>
<tr>
<td style="width: 175px;"><strong>Locality</strong></td>
<td style="width: 293px;">${userDetails.address.locality }</td>
</tr>
<tr>
<td style="width: 175px;"><strong>District</strong></td>
<td style="width: 293px;">${userDetails.address.district }</td>
</tr>
<tr>
<td style="width: 175px;"><strong>State</strong></td>
<td style="width: 293px;">${userDetails.address.state}</td>
</tr>
<tr>
<td style="width: 175px;"><strong>Pin Code</strong></td>
<td style="width: 293px;">${userDetails.address.pinCode }</td>
</tr>
</tbody>
</table>
</c:when>

<c:when test="${isAccountDetails eq 'YES'}">
<h3 style="text-align: center;">Account Details</h3>
<table style="width: 460px;" align="center">
<tbody>
<tr>
<td style="width: 175px;"><strong>Username</strong></td>
<td style="width: 293px;">${accountsDetails.userName }</td>
</tr>
<tr>
<td style="width: 175px;"><strong>Bank Name</strong></td>
<td style="width: 293px;">${accountsDetails.bankName }</td>
</tr>
<tr>
<td style="width: 175px;"><strong>Bank A/C Number</strong></td>
<td style="width: 293px;">${accountsDetails.accDetails.accNo }</td>
</tr>
<tr>
<td style="width: 175px;"><strong>Balance</strong></td>
<td style="width: 293px;">${accountsDetails.accDetails.accBal }</td>
</tr>
</tbody>
</table>
</c:when>

<c:when test="${isDepositPage eq 'YES' }">
<h3 style="text-align: center;">Deposit Balance</h3>
<form action="depositBal.bapp">
<table style="width: 460px;" align="center">
<tbody>
<tr>
<td style="width: 175px;"><strong>Username</strong></td>
<td style="width: 293px;">${accountsDetails.userName }</td>
</tr>
<tr>
<td style="width: 175px;"><strong>Bank Name</strong></td>
<td style="width: 293px;">${accountsDetails.bankName }</td>
</tr>
<tr>
<td style="width: 175px;"><strong>Bank A/C Number</strong></td>
<td style="width: 293px;">${accountsDetails.accDetails.accNo }</td>
</tr>
<tr>
<td style="width: 175px;"><strong>Balance</strong></td>
<td style="width: 293px;">${accountsDetails.accDetails.accBal }</td>
</tr>
<tr>
<td style="width: 175px;"><strong>Enter Amount to Deposit</strong></td>
<td style="width: 293px;"><input type="text" value="0" name="amount"></td>
</tr>
<tr>
<td style="width: 293px;" colspan="2"><input type="submit" value="DEPOSIT"></td>
</tr>
</tbody>
</table>
</form>
</c:when>


<c:when test="${isWithdrawPage eq 'YES' }">
<h3 style="text-align: center;">Withdraw Balance</h3>
<form action="withdrawBal.bapp">
<table style="width: 460px;" align="center">
<tbody>
<tr>
<td style="width: 175px;"><strong>Username</strong></td>
<td style="width: 293px;">${accountsDetails.userName }</td>
</tr>
<tr>
<td style="width: 175px;"><strong>Bank Name</strong></td>
<td style="width: 293px;">${accountsDetails.bankName }</td>
</tr>
<tr>
<td style="width: 175px;"><strong>Bank A/C Number</strong></td>
<td style="width: 293px;">${accountsDetails.accDetails.accNo }</td>
</tr>
<tr>
<td style="width: 175px;"><strong>Balance</strong></td>
<td style="width: 293px;">${accountsDetails.accDetails.accBal }</td>
</tr>
<tr>
<td style="width: 175px;"><strong>Enter Amount to Withdraw</strong></td>
<td style="width: 293px;"><input type="text" value="0" name="amount"></td>
</tr>
<tr>
<td style="width: 293px;" colspan="2"><input type="submit" value="WITHDRAW"></td>
</tr>
</tbody>
</table>
</form>
</c:when>

<c:when test="${isStatementPage eq 'YES' }">
<h3 style="text-align: center;">Statements Details</h3>

<p align="center">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<strong>Username :</strong>&nbsp; ${uDetails.userName },&nbsp; &nbsp;<strong>BankName :</strong> ${uDetails.bankName },&nbsp; <strong>Bank A/C No : </strong>${uDetails.accDetails.accNo },&nbsp; <strong>Bal </strong>:&nbsp; ${uDetails.accDetails.accBal }</p>
<table style=" margin-left: auto; margin-right: auto;" width="100%" border="1" cellspacing="0">
<tbody>
<tr style="height: 15px;">
<td style="width: 50px; "><strong>Sr.No</strong></td>
<td style="width: 113px; "><strong>Type</strong></td>
<td style="width: 114px; "><strong>Time</strong></td>
<td style="width: 115px; ;"><strong>Amount</strong></td>
</tr>
<c:set var="count" value="0" scope="page"></c:set>
<c:forEach var="acStmt" items="${statements}">
<tr style="height: 15px;">
<c:set var="count" value="${count + 1}" scope="page"/>
<td style="width: 50px; ">${count }</td>
<td style="width: 113px; ">${acStmt.type }</td>
<td style="width: 114px; ">${acStmt.time }</td>
<td style="width: 115px; ">${acStmt.amount }</td>
</tr>
</c:forEach>
</tbody>
</table>
</c:when>
<c:otherwise></c:otherwise>
</c:choose>



</body>
</html>