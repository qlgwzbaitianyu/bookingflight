package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.beans.BookingBean;
import com.beans.FlightBean;
import com.beans.PassengerBean;
import com.dbtuil.DBUtil;

public class BookingDaoIpm implements BookingDao {

	@Override
	public BookingBean bookFlight(int flightNumber, int passengerId, String classType, String baggage) {
		Connection conn = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		BookingBean bookingBean;
		int seatNumber = 0;
		int bookId = 0;
		DBUtil dbutil = new DBUtil();		
		String query = "select " + classType + " from seat where flight_number = ?;";
		/*read the seat number on seat table */
		try {
			conn = dbutil.loadDriver();
			ps = dbutil.getPreparedStatement(conn, query);
			ps.setInt(1, flightNumber);
			rs = ps.executeQuery();
			
			// save results to flightlist
			if(rs.next() == false) {
				System.out.println("find seats failed");
				return null;
			}
			else {
				if(rs.getInt(1) == 0) {		/* no seat for the class*/
					System.out.println("no seat!!");
					return null;
				}
				else {
					seatNumber = rs.getInt(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*set seat number -1 */
		String queryUpdateSeat = "update seat set " + classType + " = ? where flight_number = ? ;";
		try {
			ps = dbutil.getPreparedStatement(conn, queryUpdateSeat);
			ps.setInt(1, (seatNumber - 1));
			ps.setInt(2, flightNumber);
			if (ps.executeUpdate() == 0) {		/*protect from two clients update simultaneously*/
				return null;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		/*create booking table and create bean */
		String queryInsertBooking = "insert into booking values(?, ?, ?, ?, ?, ?, ?) ;";
		try {
			ps = dbutil.getPreparedStatement(conn, queryInsertBooking);
			ps.setInt(1, 0);
			ps.setInt(2, flightNumber);
			ps.setInt(3, passengerId);
			ps.setInt(4, seatNumber);
			ps.setString(5, baggage);
			ps.setString(6, classType);
			ps.setString(7, "reserved");
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		bookId = getBookingId(flightNumber, passengerId, seatNumber, classType);
		bookingBean = new BookingBean(bookId, passengerId, flightNumber, seatNumber, baggage, classType, "reserved");
		/*close db resources*/
		dbutil.closeDbResources(conn, ps);
		return bookingBean;
	}

	@Override
	public int getBookingId(int flightNumber, int passengerId, int seatNumber, String classType) {
		Connection conn = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		int bookId = 0;
		DBUtil dbutil = new DBUtil();		
		
		
		String queryGetBookingId = "select booking_id from booking where flight_number = ? and "
				+ "pass_id = ? and seat_number = ? and "
				+ "class = ?;";
		
		try {
			conn = dbutil.loadDriver();
			ps = dbutil.getPreparedStatement(conn, queryGetBookingId);
			ps.setInt(1, flightNumber);
			ps.setInt(2, passengerId);
			ps.setInt(3, seatNumber);
			ps.setString(4, classType);
			rs = ps.executeQuery();
			
			// save results to flightlist
			if(rs.next() == false) {
				System.out.println("find seats failed");
				return -1;
			}
			else {
				bookId = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bookId;
	}

	@Override
	public List<BookingBean> viewReservations(int passengerId) {
		Connection conn = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<BookingBean> bookingList = new LinkedList<BookingBean>();
		DBUtil dbutil = new DBUtil();		
		String query = "select * from booking where pass_id = ?;";
		
		try {
			conn = dbutil.loadDriver();
			ps = dbutil.getPreparedStatement(conn, query);
			ps.setInt(1, passengerId);
			rs = ps.executeQuery();
			while(rs.next()) {
				BookingBean bookingBean = new BookingBean(rs.getInt(1), rs.getInt(2), 
										rs.getInt(3), rs.getInt(4), rs.getString(5), 
										rs.getString(6), rs.getString(7));
				bookingList.add(bookingBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/* close db resource */
		dbutil.closeDbResources(conn, ps);
		return bookingList;
	}

	@Override
	public boolean cancelReservation(int bookingId, int flightNumber, String classType) {
		/* search the seat number and update +1 */
		Connection conn = null;
		PreparedStatement ps=null;
		BookingBean bookingBean;
		DBUtil dbutil = new DBUtil();
		boolean seatUpdate = false;
		boolean deleteUpdate = false;
		
		String query = "update seat set " + classType + " = " + classType + " + 1" + " where flight_number = ?;";
		String queryDelete = "delete from booking where booking_id = ?;";
		try {
			conn = dbutil.loadDriver();
			ps = dbutil.getPreparedStatement(conn, query);
			ps.setInt(1, flightNumber);
			System.out.println("update seat here..");
			if(ps.executeUpdate() > 0) {
				seatUpdate = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/* delete booking id */
		try {
			System.out.println("delete booking here..");
			ps = dbutil.getPreparedStatement(conn, queryDelete);
			ps.setInt(1, bookingId);
			if(ps.executeUpdate() > 0) {
				deleteUpdate = true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		dbutil.closeDbResources(conn, ps);
		
		if(deleteUpdate && seatUpdate) {
			return true;
		}
		else {
			return false;
		}
	}

}
