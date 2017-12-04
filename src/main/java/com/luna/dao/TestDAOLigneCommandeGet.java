package com.luna.dao;

import com.luna.entities.LigneCommande;
import com.luna.utils.GlobalConnection;

public class TestDAOLigneCommandeGet {

	public static void main(String[] args) {
		LigneCommandeDAO ligneCommandeDAO = new LigneCommandeDAOmysql(GlobalConnection.getInstance());
		
		LigneCommande LigneCo=new LigneCommande();
		
		LigneCo=ligneCommandeDAO.getLigneCommande(1);
		
		System.out.println("\n--------------------------------------------------------------------------------------------------");
		//for(LigneCommande Ligne:ligneCommandes) {
			System.out.print("\t" + LigneCo.getIdCommande() + "\t|");
			System.out.print("\t" + LigneCo.getIdLigne() + "\t|");
			System.out.print("\t" + LigneCo.getIdArticle() + "\t|");
			System.out.print("\t" + LigneCo.getQuantite() + "\t|");

			//System.out.print("\t" + cli.getDate_creation() + "\t|");//
			System.out.println("\n----------------------------------------------------------------------------------------------");
	
	//}

	}

}
