<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to home</title>
<link href='<c:url value="/css/style.css"></c:url>' rel="stylesheet">
<script type="text/javascript" src='<c:url value="/js/demo.js"></c:url>'></script>
</head>
<body>
	
	
	<img alt="demo" src='<c:url value="/img/logoMentorMe.jpg"></c:url>'>
	
	
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.8";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>

<table style="width:80%" border="0" align="center">

<tr>
<td></td><td align="right"><div class="fb-like" data-href="http://www.google.com" data-layout="button" data-action="like" data-size="small" data-show-faces="true" data-share="true"></div></td>
</tr>

<tr>
<td width="40%"> <img src="../images/logoMentorMe.jpg"/> </td> 

<td>
<table style="width:80%" border="0">
<tr>
<td align="center">About Us</td>
<td align="center">Contact Us</td>
<td align="center"><a class="demo" href = "${pageContext.request.contextPath}/login">Login</a></td></tr>
</table>
</td>
</tr>

<tr>

<td align="center">
<video width="320" height="240" controls>
  <source src="../videos/intro.mp4" type="video/mp4">
</video>
</td>

<td align="center" bgcolor="lightgreen">
It's totally free for your growth opportunity! <br><br>
Join this exciting community to unlock your potentiality, and become a leader. <br><br>
<a class="demo" href = "${pageContext.request.contextPath}/signup">SignUp</a>
</td>
</tr>

<tr>
<td></td><td> <br>MentorMeNepal's mission is to create a platform where passionate people <br> who either want to mentor or mentee to help each other can come together and explore the untammped potentiality of the mentor Read More >> </td>
</tr>

<tr>

<td align="center">
What people has to say about MentorMe Nepal.com? <br>
<video width="320" height="240" controls>
  <source src="../videos/intro.mp4" type="video/mp4">
</video>
</td>

<td align="center">
How it works? <br><br>
If you are either interested to become mentor or looking for a mentor to develop your skills, <br> and want to join MentorMeNepal community, you need to register.
Once you register, you can read the profile of mentor, or mentee <br> and offer to mentor (if you are mentor) or request to become your mentor. Then, another party will get notification... etc.
</td>

</tr>

</table>

<table style="width:80%" cellspacing="0" align="center">
<tr bgcolor="lightblue">
<td align="left">&#169;MentorMeNepal</td>
<td align="center">Believe in yourself!</td>
<td align="right">&#8482;MentorMeNepal</td>
</tr>
</table>
	
	
</body>
</html>