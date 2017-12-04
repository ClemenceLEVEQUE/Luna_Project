package com.luna.dao;

import java.util.List;

import com.luna.entities.LigneCommande;
import com.luna.utils.GlobalConnection;

public class TestLigneCommandeUpdate {

	public static void main(String[] args) {
	LigneCommandeDAO ligneCommandeDAO = new LigneCommandeDAOmysql(GlobalConnection.getInstance());
	LigneCommande LigneCo=new LigneCommande(2,2,2,3);
	ligneCommandeDAO.updateLigneCommande(LigneCo);
		List<LigneCommande> ligneCommandes = ligneCommandeDAO.getAllLigneCommande();
		System.out.println("\n--------------------------------------------------------------------------------------------------");
		for(LigneCommande LigneCo1:ligneCommandes) {
			System.out.print("\t" + LigneCo1.getIdCommande() + "\t|");
			System.out.print("\t" + LigneCo1.getIdLigne() + "\t|");
			System.out.print("\t" + LigneCo1.getIdArticle() + "\t|");
			System.out.print("\t" + LigneCo1.getQuantite() + "\t|");

			//System.out.print("\t" + cli.getDate_creation() + "\t|");//
			System.out.println("\n----------------------------------------------------------------------------------------------");
		}
	//}

	}

}
