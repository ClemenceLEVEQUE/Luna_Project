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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PCommande extends JPanel {

	private PCommandeSearch search;
	private JTextField txtCommande;
	private JTextField txtDate;
	private JTextField txtCode;
	private JTextField txtDesignation;
	private JTextField txtCateg;
	private JTextField txtMontant;
	private JTable table;
	private JTextField txtTotal;
	private JTextField txtId;
	private JTextField txtIdart;
	private JTextField txtIdLig;

	/**
	 * Create the panel.
	 */
	public PCommande(FCommande cmde) {
		setLayout(null);
		CommandeTraitement cde = new CommandeTraitement();

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 210, 560);
		panel.setLayout(null);
		panel.setBackground(new Color(255, 136, 9));
		add(panel);

		JLabel lblClients = new JLabel("Commande");
		lblClients.setIcon(new ImageIcon(PCommande.class.getResource("/gestion/commande/Shopping-Bag-64-actif.png")));
		lblClients.setHorizontalAlignment(SwingConstants.CENTER);
		lblClients.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblClients.setBounds(0, 5, 210, 64);
		panel.add(lblClients);

		JButton btnList = new JButton("Commandes existante");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnList.setRolloverIcon(new ImageIcon(PCommande.class.getResource("/gestion/Receipt-48-actif.png")));
		btnList.setHorizontalAlignment(SwingConstants.LEFT);
		btnList.setForeground(Color.WHITE);
		btnList.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnList.setFocusable(false);
		btnList.setContentAreaFilled(false);
		btnList.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnList.setIcon(new ImageIcon(PCommande.class.getResource("/gestion/Receipt-48.png")));
		btnList.setBounds(10, 80, 190, 49);
		panel.add(btnList);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(210, 0, 590, 560);
		panel_1.setBackground(new Color(255, 236, 192));
		add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Commande", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 101, 570, 334);
		panel_3.setBackground(new Color(255, 236, 192));
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setVisible(false);

		JSpinner spinner = new JSpinner();
		spinner.setForeground(Color.BLACK);
		spinner.setBounds(487, 85, 73, 20);
		panel_3.add(spinner);

		JButton btnSupprimerCom = new JButton("Supprimer");
		btnSupprimerCom.setEnabled(false);
		btnSupprimerCom.addActionListener(new ActionListener() {
			private JTextField txtNumCommande;

			public void actionPerformed(ActionEvent e) {
				cde.SupprCommande(txtId);
				txtNumCommande.setText("");
				txtDate.setText("");
				txtDesignation.setText("");
				txtCateg.setText("");
				txtCode.setText("");
				txtMontant.setText("");
				spinner.setValue(0);
				txtId.setText("");
			}
		});
		btnSupprimerCom.setRolloverIcon(new ImageIcon(PCommande.class.getResource("/gestion/Cancel-48-actif.png")));
		btnSupprimerCom.setHorizontalAlignment(SwingConstants.LEFT);
		btnSupprimerCom.setForeground(Color.WHITE);
		btnSupprimerCom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSupprimerCom.setFocusable(false);
		btnSupprimerCom.setContentAreaFilled(false);
		btnSupprimerCom.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnSupprimerCom.setIcon(new ImageIcon(PCommande.class.getResource("/gestion/Cancel-48.png")));
		btnSupprimerCom.setBounds(10, 130, 190, 49);
		panel.add(btnSupprimerCom);

		JButton btnValider = new JButton("Valider la commande");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cde.Valider(txtId);
			}
		});
		btnValider.setRolloverIcon(
				new ImageIcon(PCommande.class.getResource("/gestion/commande/Shopping-Cart-05-48-actif.png")));
		btnValider.setHorizontalAlignment(SwingConstants.LEFT);
		btnValider.setForeground(Color.WHITE);
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnValider.setFocusable(false);
		btnValider.setContentAreaFilled(false);
		btnValider.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnValider.setIcon(new ImageIcon(PCommande.class.getResource("/gestion/commande/Shopping-Cart-05-48.png")));
		btnValider.setBounds(10, 230, 190, 49);
		panel.add(btnValider);

		JButton btnSupprimerAllLig = new JButton("<html>Supprimer toutes<br/>les lignes</html>");
		btnSupprimerAllLig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cde.SupprAllLigne(txtId);
			}
		});
		btnSupprimerAllLig
				.setRolloverIcon(new ImageIcon(PCommande.class.getResource("/gestion/Garbage-Open-48-actif.png")));
		btnSupprimerAllLig.setHorizontalAlignment(SwingConstants.LEFT);
		btnSupprimerAllLig.setForeground(Color.WHITE);
		btnSupprimerAllLig.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSupprimerAllLig.setFocusable(false);
		btnSupprimerAllLig.setContentAreaFilled(false);
		btnSupprimerAllLig.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnSupprimerAllLig.setIcon(new ImageIcon(FAcceuil.class.getResource("/gestion/Garbage-Open-48.png")));
		btnSupprimerAllLig.setBounds(10, 180, 190, 49);
		panel.add(btnSupprimerAllLig);

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

		txtId = new JTextField();
		txtId.setVisible(false);
		txtId.setBounds(124, 63, 86, 20);
		panel.add(txtId);
		txtId.setColumns(10);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { lblClients, btnList, btnSupprimerCom,
				btnValider, btnSupprimerAllLig, btnAperu, btnImprimer, btnExporter, btnAcceuil }));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Informations g\u00E9n\u00E9rale", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 11, 570, 79);
		panel_2.setBackground(new Color(255, 236, 192));
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

		JLabel lblCode = new JLabel("Code :");
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCode.setBounds(160, 26, 85, 14);
		panel_3.add(lblCode);

		JComboBox<String> comboBoxCli = new JComboBox<String>();
		comboBoxCli.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBoxCli.getSelectedItem().equals("Selectionnez un client...")) {
					panel_3.setVisible(false);
				} else {
					panel_3.setVisible(true);
					cde.NouvCommande(txtDate, txtCommande, comboBoxCli, txtId);
				}
			}
		});
		comboBoxCli.setModel(new DefaultComboBoxModel<String>(cde.comboBoxClient()));
		comboBoxCli.setBounds(150, 49, 410, 20);
		panel_2.add(comboBoxCli);

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

		txtCode = new JTextField();
		txtCode.setForeground(Color.BLACK);
		txtCode.setEnabled(false);
		txtCode.setColumns(10);
		txtCode.setBounds(255, 24, 150, 20);
		panel_3.add(txtCode);

		txtDesignation = new JTextField();
		txtDesignation.setForeground(Color.BLACK);
		txtDesignation.setEnabled(false);
		txtDesignation.setColumns(10);
		txtDesignation.setBounds(255, 49, 305, 20);
		panel_3.add(txtDesignation);

		txtCateg = new JTextField();
		txtCateg.setForeground(Color.BLACK);
		txtCateg.setEnabled(false);
		txtCateg.setColumns(10);
		txtCateg.setBounds(84, 85, 150, 20);
		panel_3.add(txtCateg);

		txtMontant = new JTextField();
		txtMontant.setForeground(Color.BLACK);
		txtMontant.setEnabled(false);
		txtMontant.setColumns(10);
		txtMontant.setBounds(318, 85, 85, 20);
		panel_3.add(txtMontant);

		JToolBar toolBar = new JToolBar();
		toolBar.setBorder(new EmptyBorder(0, 0, 0, 0));
		toolBar.setFloatable(false);
		toolBar.setBounds(117, 115, 360, 50);
		toolBar.setBackground(new Color(255, 236, 192));
		panel_3.add(toolBar);

		JButton btnAjouter_1 = new JButton("Ajouter     ");
		btnAjouter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cde.AjoutLigne(Integer.parseInt(txtId.getText()), Integer.parseInt(txtIdart.getText()),
						Integer.parseInt(spinner.getValue().toString()), txtTotal);
				ActuTab();
			}
		});
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
				int lig = table.getSelectedRow();
				cde.UpdateLigne(Integer.parseInt(txtId.getText()), Integer.parseInt(txtIdart.getText()),
						Integer.parseInt(spinner.getValue().toString()), (int) table.getValueAt(lig, 0), txtTotal);
				ActuTab();
				table.changeSelection(lig, 0, false, false);
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
		btnSupprimer_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = table.getSelectedRow();
				cde.SupprLig((int) table.getValueAt(n, 0), txtTotal);
				ActuTab();
			}
		});
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

		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "id", "Code article", "Cat\u00E9gorie", "Quantit\u00E9", "Prix unitaire", "Total" }));
		table.getColumn("id").setMinWidth(0);
		table.getColumn("id").setMaxWidth(0);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cde.RemplirDepuisTab(txtCode, txtDesignation, txtMontant, txtCateg, txtIdart, spinner, txtIdLig,
						(int) table.getValueAt(table.getSelectedRow(), 0));
			}
		});
		scrollPane.setViewportView(table);

		JComboBox<String> comboBoxArt = new JComboBox<String>();
		comboBoxArt.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBoxArt.getSelectedItem().equals("Selectionnez un article...")) {
					cde.ViderArt(spinner, txtCode, txtDesignation, txtMontant, txtCateg, txtIdart);
				} else {
					cde.RemplirArt(comboBoxArt.getSelectedItem().toString(), txtCode, txtDesignation, txtMontant,
							txtCateg, txtIdart);
				}
			}
		});
		comboBoxArt.setModel(new DefaultComboBoxModel<String>(cde.comboBoxArticle()));
		comboBoxArt.setBounds(10, 20, 140, 50);
		panel_3.add(comboBoxArt);

		txtIdart = new JTextField();
		txtIdart.setVisible(false);
		txtIdart.setBounds(10, 121, 86, 20);
		panel_3.add(txtIdart);
		txtIdart.setColumns(10);

		txtIdLig = new JTextField();
		txtIdLig.setVisible(false);
		txtIdLig.setBounds(10, 152, 86, 20);
		panel_3.add(txtIdLig);
		txtIdLig.setColumns(10);

		JButton button = new JButton("Valider la commande");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cde.Valider(txtId);
			}
		});
		button.setRolloverIcon(
				new ImageIcon(PCommande.class.getResource("/gestion/commande/Shopping-Cart-05-48-actif.png")));
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
		txtTotal.setBackground(new Color(255, 136, 9));
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
		search.ActuTable();
	}

	public void ActuTab() {
		CommandeTraitement cde = new CommandeTraitement();
		if (txtId.getText().isEmpty()) {

		} else {
			table.setModel(new DefaultTableModel(cde.getTouteLigne(Integer.parseInt(txtId.getText())), new String[] {
					"id", "Code article", "Cat\u00E9gorie", "Quantit\u00E9", "Prix unitaire", "Total" }));
			table.getColumn("id").setMinWidth(0);
			table.getColumn("id").setMaxWidth(0);
		}
	}
}
