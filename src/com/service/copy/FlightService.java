package com.service.copy;

import java.util.List;

import com.beans.FlightBean;

public interface FlightService {

	public  List<FlightBean> searchFlight(String depart, String destination, String depdate); 

}
