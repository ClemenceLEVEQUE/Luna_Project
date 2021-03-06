package com.luna.traitement;

import java.util.ArrayList;
import java.util.List;
import com.luna.entities.Article;

import javax.swing.table.AbstractTableModel;

public class ArticleTableModel extends AbstractTableModel {
	private String[] columnNames = {"Id", "Code", "Catégorie", "Désignation", "Stock", "Prix unitaire"};
	private ArrayList<Article> articles;

	public ArticleTableModel(ArrayList<Article> articles) {
		this.articles = articles;
	}
	
	public List<Article> getArticle(){
		return articles;
	}

	@Override
	public int getRowCount() {
		return articles.size();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case 0:
				return Integer.class;
			case 1:
				return String.class;
	
			case 2:
				return String.class;
	
			case 3:
				return String.class;
	
			case 4:
				return Integer.class;
	
			case 5:
				return Float.class;
				
			default:
				return Object.class;
		}
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
		case 0: // Id
			return articles.get(rowIndex).getIdArticle();
		case 1: // Nom
			return articles.get(rowIndex).getCodeArt();
		case 2: // Prenom
			return articles.get(rowIndex).getCategorie();
		case 3: // Code client
			return articles.get(rowIndex).getNomArticle();
		case 4: // Tel
			return articles.get(rowIndex).getStock();
		case 5: // Mail
			return articles.get(rowIndex).getPrixUnitaire();
		default:
			throw new IllegalArgumentException();
		}
	}
}
