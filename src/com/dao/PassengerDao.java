package com.dao;

import com.beans.PassengerBean;

public interface PassengerDao {
	
	/*
	 *	Verify User's username and password in database
	 *	input: String username, String password
	 *	output: Corresponding PassengerBean in data base or null
	 */
	public PassengerBean verify(String username, String password);
	
	/*
	 *	Update user or admin's profile
	 *	input: required field for PassengerBean
	 *	output: true success update or false failed update
	 */
	public boolean updateProfile(int pass_id, String firstname, String lastname, String street, 
			String city, String state, int zipcode, String email);
	
	/*
	 *	Register PassengerBean in data base
	 *	input: new PassengerBean, String username, String password
	 *	output: true success update or false failed update
	 */
	public PassengerBean register(PassengerBean passengerBean, String userName, String passWord);

}
