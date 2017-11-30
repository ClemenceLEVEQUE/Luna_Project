package com.luna.entities;

import java.sql.Date;

public class Commande {
	private int idCommande;
	private int idClient;
	private Date dateLivraison;
	private Date dateCom;
	private char etat;

	public Commande() {
		super();
	}

	public Commande(int idClient, Date dateLivraison, Date dateCom, char etat) {
		super();
		this.idClient = idClient;
		this.dateLivraison = dateLivraison;
		this.dateCom = dateCom;
		this.etat = etat;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public Date getDateCom() {
		return dateCom;
	}

	public void setDateCom(Date dateCom) {
		this.dateCom = dateCom;
	}

	public char getEtat() {
		return etat;
	}

	public void setEtat(char etat) {
		this.etat = etat;
	}

}
