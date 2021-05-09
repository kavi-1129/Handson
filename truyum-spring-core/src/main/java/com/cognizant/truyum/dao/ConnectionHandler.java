package com.cognizant.truyum.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		Connection myConn = null;

		Properties prop = new Properties();
		prop.load(new FileReader(
				"C:\\Users\\pavit\\JavaStage3-workspace\\truyum-spring-core\\src\\connection.properties"));

		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/truyum", prop);
		if (myConn != null)
			System.out.println("Connected to Database!!!");

		return myConn;
	}

}
