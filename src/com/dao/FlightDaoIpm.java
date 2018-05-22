package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.beans.FlightBean;
import com.beans.PassengerBean;
import com.dbtuil.DBUtil;

public class FlightDaoIpm implements FlightDao {

	@Override
	public List<FlightBean> searchFlight(String depart, String destination, String depdate) {
		Connection conn = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<FlightBean> flightlist = new LinkedList<FlightBean>();
		DBUtil dbutil = new DBUtil();		
		String query = "select * from flight where depart = ? and destination = ? and depdate = ?;";
		
		try {
			conn = dbutil.loadDriver();
			ps = dbutil.getPreparedStatement(conn, query);
			ps.setString(1, depart);
			ps.setString(2, destination);
			ps.setString(3, depdate);
			rs = ps.executeQuery();
			
			// save results to flightlist
			while(rs.next()) {
				FlightBean tempbean = new FlightBean(rs.getInt(1), rs.getInt(2), 
						rs.getString(3), rs.getString(4), rs.getString(5), 
						rs.getString(6), rs.getString(7), rs.getString(8), 
						rs.getString(9), rs.getString(10));
				flightlist.add(tempbean);
			}
		} catch (Exception e) {
			// database exception handling
			e.printStackTrace();
		}
		// close db resource
		dbutil.closeDbResources(conn, ps);
		return flightlist;
	}

}
