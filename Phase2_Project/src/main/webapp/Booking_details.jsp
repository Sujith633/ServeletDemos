<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm Booking</title>
</head>
<style>
h1 {text-align: center;}
h2 {text-align: center;}
h3 {text-align: center;}
</style>
<body>
	<h1>Welcome to the booking portal</h1>
	<h2>Enter the following details to register the flight tickets</h2>
	<h3>Proceed to paymet</h3>
	<form action="Payment" method="get">
		
		<table border="1"
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
				<td>Phoneno:</td>
				<td><input type="number" name="phone" /></td>
			</tr>

			<tr>
				<td>Name of the bank:</td>
				<td><input type="text" name="bankname" /></td>
			</tr>

			<tr>
				<td>Cardno:</td>
				<td><input type="number" name="card" /></td>
			</tr>

		</table>
<h3><input type="submit" value="Pay" /></h3>
	</form>
</body>
</html>