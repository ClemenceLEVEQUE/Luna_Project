package com.luna.traitement;

import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.luna.dao.ArticleDAO;
import com.luna.dao.ArticleDAOmysql;
import com.luna.entities.Article;
import com.luna.utils.GlobalConnection;

public class ArticleTraitement {
	ArticleDAO dao;

	public ArticleTraitement() {
		this.dao = new ArticleDAOmysql(GlobalConnection.getInstance());
	}

	public void AfficherArticle(JTextField code, JTextField designation, JTextField prix, JTextField categ, JSlider qte,
			JTextField id, int idArticle) {
		Article art = new Article();
		art = dao.getArticle(idArticle);
		code.setText(art.getCodeArt());
		designation.setText(art.getNomArticle());
		categ.setText(art.getCategorie());
		prix.setText("" + art.getPrixUnitaire());
		qte.setValue(art.getStock());
		id.setText("" + art.getIdArticle());
	}

	public void Effacer(JTextField code, JTextField designation, JTextField prix, JTextField categ, JSlider qte,
			JTextField id) {
		code.setText("");
		designation.setText("");
		prix.setText("");
		categ.setText("");
		qte.setValue(0);
		id.setText("");
	}

	public void Supprimer(JTextField code, JTextField designation, JTextField prix, JTextField categ, JSlider qte,
			JTextField id, int idArticle) {
		if(dao.removeArticle(idArticle)) {
			code.setText("");
			designation.setText("");
			prix.setText("");
			categ.setText("");
			qte.setValue(0);
			id.setText("");
		} else {
			JOptionPane.showMessageDialog(code, "L'article est utilis� dans une commande.", "Suppression impossible",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void Modifier(JTextField code, JTextField designation, JTextField prix, JTextField categ, JSlider qte,
			int idArticle) {
		if (code.getText().equals("") || designation.getText().equals("") || prix.getText().equals("")
				|| categ.getText().equals("")) {
			JOptionPane.showMessageDialog(code, "Veuillez compl�ter tous les champs.", "Ajout impossible",
					JOptionPane.ERROR_MESSAGE);
		} else {
			if (VerifPrix(prix)) {
				Article Art = new Article();
				Art.setCodeArt(code.getText());
				Art.setNomArticle(designation.getText());
				Art.setPrixUnitaire(Float.parseFloat(prix.getText()));
				Art.setCategorie(categ.getText());
				Art.setStock(qte.getValue());
				Art.setIdArticle(idArticle);
				dao.updateArticle(Art);
			}
		}
	}

	public void Ajouter(JTextField code, JTextField designation, JTextField prix, JTextField categ, JSlider qte,
			JTextField Id) {
		if (Id.getText().equals("")) {
			if (code.getText().equals("") || designation.getText().equals("") || prix.getText().equals("")
					|| categ.getText().equals("")) {
				JOptionPane.showMessageDialog(Id, "Veuillez compl�ter tous les champs.", "Ajout impossible",
						JOptionPane.ERROR_MESSAGE);
			} else {
				if (VerifPrix(prix)) {
					Article Art = new Article();
					Art.setCodeArt(code.getText());
					Art.setNomArticle(designation.getText());
					Art.setPrixUnitaire(Float.parseFloat(prix.getText()));
					Art.setCategorie(categ.getText());
					Art.setStock(qte.getValue());
					dao.insertArticle(Art);
				}
			}
		} else {
			JOptionPane.showMessageDialog(Id,
					"Avant d'ajouter un article, r�initialiser les champs en cliquant sur \"Effacer\"",
					"Ajout impossible", JOptionPane.ERROR_MESSAGE);
		}
	}

	public boolean VerifPrix(JTextField prix) {
		try {
			float f = Float.parseFloat(prix.getText());
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(prix, "Le prix doit �tre au format \"999.99\"", "Ajout impossible",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
}
