package com.luna.dao;

import com.luna.entities.Article;

import com.luna.utils.GlobalConnection;

public class TestDAOArticleINSERT {

	public static void main(String[] args) {
		ArticleDAO articleDAO = new ArticleDAOmysql(GlobalConnection.getInstance());
		
		Article Art=new Article("Telephone","TEL500","Galaxy S8",599.99f, 85);
		articleDAO.insertArticle(Art);
		articleDAO.getArticle(10);
		
		System.out.println("\n--------------------------------------------------------------------------------------------------");
		//for(LigneCommande Ligne:ligneCommandes) {
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
