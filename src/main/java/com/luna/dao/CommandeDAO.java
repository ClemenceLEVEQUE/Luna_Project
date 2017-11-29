package com.luna.dao;

import java.util.List;
import com.luna.entities.Commande;



public interface CommandeDAO {


	public void insertCommande(Commande Art);

	public void updateCommande(Commande Art);

	public void removeCommande(int idCommande);

	public Commande getCommande(int idCommande);

	public List<Commande> getAllCommande();

	
}
