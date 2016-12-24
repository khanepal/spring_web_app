<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<h1> Login Here </h1>
<hr/>
<label style="color:red;"> ${error_msg}</label>
<form:form action="${pageContext.request.contextPath}/login" commandName = "user" method = "post">

<table>

<tr>
<td><label> Enter Username: </label>
<td>
<form:input type="text" path="username" name = "username"/>
<form:errors path="username" style="color:red;"></form:errors>
</td>
</tr>

<tr>
<td><label> Enter Password: </label>
<td>
<form:input type="password" path = "password" name = "password"/>
<form:errors path="password" style="color:red;"></form:errors>
</td>
</tr>

<tr>
<td></td>
<td><input type="submit" value="Login"></td>
</tr>

</table>

</form:form>
</html>