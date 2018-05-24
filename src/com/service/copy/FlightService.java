package com.service.copy;

import java.util.List;

import com.beans.FlightBean;

public interface FlightService {

	public  List<FlightBean> searchFlight(String depart, String destination, String depdate); 
	
	public boolean addFlight(FlightBean flightBean, int first_class, int business_class, int economy_class);
	
	public List<FlightBean> viewFlight();
	
	public boolean updateFlight(FlightBean flightBean);
	
	public boolean cancelFlight(String FlightNumber);
}
