package com.luna.dao;

import java.util.List;

import com.luna.entities.Client;
import com.luna.utils.GlobalConnection;

public class TestDAOClientRemove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

ClientDAO clientDAO = new ClientDAOmysql(GlobalConnection.getInstance());
		
		clientDAO.removeClient(5);
		List<Client> clients = clientDAO.getAllClient();
		System.out.println("\n--------------------------------------------------------------------------------------------------");
		for(Client Cli:clients) {
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

}
