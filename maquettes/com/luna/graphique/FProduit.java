package com.luna.graphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import com.luna.dao.ArticleDAO;
import com.luna.dao.ArticleDAOmysql;
import com.luna.traitement.ArticleTableModel;
import com.luna.utils.GlobalConnection;
import com.luna.traitement.ArticleTraitement;

import javax.swing.event.ChangeEvent;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import java.awt.Toolkit;

public class FProduit extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JTextField txtCode;
	private JTextField txtCatgorie;
	private JTextField txtDsignation;
	private JTextField txtPrixUnitaire;
	private JTextField txtStock;
	private JTextField textField;
	private ArticleTableModel model;
	private JTextField txtId;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FProduit frame = new FProduit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FProduit() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FProduit.class.getResource("/com/luna/graphique/Moon-32.png")));
		setTitle("Gestion des Articles");
		ArticleTraitement art = new ArticleTraitement();
		ArticleDAO dao = new ArticleDAOmysql(GlobalConnection.getInstance());
		setResizable(false);
		setMinimumSize(new Dimension(750, 586));
		setMaximumSize(new Dimension(1000, 1000));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 586);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(227, 241, 182));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102,152,17));
		panel.setBounds(0, 0, 160, 558);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblProduits = new JLabel("Articles");
		lblProduits.setIcon(new ImageIcon(FProduit.class.getResource("/gestion/article/Product-64-actif.png")));
		lblProduits.setHorizontalAlignment(SwingConstants.CENTER);
		lblProduits.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblProduits.setBounds(0, 5, 160, 64);
		panel.add(lblProduits);
		
		JButton button = new JButton("Aper\u00E7u");
		button.setIcon(new ImageIcon(FProduit.class.getResource("/gestion/Preview-48.png")));
		button.setRolloverIcon(new ImageIcon(FProduit.class.getResource("/gestion/Preview-48-actif.png")));
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.setFocusable(false);
		button.setContentAreaFilled(false);
		button.setBorder(new EmptyBorder(0, 0, 0, 0));
		button.setBounds(12, 310, 113, 49);
		panel.add(button);
		
		JButton button_1 = new JButton("Imprimer");
		button_1.setRolloverIcon(new ImageIcon(FProduit.class.getResource("/gestion/Printer-48-actif.png")));
		button_1.setIcon(new ImageIcon(FProduit.class.getResource("/gestion/Printer-48.png")));
		button_1.setHorizontalAlignment(SwingConstants.LEFT);
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button_1.setFocusable(false);
		button_1.setContentAreaFilled(false);
		button_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		button_1.setBounds(12, 360, 113, 49);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Exporter");
		button_2.setIcon(new ImageIcon(FProduit.class.getResource("/gestion/Data-Export-48.png")));
		button_2.setRolloverIcon(new ImageIcon(FProduit.class.getResource("/gestion/Data-Export-48-actif.png")));
		button_2.setHorizontalAlignment(SwingConstants.LEFT);
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button_2.setFocusable(false);
		button_2.setContentAreaFilled(false);
		button_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		button_2.setBounds(12, 420, 113, 49);
		panel.add(button_2);
		
		JButton button_3 = new JButton("Acceuil");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FAcceuil fen = new FAcceuil();
				fen.setVisible(true);
				close();
			}
		});
		button_3.setRolloverIcon(new ImageIcon(FProduit.class.getResource("/gestion/Home-48-actif.png")));
		button_3.setIcon(new ImageIcon(FProduit.class.getResource("/gestion/Home-48.png")));
		button_3.setHorizontalAlignment(SwingConstants.LEFT);
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button_3.setFocusable(false);
		button_3.setContentAreaFilled(false);
		button_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		button_3.setBounds(12, 500, 113, 49);
		panel.add(button_3);
		
		txtId = new JTextField();
		txtId.setVisible(false);
		txtId.setBounds(91, 53, 59, 20);
		panel.add(txtId);
		txtId.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(160, 0, 584, 558);
		panel_1.setBackground(new Color(227, 241, 182));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 204, 564, 310);
		panel_1.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(new Color(227, 241, 182));
		panel_2.setBounds(12, 11, 564, 182);
		panel_1.add(panel_2);
				
		txtCode = new JTextField();
		txtCode.setBounds(105, 9, 175, 20);
		panel_2.add(txtCode);
		txtCode.setColumns(10);
		
		txtCatgorie = new JTextField();
		txtCatgorie.setBounds(379, 9, 175, 20);
		panel_2.add(txtCatgorie);
		txtCatgorie.setColumns(10);
		
		txtDsignation = new JTextField();
		txtDsignation.setBounds(105, 34, 449, 20);
		panel_2.add(txtDsignation);
		txtDsignation.setColumns(10);
		
		txtPrixUnitaire = new JTextField();
		txtPrixUnitaire.setBounds(105, 59, 175, 20);
		panel_2.add(txtPrixUnitaire);
		txtPrixUnitaire.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setDisabledTextColor(Color.DARK_GRAY);
		txtStock.setEnabled(false);
		txtStock.setEditable(false);
		txtStock.setBounds(105, 86, 175, 20);
		panel_2.add(txtStock);
		txtStock.setColumns(10);
		
		JSlider slider = new JSlider();
		slider.setBackground(new Color(227, 241, 182));
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				txtStock.setText("" + slider.getValue());
			}
		});
		slider.setMaximum(999);
		slider.setBounds(284, 86, 270, 20);
		panel_2.add(slider);
		slider.setValue(0);
		
		JLabel lblCode = new JLabel("Code :");
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCode.setBounds(10, 11, 85, 14);
		panel_2.add(lblCode);
		
		JLabel lblCatgorie = new JLabel("Cat\u00E9gorie :");
		lblCatgorie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCatgorie.setBounds(284, 11, 85, 14);
		panel_2.add(lblCatgorie);
		
		JLabel lblDsignation = new JLabel("D\u00E9signation :");
		lblDsignation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDsignation.setBounds(10, 36, 85, 14);
		panel_2.add(lblDsignation);
		
		JLabel lblPrixUnitaire = new JLabel("Prix unitaire :");
		lblPrixUnitaire.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrixUnitaire.setBounds(10, 61, 85, 14);
		panel_2.add(lblPrixUnitaire);
		
		JLabel lblStock = new JLabel("Stock :");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStock.setBounds(10, 88, 85, 14);
		panel_2.add(lblStock);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBorder(new EmptyBorder(0, 0, 0, 0));
		toolBar.setFloatable(false);
		toolBar.setBackground(new Color(227, 241, 182));
		toolBar.setBounds(45, 120, 480, 51);
		panel_2.add(toolBar);
		
		JButton btnAjouter = new JButton("Ajouter     ");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				art.Ajouter(txtCode, txtDsignation, txtPrixUnitaire, txtCatgorie, slider, txtId);
				ArticleTableModel model2 = new ArticleTableModel(dao.getAllArticle());
				table.setModel(model2);
			}
		});
		toolBar.add(btnAjouter);
		btnAjouter.setIcon(new ImageIcon(FProduit.class.getResource("/gestion/Add-New-48.png")));
		btnAjouter.setRolloverIcon(new ImageIcon(FProduit.class.getResource("/gestion/Add-New-48-actif.png")));
		btnAjouter.setHorizontalAlignment(SwingConstants.LEFT);
		btnAjouter.setForeground(Color.BLACK);
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAjouter.setFocusable(false);
		btnAjouter.setContentAreaFilled(false);
		btnAjouter.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		JButton btnModifier = new JButton("Modifier     ");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = (int) table.getSelectedRow();
				if(i == -1) {
					JOptionPane.showMessageDialog(btnModifier, "Aucun article de sélectionné.",
							"Modification impossible", JOptionPane.ERROR_MESSAGE);
				} else {
					art.Modifier(txtCode, txtDsignation, txtPrixUnitaire, txtCatgorie, slider, (int) table.getValueAt(table.getSelectedRow(),0));
					ArticleTableModel model2 = new ArticleTableModel(dao.getAllArticle());
					table.setModel(model2);
					table.changeSelection(i, 0, false, false);
				}
			}
		});
		toolBar.add(btnModifier);
		btnModifier.setRolloverIcon(new ImageIcon(FProduit.class.getResource("/gestion/Data-Edit-48-actif.png")));
		btnModifier.setIcon(new ImageIcon(FProduit.class.getResource("/gestion/Data-Edit-48.png")));
		btnModifier.setHorizontalAlignment(SwingConstants.LEFT);
		btnModifier.setForeground(Color.BLACK);
		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnModifier.setFocusable(false);
		btnModifier.setContentAreaFilled(false);
		btnModifier.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		JButton btnSupprimer = new JButton("Supprimer     ");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i == -1) {
					JOptionPane.showMessageDialog(btnModifier, "Aucun article de sélectionné.",
							"Suppression impossible", JOptionPane.ERROR_MESSAGE);
				} else {
					art.Supprimer(txtCode, txtDsignation, txtPrixUnitaire, txtCatgorie, slider, txtId, (int) table.getValueAt(table.getSelectedRow(),0));
					ArticleTableModel model2 = new ArticleTableModel(dao.getAllArticle());
					table.setModel(model2);
				}
			}
		});
		toolBar.add(btnSupprimer);
		btnSupprimer.setIcon(new ImageIcon(FProduit.class.getResource("/gestion/Garbage-Open-48.png")));
		btnSupprimer.setRolloverIcon(new ImageIcon(FProduit.class.getResource("/gestion/Garbage-Open-48-actif.png")));
		btnSupprimer.setHorizontalAlignment(SwingConstants.LEFT);
		btnSupprimer.setForeground(Color.BLACK);
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSupprimer.setFocusable(false);
		btnSupprimer.setContentAreaFilled(false);
		btnSupprimer.setBorder(new EmptyBorder(0, 0, 0, 0));		
		JButton btnEffacer = new JButton("Effacer     ");
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				art.Effacer(txtCode, txtDsignation, txtPrixUnitaire, txtCatgorie, slider, txtId);
				table.clearSelection();
			}
		});
		toolBar.add(btnEffacer);
		btnEffacer.setRolloverIcon(new ImageIcon(FProduit.class.getResource("/gestion/Cancel-48-actif.png")));
		btnEffacer.setIcon(new ImageIcon(FProduit.class.getResource("/gestion/Cancel-48.png")));
		btnEffacer.setHorizontalAlignment(SwingConstants.LEFT);
		btnEffacer.setForeground(Color.BLACK);
		btnEffacer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEffacer.setFocusable(false);
		btnEffacer.setContentAreaFilled(false);
		btnEffacer.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		JRadioButton rdbtnCode = new JRadioButton("Code");
		rdbtnCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnCode.setBackground(new Color(227, 241, 182));
		rdbtnCode.setBounds(108, 524, 63, 23);
		panel_1.add(rdbtnCode);
		
		JRadioButton rdbtnCatgorie = new JRadioButton("Cat\u00E9gorie");
		rdbtnCatgorie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnCatgorie.setBackground(new Color(227, 241, 182));
		rdbtnCatgorie.setBounds(173, 524, 79, 23);
		panel_1.add(rdbtnCatgorie);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnCode);
		buttonGroup.add(rdbtnCatgorie);
		
		JLabel lblTrierPar = new JLabel("Trier par :");
		lblTrierPar.setIcon(new ImageIcon(FProduit.class.getResource("/gestion/Sort-Ascending-32.png")));
		lblTrierPar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTrierPar.setBounds(10, 528, 105, 14);
		panel_1.add(lblTrierPar);
		
		JLabel lblRechercher = new JLabel("Rechercher :");
		lblRechercher.setIcon(new ImageIcon(FProduit.class.getResource("/gestion/Search-32.png")));
		lblRechercher.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRechercher.setBounds(265, 526, 122, 18);
		panel_1.add(lblRechercher);
		
		textField = new JTextField();
		textField.setBounds(387, 525, 189, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		model = new ArticleTableModel(dao.getAllArticle());
		
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				art.AfficherArticle(txtCode, txtDsignation, txtPrixUnitaire, txtCatgorie, slider, txtId, (int) table.getValueAt(table.getSelectedRow(),0));
			}
		});
		scrollPane.setViewportView(table);
	}
	
	public void close() {
		this.dispose();
	}
}
