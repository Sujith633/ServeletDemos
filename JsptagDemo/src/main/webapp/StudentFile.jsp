<%@ page import="java.util.*,webservices.Students" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%
    List<Students> students = new ArrayList<>();
    students.add(new Students("Hema","Latha",true));
    students.add(new Students("Dhana","Raj",true));
    students.add(new Students("Charan","Cherry",false));
    pageContext.setAttribute("mystudents",students);

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="4">
<tr>
<th>FirstName</th>
<th>LastName</th>
<th>Discount</th>
</tr>

<c:forEach var="student" items="${mystudents}">
<tr>
<td>${student.firstname}</td>
<td>${student.lastname}</td>
<td>
<c:if test="${student.ab90per }">
Yes
</c:if>
<c:if test="${not student.ab90per }">
N.A.
</td>

</c:if>
</c:forEach>
</table>
</body>
</html>