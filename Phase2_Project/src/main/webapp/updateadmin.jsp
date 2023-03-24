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
<title>Update Admin</title>
</head>
<body>
<h1>Update Admin Password</h1>

	<form action="UpdateAdmin" method="Get">
<table border="1"  style="border:1px solid black;margin-left:auto;margin-right:auto;">
			
			<tr>
				<td>Username</td>
				<td><input type="text" name="username"/></td>
			</tr>
			
			<tr>
				<td>Password</td>
				<td><input name="password" type="password"/></td>
			</tr>
			
		</table>
		<h3><input type="submit" value="Update"/></h3>
	</form>
	

</body>
</html>