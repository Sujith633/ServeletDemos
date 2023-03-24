<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addstudent" method="post">
		<table>
		<tr>
				<td>First Name</td>
				<td><input name="firstname" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input name="lastname" /></td>
			</tr>
			<tr>
				<td>Email Id</td>
				<td><input name="email" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input name="password" type="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="save" /></td>
			</tr>
			<tr>
			<a href="students"> Save </a>
			</tr>
		</table>
	</form>
</body>
</html>