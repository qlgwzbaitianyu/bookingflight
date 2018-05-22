package com.dao;

import java.util.List;

import com.beans.FlightBean;

public interface FlightDao {
	
	public  List<FlightBean> searchFlight(String depart, String destination, String depdate); 

}
