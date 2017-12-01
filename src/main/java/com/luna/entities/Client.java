package com.luna.entities;

import java.sql.Date;

public class Client {
	private int idClient;
	private String nom;
	private String prenom;
	private String ville;
	private String rue;
	private int codePostal;
	private String tel;
	private String mail;
	private String date_creation;
	private String codeClient;
	private String remarques;
	public Client() {
		super();
	}

	public Client(String nom, String prenom, String ville, String rue, int codePostal, String tel,
			String mail, String date_creation, String codeClient,String remarques) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.ville = ville;
		this.rue = rue;
		this.codePostal = codePostal;
		this.tel = tel;
		this.mail = mail;
		this.date_creation = date_creation;
		this.codeClient = codeClient;
		this.remarques = remarques;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(String date_creation) {
		this.date_creation = date_creation;
	}

	public String getCodeClient() {
		return codeClient;
	}

	public void setCodeClient(String codeClient) {
		this.codeClient = codeClient;
	}

	public String getRemarques() {
		return remarques;
	}

	public void setRemarques(String remarque) {
		this.remarques = remarques;
	}

	
}
