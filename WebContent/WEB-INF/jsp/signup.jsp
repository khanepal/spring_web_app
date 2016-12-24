<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function doValidation(){
	var username = document.getElementById("username").value;
	if(parseInt(username.length) < 4){
		alert("user must be at least 4 characters long");
		return false;
	}
	var password = document.getElementById("password").value;
	var repassword = document.getElementById("repassword").value;
	
	if(parseInt(password.length) < 6){
		alert("Password must be at least 6 characters long");
		return false;
	}
	if(password != repassword){
		alert("Two passwords did not match!")
		return false;
	}
	return true;
}
</script>
</head>
<body>
<div>

<label>${message}</label>

<form action="${pageContext.request.contextPath}/signup" method="post" enctype="multipart/form-data" onSubmit="return doValidation()">

<table>
<tr>
<td> <label>Enter User Name: </label></td>
<td><input id="username" type="text" name="username"/></td>
</tr>
<tr>
<td> <label>Enter Password: </label></td>
<td><input id="password" type="password" name="password"/></td>
</tr>

<tr>
<td> <label>Re-enter Password: </label></td>
<td><input id="repassword" type="password" name="repassword"/></td>
</tr>

<tr>
<td> <label>Choose Gender: </label></td>
<td><input type="radio" name="gender" value="male"/><input type="radio" name="gender" value="female"/></td>
</tr>

<tr>
<td> <label>Select Vehicle: </label></td>
<td><input type="checkbox" name="vehicle" value="Car"/><input type="checkbox" name="vehicle" value="Bike"/></td>
</tr>

<tr>
<td> <label>Select Country </label></td>
<td> 
<select name="country">
<option value="Nepal">Nepal</option>
<option value="USA">USA</option>
<option value="UK">UK</option>
</select>
</td>
</tr>

<tr>
<td><label>Select Image</label></td>
<td> <input type="file" name="image"></td>
</tr>

</table>
<input type="submit" value="Sing Up" name="signup"/>
</form>
</div>
</body>
</html>