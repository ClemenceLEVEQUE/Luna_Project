
	package com.luna.dao;

	import java.util.List;

	import com.luna.entities.Article;
import com.luna.entities.Client;
import com.luna.utils.GlobalConnection;

	public class TestDAOClient {
		public static void main(String[] args) {
			ClientDAO clientDao = new ClientDAOmysql(GlobalConnection.getInstance());
			List<Client> clients = clientDao.getAllClient();
			System.out.println("\n--------------------------------------------------------------------------------------------------");
			for(Client cli:clients) {
				System.out.print("\t" + cli.getIdClient() + "\t|");
				System.out.print("\t" + cli.getNom() + "\t|");
				System.out.print("\t" + cli.getPrenom() + "\t|");
				System.out.print("\t" + cli.getVille() + "\t|");
				System.out.print("\t" + cli.getRue() + "\t|");
				System.out.print("\t" + cli.getCodePostal() + "\t|");
				System.out.print("\t" + cli.getTel() + "\t|");
				System.out.print("\t" + cli.getMail() + "\t|");
				//System.out.print("\t" + cli.getDate_creation() + "\t|");//
				System.out.println("\n----------------------------------------------------------------------------------------------");
			}
		}
	}
