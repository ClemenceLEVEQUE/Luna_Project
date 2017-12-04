package com.luna.dao;

import com.luna.entities.Client;
import com.luna.utils.GlobalConnection;

public class TestDAOClientInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientDAO clientDAO = new ClientDAOmysql(GlobalConnection.getInstance());
		
		Client Cli=new Client("LaBrocante", "Louis", "Tours"," 5 Rue Tourne", 58522,"02-54-58-58-58","louislaB@gmail.com","05-08-2007","LOU52","Cherche vieux truc");
		clientDAO.insertClient(Cli);
		clientDAO.getClient(4);
		
		System.out.println("\n--------------------------------------------------------------------------------------------------");
		//for(LigneCommande Ligne:ligneCommandes) {
		System.out.print("\t" + Cli.getIdClient() + "\t|");	
		System.out.print("\t" + Cli.getNom() + "\t|");
			System.out.print("\t" + Cli.getPrenom() + "\t|");
			System.out.print("\t" + Cli.getVille() + "\t|");
			System.out.print("\t" + Cli.getRue() + "\t|");
			System.out.print("\t" + Cli.getCodePostal() + "\t|");
			System.out.print("\t" + Cli.getTel() + "\t|");
			System.out.print("\t" + Cli.getMail() + "\t|");
			System.out.print("\t" + Cli.getDate_creation() + "\t|");
			System.out.print("\t" + Cli.getCodeClient() + "\t|");
			System.out.print("\t" + Cli.getRemarques() + "\t|");
			//System.out.print("\t" + cli.getDate_creation() + "\t|");//
			System.out.println("\n----------------------------------------------------------------------------------------------");
	}
	//}
	


}
