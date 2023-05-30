package com.flyhigh.servlets;

public class User {
	public String id;
	public String Username;
	public String password;
	public User(String id, String username, String password) {
		super();
		this.id = id;
		Username = username;
		this.password = password;
	}
	public User(String username, String password) {
		super();
		Username = username;
		this.password = password;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", Username=" + Username + ", password=" + password + "]";
	}
	

}
