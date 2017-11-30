package com.luna.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GlobalConnection {
	private String url = "jdbc:mysql://localhost:3306/db_jdbc";
	private String user = "root";
	private String passwd = "";
	private static Connection connect;

	public GlobalConnection() {
		try {
			connect = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
	 * 
	 * @return
	 */
	public static Connection getInstance() {
		if (connect == null) {
			new GlobalConnection();
		}
		return connect;
	}
}
