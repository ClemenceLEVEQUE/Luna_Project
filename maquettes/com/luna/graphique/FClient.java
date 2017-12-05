package com.luna.graphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;

public class FClient extends JFrame {
	private JPanel contentPane;

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
		setMinimumSize(new Dimension(750, 586));
		setMaximumSize(new Dimension(1000, 1000));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 586);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(197, 234, 249));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("");
		lblId.setVisible(false);
		lblId.setBounds(10, 11, 46, 14);
		contentPane.add(lblId);

		PClients cli = new PClients(this, lblId);
		cli.setBounds(0,0,750,560);
		getContentPane().add(cli);

		PClientsAjout ajout = new PClientsAjout(cli, lblId);
		ajout.setBounds(0,0,750,560);
		getContentPane().add(ajout);
		ajout.setVisible(false);

		PClientsModif modif = new PClientsModif(cli, lblId);
		modif.setBounds(0,0,750,560);
		getContentPane().add(modif);
		modif.setVisible(false);

		PClientsSearch search = new PClientsSearch(cli, lblId);
		search.setBounds(0,0,750,560);
		getContentPane().add(search);
		search.setVisible(false);
		
		cli.setPClientsAjout(ajout);
		cli.setPClientsModif(modif);
		cli.setPClientsSearch(search);
	}
}
