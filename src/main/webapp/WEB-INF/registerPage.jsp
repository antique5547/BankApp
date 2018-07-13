<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    <%@ page isELIgnored = "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<td style="height: 12px; width: 262px;"><input type="text" name="fullname"> </td>
</tr>
<tr style="height: 12px;">
<td style="height: 12px; width: 250px;">Username</td>
<td style="height: 12px; width: 262px;"><input type="text" name="uname"> </td>
</tr>
<tr style="height: 18px;">
<td style="height: 18px; width: 250px;">Email Address</td>
<td style="height: 18px; width: 262px;"><input type="text" name="emailId"></td>
</tr>
<tr style="height: 18px;">
<td style="height: 18px; width: 250px;">Password</td>
<td style="height: 18px; width: 262px;"><input type="password" name="password"></td>
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
<td style="height: 18px; width: 250px;" colspan="2" align="center"><input type="submit" value="Register"></td>
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
<td style="height: 12px; width: 262px;"><input type="text" name="uname"> </td>
</tr>
<tr style="height: 18px;">
<td style="height: 18px; width: 250px;">Password</td>
<td style="height: 18px; width: 262px;"><input type="password" name="password"></td>
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
<td style="height: 18px; width: 250px;" colspan="2" align="center"><input type="submit" value="Login"></td>
</tr>
</tbody>
</table>
</form>
</c:when>
</c:choose>


</body>
</html>