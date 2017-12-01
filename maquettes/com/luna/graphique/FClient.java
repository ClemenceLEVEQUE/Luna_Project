package com.luna.graphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class FClient extends JFrame {

	private JPanel contentPane;
	private JTextField textDateCrea;
	private JTextField textCode;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FClient frame = new FClient();
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
	public FClient() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 586);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(23, 152, 204));
		panelMenu.setBounds(0, 0, 160, 558);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Clients");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 5, 160, 64);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setIcon(new ImageIcon(FClient.class.getResource("/gestion/client/People-64-actif.png")));
		panelMenu.add(lblNewLabel);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setHorizontalAlignment(SwingConstants.LEFT);
		btnAjouter.setBounds(12, 80, 95, 49);
		btnAjouter.setForeground(new Color(255, 255, 255));
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAjouter.setFocusable(false);
		btnAjouter.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAjouter.setIcon(new ImageIcon(FClient.class.getResource("/gestion/Add-New-48.png")));
		btnAjouter.setContentAreaFilled(false);
		panelMenu.add(btnAjouter);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setHorizontalAlignment(SwingConstants.LEFT);
		btnRechercher.setBounds(12, 130, 117, 49);
		btnRechercher.setForeground(new Color(255, 255, 255));
		btnRechercher.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRechercher.setFocusable(false);
		btnRechercher.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnRechercher.setIcon(new ImageIcon(FClient.class.getResource("/gestion/Search-48.png")));
		btnRechercher.setContentAreaFilled(false);
		panelMenu.add(btnRechercher);
		
		JButton btnEdit = new JButton("Modifier");
		btnEdit.setHorizontalAlignment(SwingConstants.LEFT);
		btnEdit.setBounds(12, 180, 99, 49);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEdit.setForeground(new Color(255, 255, 255));
		btnEdit.setFocusable(false);
		btnEdit.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnEdit.setIcon(new ImageIcon(FClient.class.getResource("/gestion/Data-Edit-48.png")));
		btnEdit.setContentAreaFilled(false);
		panelMenu.add(btnEdit);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setHorizontalAlignment(SwingConstants.LEFT);
		btnSupprimer.setBounds(12, 230, 113, 49);
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSupprimer.setForeground(new Color(255, 255, 255));
		btnSupprimer.setFocusable(false);
		btnSupprimer.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnSupprimer.setIcon(new ImageIcon(FClient.class.getResource("/gestion/Garbage-Open-48.png")));
		btnSupprimer.setContentAreaFilled(false);
		panelMenu.add(btnSupprimer);
		
		JButton btnAperu = new JButton("Aper\u00E7u");
		btnAperu.setHorizontalAlignment(SwingConstants.LEFT);
		btnAperu.setIcon(new ImageIcon(FClient.class.getResource("/gestion/Preview-48.png")));
		btnAperu.setForeground(Color.WHITE);
		btnAperu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAperu.setFocusable(false);
		btnAperu.setContentAreaFilled(false);
		btnAperu.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAperu.setBounds(12, 310, 113, 49);
		panelMenu.add(btnAperu);
		
		JButton btnExporte = new JButton("Imprimer");
		btnExporte.setIcon(new ImageIcon(FClient.class.getResource("/gestion/Printer-48.png")));
		btnExporte.setHorizontalAlignment(SwingConstants.LEFT);
		btnExporte.setForeground(Color.WHITE);
		btnExporte.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExporte.setFocusable(false);
		btnExporte.setContentAreaFilled(false);
		btnExporte.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnExporte.setBounds(12, 360, 113, 49);
		panelMenu.add(btnExporte);
		
		JButton btnExporter = new JButton("Exporter");
		btnExporter.setIcon(new ImageIcon(FClient.class.getResource("/gestion/Data-Export-48.png")));
		btnExporter.setHorizontalAlignment(SwingConstants.LEFT);
		btnExporter.setForeground(Color.WHITE);
		btnExporter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExporter.setFocusable(false);
		btnExporter.setContentAreaFilled(false);
		btnExporter.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnExporter.setBounds(12, 420, 113, 49);
		panelMenu.add(btnExporter);
		
		JButton btnAcceuil = new JButton("Acceuil");
		btnAcceuil.setHorizontalAlignment(SwingConstants.LEFT);
		btnAcceuil.setIcon(new ImageIcon(FClient.class.getResource("/gestion/Home-48.png")));
		btnAcceuil.setForeground(Color.WHITE);
		btnAcceuil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAcceuil.setFocusable(false);
		btnAcceuil.setContentAreaFilled(false);
		btnAcceuil.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAcceuil.setBounds(12, 500, 113, 49);
		panelMenu.add(btnAcceuil);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(new Color(173, 216, 230));
		panelInfo.setBorder(new LineBorder(new Color(0,0,0)));
		panelInfo.setBounds(170, 11, 564, 247);
		contentPane.add(panelInfo);
		panelInfo.setLayout(null);
		
		JLabel lblDateDeCration = new JLabel("Cr\u00E9\u00E9 le :");
		lblDateDeCration.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateDeCration.setBounds(295, 11, 46, 14);
		panelInfo.add(lblDateDeCration);
		
		textDateCrea = new JTextField();
		textDateCrea.setBounds(379, 9, 175, 20);
		textDateCrea.setColumns(10);
		panelInfo.add(textDateCrea);
		
		JLabel lblCodeClient = new JLabel("Code client :");
		lblCodeClient.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodeClient.setBounds(10, 11, 77, 14);
		panelInfo.add(lblCodeClient);
		
		textCode = new JTextField();
		textCode.setColumns(10);
		textCode.setBounds(97, 9, 175, 20);
		panelInfo.add(textCode);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(97, 134, 457, 102);
		panelInfo.add(textField);
		
		JLabel label = new JLabel("Remarques : ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(10, 136, 77, 14);
		panelInfo.add(label);
		
		JLabel label_1 = new JLabel("Rue :");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(10, 86, 46, 14);
		panelInfo.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(97, 84, 457, 20);
		panelInfo.add(textField_1);
		
		JLabel label_2 = new JLabel("Tel :");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(10, 111, 46, 14);
		panelInfo.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(97, 109, 175, 20);
		panelInfo.add(textField_2);
		
		JLabel label_3 = new JLabel("Ville :");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(10, 61, 46, 14);
		panelInfo.add(label_3);
		
		JLabel label_4 = new JLabel("Nom :");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBounds(295, 36, 47, 14);
		panelInfo.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(379, 34, 175, 20);
		panelInfo.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(97, 59, 175, 20);
		panelInfo.add(textField_4);
		
		JLabel label_5 = new JLabel("Mail :");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBounds(295, 111, 46, 14);
		panelInfo.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(379, 109, 175, 20);
		panelInfo.add(textField_5);
		
		JLabel label_6 = new JLabel("Code postal :");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_6.setBounds(295, 61, 83, 14);
		panelInfo.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(379, 59, 175, 20);
		panelInfo.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(97, 34, 175, 20);
		panelInfo.add(textField_7);
		
		JLabel label_7 = new JLabel("Pr\u00E9nom :");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_7.setBounds(10, 36, 77, 14);
		panelInfo.add(label_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(170, 269, 564, 278);
		contentPane.add(scrollPane);
	}
}
