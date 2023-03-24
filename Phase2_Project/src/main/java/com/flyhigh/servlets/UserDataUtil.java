package com.flyhigh.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.flyhigh.admin.Admin;

public class UserDataUtil {
	
	List<User> users = new ArrayList<>();
	List<Flights> flights = new ArrayList<>();
	private DataSource datasource;

	public UserDataUtil(DataSource datasource) {
		
		this.datasource = datasource;
	}

	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = datasource.getConnection();
			stmt = con.createStatement();
			ResultSet resultset = stmt.executeQuery("select * from UserLogin order by id");
			while (resultset.next()) {
				
				String id = resultset.getString("id");
				System.out.println("Entered"+id);
				String username = resultset.getString("username");
				String password = resultset.getString("password");
				
				User user = new User(id, username, password);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close(con, stmt, rs);
		}
		return users;
		
	}
	
	
	public boolean values(String username, String password) {
		Connection con = null;
		PreparedStatement stmt = null;
		//ResultSet rs = null;
		
			try {
				con = datasource.getConnection();
				String sql = "select * from UserLogin where Username = ? and Password = ?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, username);
				stmt.setString(2, password);

				ResultSet resultset = null;
				boolean result = stmt.execute();
				if(result)
				resultset = stmt.getResultSet();
			if(resultset.next()) {
				
				System.out.println("User successfully logged in,Navigating to home page");
				String welcomemessage = "Welcome to the FlyAway Admin portal - " + username + "!!";
				return true;	
				
		}
			else {
				
				return false;
			}
			
	}catch (Exception e) {
		e.printStackTrace();
	}
			return false;
		
	}
	private void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	public  List<Flights> getAvailabeFlights(String source, String destination){
		
		List<Flights> flights = new ArrayList<>();

		Connection con = null;
		PreparedStatement stmt = null;
		
		
		Flights flight = null;
		
		try {
			con = this.datasource.getConnection();
			
			String sql =  "select * from flightslist where Source = ? and Destination = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, source);
			stmt.setString(2, destination);
			System.out.println(source);
			System.out.println(destination);
			ResultSet resultSet = null;
		    resultSet=stmt.executeQuery();
		
			resultSet = stmt.getResultSet();
			while (resultSet.next()) {
				int id1 = resultSet.getInt("id");
				String Flightname = resultSet.getString("Flightname");
				String Airlinename = resultSet.getString("Airlinename");
				String Source = resultSet.getString("Source");
				String Destination = resultSet.getString("Destination");
				int price = resultSet.getInt("Price");
				flight = new Flights(id1,Flightname, Airlinename, Source, Destination, price);
				flights.add(flight);
				
			
		   }
		}

		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		System.out.println(flights);
		
		return flights;
		
	}


	

}
