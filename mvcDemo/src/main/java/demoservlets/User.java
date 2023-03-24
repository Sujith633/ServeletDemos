package demoservlets;

public class User {
	private String firstname;
	private String Lastname;
	private String email;
	private int userID;
	public User(String firstname, String lastname, String email, int userID) {
		super();
		this.firstname = firstname;
		Lastname = lastname;
		this.email = email;
		this.userID = userID;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	

}
