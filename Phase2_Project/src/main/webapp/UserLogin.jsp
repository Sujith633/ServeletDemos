<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
h1 {text-align: center;}
h2 {text-align: center;}
h3 {text-align: center;}
</style>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
<h1>User Login Page</h1>
	<form action="UserLogin" method="get">

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