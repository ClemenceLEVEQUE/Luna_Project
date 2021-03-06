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
		String numCom=Comm.getNumCom();
		float total=Comm.getTotal();
		
		
		try {
			state = conn.createStatement();
			String str= "INSERT INTO Commande(idClient, dateLivraison, dateCom, etat, numCommande, Total) VALUES (" + IdClient + ",'"
							+ DateLivraison + "','" + DateCom + "','" + Etat + "','"+ numCom +"',"+ total+ ")";
			state.executeUpdate(str);
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
		String numCom=Comm.getNumCom();
		float total=Comm.getTotal();
		try {
			state = conn.createStatement();
			state.executeUpdate("UPDATE Commande SET idClient = " + IdClient + ", dateLivraison = '"
					+  DateLivraison + "', dateCom = '" + IDateCom + "', etat = '" + Etat + "', numCommande = '"+ numCom +"', total = "+ total
					+ " WHERE idClient = " + Comm.getIdCommande());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeCommande(int idCommande) {
		try {
			state = conn.createStatement();
			state.executeUpdate("DELETE FROM Commande WHERE idCommande = " + idCommande);
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
			if(result.first()) {
			cde.setDateCom(result.getString("dateCom"));
			cde.setDateLivraison(result.getString("dateLivraison"));
			cde.setEtat(result.getString("etat").charAt(0));
			cde.setIdClient(result.getInt("idClient"));
			cde.setNumCom(result.getString("numCommande"));
			cde.setTotal(result.getInt("Total"));
			cde.setIdCommande(idCommande);
			
		} 
			}catch (SQLException e) {
			e.printStackTrace();
		}
		return cde;
	}

}
