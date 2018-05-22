package com.service.copy;

import java.util.List;

import com.beans.BookingBean;
import com.dao.BookingDaoIpm;

public class BookingServiceIpm implements BookingService {

	@Override
	public BookingBean bookFlight(int flightNumber, int passengerId, String classType, String baggage) {
		return new BookingDaoIpm().bookFlight(flightNumber, passengerId, classType, baggage);
	}

	@Override
	public List<BookingBean> viewReservations(int passengerId) {
		return new BookingDaoIpm().viewReservations(passengerId);
	}
	
	public boolean cancelReservation(int BookingId, int flightNumber, String classType) {
		return new BookingDaoIpm().cancelReservation(BookingId, flightNumber, classType);
	}

	
}
