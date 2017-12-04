package com.luna.graphique;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.luna.traitement.ClientTableModel;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

public class PClients extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	private PClientsModif modif;
	private PClientsAjout ajout;
	private PClientsSearch search;
	private JTable table;
	private ClientTableModel model;
	/**
	 * Create the panel.
	 */
	public PClients(FClient cli) {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 160, 560);
		panel.setLayout(null);
		panel.setBackground(new Color(23, 152, 204));
		add(panel);

		JLabel lblClients = new JLabel("Clients");
		lblClients.setIcon(new ImageIcon(PClients.class.getResource("/gestion/client/People-64-actif.png")));
		lblClients.setHorizontalAlignment(SwingConstants.CENTER);
		lblClients.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblClients.setBounds(0, 5, 160, 64);
		panel.add(lblClients);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajout();
			}
		});
		btnAjouter.setRolloverIcon(new ImageIcon(PClients.class.getResource("/gestion/Add-New-48-actif.png")));
		btnAjouter.setHorizontalAlignment(SwingConstants.LEFT);
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAjouter.setFocusable(false);
		btnAjouter.setContentAreaFilled(false);
		btnAjouter.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAjouter.setIcon(new ImageIcon(FClient.class.getResource("/gestion/Add-New-48.png")));
		btnAjouter.setBounds(12, 80, 95, 49);
		panel.add(btnAjouter);

		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnRechercher.setRolloverIcon(new ImageIcon(PClients.class.getResource("/gestion/Search-48-actif.png")));
		btnRechercher.setHorizontalAlignment(SwingConstants.LEFT);
		btnRechercher.setForeground(Color.WHITE);
		btnRechercher.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRechercher.setFocusable(false);
		btnRechercher.setContentAreaFilled(false);
		btnRechercher.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnRechercher.setIcon(new ImageIcon(FAcceuil.class.getResource("/gestion/Search-48.png")));
		btnRechercher.setBounds(12, 130, 117, 49);
		panel.add(btnRechercher);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modif();
			}
		});
		btnModifier.setRolloverIcon(new ImageIcon(PClients.class.getResource("/gestion/Data-Edit-48-actif.png")));
		btnModifier.setHorizontalAlignment(SwingConstants.LEFT);
		btnModifier.setForeground(Color.WHITE);
		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnModifier.setFocusable(false);
		btnModifier.setContentAreaFilled(false);
		btnModifier.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnModifier.setIcon(new ImageIcon(FAcceuil.class.getResource("/gestion/Data-Edit-48.png")));
		btnModifier.setBounds(12, 180, 99, 49);
		panel.add(btnModifier);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setRolloverIcon(new ImageIcon(PClients.class.getResource("/gestion/Garbage-Open-48-actif.png")));
		btnSupprimer.setHorizontalAlignment(SwingConstants.LEFT);
		btnSupprimer.setForeground(Color.WHITE);
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSupprimer.setFocusable(false);
		btnSupprimer.setContentAreaFilled(false);
		btnSupprimer.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnSupprimer.setIcon(new ImageIcon(FAcceuil.class.getResource("/gestion/Garbage-Open-48.png")));
		btnSupprimer.setBounds(12, 230, 113, 49);
		panel.add(btnSupprimer);

		JButton btnAperu = new JButton("Aper\u00E7u");
		btnAperu.setRolloverIcon(new ImageIcon(PClients.class.getResource("/gestion/Preview-48-actif.png")));
		btnAperu.setHorizontalAlignment(SwingConstants.LEFT);
		btnAperu.setForeground(Color.WHITE);
		btnAperu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAperu.setFocusable(false);
		btnAperu.setContentAreaFilled(false);
		btnAperu.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAperu.setIcon(new ImageIcon(FAcceuil.class.getResource("/gestion/Preview-48.png")));
		btnAperu.setBounds(12, 310, 113, 49);
		panel.add(btnAperu);

		JButton btnImprimer = new JButton("Imprimer");
		btnImprimer.setRolloverIcon(new ImageIcon(PClients.class.getResource("/gestion/Printer-48-actif.png")));
		btnImprimer.setHorizontalAlignment(SwingConstants.LEFT);
		btnImprimer.setForeground(Color.WHITE);
		btnImprimer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnImprimer.setFocusable(false);
		btnImprimer.setContentAreaFilled(false);
		btnImprimer.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnImprimer.setIcon(new ImageIcon(FAcceuil.class.getResource("/gestion/Printer-48.png")));
		btnImprimer.setBounds(12, 360, 113, 49);
		panel.add(btnImprimer);

		JButton btnExporter = new JButton("Exporter");
		btnExporter.setRolloverIcon(new ImageIcon(PClients.class.getResource("/gestion/Data-Export-48-actif.png")));
		btnExporter.setHorizontalAlignment(SwingConstants.LEFT);
		btnExporter.setForeground(Color.WHITE);
		btnExporter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExporter.setFocusable(false);
		btnExporter.setContentAreaFilled(false);
		btnExporter.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnExporter.setIcon(new ImageIcon(FAcceuil.class.getResource("/gestion/Data-Export-48.png")));
		btnExporter.setBounds(12, 410, 113, 49);
		panel.add(btnExporter);

		JButton btnAcceuil = new JButton("Acceuil");
		btnAcceuil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FAcceuil fen = new FAcceuil();
				fen.setVisible(true);
				cli.dispose();
			}
		});
		btnAcceuil.setRolloverIcon(new ImageIcon(PClients.class.getResource("/gestion/Home-48-actif.png")));
		btnAcceuil.setHorizontalAlignment(SwingConstants.LEFT);
		btnAcceuil.setForeground(Color.WHITE);
		btnAcceuil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAcceuil.setFocusable(false);
		btnAcceuil.setContentAreaFilled(false);
		btnAcceuil.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAcceuil.setIcon(new ImageIcon(FAcceuil.class.getResource("/gestion/Home-48.png")));
		btnAcceuil.setBounds(12, 500, 113, 49);
		panel.add(btnAcceuil);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { lblClients, btnAjouter, btnRechercher,
				btnModifier, btnSupprimer, btnAperu, btnImprimer, btnExporter, btnAcceuil }));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(160, 0, 590, 560);
		panel_1.setBackground(new Color(197, 234, 249));
		add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 11, 564, 246);
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(new Color(197, 234, 249));

		JLabel label_1 = new JLabel("Cr\u00E9\u00E9 le :");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(295, 11, 46, 14);
		panel_2.add(label_1);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(379, 9, 175, 20);
		panel_2.add(textField);

		JLabel lblCodeClient = new JLabel("Code client :");
		lblCodeClient.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodeClient.setBounds(10, 11, 77, 14);
		panel_2.add(lblCodeClient);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(97, 9, 175, 20);
		panel_2.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(97, 134, 457, 102);
		panel_2.add(textField_2);

		JLabel lblRemarques = new JLabel("Remarques : ");
		lblRemarques.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRemarques.setBounds(10, 136, 77, 14);
		panel_2.add(lblRemarques);

		JLabel lblRue = new JLabel("Rue :");
		lblRue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRue.setBounds(10, 86, 46, 14);
		panel_2.add(lblRue);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(97, 84, 457, 20);
		panel_2.add(textField_3);

		JLabel lblTel = new JLabel("Tel :");
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTel.setBounds(10, 111, 46, 14);
		panel_2.add(lblTel);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(97, 109, 175, 20);
		panel_2.add(textField_4);

		JLabel lblVille = new JLabel("Ville :");
		lblVille.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVille.setBounds(10, 61, 46, 14);
		panel_2.add(lblVille);

		JLabel label_7 = new JLabel("Nom :");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_7.setBounds(295, 36, 47, 14);
		panel_2.add(label_7);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(379, 34, 175, 20);
		panel_2.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(97, 59, 175, 20);
		panel_2.add(textField_6);

		JLabel label_8 = new JLabel("Mail :");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_8.setBounds(295, 111, 46, 14);
		panel_2.add(label_8);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(379, 109, 175, 20);
		panel_2.add(textField_7);

		JLabel label_9 = new JLabel("Code postal :");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_9.setBounds(295, 61, 83, 14);
		panel_2.add(label_9);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(379, 59, 175, 20);
		panel_2.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(97, 34, 175, 20);
		panel_2.add(textField_9);

		JLabel lblPrnom = new JLabel("Pr\u00E9nom :");
		lblPrnom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrnom.setBounds(10, 36, 77, 14);
		panel_2.add(lblPrnom);

		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Odre croissant (a - z)", "Ordre d\u00E9croissant (z - a)"}));
		comboBox.setBounds(114, 525, 175, 20);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 263, 564, 251);

		JLabel lblTrierLaListe = new JLabel("Trier la liste par :");
		lblTrierLaListe.setBounds(12, 528, 100, 14);
		lblTrierLaListe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.setLayout(null);
		panel_1.add(panel_2);
		panel_1.add(scrollPane);

		model = new ClientTableModel();

		table = new JTable(model);
		scrollPane.setViewportView(table);
		panel_1.add(lblTrierLaListe);
		panel_1.add(comboBox);
		panel_1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { panel_2, label_1, textField,
				lblCodeClient, textField_1, textField_2, lblRemarques, lblRue, textField_3, lblTel, textField_4,
				lblVille, label_7, textField_5, textField_6, label_8, textField_7, label_9, textField_8, textField_9,
				lblPrnom, scrollPane, lblTrierLaListe, comboBox }));

	}

	public void setPClientsModif(PClientsModif modif) {
		this.modif = modif;
	}

	public void setPClientsAjout(PClientsAjout ajout) {
		this.ajout = ajout;
	}

	public void setPClientsSearch(PClientsSearch search) {
		this.search = search;
	}

	public void modif() {
		this.setVisible(false);
		modif.setVisible(true);
	}

	public void ajout() {
		this.setVisible(false);
		ajout.setVisible(true);
	}

	public void search() {
		this.setVisible(false);
		search.setVisible(true);
	}
}
