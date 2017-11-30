package com.luna.dao;

import java.util.List;

import com.luna.entities.Article;
import com.luna.utils.GlobalConnection;

public class TestDAO {
	public static void main(String[] args) {
		try {

			ArticleDAO articleDao = new ArticleDAOmysql(GlobalConnection.getInstance());
			System.out.println(
					"\n---------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.print("\t" + articleDao.getArticle(3).getString("NomArticle") + "\t|");

			System.out.print("\t" + articleDao.getArticle(3).getString("CodeArt") + "\t|");
			System.out.print("\t" + articleDao.getArticle(3).getString("Categorie") + "\t|");
			System.out.print("\t" + articleDao.getArticle(3).getFloat("PrixUnitaire") + "\t|");
			System.out.print("\t" + articleDao.getArticle(3).getInt("Stock") + "\t|");
			System.out.println(
					"\n--------------------------------------------------------------------------------------------------------------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
