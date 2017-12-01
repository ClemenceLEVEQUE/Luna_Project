package com.luna.dao;
import java.util.List;

import com.luna.entities.LigneCommande;
import com.luna.utils.GlobalConnection;

	public class TestDAOLigneCommande {
		public static void main(String[] args) {
			LigneCommandeDAO ligneCommandeDAO = new LigneCommandeDAOmysql(GlobalConnection.getInstance());
			List<LigneCommande> ligneCommandes = ligneCommandeDAO.getAllLigneCommande();
			System.out.println("\n--------------------------------------------------------------------------------------------------");
			for(LigneCommande Ligne:ligneCommandes) {
				System.out.print("\t" + Ligne.getIdCommande() + "\t|");
				System.out.print("\t" + Ligne.getIdLigne() + "\t|");
				System.out.print("\t" + Ligne.getIdArticle() + "\t|");
				System.out.print("\t" + Ligne.getQuantite() + "\t|");
	
				//System.out.print("\t" + cli.getDate_creation() + "\t|");//
				System.out.println("\n----------------------------------------------------------------------------------------------");
			}
		}
	}


