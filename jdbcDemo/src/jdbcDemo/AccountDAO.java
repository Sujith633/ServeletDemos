package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs =null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
		    statement = connection.createStatement();
		    rs = statement.executeQuery("select * from user1");
			while(rs.next()) {
				
				String lastname = rs.getString(2);
				String firstname = rs.getString(1);
				String email = rs.getString(3);
				String password = rs.getString(4);
				System.out.println("|"+lastname+"|"+firstname+"|"+email+"|"+password);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			//cleanup
			
			try {
				rs.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
