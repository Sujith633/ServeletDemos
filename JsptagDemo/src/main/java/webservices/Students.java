package webservices;

public class Students {
	public Students(String firstname, String lastname, boolean ab90per) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.ab90per = ab90per;
	}
	private String firstname;
	private String lastname;
	private boolean ab90per;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public boolean isAb90per() {
		return ab90per;
	}
	public void setAb90per(boolean ab90per) {
		this.ab90per = ab90per;
	}
	
	

}
