package com.beans;


public class PassengerBean {
	private int pass_id;
	private String username;
	private String usertype;
	private String firstname;
	private String lastname;
	private String street;
	private String city;
	private String state;
	private int zipcode;
	private String email;
	
	
	public PassengerBean(int pass_id, String username, String usertype, 
						String firstname, String lastname, String street, 
						String city, String state, int zipcode, String email ) {
		this.pass_id = pass_id;
		this.username = username;
		this.usertype = usertype;
		this.firstname = firstname;
		this.lastname = lastname;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.email = email;
	}


	public int getPass_id() {
		return pass_id;
	}


	public void setPass_id(int pass_id) {
		this.pass_id = pass_id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUsertype() {
		return usertype;
	}


	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getZipcode() {
		return zipcode;
	}


	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
