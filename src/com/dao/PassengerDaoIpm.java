package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.beans.PassengerBean;
import com.dbtuil.DBUtil;

public class PassengerDaoIpm implements PassengerDao {

	@Override
	public PassengerBean verify(String username, String password) {
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
			conn = dbutil.loadDriver();
			ps = dbutil.getPreparedStatement(conn, query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			// no match return null other wise return new bean
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
		} catch (Exception e) {
			// database exception handling
			e.printStackTrace();
		}
		
		// close db resource
		dbutil.closeDbResources(conn, ps);
		return pb;
	}
	

}
