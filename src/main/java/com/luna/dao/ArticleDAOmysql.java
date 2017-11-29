package com.luna.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
		try {
			state = conn.createStatement();
			state.executeQuery("INSERT INTO Article(categorie, codeArt, nomArticle, prixUnitaire, stock) VALUES ('" + article.getCategorie() + "','" + article.getCodeArt() + "','"
					+ article.getNomArticle() +"'," + article.getPrixUnitaire() + "," + article.getStock());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateArticle(Article article) {
		try {
			state = conn.createStatement();
			state.executeQuery("UPDATE Article SET categorie = " + article.getCategorie() + "','" + article.getCodeArt() + "','"
					+ article.getNomArticle() +"'," + article.getPrixUnitaire() + "," + article.getStock());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeArticle(int idArticle) {

	}

	@Override
	public Article getArticle(int idArticle) {
		return null;
	}

	public List<Article> getAllArticle() {
		List<Article> articles = new ArrayList<Article>();
		Article article = null;
		try {

			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM Article");

			while (result.next()) {
				article = new Article();
				article.setCategorie(result.getString("categorie"));
				article.setCodeArt(result.getString("codeArticle"));
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