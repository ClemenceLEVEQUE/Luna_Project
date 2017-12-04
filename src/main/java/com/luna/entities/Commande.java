package com.luna.entities;

public class Commande {
	private int idCommande;
	private int idClient;
	private String dateLivraison;
	private String dateCom;
	private char etat;
	private String numCom;
	private float total;
	public Commande() {
		super();
	}

	public Commande(int idClient, String dateLivraison, String dateCom, char etat, String numCom, float total) {
		super();
		this.idClient = idClient;
		this.dateLivraison = dateLivraison;
		this.dateCom = dateCom;
		this.etat = etat;
		this.numCom=numCom;
		this.total=total;
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

	public String getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(String dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public String getDateCom() {
		return dateCom;
	}

	public void setDateCom(String dateCom) {
		this.dateCom = dateCom;
	}

	public char getEtat() {
		return etat;
	}

	public void setEtat(char etat) {
		this.etat = etat;
	}
	

	public String getNumCom() {
		return numCom;
	}

	public void setNumCom(String numCom) {
		this.numCom = numCom;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Commande(int idCommande, int idClient, String dateLivraison, String dateCom, char etat, String numCom, float total) {
		super();
		this.idCommande = idCommande;
		this.idClient = idClient;
		this.dateLivraison = dateLivraison;
		this.dateCom = dateCom;
		this.etat = etat;
		this.numCom=numCom;
		this.total=total;
	}

}
