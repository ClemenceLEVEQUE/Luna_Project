package com.luna.graphique;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.luna.traitement.CommandeTraitement;

public class PCommandeSearch extends JPanel {
	private JTable table;
	private JTextField txtSearch;

	/**
	 * Create the panel.
	 */
	public PCommandeSearch(PCommande cmde) {
		setLayout(null);
		CommandeTraitement cde = new CommandeTraitement();

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 210, 560);
		panel.setLayout(null);
		panel.setBackground(new Color(255,136,9));
		add(panel);

		JLabel lblClients = new JLabel("Commande");
		lblClients.setIcon(new ImageIcon(PCommandeSearch.class.getResource("/gestion/commande/Shopping-Bag-64-actif.png")));
		lblClients.setHorizontalAlignment(SwingConstants.CENTER);
		lblClients.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblClients.setBounds(0, 5, 210, 64);
		panel.add(lblClients);

		JButton btnAperu = new JButton("Aper\u00E7u");
		btnAperu.setRolloverIcon(new ImageIcon(PCommandeSearch.class.getResource("/gestion/Preview-48-actif.png")));
		btnAperu.setHorizontalAlignment(SwingConstants.LEFT);
		btnAperu.setForeground(Color.WHITE);
		btnAperu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAperu.setFocusable(false);
		btnAperu.setContentAreaFilled(false);
		btnAperu.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAperu.setIcon(new ImageIcon(FAcceuil.class.getResource("/gestion/Preview-48.png")));
		btnAperu.setBounds(10, 310, 113, 49);
		panel.add(btnAperu);

		JButton btnImprimer = new JButton("Imprimer");
		btnImprimer.setRolloverIcon(new ImageIcon(PCommandeSearch.class.getResource("/gestion/Printer-48-actif.png")));
		btnImprimer.setHorizontalAlignment(SwingConstants.LEFT);
		btnImprimer.setForeground(Color.WHITE);
		btnImprimer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnImprimer.setFocusable(false);
		btnImprimer.setContentAreaFilled(false);
		btnImprimer.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnImprimer.setIcon(new ImageIcon(FAcceuil.class.getResource("/gestion/Printer-48.png")));
		btnImprimer.setBounds(10, 360, 113, 49);
		panel.add(btnImprimer);

		JButton btnExporter = new JButton("Exporter");
		btnExporter
				.setRolloverIcon(new ImageIcon(PCommandeSearch.class.getResource("/gestion/Data-Export-48-actif.png")));
		btnExporter.setHorizontalAlignment(SwingConstants.LEFT);
		btnExporter.setForeground(Color.WHITE);
		btnExporter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExporter.setFocusable(false);
		btnExporter.setContentAreaFilled(false);
		btnExporter.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnExporter.setIcon(new ImageIcon(FAcceuil.class.getResource("/gestion/Data-Export-48.png")));
		btnExporter.setBounds(10, 410, 113, 49);
		panel.add(btnExporter);

		JButton btnAcceuil = new JButton("Annuler");
		btnAcceuil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			masquer(cmde);
			}
		});
		btnAcceuil.setRolloverIcon(new ImageIcon(PCommandeSearch.class.getResource("/gestion/Cancel-48-actif.png")));
		btnAcceuil.setHorizontalAlignment(SwingConstants.LEFT);
		btnAcceuil.setForeground(Color.WHITE);
		btnAcceuil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAcceuil.setFocusable(false);
		btnAcceuil.setContentAreaFilled(false);
		btnAcceuil.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAcceuil.setIcon(new ImageIcon(PCommandeSearch.class.getResource("/gestion/Cancel-48.png")));
		btnAcceuil.setBounds(12, 500, 113, 49);
		panel.add(btnAcceuil);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i != -1) {
					// Si ligne sélectionnée
					cde.SupprCommandeSearch((int) table.getValueAt(i, 0));
					ActuTable();
				} else {
					JOptionPane.showMessageDialog(btnSupprimer, "Aucune ligne de sélectionné.", "Suppression impossible",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSupprimer.setIcon(new ImageIcon(PCommandeSearch.class.getResource("/gestion/Garbage-Open-48.png")));
		btnSupprimer.setRolloverIcon(new ImageIcon(PCommandeSearch.class.getResource("/gestion/Garbage-Open-48-actif.png")));
		btnSupprimer.setHorizontalAlignment(SwingConstants.LEFT);
		btnSupprimer.setForeground(Color.WHITE);
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSupprimer.setFocusable(false);
		btnSupprimer.setContentAreaFilled(false);
		btnSupprimer.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnSupprimer.setBounds(10, 80, 113, 49);
		panel.add(btnSupprimer);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(210, 0, 590, 560);
		panel_1.setBackground(new Color(255,236,192));
		add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 570, 506);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			cde.getAllCommande(),
			new String[] {
				"id", "Num. de commande", "Code client", "Total TTC", "Date creation", "Date livr.", "Etat"
			}
		));
		table.getColumn("id").setMinWidth(0);
		table.getColumn("id").setMaxWidth(0);
		scrollPane.setViewportView(table);
		
		JLabel lblTotalDesCommandes = new JLabel("Total des commandes :");
		lblTotalDesCommandes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTotalDesCommandes.setBounds(10, 528, 141, 14);
		panel_1.add(lblTotalDesCommandes);
		
		JLabel lblTotal = new JLabel(" total \u20AC");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTotal.setBounds(161, 528, 109, 14);
		panel_1.add(lblTotal);
		
		JLabel lblRechercher = new JLabel("Rechercher :");
		lblRechercher.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRechercher.setBounds(312, 528, 79, 14);
		panel_1.add(lblRechercher);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSearch.setBounds(401, 526, 179, 20);
		panel_1.add(txtSearch);
		txtSearch.setColumns(10);
	}
	
	public void masquer(PCommande cmde) {
		this.setVisible(false);
		cmde.setVisible(true);
	}
	
	public void ActuTable() {
		CommandeTraitement cde = new CommandeTraitement();
		table.setModel(new DefaultTableModel(
			cde.getAllCommande(),
			new String[] {
				"id", "Num. de commande", "Code client", "Total TTC", "Date creation", "Date livr.", "Etat"
			}
		));
		table.getColumn("id").setMinWidth(0);
		table.getColumn("id").setMaxWidth(0);
	}
}
