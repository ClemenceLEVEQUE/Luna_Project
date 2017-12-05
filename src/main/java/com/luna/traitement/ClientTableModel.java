package com.luna.traitement;

import java.util.ArrayList;
import java.util.List;
import com.luna.entities.Client;
import com.luna.utils.GlobalConnection;
import com.luna.dao.*;

import javax.swing.table.AbstractTableModel;

public class ClientTableModel extends AbstractTableModel {
	private String[] columnNames = {"Id", "Nom", "Prénom", "Code client", "Tel", "Mail"};
	private ArrayList<Client> clients;

	public ClientTableModel(int sortby) {
		ClientDAO dao = new ClientDAOmysql(GlobalConnection.getInstance());
		this.clients = dao.getAllClient(sortby);
	}
	
	public List<Client> getClient(){
		return clients;
	}

	@Override
	public int getRowCount() {
		return clients.size();
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
				return String.class;
	
			case 5:
				return String.class;
				
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
			return clients.get(rowIndex).getIdClient();
		case 1: // Nom
			return clients.get(rowIndex).getNom();
		case 2: // Prenom
			return clients.get(rowIndex).getPrenom();
		case 3: // Code client
			return clients.get(rowIndex).getCodeClient();
		case 4: // Tel
			return clients.get(rowIndex).getTel();
		case 5: // Mail
			return clients.get(rowIndex).getMail();
		default:
			throw new IllegalArgumentException();
		}
	}
}
