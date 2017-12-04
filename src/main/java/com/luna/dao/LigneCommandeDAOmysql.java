package com.luna.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.luna.entities.LigneCommande;

public class LigneCommandeDAOmysql implements LigneCommandeDAO {
	Connection conn = null;
	Statement state = null;
	ResultSet result = null;

	public LigneCommandeDAOmysql(Connection connection) {
		this.conn = connection;
	}
	
	@Override
	public void insertLigneCommande(LigneCommande ligneCo) {
		int IdCommande =ligneCo.getIdCommande();
		int IdArticle=ligneCo.getIdArticle();
		int Quantite = ligneCo.getQuantite();
		
		try {
			state = conn.createStatement();
			
			String str = "INSERT INTO LigneCommande(idCommande, idArticle, quantite) VALUES (" + IdCommande + ","
					+ IdArticle + "," + Quantite+")";
			state.executeUpdate(str);
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateLigneCommande(LigneCommande ligneCo) {
		
		int IdCommande =ligneCo.getIdCommande();
		int IdArticle=ligneCo.getIdArticle();
		int Quantite = ligneCo.getQuantite();
		int IdLigne = ligneCo.getIdLigne();
		try {
			state = conn.createStatement();
			state.executeUpdate("UPDATE LigneCommande SET idCommande = " + IdCommande + ", idArticle = "
					+ IdArticle + ", quantite = " + Quantite + " WHERE idLigne = " + IdLigne);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeLigneCommande(int idLigneCommande) {
		
		try {
			state = conn.createStatement();
			state.executeUpdate("DELETE FROM LigneCommande WHERE idLigne = " + idLigneCommande);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public LigneCommande getLigneCommande(int idLigneCommande) {
		LigneCommande cde = new LigneCommande();
		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM LigneCommande WHERE idLigne = '" + idLigneCommande+ "'");
			result.first();
			cde.setIdCommande(result.getInt("idCommande"));
			cde.setIdLigne(result.getInt("idLigne"));
			cde.setIdArticle(result.getInt("idArticle"));
			cde.setQuantite(result.getInt("quantite"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cde;
	}

	@Override
	public List<LigneCommande> getAllLigneCommande() {
		List<LigneCommande> cdes = new ArrayList<LigneCommande>();
		LigneCommande cde = null;
		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM LigneCommande");
			
			while (result.next()) {
				cde = new LigneCommande();
				cde.setIdCommande(result.getInt("idCommande"));
				cde.setIdLigne(result.getInt("idLigne"));
				cde.setIdArticle(result.getInt("idArticle"));
				cde.setQuantite(result.getInt("quantite"));
				cdes.add(cde);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cdes;
	}

}
