package com.luna.entities;

public class Article {
	private int idArticle;
	private String categorie;
	private String codeArt;
	private String nomArticle;
	private float prixUnitaire;
	private int stock;

	public Article() {
		super();
	}

	public Article(String categorie, String codeArt, String nomArticle, float prixUnitaire, int stock) {
		super();
		this.categorie = categorie;
		this.codeArt = codeArt;
		this.nomArticle = nomArticle;
		this.prixUnitaire = prixUnitaire;
		this.stock = stock;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getCodeArt() {
		return codeArt;
	}

	public void setCodeArt(String codeArt) {
		this.codeArt = codeArt;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
