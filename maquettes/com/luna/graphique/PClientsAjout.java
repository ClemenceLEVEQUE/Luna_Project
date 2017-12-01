package com.luna.graphique;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
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
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PClientsAjout extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_13;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_6;
	private JTextField textField_9;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public PClientsAjout(PClients cli) {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 160, 560);
		panel.setLayout(null);
		panel.setBackground(new Color(23, 152, 204));
		add(panel);
		
		JLabel lblClients = new JLabel("Ajout");
		lblClients.setIcon(new ImageIcon(PClientsAjout.class.getResource("/gestion/client/User-Add-64.png")));
		lblClients.setHorizontalAlignment(SwingConstants.CENTER);
		lblClients.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblClients.setBounds(0, 5, 160, 64);
		panel.add(lblClients);
		
		JButton btnSauvegarder = new JButton("Sauvegarder");
		btnSauvegarder.setRolloverIcon(new ImageIcon(PClientsAjout.class.getResource("/gestion/Save-48-actif.png")));
		btnSauvegarder.setHorizontalAlignment(SwingConstants.LEFT);
		btnSauvegarder.setForeground(Color.WHITE);
		btnSauvegarder.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSauvegarder.setFocusable(false);
		btnSauvegarder.setContentAreaFilled(false);
		btnSauvegarder.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnSauvegarder.setIcon(new ImageIcon(PClientsAjout.class.getResource("/gestion/Save-48.png")));
		btnSauvegarder.setBounds(12, 80, 138, 49);
		panel.add(btnSauvegarder);
		
		JButton btnAperu = new JButton("Aper\u00E7u");
		btnAperu.setRolloverIcon(new ImageIcon(PClientsAjout.class.getResource("/gestion/Preview-48-actif.png")));
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
		btnImprimer.setRolloverIcon(new ImageIcon(PClientsAjout.class.getResource("/gestion/Printer-48-actif.png")));
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
		btnExporter.setRolloverIcon(new ImageIcon(PClientsAjout.class.getResource("/gestion/Printer-48-actif.png")));
		btnExporter.setHorizontalAlignment(SwingConstants.LEFT);
		btnExporter.setForeground(Color.WHITE);
		btnExporter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExporter.setFocusable(false);
		btnExporter.setContentAreaFilled(false);
		btnExporter.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnExporter.setIcon(new ImageIcon(FAcceuil.class.getResource("/gestion/Data-Export-48.png")));
		btnExporter.setBounds(12, 420, 113, 49);
		panel.add(btnExporter);
		
		JButton btnAcceuil = new JButton("Annuler");
		btnAcceuil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				masquer(cli);
			}
		});
		btnAcceuil.setRolloverIcon(new ImageIcon(PClientsAjout.class.getResource("/gestion/Cancel-48-actif.png")));
		btnAcceuil.setHorizontalAlignment(SwingConstants.LEFT);
		btnAcceuil.setForeground(Color.WHITE);
		btnAcceuil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAcceuil.setFocusable(false);
		btnAcceuil.setContentAreaFilled(false);
		btnAcceuil.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAcceuil.setIcon(new ImageIcon(PClientsAjout.class.getResource("/gestion/Cancel-48.png")));
		btnAcceuil.setBounds(12, 500, 113, 49);
		panel.add(btnAcceuil);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(160, 0, 590, 560);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(197, 234, 249));
		add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Client", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(new Color(197, 234, 249));
		panel_2.setBounds(12, 11, 564, 55);
		panel_1.add(panel_2);
		
		JLabel lblCrLe = new JLabel("Cr\u00E9\u00E9 le :");
		lblCrLe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCrLe.setBounds(295, 26, 46, 14);
		panel_2.add(lblCrLe);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(379, 24, 175, 20);
		panel_2.add(textField);
		
		JLabel lblCodeClient = new JLabel("Code client :");
		lblCodeClient.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodeClient.setBounds(10, 26, 77, 14);
		panel_2.add(lblCodeClient);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(97, 24, 175, 20);
		panel_2.add(textField_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "Etat civil", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(new Color(197, 234, 249));
		panel_3.setBounds(12, 77, 564, 109);
		panel_1.add(panel_3);
		
		JLabel label_4 = new JLabel("Rue :");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBounds(10, 80, 46, 14);
		panel_3.add(label_4);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(97, 78, 457, 20);
		panel_3.add(textField_13);
		
		JLabel label_6 = new JLabel("Ville :");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_6.setBounds(10, 55, 46, 14);
		panel_3.add(label_6);
		
		JLabel label_10 = new JLabel("Nom :");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_10.setBounds(295, 30, 47, 14);
		panel_3.add(label_10);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(379, 28, 175, 20);
		panel_3.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(97, 53, 175, 20);
		panel_3.add(textField_16);
		
		JLabel label_12 = new JLabel("Code postal :");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_12.setBounds(295, 55, 83, 14);
		panel_3.add(label_12);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(379, 53, 175, 20);
		panel_3.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(97, 28, 175, 20);
		panel_3.add(textField_19);
		
		JLabel label_13 = new JLabel("Pr\u00E9nom :");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_13.setBounds(10, 30, 77, 14);
		panel_3.add(label_13);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "Coordon\u00E9es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(new Color(197, 234, 249));
		panel_4.setBounds(12, 197, 564, 55);
		panel_1.add(panel_4);
		
		JLabel label_5 = new JLabel("Tel :");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBounds(10, 26, 46, 14);
		panel_4.add(label_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(97, 24, 175, 20);
		panel_4.add(textField_6);
		
		JLabel label_9 = new JLabel("Mail :");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_9.setBounds(295, 26, 46, 14);
		panel_4.add(label_9);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(379, 24, 175, 20);
		panel_4.add(textField_9);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Remarques", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBackground(new Color(197, 234, 249));
		panel_5.setBounds(12, 263, 564, 279);
		panel_1.add(panel_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 28, 544, 240);
		panel_5.add(textField_4);
	}
	
	public void masquer(PClients cli) {
		this.setVisible(false);
		cli.setVisible(true);
	}
}
