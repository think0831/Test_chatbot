package com.afc.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnecter {
	
	private Connection conn;
	private final static String driverName = "oracle.jdbc.driver.OracleDriver";
	private final static String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private final static String id = "afc";
	private final static String pw = "afc$";
	
	public Connection getConnection() {
		
		if(conn == null) {
			try {
				Class.forName(driverName);
				conn = DriverManager.getConnection(url, id, pw);
				
			} catch (Exception e) {
				System.out.println(e + "DateBase can't connect");
				conn = null;
			}
			return conn;
			
			
		} else {
			return conn;
		}
		
		
	}
	
	

}
