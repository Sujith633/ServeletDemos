package com.flyhigh.servlets;

public class Flights {
	private int id;
	private String flightname;
	private String airlinename;
	private String source;
	private String destination;
	private int numofpass;
	
	
	public Flights(int id, String flightname, String airlinename, String source, String destination, int numofpass) {
		super();
		this.id = id;
		this.flightname = flightname;
		this.airlinename = airlinename;
		this.source = source;
		this.destination = destination;
		this.numofpass = numofpass;
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Flights(String flightname, String airlinename, String source, String destination, int numofpass) {
		super();
		this.flightname = flightname;
		this.airlinename = airlinename;
		this.source = source;
		this.destination = destination;
		this.numofpass = numofpass;
	}



	public String getFlightname() {
		return flightname;
	}

	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}

	public String getAirlinename() {
		return airlinename;
	}

	public void setAirlinename(String airlinename) {
		this.airlinename = airlinename;
	}

	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getNumofpass() {
		return numofpass;
	}
	public void setNumofpass(int numofpass) {
		this.numofpass = numofpass;
	}



	@Override
	public String toString() {
		return "Flights [id=" + id + ", flightname=" + flightname + ", airlinename=" + airlinename + ", source="
				+ source + ", destination=" + destination + ", price =" + numofpass + "]";
	}
	
	

}
