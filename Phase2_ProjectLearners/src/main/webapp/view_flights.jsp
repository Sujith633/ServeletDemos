<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
h1 {text-align: center;}
h2 {text-align: center;}
h3 {text-align: center;}
</style>
<body bgcolor="lightpink">
<h1>All Available Flights List:</h1>
<table border="1"  style="border:1px solid black;margin-left:auto;margin-right:auto;">
<tr>
<th>Id</th>
<th>FlightName</th>
<th>AirLineName</th>
<th>Source</th>
<th>Destination</th>
<th>Price</th>
</tr>

<c:forEach var="flight" items="${flight_list}">

<tr>
<td>${flight.id}</td>
<td>${flight.flightname}</td>
<td>${flight.airlinename}</td>
<td>${flight.source}</td>
<td>${flight.destination}</td>
<td>${flight.numofpass}</td>

</tr>
</c:forEach>
</table>

</body>
</html>