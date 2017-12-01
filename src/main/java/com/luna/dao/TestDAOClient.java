
	package com.luna.dao;

	import java.util.List;

	import com.luna.entities.Article;
import com.luna.entities.Client;
import com.luna.utils.GlobalConnection;

	public class TestDAOClient {
		public static void main(String[] args) {
			ClientDAO clientDao = new ClientDAOmysql(GlobalConnection.getInstance());
			Client Cli=new Client("El Koulali", "Karim",  "Apt", "2 place du luberon", 84400,  "06-78-45-45-65",
			 "monMail@gmail.com","02-12-2017","remarques","23332234");
			
			clientDao.insertClient(Cli);
		clientDao.getClient(5);
			System.out.println("\n--------------------------------------------------------------------------------------------------");
	//		for(Client Cli:clientDao) {
				
				System.out.print("\t" + Cli.getNom() + "\t|");
				System.out.print("\t" + Cli.getPrenom() + "\t|");
				System.out.print("\t" + Cli.getVille() + "\t|");
				System.out.print("\t" + Cli.getRue() + "\t|");
				System.out.print("\t" + Cli.getCodePostal() + "\t|");
				System.out.print("\t" + Cli.getTel() + "\t|");
				System.out.print("\t" + Cli.getMail() + "\t|");
				System.out.print("\t" + Cli.getRemarques() + "\t|");
				System.out.print("\t" + Cli.getCodeClient() + "\t|");
				//System.out.print("\t" + cli.getDate_creation() + "\t|");//
				System.out.println("\n----------------------------------------------------------------------------------------------");
		//	}
		}
	}
