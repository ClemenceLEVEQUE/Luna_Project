package com.luna.dao;

import java.util.List;

import com.luna.entities.LigneCommande;

public interface LigneCommandeDAO {

	public void insertLigneCommande(LigneCommande ligneCo);

	public void updateLigneCommande(LigneCommande ligneCo);

	public void removeLigneCommande(int idLigneCommande);

	public LigneCommande getLigneCommande(int idLigneCommande);

	public List<LigneCommande> getAllLigneCommande();

}
