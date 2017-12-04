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
	
	public DefaultTableModel getLigneCommandeArticle(DefaultTableModel table) {
		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM LigneCommande, Article WHERE LigneCommande.idArticle = Article.idArticle");
			int i = 1;
			while(result.next()) {
				int id = result.getInt("idLigne");
				String code = new String(result.getString("codeArt"));
				String categorie = new String(result.getString("categorie"));
				int qte = result.getInt("quantite");
				float prix = result.getFloat("prixUnitaire");
				float total = prix * qte;
				
				table.addRow(new Object[] {id,code,categorie,qte,prix,total});
				
			//	table.setValueAt(id,i,6);
			//	table.setValueAt(code, i, 1);
			//	table.setValueAt(categorie, i, 2);
			//	table.setValueAt(qte, i, 3);
			//	table.setValueAt(prix, i, 4);
			//	table.setValueAt(total, i, 5);
				
				i++;
			}
			return table;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
