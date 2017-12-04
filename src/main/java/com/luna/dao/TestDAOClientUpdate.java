package com.luna.dao;

import java.util.List;

import com.luna.entities.Article;
import com.luna.entities.Client;
import com.luna.utils.GlobalConnection;

public class TestDAOClientUpdate {

	public static void main(String[] args) {
	
		ClientDAO clientDAO = new ClientDAOmysql(GlobalConnection.getInstance());
		Client Cli=new Client(6,"LaBrocante", "Loulou", "Tours"," 9 Rue Tourne", 58522,"02-54-58-58-58","louislaB@gmail.com","05-08-2007","LOU52","Cherche vieux truc");
		
		clientDAO.updateClient(Cli);
			List<Client> clients = clientDAO.getAllClient();
			System.out.println("\n--------------------------------------------------------------------------------------------------");
			for(Client Cli1:clients) {
				System.out.print("\t" + Cli1.getIdClient() + "\t|");	
				System.out.print("\t" + Cli1.getNom() + "\t|");
					System.out.print("\t" + Cli1.getPrenom() + "\t|");
					System.out.print("\t" + Cli1.getVille() + "\t|");
					System.out.print("\t" + Cli1.getRue() + "\t|");
					System.out.print("\t" + Cli1.getCodePostal() + "\t|");
					System.out.print("\t" + Cli1.getTel() + "\t|");
					System.out.print("\t" + Cli1.getMail() + "\t|");
					System.out.print("\t" + Cli1.getDate_creation() + "\t|");
					System.out.print("\t" + Cli1.getCodeClient() + "\t|");
					System.out.print("\t" + Cli1.getRemarques() + "\t|");
					//System.out.print("\t" + cli.getDate_creation() + "\t|");//
				System.out.println("\n----------------------------------------------------------------------------------------------");
			}
		//}

		}

	


}


