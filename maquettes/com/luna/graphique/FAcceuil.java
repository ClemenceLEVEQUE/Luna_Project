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
import javax.swing.JMenu;
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
import javax.swing.JMenuBar;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JMenuItem;

public class FAcceuil extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FAcceuil frame = new FAcceuil();
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
	public FAcceuil() {
		setResizable(false);
		setTitle("Bienvenue sur SARL Luna");
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceConnect.class.getResource("/com/luna/graphique/Moon-32.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 475);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		JMenu mnParam = new JMenu("Paramètres");
		menuBar.add(mnParam);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panelMenu, BorderLayout.WEST);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnQuitter.setPreferredSize(new Dimension(100, 30));
		btnQuitter.setMaximumSize(new Dimension(100, 30));
		btnQuitter.setMinimumSize(new Dimension(100, 30));
		btnQuitter.setToolTipText("");
		btnQuitter.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnQuitter.setFocusable(false);
		btnQuitter.setContentAreaFilled(false);
		btnQuitter.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelTitre = new JLabel("LUNA SARL");
		labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitre.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel labelDescr = new JLabel("");
		labelDescr.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panelMenu = new GroupLayout(panelMenu);
		gl_panelMenu.setHorizontalGroup(
			gl_panelMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelMenu.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelMenu.createParallelGroup(Alignment.TRAILING)
						.addComponent(labelDescr, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addComponent(labelTitre, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addComponent(btnQuitter, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelMenu.setVerticalGroup(
			gl_panelMenu.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelMenu.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelTitre, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelDescr, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 295, Short.MAX_VALUE)
					.addComponent(btnQuitter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panelMenu.setLayout(gl_panelMenu);
		
		JPanel panelBoutons = new JPanel();
		contentPane.add(panelBoutons, BorderLayout.CENTER);
		panelBoutons.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel sep1 = new JLabel("");
		panelBoutons.add(sep1);
		
		JPanel panelProducts = new JPanel();
		panelBoutons.add(panelProducts);
		panelProducts.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnProducts = new JButton("");
		panelProducts.add(btnProducts);
		btnProducts.setFocusable(false);
		btnProducts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnProducts.setIcon(new ImageIcon(FAcceuil.class.getResource("/accueil/Product-128-actif.png")));
				labelDescr.setText("<html>Gestion des<br/>produits</html>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnProducts.setIcon(new ImageIcon(FAcceuil.class.getResource("/accueil/Product-128.png")));
				labelDescr.setText("");
			}
		});
		btnProducts.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnProducts.setIcon(new ImageIcon(FAcceuil.class.getResource("/accueil/Product-128.png")));
		btnProducts.setContentAreaFilled(false);
		
		JLabel sep2 = new JLabel("");
		panelBoutons.add(sep2);
		
		JPanel panelPeople = new JPanel();
		panelBoutons.add(panelPeople);
		JButton btnPeople = new JButton("");
		panelPeople.add(btnPeople);
		btnPeople.setFocusable(false);
		btnPeople.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPeople.setIcon(new ImageIcon(FAcceuil.class.getResource("/accueil/People-128-actif.png")));
				labelDescr.setText("<html>Gestion des<br/>clients</html>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPeople.setIcon(new ImageIcon(FAcceuil.class.getResource("/accueil/People-128.png")));
				labelDescr.setText("");
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				FClient client = new FClient();
				client.setVisible(true);
			}
		});
		btnPeople.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnPeople.setIcon(new ImageIcon(FAcceuil.class.getResource("/accueil/People-128.png")));
		btnPeople.setContentAreaFilled(false);
		
		JPanel panelDiagram = new JPanel();
		panelBoutons.add(panelDiagram);
		
		JButton btnDiagram = new JButton("");
		panelDiagram.add(btnDiagram);
		btnDiagram.setFocusable(false);
		btnDiagram.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDiagram.setIcon(new ImageIcon(FAcceuil.class.getResource("/accueil/Diagram-128-actif.png")));
				labelDescr.setText("Statistiques");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDiagram.setIcon(new ImageIcon(FAcceuil.class.getResource("/accueil/Diagram-128.png")));
				labelDescr.setText("");
			}
		});
		btnDiagram.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnDiagram.setIcon(new ImageIcon(FAcceuil.class.getResource("/accueil/Diagram-128.png")));
		btnDiagram.setContentAreaFilled(false);
		
		JPanel panelShopping = new JPanel();
		panelBoutons.add(panelShopping);
		
		JButton btnShopping = new JButton("");
		panelShopping.add(btnShopping);
		btnShopping.setFocusable(false);
		btnShopping.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnShopping.setIcon(new ImageIcon(FAcceuil.class.getResource("/accueil/Shopping-Bag-128-actif.png")));
				labelDescr.setText("<html>Gestion des<br/>achats</html>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnShopping.setIcon(new ImageIcon(FAcceuil.class.getResource("/accueil/Shopping-Bag-128.png")));
				labelDescr.setText("");
			}
		});
		btnShopping.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnShopping.setIcon(new ImageIcon(FAcceuil.class.getResource("/accueil/Shopping-Bag-128.png")));
		btnShopping.setContentAreaFilled(false);
		
		JLabel sep3 = new JLabel("");
		panelBoutons.add(sep3);
		
		JPanel panelSettings = new JPanel();
		panelBoutons.add(panelSettings);
		
		JButton btnSettings = new JButton("");
		panelSettings.add(btnSettings);
		btnSettings.setFocusable(false);
		btnSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSettings.setIcon(new ImageIcon(FAcceuil.class.getResource("/accueil/Settings-02-128-actif.png")));
				labelDescr.setText("Paramètres");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSettings.setIcon(new ImageIcon(FAcceuil.class.getResource("/accueil/Settings-02-128.png")));
				labelDescr.setText("");
			}
		});
		btnSettings.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnSettings.setIcon(new ImageIcon(FAcceuil.class.getResource("/accueil/Settings-02-128.png")));
		btnSettings.setContentAreaFilled(false);
		
		JLabel sep4 = new JLabel("");
		panelBoutons.add(sep4);
	}
}
