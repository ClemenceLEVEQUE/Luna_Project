package com.luna.dao;

import com.luna.entities.Commande;
import com.luna.utils.GlobalConnection;

public class TestDAOCommandeInsert {

	public static void main(String[] args) {
CommandeDAO commandeDAO = new CommandeDAOmysql(GlobalConnection.getInstance());
		
		Commande Comm=new Commande(4,"10-02-2018","04-12-2017",'T',"COM00004",532.58f);
		commandeDAO.insertCommande(Comm);
		Comm = commandeDAO.getCommande(4);
		
		System.out.println("\n--------------------------------------------------------------------------------------------------");
		//for(LigneCommande Ligne:ligneCommandes) {
		System.out.print("|\t" + Comm.getIdClient() + "\t|");
		System.out.print("\t" + Comm.getDateLivraison() + "\t|");
		System.out.print("\t" + Comm.getDateCom() + "\t|");
		System.out.print("\t" + Comm.getEtat() + "\t|");
		System.out.println("\t" + Comm.getNumCom() + "\t|");
		System.out.println("\t" + Comm.getTotal() + "\t|");
			System.out.println("\n----------------------------------------------------------------------------------------------");
	
	}

}
