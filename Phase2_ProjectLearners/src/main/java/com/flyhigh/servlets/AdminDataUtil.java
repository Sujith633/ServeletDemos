package com.flyhigh.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.sql.DataSource;

import com.flyhigh.admin.Admin;

public class AdminDataUtil {
	List<Admin> admins = new ArrayList<>();
	List<Flights> flights = new ArrayList<>();

	private DataSource datasource;

	public AdminDataUtil(DataSource datasource) {

		this.datasource = datasource;
	}

	public List<Admin> getAdmins() {
		List<Admin> admins = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = datasource.getConnection();
			stmt = con.createStatement();
			ResultSet resultset = stmt.executeQuery("select * from AdminLogin order by id");
			while (resultset.next()) {

				String id = resultset.getString("id");
				System.out.println("Entered" + id);
				String username = resultset.getString("username");
				String password = resultset.getString("password");

				Admin admin = new Admin(id, username, password);
				admins.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close(con, stmt, rs);
		}
		return admins;
	}

	public boolean values(String username, String password) {

		Connection con = null;
		PreparedStatement stmt = null;
		// ResultSet rs = null;

		try {
			con = datasource.getConnection();
			String sql = "select * from AdminLogin where Username = ? and Password = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);

			ResultSet resultset = null;
			boolean result = stmt.execute();
			if (result)
				resultset = stmt.getResultSet();
			if (resultset.next()) {
				System.out.println("User successfully logged in,Navigating to home page");
				String welcomemessage = "Welcome to the FlyAway Admin portal - " + username + "!!";
				return true;

			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private static void close(Connection con, Statement stmt, ResultSet rs) {
		// TODO Auto-generated method stub
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

	public void UpdateAdmin(String username, String password) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			// get connection from connection pool
			con = this.datasource.getConnection();
			String sql = "UPDATE AdminLogin SET Password = ? WHERE Username = ?";
			stmt = con.prepareStatement(sql);

			stmt.setString(1, password);
			stmt.setString(2, username);
			stmt.execute();
			System.out.println("updated " + stmt.execute());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, null);
		}
	}

	public List<Flights> getFlights() {
		List<Flights> flights = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;

		Flights flight = null;
		try {
			// get connection from connection pool
			con = this.datasource.getConnection();

			stmt = con.createStatement();

			// ResultSet resultset = stmt.executeQuery("select * from AdminLogin order by
			// id");

			ResultSet resultSet = stmt.executeQuery("select * from flightslist order by id");

			while (resultSet.next()) {
				int id1 = resultSet.getInt("id");

				String Flightname = resultSet.getString("Flightname");
				String Airlinename = resultSet.getString("Airlinename");
				String Source = resultSet.getString("Source");
				String Destination = resultSet.getString("Destination");
				int price = resultSet.getInt("Price");
				flight = new Flights(id1, Flightname, Airlinename, Source, Destination, price);
				flights.add(flight);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, null);
		}
		return flights;
	}

}
