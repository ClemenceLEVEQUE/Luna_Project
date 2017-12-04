package com.luna.dao;

import java.util.List;

import com.luna.entities.Article;
import com.luna.utils.GlobalConnection;

public class TestDAOArticleUpdate {

	public static void main(String[] args) {
		
			ArticleDAO articleDAO = new ArticleDAOmysql(GlobalConnection.getInstance());
			Article Art=new Article(2,"Telephone","TEL500","Samsung S8",599.99f, 85);
			articleDAO.updateArticle(Art);
				List<Article> articles = articleDAO.getAllArticle();
				System.out.println("\n--------------------------------------------------------------------------------------------------");
				for(Article Art1:articles) {
					System.out.print("\t" + Art1.getIdArticle() + "\t|");
					System.out.print("\t" + Art1.getCategorie() + "\t|");
					System.out.print("\t" + Art1.getCodeArt() + "\t|");
					System.out.print("\t" + Art1.getNomArticle() + "\t|");
					System.out.print("\t" + Art1.getPrixUnitaire() + "\t|");
					System.out.print("\t" + Art1.getStock() + "\t|");
					//System.out.print("\t" + cli.getDate_creation() + "\t|");//
					System.out.println("\n----------------------------------------------------------------------------------------------");
				}
			//}

			}

		
	

	}


