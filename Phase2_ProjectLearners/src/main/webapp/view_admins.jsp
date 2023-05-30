<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admins List</title>
</head>
<style>
h1 {text-align: center;}
h2 {text-align: center;}
h3 {text-align: center;}
</style>
<body bgcolor="lightblue">
<h1>Admins List</h1>
		<table border="1"  style="border:1px solid black;margin-left:auto;margin-right:auto;">

<tr>
<th>Id</th>
<th>Username</th>
<th>Password</th>
</tr>

<c:forEach var="admin" items="${admins_list}">

<tr>
<td>${admin.id}</td>
<td>${admin.username}</td>
<td>${admin.password}</td>

</tr>
</c:forEach>
</table>
<h1><a href="Index.html">Home</a></h1>
</body>
</html>