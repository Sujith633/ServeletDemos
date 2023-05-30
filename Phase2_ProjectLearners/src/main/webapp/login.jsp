<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<style>
h1 {text-align: center;}
h2 {text-align: center;}
h3 {text-align: center;}
</style>
<body align="center" bgcolor=#d0bdf4 >
	<h1>Admin Login Page</h1>
	<form action="AdminLogin" method="get">
<table border="1"  style="border:1px solid black;margin-left:auto;margin-right:auto;">
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" /></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><input name="password" type="password" /></td>
			</tr>
			

		</table>
		<h3><input type="submit" value="Login"/></h3>
	</form>
</body>
</html>