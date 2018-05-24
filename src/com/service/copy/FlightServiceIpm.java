package com.service.copy;

import java.util.List;

import com.beans.FlightBean;
import com.dao.FlightDaoIpm;

public class FlightServiceIpm implements FlightService {

	@Override
	public  List<FlightBean> searchFlight(String depart, String destination, String depdate) {
		
		return new FlightDaoIpm().searchFlight(depart, destination, depdate);
	}

	@Override
	public boolean addFlight(FlightBean flightBean, int first_class, int business_class, int economy_class) {
		return new FlightDaoIpm().addFlight(flightBean, first_class, business_class, economy_class);
	}

	@Override
	public List<FlightBean> viewFlight() {
		return new FlightDaoIpm().viewFlight();
	}

	@Override
	public boolean updateFlight(FlightBean flightBean) {
		return new FlightDaoIpm().updateFlight(flightBean);
	}

	@Override
	public boolean cancelFlight(String FlightNumber) {
		return new FlightDaoIpm().cancelFlight(FlightNumber);
	}
	

}
