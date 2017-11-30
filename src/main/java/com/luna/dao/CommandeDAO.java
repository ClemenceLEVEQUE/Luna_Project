package com.luna.dao;

import java.util.List;
import com.luna.entities.Commande;



public interface CommandeDAO {


	public void insertCommande(Commande Comm);

	public void updateCommande(Commande Comm);

	public void removeCommande(int idCommande);

	public Commande getCommande(int idCommande);

	public List<Commande> getAllCommande();

	
}
