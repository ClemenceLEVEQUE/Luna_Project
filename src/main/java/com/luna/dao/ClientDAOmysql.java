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
		String Nom = Cli.getNom();
		String Prenom = Cli.getPrenom();
		String Ville = Cli.getVille();
		String Rue = Cli.getRue();
		int CodePostal = Cli.getCodePostal();
		String Tel = Cli.getTel();
		String Mail = Cli.getMail();
		String Date_creation = Cli.getDate_creation();
		String CodeClient = Cli.getCodeClient();
		String Remarques = Cli.getRemarques();

		try {
			state = conn.createStatement();
			
					String str = "INSERT INTO Client(nom, prenom, ville, rue, codePostal, tel, mail, date_creation, CodeClient, Remarques) VALUES ('"
							+ Nom + "','" + Prenom + "','" + Ville + "','" + Rue + "',"
							+ CodePostal + ",'" + Tel + "','" + Mail + "','"
							+ Date_creation + "','" + CodeClient + "','" + Remarques+"')";
					state.executeUpdate(str);
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

					+ "', date_creation = '" + Cli.getDate_creation() + "', remarques = '" + Cli.getRemarques()
					+ "', codeClient = '" + Cli.getCodeClient() + "' WHERE idClient = " + Cli.getIdClient());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean removeClient(int idClient) {
		try {
			state = conn.createStatement();
			state.executeUpdate("DELETE FROM Client WHERE idClient = " + idClient);
			return true;
		} catch (SQLException e) {
			return false;
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
			cli.setRemarques(result.getString("remarques"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cli;
	}

	@Override
	public ArrayList<Client> getAllClient(int sortby) {
		ArrayList<Client> clients = new ArrayList<Client>();
		Client cli = null;
		try {
			state = conn.createStatement();
			String str = "SELECT * FROM Client ORDER BY ";
			switch(sortby) {
			case 1:
				str += "codeClient asc";
				break;
				
			case 2:
				str += "nom asc";
				break;
				
			default:
				str += "codeClient asc";
			}
			result = state.executeQuery(str);

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
				cli.setRemarques(result.getString("remarques"));
				clients.add(cli);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

}
