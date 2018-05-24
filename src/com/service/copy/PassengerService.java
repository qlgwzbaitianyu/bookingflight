package com.service.copy;

import com.beans.PassengerBean;

public interface PassengerService {
	/*
	 *	Verify User's username and password in database
	 *	input: String username, String password
	 *	output: Corresponding PassengerBean in data base or null
	 */
	public PassengerBean verifyUser(String userName, String passWord);
	
	/*
	 *	Update user or admin's profile
	 *	input: required field for PassengerBean
	 *	output: true success update or false failed update
	 */
	public boolean  updateProfile(int pass_id, String firstName, String lastName, String street, 
			String city, String state, int zipCode, String email);
	
	/*
	 *	Register PassengerBean in data base
	 *	input: new PassengerBean, String username, String password
	 *	output: true success update or false failed update
	 */
	public PassengerBean register(PassengerBean passengerBean, String userName, String passWord);
}


