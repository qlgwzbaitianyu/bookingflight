package com.service.copy;

import com.beans.PassengerBean;
import com.dao.PassengerDaoIpm;

public class PassengerServiceIpm implements PassengerService {

	@Override
	public PassengerBean verifyUser(String username, String password) {
		return new PassengerDaoIpm().verify(username, password);
	}

	@Override
	public boolean updateProfile(int pass_id, String firstName, String lastName, String street, String city,
			String state, int zipCode, String email) {
		return new PassengerDaoIpm().updateProfile(pass_id, firstName, lastName, street, city, state, zipCode, email);
	}
	
	public PassengerBean register(PassengerBean passengerBean, String userName, String passWord) {
		return new PassengerDaoIpm().register(passengerBean, userName, passWord);
	}

}
