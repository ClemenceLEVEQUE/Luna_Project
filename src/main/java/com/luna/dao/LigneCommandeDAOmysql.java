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

	@Override
	public void insertLigneCommande(LigneCommande ligneCo) {
		try {
			state = conn.createStatement();
			state.executeQuery(
					"INSERT INTO LigneCommande(idCommande, idArticle, quantite) VALUES (" + ligneCo.getIdCommande() + ","
							+ ligneCo.getIdArticle() + "," + ligneCo.getQuantite());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateLigneCommande(LigneCommande ligneCo) {
		try {
			state = conn.createStatement();
			state.executeQuery("UPDATE LigneCommande SET idCommande = " + ligneCo.getIdCommande() + ", idArticle = "
					+ ligneCo.getIdArticle() + ", quantite = " + ligneCo.getQuantite() + " WHERE idLigne = " + ligneCo.getIdLigne());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeLigneCommande(int idLigneCommande) {
		try {
			state = conn.createStatement();
			state.executeQuery("DELETE FROM LigneCommande WHERE idLigneCommande = " + idLigneCommande);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public LigneCommande getLigneCommande(int idLigneCommande) {
		LigneCommande cde = new LigneCommande();
		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM LigneCommande WHERE idLigneCommande = " + idLigneCommande);
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
