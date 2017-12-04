package com.luna.dao;

import java.util.List;

import com.luna.entities.Article;
import com.luna.utils.GlobalConnection;

public class TestDAOArticleRemove {

	public static void main(String[] args) {
	ArticleDAO articleDAO = new ArticleDAOmysql(GlobalConnection.getInstance());
		
		articleDAO.removeArticle(10);
		List<Article> articles = articleDAO.getAllArticle();
		System.out.println("\n--------------------------------------------------------------------------------------------------");
		for(Article Art:articles) {
			System.out.print("\t" + Art.getIdArticle() + "\t|");
			System.out.print("\t" + Art.getCategorie() + "\t|");
			System.out.print("\t" + Art.getCodeArt() + "\t|");
			System.out.print("\t" + Art.getNomArticle() + "\t|");
			System.out.print("\t" + Art.getPrixUnitaire() + "\t|");
			System.out.print("\t" + Art.getStock() + "\t|");

			//System.out.print("\t" + cli.getDate_creation() + "\t|");//
			System.out.println("\n----------------------------------------------------------------------------------------------");
		}
	//}
	

	}

}
