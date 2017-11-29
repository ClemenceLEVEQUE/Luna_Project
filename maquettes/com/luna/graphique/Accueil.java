package com.luna.graphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Accueil extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil frame = new Accueil();
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
	public Accueil() {
		setTitle("Bienvenue sur SARL Luna");
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceConnect.class.getResource("/com/luna/graphique/Moon-32.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(124, 31, 500, 400);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnProducts = new JButton("");
		btnProducts.setBorder(null);
		panel.add(btnProducts, BorderLayout.NORTH);
		btnProducts.setIcon(new ImageIcon(Accueil.class.getResource("/accueil/Product-128.png")));
		btnProducts.setContentAreaFilled(false);
		
		JButton btnDiagram = new JButton("");
		btnDiagram.setBorder(null);
		panel.add(btnDiagram, BorderLayout.CENTER);
		btnDiagram.setIcon(new ImageIcon(Accueil.class.getResource("/accueil/Diagram-128.png")));
		btnDiagram.setContentAreaFilled(false);
		
		JButton btnShopping = new JButton("");
		btnShopping.setBorder(null);
		panel.add(btnShopping, BorderLayout.EAST);
		btnShopping.setIcon(new ImageIcon(Accueil.class.getResource("/accueil/Shopping-Bag-128.png")));
		btnShopping.setContentAreaFilled(false);
		JButton btnPeople = new JButton("");
		btnPeople.setBorder(null);
		panel.add(btnPeople, BorderLayout.WEST);
		btnPeople.setIcon(new ImageIcon(Accueil.class.getResource("/accueil/People-128.png")));
		btnPeople.setContentAreaFilled(false);
		
		JButton btnSettings = new JButton("");
		btnSettings.setBorder(null);
		panel.add(btnSettings, BorderLayout.SOUTH);
		btnSettings.setIcon(new ImageIcon(Accueil.class.getResource("/accueil/Settings-02-128.png")));
		btnSettings.setContentAreaFilled(false);
	}
}
