package com.dao;

import java.util.List;

import com.beans.FlightBean;

public interface FlightDao {
	
	/*
	 *	search the flight
	 *	input: flight depart, destination and depart date
	 *	output: list of flightbean
	 */
	public  List<FlightBean> searchFlight(String depart, String destination, String depdate);	
	
	/*
	 *	add the flight into table
	 *	input: flight bean, totall seat number for 3 classes
	 *	output: true/false
	 */
	public boolean addFlight(FlightBean flightBean, int first_class, int business_class, int economy_class);
	
	/*
	 *	search all existing flights
	 *	input: 
	 *	output: list of flightbean
	 */
	public List<FlightBean> viewFlight();
	
	/*
	 *	update the flight
	 *	input: flight bean
	 *	output: true/false
	 */
	public boolean updateFlight(FlightBean flightBean);
	
	/*
	 *	delete the flightbean from table
	 *	input: flight number
	 *	output: true/false
	 */
	public boolean cancelFlight(String FlightNumber);

}
