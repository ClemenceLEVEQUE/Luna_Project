package com.luna.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.luna.entities.Article;

public class ArticleDAOmysql implements ArticleDAO {
	Connection conn = null;
	Statement state = null;
	ResultSet result = null;

	public ArticleDAOmysql(Connection connection) {
		this.conn = connection;
	}

	@Override
	public void insertArticle(Article article) {
	String NomArticle=	article.getNomArticle();
	float PrixUnitaire= article.getPrixUnitaire();
	int Stock= article.getStock();
	String Categorie= article.getCategorie();
	String CodeArt= article.getCodeArt();
		try {
			state = conn.createStatement();
			String stra ="INSERT INTO Article(categorie, codeArt, nomArticle, prixUnitaire, stock) VALUES ('" + Categorie + "','" + CodeArt + "','"
					+ NomArticle +"'," + PrixUnitaire + "," + Stock+")";
			state.executeUpdate(stra);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateArticle(Article article) {
		try {
			state = conn.createStatement();
			state.executeUpdate("UPDATE Article SET categorie = '" + article.getCategorie() + "', codeArt = '" + article.getCodeArt() + "', nomArticle = '"
					+ article.getNomArticle() +"', prixUnitaire = " + article.getPrixUnitaire() + ", stock = " + article.getStock() + " WHERE idArticle = "
					+ article.getIdArticle());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean removeArticle(int idArticle) {
		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM LigneCommande WHERE idArticle = " + idArticle);
			if(result.first()) {
				// Il y a un résultat
				return false;
			} else {
				state = conn.createStatement();
				state.executeUpdate("DELETE FROM Article WHERE idArticle = "+ idArticle);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Article getArticle(int idArticle) {
		Article art = new Article();
		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM Article WHERE idArticle = " + idArticle);
			if (result.first()) {
				art.setIdArticle(result.getInt("idArticle"));
				art.setCategorie(result.getString("categorie"));
				art.setCodeArt(result.getString("codeArt"));
				art.setNomArticle(result.getString("nomArticle"));
				art.setPrixUnitaire(result.getFloat("prixUnitaire"));
				art.setStock(result.getInt("stock"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return art;
	}

	public ArrayList<Article> getAllArticle(int sortby) {
		ArrayList<Article> articles = new ArrayList<Article>();
		Article article = null;
		try {
			state = conn.createStatement();
			String str = new String("SELECT * FROM Article ORDER BY ");
			switch(sortby) {
			case 1:
				str += "codeArt asc";
				break;
				
			case 2:
				str += "categorie asc";
				break;
				
			default:
				str += "codeArt asc";
				break;
			}
			result = state.executeQuery(str);

			while (result.next()) {
				article = new Article();
				article.setIdArticle(result.getInt("idArticle"));
				article.setCategorie(result.getString("categorie"));
				article.setCodeArt(result.getString("codeArt"));
				article.setNomArticle(result.getString("nomArticle"));
				article.setPrixUnitaire(result.getFloat("prixUnitaire"));
				article.setStock(result.getInt("stock"));
				articles.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}
}
