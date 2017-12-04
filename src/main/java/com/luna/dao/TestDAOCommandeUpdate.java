package com.luna.dao;

import java.util.List;

import com.luna.entities.Client;
import com.luna.entities.Commande;
import com.luna.utils.GlobalConnection;

public class TestDAOCommandeUpdate {

	public static void main(String[] args) {
CommandeDAO commandeDAO = new CommandeDAOmysql(GlobalConnection.getInstance());
		
		Commande Comm=new Commande(1,4,"20-02-2018","04-12-2017",'T');
		commandeDAO.updateCommande(Comm);
		List<Commande> Commandes = commandeDAO.getAllCommande();
		
		System.out.println("\n--------------------------------------------------------------------------------------------------");
		for(Commande Comm1:Commandes) {
		System.out.print("\t" + Comm1.getIdClient() + "\t|");
		System.out.print("\t" + Comm1.getDateLivraison() + "\t|");
		System.out.print("\t" + Comm1.getDateCom() + "\t|");
		System.out.print("\t" + Comm1.getEtat() + "\t|");	
		//System.out.print("\t" + cli.getDate_creation() + "\t|");//
			System.out.println("\n----------------------------------------------------------------------------------------------");
	
	}

}

	}


