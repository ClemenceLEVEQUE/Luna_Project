package com.luna.traitement;

import java.util.List;
import com.luna.entities.Commande;
import com.luna.utils.GlobalConnection;
import com.luna.dao.*;

import javax.swing.table.AbstractTableModel;

public class CommandeTableModel extends AbstractTableModel {
	private String[] columnNames = {"Id", "Num commande", "Code client", "Date cmde", "Date livr", "Etat","Total"};
	private List<Commande> cmdes;

	public CommandeTableModel() {
		CommandeDAO dao = new CommandeDAOmysql(GlobalConnection.getInstance());
		this.cmdes = dao.getAllCommande();
	}
	
	public List<Commande> getCommande(){
		return cmdes;
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
	
			case 2:
				return Integer.class;
	
			case 3:
				return String.class;
	
			case 4:
				return String.class;
	
			case 5:
				return String.class;
				
			case 6:
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
			return cmdes.get(rowIndex).getIdCommande();
		case 1: // Num commande
			//return cmdes.get(rowIndex).getNumCommande();
		case 2: // Code client
			return cmdes.get(rowIndex).getIdClient();
		case 3: // Date cmde
			return cmdes.get(rowIndex).getDateCom();
		case 4: // Date livr
			return cmdes.get(rowIndex).getDateLivraison();
		case 5: // Etat
			return cmdes.get(rowIndex).getEtat();
		case 6: // Total
			//return cmdes.get(rowIndex).getTotal();
		default:
			throw new IllegalArgumentException();
		}
	}
}
