package com.beans;

public class FlightBean {
	
	private int flight_number;
	private int seat;
	private String arrtime;
	private String arrdate;
	private String deptime;
	private String depdate;
	private String airport;
	private String depart;
	private String destination;
	private String airplane_producer;
	
	
	public FlightBean(int flight_number, int seat, String arrtime, 
					  String arrdate, String deptime, String depdate, 
					  String airport, String depart, String destination, String airplane_producer){
		this.flight_number = flight_number;
		this.seat = seat;
		this.arrtime = arrtime;
		this.arrdate = arrdate;
		this.deptime = deptime;
		this.depdate = depdate;
		this.airport = airport;
		this.depart = depart;
		this.destination = destination;
		this.airplane_producer = airplane_producer;
	}


	public int getFlight_number() {
		return flight_number;
	}


	public void setFlight_number(int flight_number) {
		this.flight_number = flight_number;
	}


	public int getSeat() {
		return seat;
	}


	public void setSeat(int seat) {
		this.seat = seat;
	}


	public String getArrtime() {
		return arrtime;
	}


	public void setArrtime(String arrtime) {
		this.arrtime = arrtime;
	}


	public String getArrdate() {
		return arrdate;
	}


	public void setArrdate(String arrdate) {
		this.arrdate = arrdate;
	}


	public String getDeptime() {
		return deptime;
	}


	public void setDeptime(String deptime) {
		this.deptime = deptime;
	}


	public String getDepdate() {
		return depdate;
	}


	public void setDepdate(String depdate) {
		this.depdate = depdate;
	}


	public String getAirport() {
		return airport;
	}


	public void setAirport(String airport) {
		this.airport = airport;
	}


	public String getDepart() {
		return depart;
	}


	public void setDepart(String depart) {
		this.depart = depart;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String getAirplane_producer() {
		return airplane_producer;
	}


	public void setAirplane_producer(String airplane_producer) {
		this.airplane_producer = airplane_producer;
	}
	
	

}
