package com.luna.traitement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.luna.entities.User;

public class UsersTraitement {
	private User user;
	Connection conn = null;
	Statement state = null;
	ResultSet result = null;
	
	public UsersTraitement(String login, String pwd, Connection conn) {
		this.conn = conn;
		this.user = new User(login, pwd);
	}
	
	public boolean Authentification() {
		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM Users WHERE login = '" + user.getLogin() + "' AND password = '" + user.getMdP() + "';");
			return result.last();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
