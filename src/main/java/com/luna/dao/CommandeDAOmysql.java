package com.luna.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.luna.entities.Commande;

public class CommandeDAOmysql implements CommandeDAO {
	Connection conn = null;
	Statement state = null;
	ResultSet result = null;

	public CommandeDAOmysql(Connection connection) {
		this.conn = connection;
	}
	
	@Override
	public void insertCommande(Commande Comm) {
		String DateLivraison =Comm.getDateLivraison();
		String DateCom=Comm.getDateCom();
		char Etat = Comm.getEtat();
		int IdClient = Comm.getIdClient();
		
		try {
			state = conn.createStatement();
			state.executeUpdate(
					"INSERT INTO Commande(idClient, dateLivraison, dateCom, etat) VALUES (" + IdClient + ",'"
							+ DateLivraison + "','" + DateCom + "','" + Etat + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCommande(Commande Comm) {
		String DateLivraison =Comm.getDateLivraison();
		String IDateCom=Comm.getDateCom();
		char Etat = Comm.getEtat();
		int IdClient = Comm.getIdClient();
		
		try {
			state = conn.createStatement();
			state.executeQuery("UPDATE Commande SET idClient = " + IdClient + ", dateLivraison = '"
					+  DateLivraison + "', dateCom = '" + IDateCom + "', etat = '" + Etat
					+ "' WHERE idClient = " + Comm.getIdCommande());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeCommande(int idCommande) {
		try {
			state = conn.createStatement();
			state.executeQuery("DELETE FROM Commande WHERE idCommande = " + idCommande);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Commande getCommande(int idCommande) {
		Commande cde = new Commande();
		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM Commande WHERE idCommande = " + idCommande);
			result.first();
			cde.setDateCom(result.getString("dateCom"));
			cde.setDateLivraison(result.getString("dateLivraison"));
			cde.setEtat(result.getString("etat").charAt(0));
			cde.setIdClient(result.getInt("idClient"));
			cde.setIdCommande(idCommande);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cde;
	}

	@Override
	public List<Commande> getAllCommande() {
		List<Commande> cdes = new ArrayList<Commande>();
		Commande cde = null;
		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM Commande");

			while (result.next()) {
				cde = new Commande();
				cde.setDateCom(result.getString("dateCom"));
				cde.setDateLivraison(result.getString("dateLivraison"));
				cde.setEtat(result.getString("etat").charAt(0));
				cde.setIdClient(result.getInt("idClient"));
				cde.setIdCommande(result.getInt("idCommande"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cdes;
	}

}
