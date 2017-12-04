package com.luna.dao;

import java.util.List;

import com.luna.entities.Commande;
import com.luna.utils.GlobalConnection;

public class TestDAOCommandeRemove {

	public static void main(String[] args) {
CommandeDAO commandeDAO = new CommandeDAOmysql(GlobalConnection.getInstance());
		
		commandeDAO.removeCommande(2);
		List<Commande> commandes = commandeDAO.getAllCommande();
		System.out.println("\n--------------------------------------------------------------------------------------------------");
		for(Commande Comm:commandes) {
			System.out.print("\t" + Comm.getIdClient() + "\t|");
			System.out.print("\t" + Comm.getDateLivraison() + "\t|");
			System.out.print("\t" + Comm.getDateCom() + "\t|");
			System.out.print("\t" + Comm.getEtat() + "\t|");	//System.out.print("\t" + cli.getDate_creation() + "\t|");//
			

			//System.out.print("\t" + cli.getDate_creation() + "\t|");//
			System.out.println("\n----------------------------------------------------------------------------------------------");
		}
	//}
	

	

	}

}
