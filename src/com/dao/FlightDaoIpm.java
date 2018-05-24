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

	@Override
	public boolean addFlight(FlightBean flightBean, int first_class, int business_class, int economy_class) {
		boolean addFlightResult = false;
		boolean getFlightId = false;
		boolean addSeat = false;
		Connection conn = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<FlightBean> flightlist = new LinkedList<FlightBean>();
		DBUtil dbutil = new DBUtil();
		int flightId = 0;
		String queryInsertFlight = "insert into flight values(0, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		String queryInsertSeat = "insert into seat values(?, ?, ?, ?);";
		String queryGetFlitId = "SELECT MAX(flight_number) FROM flight;";
		
		try {	/* first insert the flight bean*/
			conn = dbutil.loadDriver();
			ps = dbutil.getPreparedStatement(conn, queryInsertFlight);
			ps.setInt(1, flightBean.getSeat());
			ps.setString(2, flightBean.getArrtime());
			ps.setString(3, flightBean.getArrdate());
			ps.setString(4, flightBean.getDeptime());
			ps.setString(5, flightBean.getDepdate());
			ps.setString(6, flightBean.getAirport());
			ps.setString(7, flightBean.getDepart());
			ps.setString(8, flightBean.getDestination());
			ps.setString(9, flightBean.getAirplane_producer());
			if(ps.executeUpdate() != 0) {
				addFlightResult = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {	/* find out the flight number*/
			ps = dbutil.getPreparedStatement(conn, queryGetFlitId);
			rs = ps.executeQuery();
			if(rs.next() != false) {
				flightId = rs.getInt(1);
				getFlightId = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {	/* insert seat */
			ps = dbutil.getPreparedStatement(conn, queryInsertSeat);
			ps.setInt(1, flightId);
			ps.setInt(2, first_class);
			ps.setInt(3, business_class);
			ps.setInt(4, economy_class);
			if(ps.executeUpdate() != 0) {
				addSeat = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(addFlightResult && getFlightId && addSeat) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<FlightBean> viewFlight() {
		Connection conn = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<FlightBean> flightlist = new LinkedList<FlightBean>();
		DBUtil dbutil = new DBUtil();		
		String query = "select * from flight;";
		
		try {
			conn = dbutil.loadDriver();
			ps = dbutil.getPreparedStatement(conn, query);
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

	@Override
	public boolean updateFlight(FlightBean flightBean) {
		boolean updateResult = false;
		Connection conn = null;
		PreparedStatement ps=null;
		DBUtil dbutil = new DBUtil();
		String updateFlight ="update flight set " + 
				" seat = ?, arrtime = ?, arrdate = ?, deptime = ?, depdate = ?, airport = ?, depart = ?, " + 
				" destination = ?, airplane_producer = ? where flight_number = ?;";
		
		try {
			conn = dbutil.loadDriver();
			ps = dbutil.getPreparedStatement(conn, updateFlight);
			ps.setInt(1, flightBean.getSeat());
			ps.setString(2, flightBean.getArrtime());
			ps.setString(3, flightBean.getArrdate());
			ps.setString(4, flightBean.getDeptime());
			ps.setString(5, flightBean.getDepdate());
			ps.setString(6, flightBean.getAirport());
			ps.setString(7, flightBean.getDepart());
			ps.setString(8, flightBean.getDestination());
			ps.setString(9, flightBean.getAirplane_producer());
			ps.setInt(10, flightBean.getFlight_number());
			if (ps.executeUpdate() != 0) {
				updateResult = true;
			}
		}catch (Exception e) {		 //database exception handling 
				e.printStackTrace();
		}
			
		dbutil.closeDbResources(conn, ps); /* close db resource */
		return updateResult;
	}

	@Override
	public boolean cancelFlight(String FlightNumber) {
		boolean cancelFlightResult = false;
		boolean cancelSeat = false;
		Connection conn = null;
		PreparedStatement ps=null;
		DBUtil dbutil = new DBUtil();
		String queryCancelFlight = "delete from flight where flight_number = ?;";
		String queryCancelSeat = "delete from seat where flight_number = ?;";
		String queryCancelBooking = "delete from booking where flight_number = ?;";
		
		/* first delete the seat associate with flight */
		try {
			conn = dbutil.loadDriver();
			ps = dbutil.getPreparedStatement(conn, queryCancelSeat);
			ps.setInt(1, Integer.parseInt(FlightNumber));
			if(ps.executeUpdate() != 0) {
				cancelSeat = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		/* second delete the booking associate with flight */
		try {
			ps = dbutil.getPreparedStatement(conn, queryCancelBooking);
			ps.setInt(1, Integer.parseInt(FlightNumber));
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		/* last delete the flight*/
		if(cancelSeat) {
			try {
				ps = dbutil.getPreparedStatement(conn, queryCancelFlight);
				ps.setInt(1, Integer.parseInt(FlightNumber));
				if(ps.executeUpdate() != 0) {
					cancelFlightResult = true;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return cancelFlightResult;
	}

}
