package com.luna.dao;

import com.luna.entities.Client;
import com.luna.utils.GlobalConnection;

public class TestDAOClientGet {

	public static void main(String[] args) {
		ClientDAO clientDAO = new ClientDAOmysql(GlobalConnection.getInstance());
		
		Client Cli=new Client();
				
				Cli=clientDAO.getClient(2);
				
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
			
			//}

			
			}}
			