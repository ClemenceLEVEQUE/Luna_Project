package com.luna.traitement;

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
}
