package com.dbtuil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DBUtil {
	
	private    static final String DB_URL = "jdbc:mysql://localhost:3306/mydb2";
	static final String USER = "root";
	static final String PASS = "Bty890108";
	static final String DRIVER = "com.mysql.jdbc.Driver";
	 ResultSet rs = null;
	
	public static Connection loadDriver() throws SQLException{
		Connection conn = null;
		try {
			Class.forName(DRIVER);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		
		return conn;
	}
	
	
	public static PreparedStatement getPreparedStatement(Connection con,String sql) {
		PreparedStatement ps=null;
		try {
			ps= con.prepareStatement(sql);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ps;
	}
	
	
	public static ResultSet getResult(PreparedStatement ps) {
		ResultSet rs=null;
		try {
			rs= ps.executeQuery();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public static int executeUpdate(PreparedStatement ps) {
		int i=-1;
		try {
			i= ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	
	public static void closeDbResources(Connection con) {
		try {
			if(con!= null)
				con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void closeDbResources(Connection con, PreparedStatement ps) {
		try {
			if(ps!=null)
				ps.close();
			
			if(con!= null)
				con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void closeDbResources(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if(rs!=null)
				rs.close();
			
			if(ps!=null)
				ps.close();
			
			if(con!= null)
				con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

}
