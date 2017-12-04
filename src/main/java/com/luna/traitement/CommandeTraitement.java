package com.luna.traitement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;

import com.luna.dao.*;
import com.luna.utils.GlobalConnection;

public class CommandeTraitement {
	Connection conn = null;
	Statement state = null;
	ResultSet result = null;
	LigneCommandeDAO ligne;
	ArticleDAO article;
	
	public CommandeTraitement() {
		this.conn = GlobalConnection.getInstance();
		this.ligne = new LigneCommandeDAOmysql(conn);
		this.article = new ArticleDAOmysql(conn);
	}
	
	public void getLigneCommandeArticle(JTable table) {
		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM LigneCommande, Article WHERE LigneCommande.idArticle = Article.idArticle");
			int i = 1;
			while(result.next()) {
				table.setValueAt(result.getInt("idLigne"), i, 0);
				table.setValueAt(result.getString("codeArt"),i,1);
				table.setValueAt(result.getString("categorie"),i,2);
				table.setValueAt(result.getInt("quantite"),i,3);
				table.setValueAt(result.getFloat("prixUnitaire"),i,4);
				float prix = result.getInt("quantite") * result.getFloat("prixUnitaire");
				table.setValueAt(prix,i,5);
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
