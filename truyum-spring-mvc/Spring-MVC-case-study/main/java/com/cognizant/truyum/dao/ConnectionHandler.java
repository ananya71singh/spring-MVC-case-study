package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionHandler {
	/**
	 * Gets an instance of connection by reading connection property files 
	 * @return connection object
	 */
	public static Connection getConnection() {
		Connection con = null;
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("src/main/resources/connection.properties"));
			Class.forName(properties.getProperty("driver"));
			con = DriverManager.getConnection(properties.getProperty("connection-url"), properties.getProperty("user"),
					properties.getProperty("password"));
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

		}

		return con;
	}
	
	
}

