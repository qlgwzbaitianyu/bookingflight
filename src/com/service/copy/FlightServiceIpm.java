package com.service.copy;

import java.util.List;

import com.beans.FlightBean;
import com.dao.FlightDaoIpm;

public class FlightServiceIpm implements FlightService {

	@Override
	public  List<FlightBean> searchFlight(String depart, String destination, String depdate) {
		
		return new FlightDaoIpm().searchFlight(depart, destination, depdate);
	}

}
