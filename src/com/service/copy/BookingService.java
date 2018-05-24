package com.service.copy;

import java.util.List;

import com.beans.BookingBean;

public interface BookingService {
	public BookingBean bookFlight(int flightNumber, int passengerId, String classType, String baggage);
	
	public  List<BookingBean> viewReservations(int passengerId); 
	
	public boolean cancelReservation(int BookingId, int flightNumber, String classType);
	
	public  List<BookingBean> viewAllReservations();
	
	
}
