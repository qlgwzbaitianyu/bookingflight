package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.beans.PassengerBean;
import com.dbtuil.DBUtil;

public class PassengerDaoIpm implements PassengerDao {

	@Override
	public PassengerBean verify(String userName, String passWord) {
		Connection conn = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		PassengerBean pb = null;
		String query = "select * from logintable "
				+ "inner join passenger "
				+ "on logintable.username = passenger.username "
				+ "where logintable.username = ? and logintable.password = ?;";
		DBUtil dbutil = new DBUtil();
		
		try {
			conn = dbutil.loadDriver();			/* load driver and set preparestatement*/
			ps = dbutil.getPreparedStatement(conn, query);
			ps.setString(1, userName);
			ps.setString(2, passWord);
			rs = ps.executeQuery();
			
			/* no match return null other wise return new passengerbean */
			if(rs.next() == false) {
				System.out.println("no match!");
				return null;
			}
			else {
				pb = new PassengerBean(rs.getInt(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getString(7), 
						rs.getString(8), rs.getString(9), rs.getString(10), 
						rs.getInt(11), rs.getString(12));		
			}
		}catch (Exception e) {		/* database exception handling */
			e.printStackTrace();
		}
		dbutil.closeDbResources(conn, ps, rs); /* close db resource */
		return pb;
	}

	@Override
	public boolean updateProfile(int pass_id, String firstName, String lastName, String street, String city, String state, int zipCode,
			String email) {
		boolean updateResult = true;
		Connection conn = null;
		PreparedStatement ps=null;
		PassengerBean pb = null;
		DBUtil dbutil = new DBUtil();
		String query ="update passenger set" + 
				" firstname = ?, lastname = ?, street = ?, city = ?, state = ?, zipcode = ?, email = ? " + 
				" where pass_id = ?;";
		
		try {
			conn = dbutil.loadDriver();
			ps = dbutil.getPreparedStatement(conn, query);
			ps.setString(1, firstName);		/* set prepare satement and update passengerbean*/
			ps.setString(2, lastName);
			ps.setString(3, street);
			ps.setString(4, city);
			ps.setString(5, state);
			ps.setInt(6, zipCode);
			ps.setString(7, email);
			ps.setInt(8, pass_id);
			ps.executeUpdate();
		}catch (Exception e) {		/* database exception handling */
				e.printStackTrace();
		}
			
		dbutil.closeDbResources(conn, ps); /* close db resource */
		return updateResult;
	}

	@Override
	public PassengerBean register(PassengerBean passengerBean, String userName, String passWord) {
		Connection conn = null;
		PreparedStatement ps=null;
		PassengerBean pb = null;
		DBUtil dbutil = new DBUtil();
		String queryInsertLogin = "insert into logintable values(?, ?);";
		String queryInsertPassenger = "insert into passenger values(0, ?, 'user', ?, ?, ?, ?, ?, ?, ?);";
		
		try {			/* before create new passnger, insert new row into login table of username and password*/
			conn = dbutil.loadDriver();
			ps = dbutil.getPreparedStatement(conn, queryInsertLogin);
			ps.setString(1, userName);
			ps.setString(2, passWord);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try {		/* create new passenger bean*/
			ps = dbutil.getPreparedStatement(conn, queryInsertPassenger);
			ps.setString(1, userName);
			ps.setString(2, passengerBean.getFirstname());
			ps.setString(3, passengerBean.getLastname());
			ps.setString(4, passengerBean.getStreet());
			ps.setString(5, passengerBean.getCity());
			ps.setString(6, passengerBean.getState());
			ps.setInt(7, passengerBean.getZipcode());
			ps.setString(8, passengerBean.getEmail());
			ps.executeUpdate();
		}catch (Exception e) {		/* database exception handling */
				e.printStackTrace();
		}
			
		dbutil.closeDbResources(conn, ps); /* close db resource */
		return null;
	}
	

}
