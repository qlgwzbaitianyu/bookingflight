package com.dao;

import com.beans.PassengerBean;

public interface PassengerDao {
	
	public PassengerBean verify(String username, String password);

}
