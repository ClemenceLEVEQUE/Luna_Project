package com.luna.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.luna.entities.Client;

public class ClientDAOmysql implements ClientDAO {
	Connection conn = null;
	Statement state = null;
	ResultSet result = null;

	public ClientDAOmysql(Connection connection) {
		this.conn = connection;
	}
	
	@Override
	public void insertClient(Client Cli) {
		try {
			state = conn.createStatement();
			state.executeUpdate(
					"INSERT INTO Client(nom, prenom, ville, rue, codePostal, tel, mail, date_creation) VALUES ('"
							+ Cli.getNom() + "','" + Cli.getPrenom() + "','" + Cli.getVille() + "','" + Cli.getRue()
							+ "'," + Cli.getCodePostal() + ",'" + Cli.getTel() + "','" + Cli.getMail() + "','"
							+ Cli.getDate_creation() + "'"+ Cli.getCodeClient()+ "'"+ Cli.getRemarques());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateClient(Client Cli) {
		try {
			state = conn.createStatement();
			state.executeUpdate("UPDATE Client SET nom = '" + Cli.getNom() + "', prenom = '" + Cli.getPrenom()
					+ "', ville = '" + Cli.getVille() + "', rue = '" + Cli.getRue() + "', codePostal = "
					+ Cli.getCodePostal() + ", tel = '" + Cli.getTel() + "', mail = '" + Cli.getMail()
<<<<<<< HEAD
					+ "', date_creation = '" + Cli.getDate_creation() + "', remarques = '" + Cli.getRemarque() + "', codeClient = '" + Cli.getCodeClient()
					+ "' WHERE idClient = " + Cli.getIdClient()+"' Code Client = "+  Cli.getCodeClient()+ "'"+ Cli.getRemarque());
=======
					+ "', date_creation = '" + Cli.getDate_creation() + "' WHERE idClient = " + Cli.getIdClient()+"' Code Client = "+  Cli.getCodeClient()+ "'"+ Cli.getRemarques());
>>>>>>> branch 'master' of https://github.com/ClemenceLEVEQUE/Luna_Project
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeClient(int idClient) {
		try {
			state = conn.createStatement();
			state.executeQuery("DELETE FROM Client WHERE idClient = " + idClient);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Client getClient(int idClient) {
		Client cli = new Client();
		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM Client WHERE idClient = " + idClient);
			result.first();
			cli.setIdClient(idClient);
			cli.setNom(result.getString("nom"));
			cli.setPrenom(result.getString("prenom"));
			cli.setVille(result.getString("ville"));
			cli.setRue(result.getString("rue"));
			cli.setCodePostal(result.getInt("codePostal"));
			cli.setTel(result.getString("tel"));
			cli.setMail(result.getString("mail"));
			cli.setDate_creation(result.getString("date_creation"));
			cli.setCodeClient(result.getString("codeClient"));
<<<<<<< HEAD
			cli.setRemarque(result.getString("remarques"));
=======
			cli.setRemarques(result.getString("remarques"));
>>>>>>> branch 'master' of https://github.com/ClemenceLEVEQUE/Luna_Project
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cli;
	}

	@Override
	public List<Client> getAllClient() {
		List<Client> clients = new ArrayList<Client>();
		Client cli = null;
		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM Client");

			while (result.next()) {
				cli = new Client();
				cli.setIdClient(result.getInt("idClient"));
				cli.setNom(result.getString("nom"));
				cli.setPrenom(result.getString("prenom"));
				cli.setVille(result.getString("ville"));
				cli.setRue(result.getString("rue"));
				cli.setCodePostal(result.getInt("codePostal"));
				cli.setTel(result.getString("tel"));
				cli.setMail(result.getString("mail"));
				cli.setDate_creation(result.getString("date_creation"));
				cli.setCodeClient(result.getString("codeClient"));
<<<<<<< HEAD
				cli.setRemarque(result.getString("remarques"));
=======
				cli.setRemarques(result.getString("remarque"));
>>>>>>> branch 'master' of https://github.com/ClemenceLEVEQUE/Luna_Project
				clients.add(cli);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

}
