package com.luna.dao;

import com.luna.entities.Commande;
import com.luna.utils.GlobalConnection;

public class TestDAOCommandeGet {

	public static void main(String[] args) {
		CommandeDAO commandeDAO = new CommandeDAOmysql(GlobalConnection.getInstance());
		
		Commande Comm=new Commande();
				
				Comm=commandeDAO.getCommande(2);
				
				System.out.println("\n--------------------------------------------------------------------------------------------------");
				//for(LigneCommande Ligne:ligneCommandes) {
					System.out.print("\t" + Comm.getIdClient() + "\t|");
					System.out.print("\t" + Comm.getDateLivraison() + "\t|");
					System.out.print("\t" + Comm.getDateCom() + "\t|");
					System.out.print("\t" + Comm.getEtat() + "\t|");

					//System.out.print("\t" + cli.getDate_creation() + "\t|");//
					System.out.println("\n----------------------------------------------------------------------------------------------");
			
	
	
	}

}
