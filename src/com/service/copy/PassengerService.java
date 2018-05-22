package com.service.copy;

import com.beans.PassengerBean;

public interface PassengerService {
	public PassengerBean verifyUser(String username, String password);
	
	public boolean  updateProfile(int pass_id, String firstname, String lastname, String street, 
			String city, String state, int zipcode, String email);
	
	public PassengerBean register(PassengerBean passengerBean, String userName, String passWord);
}
