package com.beans;

public class BookingBean {
	private int bookId = 0;
	private int passengerId;
	private int flightNumber;
	private int seatNumber;
	private String baggage;
	private String classType;
	private String reservStatus;
	
	public BookingBean(int bookId, int passengerId, int flightNumber, int seatNumber, String baggage, String classType, String reservStatus){
		this.passengerId = passengerId;
		this.flightNumber = flightNumber;
		this.seatNumber = seatNumber;
		this.baggage = baggage;
		this.classType = classType;
		this.reservStatus = reservStatus;
		this.bookId = bookId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getBaggage() {
		return baggage;
	}

	public void setBaggage(String baggage) {
		this.baggage = baggage;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public String getReservStatus() {
		return reservStatus;
	}

	public void setReservStatus(String reservStatus) {
		this.reservStatus = reservStatus;
	}
	
	

}
