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

	@Override
	public void insertCommande(Commande Comm) {
		try {
			state = conn.createStatement();
			state.executeQuery(
					"INSERT INTO Commande(idClient, dateLivraison, dateCom, etat) VALUES (" + Comm.getIdClient() + ",'"
							+ Comm.getDateLivraison() + "','" + Comm.getDateCom() + "','" + Comm.getEtat() + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCommande(Commande Comm) {
		try {
			state = conn.createStatement();
			state.executeQuery("UPDATE Commande SET idClient = " + Comm.getIdClient() + ", dateLivraison = '"
					+ Comm.getDateLivraison() + "', dateCom = '" + Comm.getDateCom() + "', etat = '" + Comm.getEtat()
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
			cde.setDateCom(result.getDate("dateCom"));
			cde.setDateLivraison(result.getDate("dateLivraison"));
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
				cde.setDateCom(result.getDate("dateCom"));
				cde.setDateLivraison(result.getDate("dateLivraison"));
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
