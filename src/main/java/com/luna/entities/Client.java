package com.luna.entities;

import java.sql.Date;

public class Client {
	private int idClient;
	private String nom;
	private String prenom;
	private String ville;
	private String rue;
	private int codePostal;
	private String Tel;
	private String Mail;
	private Date date_creation;

	public Client() {
		super();
	}

	public Client(int idClient, String nom, String prenom, String ville, String rue, int codePostal, String tel,
			String mail, Date date_creation) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.ville = ville;
		this.rue = rue;
		this.codePostal = codePostal;
		Tel = tel;
		Mail = mail;
		this.date_creation = date_creation;
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
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public String getMail() {
		return Mail;
	}

	public void setMail(String mail) {
		Mail = mail;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	
	
}
