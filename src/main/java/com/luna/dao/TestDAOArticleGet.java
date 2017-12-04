package com.luna.dao;

import com.luna.entities.Article;
import com.luna.utils.GlobalConnection;

public class TestDAOArticleGet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ArticleDAO articleDAO = new ArticleDAOmysql(GlobalConnection.getInstance());
		
Article Art=new Article();
		
		Art=articleDAO.getArticle(6);
		
		System.out.println("\n--------------------------------------------------------------------------------------------------");
		//for(LigneCommande Ligne:ligneCommandes) {
			System.out.print("\t" + Art.getNomArticle() + "\t|");
			System.out.print("\t" + Art.getPrixUnitaire() + "\t|");
			System.out.print("\t" + Art.getStock() + "\t|");
			System.out.print("\t" + Art.getCategorie() + "\t|");

			//System.out.print("\t" + cli.getDate_creation() + "\t|");//
			System.out.println("\n----------------------------------------------------------------------------------------------");
	
	//}

	
	}}
	
