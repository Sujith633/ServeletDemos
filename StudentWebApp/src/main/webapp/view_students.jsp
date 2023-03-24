<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
</head>
<body>
<table border="1">
<tr>
<th>Id</th>
<th>FirstName</th>
<th>LastName</th>
<th>Email</th>
</tr>

<c:forEach var="student" items="${students_list}">

<tr>
<td>${student.id}</td>
<td>${student.firstname}</td>
<td>${student.lastname}</td>
<td>${student.email}</td>

<td><a href="deletestudent?studentId=${student.id}">Delete</a>
</tr>
</c:forEach>
</table>

</body>
</html>