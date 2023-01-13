package com.fuse.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Fuse_DB_Connection {
	public static Connection  con;
	public static Connection getConnection() throws SQLException,Exception{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fuse","root","");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}//catch
		return con;	
	}//method

	public static void main(String[] args)throws SQLException,Exception {
		
		Fuse_DB_Connection.getConnection();
		if(con.isClosed()) {
			System.out.println("Connection is Closed");
		}
		else {
			System.out.println("Connection is Open");
		}
	}//main method

}//class
