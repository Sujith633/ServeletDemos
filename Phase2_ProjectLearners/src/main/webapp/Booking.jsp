<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking</title>
</head>
<style>
h1 {
	text-align: center;
}
</style>
<body bgcolor="lightblue">
	<h1>Welcome to the Flyhigh ticket booking portal</h1>
	<form action="User_TicketBooking" method="get">
		
		<table
			style="border: 1px solid black; margin-left: auto; margin-right: auto;">
			<tr>
			<td>
			<label for="start">Date of traveling:</label></td>
			<td> <input type="date"
			id="start" name="date" value="2023-03-01" min="2023-01-01"
			max="2023-04-01">
			</td>
			</tr>

			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" /></td>
			</tr>

			<tr>
				<td>EmailId:</td>
				<td><input type="text" name="emailid" /></td>
			</tr>
			<tr>
				<td>Source:</td>
				<td><input type="text" name="source" /></td>
			</tr>
			<tr>
				<td>Destination:</td>
				<td><input type="text" name="destination" /></td>
			</tr>
			<tr>
				<td>No.of passangers:</td>
				<td><input type="number" name="numofpass" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>


		</table>
	</form>
</body>
</html>