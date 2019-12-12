package com.neha.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MysqlConnection {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/S2DJM", "root", “Neharika@123");
			//in url --> connecting to msql data base
			///in order to manipulate servers u gotat connect like this
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/survey_connect", "root", "Neharika@123");
			//System.out.println(connection);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
 