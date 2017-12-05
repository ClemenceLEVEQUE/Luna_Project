package com.luna.traitement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
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
			result = state.executeQuery(
					"SELECT * FROM LigneCommande, Article WHERE LigneCommande.idArticle = Article.idArticle AND LigneCommande.IdCommande = "
							+ idCommande);
			int i = 0;
			result.last();
			int taille = result.getRow();
			Object[][] str = new Object[taille][6];
			result.beforeFirst();
			while (result.next()) {
				int id = result.getInt("idLigne");
				String code = new String(result.getString("codeArt"));
				String categorie = new String(result.getString("categorie"));
				int qte = result.getInt("quantite");
				float prix = result.getFloat("prixUnitaire");
				float total = prix * qte;

				str[i] = new Object[] { id, code, categorie, qte, prix, total };
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
			result = state.executeQuery(
					"SELECT * FROM Commande, Client WHERE Commande.idClient = Client.idClient ORDER BY numCommande desc");
			int i = 0;
			result.last();
			int taille = result.getRow();
			Object[][] str = new Object[taille][6];
			result.beforeFirst();
			while (result.next()) {
				int id = result.getInt("idCommande");
				String num = result.getString("numCommande");
				String code = new String(result.getString("codeClient"));
				String dateCrea = new String(result.getString("dateCom"));
				String dateLivr = new String(result.getString("dateLivraison"));
				char etat = result.getString("etat").charAt(0);
				float total = result.getFloat("total");

				str[i] = new Object[] { id, num, code, total, dateCrea, dateLivr, etat };
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
		String[] str = new String[list.size() + 1];
		int i = 1;
		str[0] = "Selectionnez un article...";
		for (Article art : list) {
			str[i] = art.getCodeArt();
			i++;
		}
		return str;
	}

	public String[] comboBoxClient() {
		ArrayList<Client> list = cli.getAllClient(0);
		String[] str = new String[list.size() + 1];
		int i = 1;
		str[0] = "Selectionnez un client...";
		for (Client cmde : list) {
			str[i] = cmde.getCodeClient();
			i++;
		}
		return str;
	}

	public void NouvCommande(JTextField date, JTextField num, JComboBox<String> code, JTextField id) {
		if (num.getText().isEmpty()) {
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

				// Instance de la classe Commande afin d'utiliser la fonction insertCommande de
				// CommandeDAO
				Commande cde = new Commande();
				cde.setDateCom(date.getText());
				cde.setDateLivraison(d.toString());
				cde.setEtat('P');
				cde.setNumCom(num.getText());
				state = conn.createStatement();
				result = state.executeQuery(
						"SELECT idClient FROM Client WHERE codeClient = '" + code.getSelectedItem() + "'");
				result.first();
				cde.setIdClient(result.getInt("idClient"));
				cde.setTotal(0);

				cmde.insertCommande(cde);

				state = conn.createStatement();
				result = state.executeQuery("SELECT idCommande FROM Commande WHERE dateCom = '" + cde.getDateCom()
						+ "' AND dateLivraison = '" + cde.getDateLivraison() + "' AND etat = 'P' AND numCommande = '"
						+ cde.getNumCom() + "'");
				result.first();
				id.setText("" + result.getInt("idCommande"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void SupprCommandeSearch(int idCommande) {
		ArrayList<LigneCommande> list = ligne.getAllLignePourCommande(idCommande);
		for (LigneCommande lig : list) {
			ligne.removeLigneCommande(lig.getIdLigne());
		}
		cmde.removeCommande(idCommande);
	}

	public void SupprAllLigne(JTextField id) {
		if (id.getText().isEmpty()) {

		} else {
			int idCommande = Integer.parseInt(id.getText());
			ArrayList<LigneCommande> list = ligne.getAllLignePourCommande(idCommande);
			for (LigneCommande lig : list) {
				ligne.removeLigneCommande(lig.getIdLigne());
			}
		}
	}

	public void SupprCommande(JTextField id) {
		if (id.getText().isEmpty()) {

		} else {
			int idCommande = Integer.parseInt(id.getText());
			ArrayList<LigneCommande> list = ligne.getAllLignePourCommande(idCommande);
			for (LigneCommande lig : list) {
				ligne.removeLigneCommande(lig.getIdLigne());
			}
			cmde.removeCommande(idCommande);
		}
	}

	public void Valider(JTextField id) {
		if (id.getText().isEmpty()) {

		} else {
			int i = Integer.parseInt(id.getText());
			Commande Comm = new Commande();
			Comm = cmde.getCommande(i);
			Comm.setEtat('V');
			cmde.updateCommande(Comm);
		}
	}

	public void RemplirArt(String codeArt, JTextField code, JTextField designation, JTextField montant,
			JTextField categorie, JTextField idArt) {
		try {
			state = conn.createStatement();
			result = state.executeQuery("SELECT idArticle FROM Article WHERE codeArt = '" + codeArt + "'");
			result.first();
			int id = result.getInt("idArticle");

			Article art = new Article();
			art = article.getArticle(id);
			code.setText(art.getCodeArt());
			designation.setText(art.getNomArticle());
			montant.setText("" + art.getPrixUnitaire());
			categorie.setText(art.getCategorie());
			idArt.setText("" + art.getIdArticle());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void ViderArt(JSpinner spinner, JTextField code, JTextField designation, JTextField montant,
			JTextField categorie, JTextField idArt) {
		code.setText("");
		designation.setText("");
		montant.setText("");
		categorie.setText("");
		idArt.setText("");
		spinner.setValue(0);
	}

	public void AjoutLigne(int idCommande, int idArt, int qte) {
		LigneCommande ligneCo = new LigneCommande();
		ligneCo.setIdArticle(idArt);
		ligneCo.setIdCommande(idCommande);
		ligneCo.setQuantite(qte);
		ligne.insertLigneCommande(ligneCo);
	}

	public void UpdateLigne(int idCommande, int idArt, int qte, int idLig) {
		LigneCommande ligneCo = new LigneCommande();
		ligneCo = ligne.getLigneCommande(idLig);
		ligneCo.setIdArticle(idArt);
		ligneCo.setIdCommande(idCommande);
		ligneCo.setQuantite(qte);
		ligne.updateLigneCommande(ligneCo);
	}

	public void SupprLig(int idLig) {
		ligne.removeLigneCommande(idLig);
	}

	public void RemplirDepuisTab(JTextField code, JTextField designation, JTextField montant, JTextField categorie,
			JTextField idArt, JSpinner spinner, JTextField idLig, int idLigne) {
		Article art = new Article();
		art = article.getArticle(Integer.parseInt(idArt.getText()));
		float total = art.getPrixUnitaire() * Integer.parseInt(spinner.getValue().toString());

		code.setText(art.getCodeArt());
		designation.setText(art.getNomArticle());
		montant.setText("" + total);
		categorie.setText(art.getCategorie());
		idArt.setText("" + art.getIdArticle());
		idLig.setText("" + idLigne);
	}
}
