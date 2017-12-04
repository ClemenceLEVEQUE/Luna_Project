package com.luna.traitement;

import javax.swing.JTextField;

import com.luna.dao.*;
import com.luna.entities.Client;
import com.luna.utils.GlobalConnection;

public class ClientTraitement {
	ClientDAO client;
	
	public ClientTraitement() {
		this.client = new ClientDAOmysql(GlobalConnection.getInstance());
	}
	
	public void AfficherPClient(JTextField code, JTextField creation, JTextField prenom, JTextField nom,
			JTextField ville, JTextField codep, JTextField rue, JTextField tel, JTextField mail, JTextField remarques, int idClient) {
		Client cli = new Client();
		cli = client.getClient(idClient);
		code.setText(cli.getCodeClient());
		creation.setText(cli.getDate_creation());
		prenom.setText(cli.getPrenom());
		nom.setText(cli.getNom());
		ville.setText(cli.getVille());
		codep.setText("" + cli.getCodePostal());
		rue.setText(cli.getRue());
		tel.setText(cli.getTel());
		mail.setText(cli.getMail());
		remarques.setText(cli.getRemarques());
	}
}
