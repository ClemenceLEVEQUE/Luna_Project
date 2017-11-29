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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;
import java.awt.Panel;
import java.awt.Dimension;

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
		setResizable(false);
		setTitle("Bienvenue sur SARL Luna");
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceConnect.class.getResource("/com/luna/graphique/Moon-32.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnQuitter.setBounds(10, 481, 100, 30);
		contentPane.add(btnQuitter);
		btnQuitter.setPreferredSize(new Dimension(100, 30));
		btnQuitter.setMaximumSize(new Dimension(100, 30));
		btnQuitter.setMinimumSize(new Dimension(100, 30));
		btnQuitter.setToolTipText("");
		btnQuitter.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnQuitter.setFocusable(false);
		btnQuitter.setContentAreaFilled(false);
		btnQuitter.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton btnProducts = new JButton("");
		btnProducts.setBounds(208, 11, 128, 128);
		contentPane.add(btnProducts);
		btnProducts.setToolTipText("");
		btnProducts.setFocusable(false);
		btnProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnProducts, "Vous avez cliqué sur un bouton.");
			}
		});
		btnProducts.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnProducts.setIcon(new ImageIcon(Accueil.class.getResource("/accueil/Product-128.png")));
		btnProducts.setContentAreaFilled(false);
		JButton btnPeople = new JButton("");
		btnPeople.setBounds(10, 197, 128, 128);
		contentPane.add(btnPeople);
		btnPeople.setToolTipText("");
		btnPeople.setFocusable(false);
		btnPeople.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnProducts, "Vous avez cliqué sur un bouton.");
			}
		});
		btnPeople.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnPeople.setIcon(new ImageIcon(Accueil.class.getResource("/accueil/People-128.png")));
		btnPeople.setContentAreaFilled(false);
		
		JButton btnShopping = new JButton("");
		btnShopping.setBounds(406, 197, 128, 128);
		contentPane.add(btnShopping);
		btnShopping.setToolTipText("");
		btnShopping.setFocusable(false);
		btnShopping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnProducts, "Vous avez cliqué sur un bouton.");
			}
		});
		btnShopping.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnShopping.setIcon(new ImageIcon(Accueil.class.getResource("/accueil/Shopping-Bag-128.png")));
		btnShopping.setContentAreaFilled(false);
		
		JButton btnSettings = new JButton("");
		btnSettings.setBounds(208, 382, 128, 128);
		contentPane.add(btnSettings);
		btnSettings.setFocusable(false);
		btnSettings.setToolTipText("");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnProducts, "Vous avez cliqué sur un bouton.");
			}
		});
		btnSettings.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnSettings.setIcon(new ImageIcon(Accueil.class.getResource("/accueil/Settings-02-128.png")));
		btnSettings.setContentAreaFilled(false);
		
		JButton btnDiagram = new JButton("");
		btnDiagram.setBounds(208, 197, 128, 128);
		contentPane.add(btnDiagram);
		btnDiagram.setToolTipText("");
		btnDiagram.setFocusable(false);
		btnDiagram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnProducts, "Vous avez cliqué sur un bouton.");
			}
		});
		btnDiagram.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnDiagram.setIcon(new ImageIcon(Accueil.class.getResource("/accueil/Diagram-128.png")));
		btnDiagram.setContentAreaFilled(false);
	}
}
