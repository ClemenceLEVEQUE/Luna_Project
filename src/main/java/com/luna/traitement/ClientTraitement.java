package com.luna.traitement;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.luna.dao.*;
import com.luna.entities.Client;
import com.luna.utils.GlobalConnection;

public class ClientTraitement {
	ClientDAO client;

	public ClientTraitement() {
		this.client = new ClientDAOmysql(GlobalConnection.getInstance());
	}

	public void Afficher(JTextField code, JTextField creation, JTextField prenom, JTextField nom, JTextField ville,
			JTextField codep, JTextField rue, JTextField tel, JTextField mail, JTextField remarques, JTextField id,
			int idClient) {
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
		id.setText("" + cli.getIdClient());
	}

	public void Save(JTextField code, JTextField creation, JTextField prenom, JTextField nom, JTextField ville,
			JTextField codep, JTextField rue, JTextField tel, JTextField mail, JTextField remarques, JTextField id) {
		if (code.getText().equals("") || creation.getText().equals("") || prenom.getText().equals("")
				|| nom.getText().equals("") || ville.getText().equals("") || codep.getText().equals("")
				|| rue.getText().equals("") || tel.getText().equals("") || mail.getText().equals("")
				|| remarques.getText().equals("")) {
			JOptionPane.showMessageDialog(code, "Veuillez compléter tous les champs.", "Modification impossible",
					JOptionPane.ERROR_MESSAGE);
		} else {
			Client cli = new Client();
			cli.setCodeClient(code.getText());
			cli.setDate_creation(creation.getText());
			cli.setPrenom(prenom.getText());
			cli.setNom(nom.getText());
			cli.setVille(ville.getText());
			cli.setCodePostal(Integer.parseInt(codep.getText()));
			cli.setRue(rue.getText());
			cli.setTel(tel.getText());
			cli.setMail(mail.getText());
			cli.setRemarques(remarques.getText());
			cli.setIdClient(Integer.parseInt(id.getText()));

			client.updateClient(cli);
		}
	}

	public void Insert(JTextField code, JTextField creation, JTextField prenom, JTextField nom, JTextField ville,
			JTextField codep, JTextField rue, JTextField tel, JTextField mail, JTextField remarques) {
		if (code.getText().equals("") || creation.getText().equals("") || prenom.getText().equals("")
				|| nom.getText().equals("") || ville.getText().equals("") || codep.getText().equals("")
				|| rue.getText().equals("") || tel.getText().equals("") || mail.getText().equals("")
				|| remarques.getText().equals("")) {
			JOptionPane.showMessageDialog(code, "Veuillez compléter tous les champs.", "Ajout impossible",
					JOptionPane.ERROR_MESSAGE);
		} else {
			Client cli = new Client();
			cli.setCodeClient(code.getText());
			cli.setDate_creation(creation.getText());
			cli.setPrenom(prenom.getText());
			cli.setNom(nom.getText());
			cli.setVille(ville.getText());
			cli.setCodePostal(Integer.parseInt(codep.getText()));
			cli.setRue(rue.getText());
			cli.setTel(tel.getText());
			cli.setMail(mail.getText());
			cli.setRemarques(remarques.getText());

			client.insertClient(cli);
		}
	}

	public void Suppr(JTextField code, JTextField creation, JTextField prenom, JTextField nom, JTextField ville,
			JTextField codep, JTextField rue, JTextField tel, JTextField mail, JTextField remarques, JTextField id,
			int idClient) {
		code.setText("");
		creation.setText("");
		prenom.setText("");
		nom.setText("");
		ville.setText("");
		codep.setText("");
		rue.setText("");
		tel.setText("");
		mail.setText("");
		remarques.setText("");
		id.setText("");

		client.removeClient(idClient);
	}
}
