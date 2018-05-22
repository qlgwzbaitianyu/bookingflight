package com.dao;

import com.beans.PassengerBean;

public interface PassengerDao {
	
	public PassengerBean verify(String username, String password);
	
	public boolean updateProfile(int pass_id, String firstname, String lastname, String street, 
			String city, String state, int zipcode, String email);
	
	public PassengerBean register(PassengerBean passengerBean, String userName, String passWord);

}
