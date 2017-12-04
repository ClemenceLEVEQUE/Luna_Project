package com.luna.traitement;

import javax.swing.JOptionPane;
import javax.swing.JSlider;
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
	
	public void AfficherArticle(JTextField code, JTextField designation, JTextField prix, JTextField categ, JSlider qte, JTextField id, int idArticle) {
		Article art = new Article();
		art = dao.getArticle(idArticle);
		code.setText(art.getCodeArt());
		designation.setText(art.getNomArticle());
		categ.setText(art.getCategorie());
		prix.setText("" + art.getPrixUnitaire());
		qte.setValue(art.getStock());
		id.setText("" + art.getIdArticle());
	}
	
	public void Effacer(JTextField code, JTextField designation, JTextField prix, JTextField categ, JSlider qte, JTextField id) {
		code.setText("");
		designation.setText("");
		prix.setText("");
		categ.setText("");
		qte.setValue(0);
		id.setText("");
	}
	
	public void Supprimer(JTextField code, JTextField designation, JTextField prix, JTextField categ, JSlider qte, JTextField id, int idArticle) {
		dao.removeArticle(idArticle);
		code.setText("");
		designation.setText("");
		prix.setText("");
		categ.setText("");
		qte.setValue(0);
		id.setText("");
	}
	
	public void Modifier(JTextField code, JTextField designation, JTextField prix, JTextField categ, JSlider qte, int idArticle) {
		Article Art = new Article();
		Art.setCodeArt(code.getText());
		Art.setNomArticle(designation.getText());
		Art.setPrixUnitaire(Float.parseFloat(prix.getText()));
		Art.setCategorie(categ.getText());
		Art.setStock(qte.getValue());
		Art.setIdArticle(idArticle);
		dao.updateArticle(Art);
	}
	
	public void Ajouter(JTextField code, JTextField designation, JTextField prix, JTextField categ, JSlider qte, JTextField Id) {
		if(Id.getText().equals("")) {
			if(code.getText().equals("")  || designation.getText().equals("") || prix.getText().equals("") || categ.getText().equals("")) {
				JOptionPane.showMessageDialog(Id, "Veuillez compléter tous les champs.",
						"Ajout impossible", JOptionPane.ERROR_MESSAGE);
			} else {
				if(true) {
					
				}
				Article Art = new Article();
				Art.setCodeArt(code.getText());
				Art.setNomArticle(designation.getText());
				Art.setPrixUnitaire(Float.parseFloat(prix.getText()));
				Art.setCategorie(categ.getText());
				Art.setStock(qte.getValue());
				dao.insertArticle(Art);
			}
		} else {
			JOptionPane.showMessageDialog(Id, "Avant d'ajouter un article, réinitialiser les champs en cliquant sur \"Effacer\"",
					"Ajout impossible", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void Verif(JTextField prix, JTextField categ, JSlider qte, JTextField Id) {
		try {
			
		} catch (Exception e){
			
		}
	}
}
