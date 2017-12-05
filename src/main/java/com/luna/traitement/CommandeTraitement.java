package com.luna.traitement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.luna.dao.*;
import com.luna.entities.Article;
import com.luna.entities.Client;
import com.luna.entities.Commande;
import com.luna.entities.LigneCommande;
import com.luna.utils.GlobalConnection;

public class CommandeTraitement {
	Connection conn = null;
	Statement state = null;
	ResultSet result = null;
	LigneCommandeDAO ligne;
	ArticleDAO article;
	ClientDAO cli;
	CommandeDAO cmde;
	
	public CommandeTraitement() {
		this.conn = GlobalConnection.getInstance();
		this.ligne = new LigneCommandeDAOmysql(conn);
		this.article = new ArticleDAOmysql(conn);
		this.cli = new ClientDAOmysql(conn);
		this.cmde = new CommandeDAOmysql(conn);
	}
	
	public Object[][] getTouteLigne(int idCommande) {
		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM LigneCommande, Article WHERE LigneCommande.idArticle = Article.idArticle AND LigneCommande.IdCommande = " + idCommande);
			int i = 0;
			result.last();
			int taille = result.getRow();
			Object[][] str = new Object[taille][6];
			result.beforeFirst();
			while(result.next()) {
				int id = result.getInt("idLigne");
				String code = new String(result.getString("codeArt"));
				String categorie = new String(result.getString("categorie"));
				int qte = result.getInt("quantite");
				float prix = result.getFloat("prixUnitaire");
				float total = prix * qte;
				
				str[i] = new Object[] {id,code,categorie,qte,prix,total};
				i++;
			}
			return str;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Object[][] getAllCommande() {
		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT * FROM Commande, Client WHERE Commande.idClient = Client.idClient ORDER BY numCommande desc");
			int i = 0;
			result.last();
			int taille = result.getRow();
			Object[][] str = new Object[taille][6];
			result.beforeFirst();
			while(result.next()) {
				int id = result.getInt("idCommande");
				String num = result.getString("numCommande");
				String code = new String(result.getString("codeClient"));
				String dateCrea = new String(result.getString("dateCom"));
				String dateLivr= new String(result.getString("dateLivraison"));
				char etat = result.getString("etat").charAt(0);
				float total = result.getFloat("total");

				str[i] = new Object[] {id,num,code,total,dateCrea,dateLivr,etat};
				i++;
			}
			return str;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String[] comboBoxArticle() {
		ArrayList<Article> list = article.getAllArticle(0);
		String[] str = new String[list.size()];
		int i = 0;
		for(Article art : list) {
			str[i] = art.getNomArticle();
			i++;
		}
		return str;
	}
	

	public String[] comboBoxClient(){
		ArrayList<Client> list = cli.getAllClient();
		String[] str = new String[list.size() + 1];
		int i = 1;
		str[0] = "Selectionnez un client...";
		for(Client cmde : list){
			str[i] = cmde.getCodeClient();
			i++;
		}
		return str;
	}
	
	public void NouvCommande(JTextField date, JTextField num, JComboBox<String> code) {
		if(num.getText().isEmpty()) {
			try {
				state = conn.createStatement();
				result = state.executeQuery("SELECT MAX(numCommande) FROM Commande");
				result.first();
				
				// Recup du num commande et calcul pour obtenir le num suivant
				String str = result.getString("MAX(numCommande)");
				str = str.replace("COM", "");
				int numCom = Integer.parseInt(str) + 1;
				str = "00000" + numCom;
				str = str.substring(str.length() - 5);
				num.setText("COM" + str);
				
				// Recup de la date de creation et de livr
				LocalDate d = LocalDate.now();
				date.setText(d.toString());
				d = d.plusDays(5);
				
				// Instance de la classe Commande afin d'utiliser la fonction insertCommande de CommandeDAO
				Commande cde = new Commande();
				cde.setDateCom(date.getText());
				cde.setDateLivraison(d.toString());
				cde.setEtat('P');
				cde.setNumCom(num.getText());
				state = conn.createStatement();
				result = state.executeQuery("SELECT idClient FROM Client WHERE codeClient = '" + code.getSelectedItem() + "'");
				result.first();
				cde.setIdClient(result.getInt("idClient"));
				cde.setTotal(0);

				System.out.println(cde.getDateCom() + " " + cde.getDateLivraison() + " " + cde.getEtat() + " " + cde.getIdClient() + " " + cde.getTotal() + " " + cde.getNumCom());
				cmde.insertCommande(cde);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void SupprCommande(int idCommande) {
		// On commence par supprimer les lignes (contraintes d'integrites des Foreign Key)
		ArrayList<LigneCommande> list = ligne.getAllLignePourCommande(idCommande);
		for(LigneCommande lig : list) {
			ligne.removeLigneCommande(lig.getIdLigne());
		}
		
		// On fini par supprimer la commande
		cmde.removeCommande(idCommande);
	}
}
