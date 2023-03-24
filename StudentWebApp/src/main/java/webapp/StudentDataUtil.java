package webapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;



public class StudentDataUtil {
	
	List<Admin> admins = new ArrayList<>();
	
	private DataSource datasource;

	public StudentDataUtil(DataSource datasource) {
		
		this.datasource = datasource;
	}
	public List<Admin> getStudents(){
		List<Admin> admins = new ArrayList<>();
		
		Connection con=null;
		Statement stmt = null;
		ResultSet rs= null;
		try {
			con = datasource.getConnection();
			stmt = con.createStatement();
			ResultSet resultset = stmt.executeQuery("select * from student order by id");
			while(resultset.next()) {
				int id = resultset.getInt("id");
				String fname=resultset.getString("first_name");
				String lname=resultset.getString("last_name");
				String email=resultset.getString("email");
				Admin admin = new Admin(id,fname,lname,email);
				admins.add(admin);
		}
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}finally {
			close(con,stmt,rs);
		}
		return admins;
	}
	private void close(Connection con, Statement stmt, ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
}
	public void addStudent( String firstname, String lastname, String email) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con= this.datasource.getConnection();
			String sql  = "insert into student (first_name, last_name, email)" + "values (?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, firstname);
			stmt.setString(2, lastname);
			stmt.setString(3, email);
			stmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con , stmt, null);
		}
	}
	
}