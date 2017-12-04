package com.luna.graphique;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.luna.traitement.ArticleTableModel;
import com.luna.traitement.CommandeTraitement;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.ComponentOrientation;
import javax.swing.DebugGraphics;
import javax.swing.JSpinner;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.table.DefaultTableModel;

public class PCommande extends JPanel {

	private PCommandeSearch search;
	private ArticleTableModel model;
	private JTextField txtCommande;
	private JTextField txtDate;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTextField txtTotal;
	/**
	 * Create the panel.
	 */
	public PCommande(FCommande cmde) {
		setLayout(null);
		CommandeTraitement cde = new CommandeTraitement();

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 210, 560);
		panel.setLayout(null);
		panel.setBackground(new Color(255,136,9));
		add(panel);

		JLabel lblClients = new JLabel("Commande");
		lblClients.setIcon(new ImageIcon(PCommande.class.getResource("/gestion/commande/Shopping-Bag-64-actif.png")));
		lblClients.setHorizontalAlignment(SwingConstants.CENTER);
		lblClients.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblClients.setBounds(0, 5, 210, 64);
		panel.add(lblClients);

		JButton btnAjouter = new JButton("Commandes existante");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnAjouter.setRolloverIcon(new ImageIcon(PCommande.class.getResource("/gestion/Receipt-48-actif.png")));
		btnAjouter.setHorizontalAlignment(SwingConstants.LEFT);
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAjouter.setFocusable(false);
		btnAjouter.setContentAreaFilled(false);
		btnAjouter.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAjouter.setIcon(new ImageIcon(PCommande.class.getResource("/gestion/Receipt-48.png")));
		btnAjouter.setBounds(10, 80, 190, 49);
		panel.add(btnAjouter);

		JButton btnRechercher = new JButton("Supprimer");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnRechercher.setRolloverIcon(new ImageIcon(PCommande.class.getResource("/gestion/Cancel-48-actif.png")));
		btnRechercher.setHorizontalAlignment(SwingConstants.LEFT);
		btnRechercher.setForeground(Color.WHITE);
		btnRechercher.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRechercher.setFocusable(false);
		btnRechercher.setContentAreaFilled(false);
		btnRechercher.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnRechercher.setIcon(new ImageIcon(PCommande.class.getResource("/gestion/Cancel-48.png")));
		btnRechercher.setBounds(10, 130, 190, 49);
		panel.add(btnRechercher);

		JButton btnModifier = new JButton("Valider la commande");
		btnModifier.setRolloverIcon(new ImageIcon(PCommande.class.getResource("/gestion/commande/Shopping-Cart-05-48-actif.png")));
		btnModifier.setHorizontalAlignment(SwingConstants.LEFT);
		btnModifier.setForeground(Color.WHITE);
		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnModifier.setFocusable(false);
		btnModifier.setContentAreaFilled(false);
		btnModifier.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnModifier.setIcon(new ImageIcon(PCommande.class.getResource("/gestion/commande/Shopping-Cart-05-48.png")));
		btnModifier.setBounds(10, 230, 190, 49);
		panel.add(btnModifier);

		JButton btnSupprimer = new JButton("<html>Supprimer toutes<br/>les lignes</html>");
		btnSupprimer.setRolloverIcon(new ImageIcon(PCommande.class.getResource("/gestion/Garbage-Open-48-actif.png")));
		btnSupprimer.setHorizontalAlignment(SwingConstants.LEFT);
		btnSupprimer.setForeground(Color.WHITE);
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSupprimer.setFocusable(false);
		btnSupprimer.setContentAreaFilled(false);
		btnSupprimer.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnSupprimer.setIcon(new ImageIcon(FAcceuil.class.getResource("/gestion/Garbage-Open-48.png")));
		btnSupprimer.setBounds(10, 180, 190, 49);
		panel.add(btnSupprimer);

		JButton btnAperu = new JButton("Aper\u00E7u");
		btnAperu.setRolloverIcon(new ImageIcon(PCommande.class.getResource("/gestion/Preview-48-actif.png")));
		btnAperu.setHorizontalAlignment(SwingConstants.LEFT);
		btnAperu.setForeground(Color.WHITE);
		btnAperu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAperu.setFocusable(false);
		btnAperu.setContentAreaFilled(false);
		btnAperu.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAperu.setIcon(new ImageIcon(FAcceuil.class.getResource("/gestion/Preview-48.png")));
		btnAperu.setBounds(10, 310, 190, 49);
		panel.add(btnAperu);

		JButton btnImprimer = new JButton("Imprimer");
		btnImprimer.setRolloverIcon(new ImageIcon(PCommande.class.getResource("/gestion/Printer-48-actif.png")));
		btnImprimer.setHorizontalAlignment(SwingConstants.LEFT);
		btnImprimer.setForeground(Color.WHITE);
		btnImprimer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnImprimer.setFocusable(false);
		btnImprimer.setContentAreaFilled(false);
		btnImprimer.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnImprimer.setIcon(new ImageIcon(FAcceuil.class.getResource("/gestion/Printer-48.png")));
		btnImprimer.setBounds(10, 360, 190, 49);
		panel.add(btnImprimer);

		JButton btnExporter = new JButton("Exporter");
		btnExporter.setRolloverIcon(new ImageIcon(PCommande.class.getResource("/gestion/Data-Export-48-actif.png")));
		btnExporter.setHorizontalAlignment(SwingConstants.LEFT);
		btnExporter.setForeground(Color.WHITE);
		btnExporter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExporter.setFocusable(false);
		btnExporter.setContentAreaFilled(false);
		btnExporter.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnExporter.setIcon(new ImageIcon(FAcceuil.class.getResource("/gestion/Data-Export-48.png")));
		btnExporter.setBounds(10, 410, 190, 49);
		panel.add(btnExporter);

		JButton btnAcceuil = new JButton("Acceuil");
		btnAcceuil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FAcceuil fen = new FAcceuil();
				fen.setVisible(true);
				cmde.dispose();
			}
		});
		btnAcceuil.setRolloverIcon(new ImageIcon(PCommande.class.getResource("/gestion/Home-48-actif.png")));
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
		panel_1.setBounds(210, 0, 590, 560);
		panel_1.setBackground(new Color(255,236,192));
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Informations g\u00E9n\u00E9rale", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 11, 570, 79);
		panel_2.setBackground(new Color(255,236,192));
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCommandeEnCours = new JLabel("Commande en cours :");
		lblCommandeEnCours.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCommandeEnCours.setBounds(10, 26, 130, 14);
		panel_2.add(lblCommandeEnCours);
		
		JLabel lblNomDuClient = new JLabel("Nom du client :");
		lblNomDuClient.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomDuClient.setBounds(10, 51, 130, 14);
		panel_2.add(lblNomDuClient);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDate.setBounds(356, 26, 44, 14);
		panel_2.add(lblDate);
		
		txtCommande = new JTextField();
		txtCommande.setEnabled(false);
		txtCommande.setBounds(150, 24, 150, 20);
		panel_2.add(txtCommande);
		txtCommande.setColumns(10);
		
		txtDate = new JTextField();
		txtDate.setEnabled(false);
		txtDate.setBounds(410, 24, 150, 20);
		panel_2.add(txtDate);
		txtDate.setColumns(10);
		
		JButton btnSelectCli = new JButton("S\u00E9lectionner le client");
		btnSelectCli.setFocusable(false);
		btnSelectCli.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSelectCli.setBounds(150, 48, 410, 23);
		panel_2.add(btnSelectCli);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Commande", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 101, 570, 334);
		panel_3.setBackground(new Color(255,236,192));
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnSlectionnerUnArticle = new JButton("<html>S\u00E9lectionner<br/>un article</html>");
		btnSlectionnerUnArticle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSlectionnerUnArticle.setFocusable(false);
		btnSlectionnerUnArticle.setBounds(10, 20, 140, 50);
		panel_3.add(btnSlectionnerUnArticle);
		
		JLabel lblCode = new JLabel("Code :");
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCode.setBounds(160, 26, 85, 14);
		panel_3.add(lblCode);
		
		JLabel lblCatgorie = new JLabel("Cat\u00E9gorie :");
		lblCatgorie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCatgorie.setBounds(10, 87, 64, 14);
		panel_3.add(lblCatgorie);
		
		JLabel lblDsignation = new JLabel("D\u00E9signation :");
		lblDsignation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDsignation.setBounds(160, 51, 85, 14);
		panel_3.add(lblDsignation);
		
		JLabel lblMontant = new JLabel("Montant :");
		lblMontant.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMontant.setBounds(244, 87, 64, 14);
		panel_3.add(lblMontant);
		
		JLabel lblQuantit = new JLabel("Quantit\u00E9 :");
		lblQuantit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantit.setBounds(413, 87, 64, 14);
		panel_3.add(lblQuantit);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(255, 24, 150, 20);
		panel_3.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(255, 49, 305, 20);
		panel_3.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(84, 85, 150, 20);
		panel_3.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(318, 85, 85, 20);
		panel_3.add(textField_3);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(487, 85, 73, 20);
		panel_3.add(spinner);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(117, 115, 360, 50);
		toolBar.setBackground(new Color(255,236,192));
		panel_3.add(toolBar);
		
		JButton btnAjouter_1 = new JButton("Ajouter     ");
		btnAjouter_1.setRolloverIcon(new ImageIcon(PCommande.class.getResource("/gestion/Add-New-48-actif.png")));
		btnAjouter_1.setIcon(new ImageIcon(PCommande.class.getResource("/gestion/Add-New-48.png")));
		btnAjouter_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnAjouter_1.setForeground(Color.BLACK);
		btnAjouter_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAjouter_1.setFocusable(false);
		btnAjouter_1.setContentAreaFilled(false);
		btnAjouter_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		toolBar.add(btnAjouter_1);
		
		JButton btnModifier_1 = new JButton("Modifier     ");
		btnModifier_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModifier_1.setRolloverIcon(new ImageIcon(PCommande.class.getResource("/gestion/Data-Edit-48-actif.png")));
		btnModifier_1.setIcon(new ImageIcon(PCommande.class.getResource("/gestion/Data-Edit-48.png")));
		btnModifier_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnModifier_1.setForeground(Color.BLACK);
		btnModifier_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnModifier_1.setFocusable(false);
		btnModifier_1.setContentAreaFilled(false);
		btnModifier_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		toolBar.add(btnModifier_1);
		
		JButton btnSupprimer_1 = new JButton("Supprimer");
		btnSupprimer_1.setRolloverIcon(new ImageIcon(PCommande.class.getResource("/gestion/Cancel-48-actif.png")));
		btnSupprimer_1.setIcon(new ImageIcon(PCommande.class.getResource("/gestion/Cancel-48.png")));
		btnSupprimer_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnSupprimer_1.setForeground(Color.BLACK);
		btnSupprimer_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSupprimer_1.setFocusable(false);
		btnSupprimer_1.setContentAreaFilled(false);
		btnSupprimer_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		toolBar.add(btnSupprimer_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 176, 550, 147);
		panel_3.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addColumn(new String[] {"id", "Code article", "Cat\u00E9gorie", "Quantit\u00E9", "Prix unitaire", "Total"});
		model = cde.getLigneCommandeArticle(model);
		table.setModel(model);
		table.getColumn("id").setMinWidth(0);
		table.getColumn("id").setMaxWidth(0);
		scrollPane.setViewportView(table);
		//cde.getLigneCommandeArticle(table);
		
		JButton button = new JButton("Valider la commande");
		button.setRolloverIcon(new ImageIcon(PCommande.class.getResource("/gestion/commande/Shopping-Cart-05-48-actif.png")));
		button.setIcon(new ImageIcon(PCommande.class.getResource("/gestion/commande/Shopping-Cart-05-48.png")));
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.setFocusable(false);
		button.setContentAreaFilled(false);
		button.setBorder(new EmptyBorder(0, 0, 0, 0));
		button.setBounds(390, 500, 190, 49);
		panel_1.add(button);
		
		txtTotal = new JTextField();
		txtTotal.setEnabled(false);
		txtTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTotal.setBackground(new Color(255,136,9));
		txtTotal.setBounds(440, 455, 126, 43);
		panel_1.add(txtTotal);
		txtTotal.setColumns(10);
	}

	public void setPCommandeSearch(PCommandeSearch search) {
		this.search = search;
	}
	
	public void search() {
		this.setVisible(false);
		search.setVisible(true);
	}
}
