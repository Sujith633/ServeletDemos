<%@ page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!
	Connection con;
	PreparedStatement ps;

	public void jspInit() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
			ps = con.prepareStatement("insert into account1 values (?,?,?,?)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void jspDestroy() {
		try {
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}%>
	<%
int account = Integer.parseInt(request.getParameter("accno"));
String fn = request.getParameter("firstname");
String ln = request.getParameter("lastname");
int bal = Integer.parseInt(request.getParameter("balance"));

ps.setInt(1,account);
ps.setString(2,fn);
ps.setString(3,ln);
ps.setInt(4,bal);
ps.executeUpdate();

%>
	<%@ include file = "Account.html" %>
</body>
</html>