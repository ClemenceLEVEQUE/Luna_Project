package com.luna.traitement;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import com.luna.dao.ClientDAO;
import com.luna.dao.ClientDAOmysql;
import com.luna.entities.Client;
import com.luna.utils.GlobalConnection;

public class PeopleTraitement {
	private ClientDAO client;

	public PeopleTraitement() {
		client = new ClientDAOmysql(GlobalConnection.getInstance());
	}

	public void RemplirTableau(JTable table) {
		List<Client> clients = client.getAllClient(); // R�cup�re les donn�es
		List<String> headers = new ArrayList<String>(); // Ent�tes
	}
}
