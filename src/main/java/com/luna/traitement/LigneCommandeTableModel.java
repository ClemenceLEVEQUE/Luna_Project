package com.luna.traitement;

import java.util.List;
import com.luna.entities.LigneCommande;
import com.luna.utils.GlobalConnection;
import com.luna.dao.*;

import javax.swing.table.AbstractTableModel;

public class LigneCommandeTableModel extends AbstractTableModel {
	private String[] columnNames = {"Id", "Code", "Catégorie", "Désignation", "Stock", "Prix unitaire"};
	private List<LigneCommande> ligneCommandes;

	public LigneCommandeTableModel() {
		LigneCommandeDAO dao = new LigneCommandeDAOmysql(GlobalConnection.getInstance());
		this.ligneCommandes = dao.getAllLigneCommande();
	}
	
	public List<LigneCommande> getLigneCommande(){
		return ligneCommandes;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
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
	
			case 3:
				return String.class;
	
			case 2:
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
			return ligneCommandes.get(rowIndex).getIdArticle();
		case 1: // Nom
			return ligneCommandes.get(rowIndex).getIdArticle();
		case 2: // Prenom
			return ligneCommandes.get(rowIndex).getIdArticle();
		case 3: // Code client
			return ligneCommandes.get(rowIndex).getIdArticle();
		default:
			throw new IllegalArgumentException();
		}
	}
}
