package com.service.copy;

import com.beans.PassengerBean;
import com.dao.PassengerDaoIpm;

public class PassengerServiceIpm implements PassengerService {

	@Override
	public PassengerBean verifyUser(String username, String password) {
		return new PassengerDaoIpm().verify(username, password);
	}

}
