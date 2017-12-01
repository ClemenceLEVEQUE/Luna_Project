package com.luna.dao;

	
	import java.util.List;

import com.luna.entities.Client;
import com.luna.entities.LigneCommande;
	import com.luna.utils.GlobalConnection;

		public class TestDAOLigneCommandeInsert  {
			public static void main(String[] args) {
				LigneCommandeDAO ligneCommandeDAO = new LigneCommandeDAOmysql(GlobalConnection.getInstance());
				
				LigneCommande LigneCo=new LigneCommande(2,2, 1);
				ligneCommandeDAO.insertLigneCommande(LigneCo);
				ligneCommandeDAO.getLigneCommande(6);
				
				System.out.println("\n--------------------------------------------------------------------------------------------------");
				//for(LigneCommande Ligne:ligneCommandes) {
					System.out.print("\t" + LigneCo.getIdCommande() + "\t|");
					System.out.print("\t" + LigneCo.getIdLigne() + "\t|");
					System.out.print("\t" + LigneCo.getIdArticle() + "\t|");
					System.out.print("\t" + LigneCo.getQuantite() + "\t|");
		
					//System.out.print("\t" + cli.getDate_creation() + "\t|");//
					System.out.println("\n----------------------------------------------------------------------------------------------");
			}
			//}
			
		}
		


