package com.luna.traitement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
	
	public Object[][] getLigneCommandeArticle() {
		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM LigneCommande, Article WHERE LigneCommande.idArticle = Article.idArticle");
			int i = 1;
			result.last();
			int taille = result.getRow();
			Object[][] str = new Object[taille][6];
			int compteur =0;
			result.first();
			while(result.next()) {
				int id = result.getInt("idLigne");
				String code = new String(result.getString("codeArt"));
				String categorie = new String(result.getString("categorie"));
				int qte = result.getInt("quantite");
				float prix = result.getFloat("prixUnitaire");
				float total = prix * qte;
				
				str[compteur] = new Object[] {id,code,categorie,qte,prix,total};
				i++;
			}
			return str;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
