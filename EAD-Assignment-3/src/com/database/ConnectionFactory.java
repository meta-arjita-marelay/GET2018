package com.database;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * ConnectDB is used to create a connection between client and database.
 * @author Arjita
 *
 */
public class ConnectionFactory {
	/**
	 * getConnection to employee database
	 * @return Connection variable to database
	 */
	public static Connection getconnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/"
					+ "employee?autoReconnect=true&useSSL=false";
			conn = (Connection) DriverManager.getConnection(url, "root",
					"user#123");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error loading driver: " + cnfe);
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}

