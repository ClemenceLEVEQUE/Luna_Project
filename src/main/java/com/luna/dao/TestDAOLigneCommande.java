package com.luna.dao;
import java.util.List;

import com.luna.entities.LigneCommande;
import com.luna.utils.GlobalConnection;

	public class TestDAOLigneCommande {
		public static void main(String[] args) {
			LigneCommandeDAO ligneCommandeDAO = new LigneCommandeDAOmysql(GlobalConnection.getInstance());
			List<LigneCommande> ligneCommandes = ligneCommandeDAO.getAllLigneCommande();
			System.out.println("\n--------------------------------------------------------------------------------------------------");
			for(LigneCommande LigneCo:ligneCommandes) {
				System.out.print("\t" + LigneCo.getIdCommande() + "\t|");
				System.out.print("\t" + LigneCo.getIdLigne() + "\t|");
				System.out.print("\t" + LigneCo.getIdArticle() + "\t|");
				System.out.print("\t" + LigneCo.getQuantite() + "\t|");
	
				//System.out.print("\t" + cli.getDate_creation() + "\t|");//
				System.out.println("\n----------------------------------------------------------------------------------------------");
			}
		}
	}


