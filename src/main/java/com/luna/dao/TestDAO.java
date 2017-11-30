package com.luna.dao;

import java.sql.ResultSet;
import java.util.List;

import com.luna.entities.Article;
import com.luna.utils.GlobalConnection;

public class TestDAO {
	public static void main(String[] args) {
		try {

			ArticleDAO articleDao = new ArticleDAOmysql(GlobalConnection.getInstance());
			Article article = new Article();
			article = articleDao.getArticle(3);
			
			System.out.println(
					"\n---------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.print("\t" + article.getNomArticle() + "\t|");
			System.out.print("\t" + article.getCodeArt() + "\t|");
			System.out.print("\t" + article.getCategorie() + "\t|");
			System.out.print("\t" + article.getPrixUnitaire() + "\t|");
			System.out.print("\t" + article.getStock() + "\t|");
			System.out.println(
					"\n--------------------------------------------------------------------------------------------------------------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
