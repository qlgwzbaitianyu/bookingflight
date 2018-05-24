package com.dao;

import java.util.List;

import com.beans.BookingBean;
import com.beans.FlightBean;

public interface BookingDao {
	public BookingBean bookFlight(int flightNumber, int passengerId, String classType, String baggage);

	public int getBookingId(int flightNumber, int passengerNumber, int seatNumber, String classType);
	
	public  List<BookingBean> viewReservations(int passengerId);
	
	public  List<BookingBean> viewAllReservations();
	
	public boolean cancelReservation(int BookingId, int flightNumber, String classType);
	
	

}
