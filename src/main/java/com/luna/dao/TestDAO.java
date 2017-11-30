package com.luna.dao;

import java.util.List;

import com.luna.entities.Article;
import com.luna.utils.GlobalConnection;

public class TestDAO {
	public static void main(String[] args) {
		ArticleDAO articleDao = new ArticleDAOmysql(GlobalConnection.getInstance());
		List<Article> articles = articleDao.getAllArticle();
		System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------");
		for (Article Art : articles) {
			System.out.print("\t" + Art.getIdArticle() + "\t|");
			System.out.print("\t" + Art.getNomArticle() + "\t|");
			System.out.print("\t" + Art.getCodeArt() + "\t|");
			System.out.print("\t" + Art.getCategorie() + "\t|");
			System.out.print("\t" + Art.getPrixUnitaire() + "\t|");
			System.out.print("\t" + Art.getStock() + "\t|");
			System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------------");
		}
	}

}
