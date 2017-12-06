package com.luna.graphique;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.luna.graphique.FConnect;
import com.luna.traitement.UsersTraitement;
import com.luna.utils.GlobalConnection;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class FConnect extends JFrame {

	private JPanel contentPane;
	private JTextField login;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FConnect frame = new FConnect();
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
	public FConnect() {

		setTitle("Bienvenue sur SARL LUNA");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(FConnect.class.getResource("/com/luna/graphique/Moon-32.png")));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JLabel lblBienvenueSurSarl = new JLabel("Bienvenue sur SARL LUNA");
		lblBienvenueSurSarl.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenueSurSarl.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblBienvenueSurSarl, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		// Label qui contient le titre en haut
		password = new JTextField();
		password.setBounds(142, 43, 170, 20);
		panel.add(password);

		login = new JTextField();
		login.setBounds(142, 12, 170, 20);
		panel.add(login);
		login.setColumns(10);

		JLabel lblUser = new JLabel(" Nom d'utilisateur :");
		lblUser.setBounds(10, 11, 124, 20);
		panel.add(lblUser);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblPassword = new JLabel(" Mot de passe :");
		lblPassword.setBounds(10, 42, 124, 20);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel label = new JLabel("");
		label.setBounds(510, 0, 85, 20);
		panel.add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 26));

		JLabel lblVeuillezSaisir = new JLabel(
				"<html>Veuillez saisir le nom d'utilisateur ainsi que le mot de passe associ\u00E9 \u00E0 ce dernier afin d'acc\u00E8der \u00E0 l'application.</html>");
		lblVeuillezSaisir.setForeground(Color.GRAY);
		lblVeuillezSaisir.setBounds(10, 73, 339, 29);
		panel.add(lblVeuillezSaisir);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JButton btnParamtres = new JButton("Param\u00E8tres");
		panel_1.add(btnParamtres);

		JButton btnValider = new JButton("Valider");
		panel_1.add(btnValider);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		panel_1.add(btnAnnuler);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsersTraitement auth = new UsersTraitement(login.getText(), password.getText(),
						GlobalConnection.getInstance());
				if (auth.Authentification()) {
					FAcceuil fen = new FAcceuil();
					fen.setVisible(true);
					close();
				} else {
					JOptionPane.showMessageDialog(btnValider, "Le login ou le mot de passe saisi est incorrect.",
							"Connexion impossible", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	public void close() {
		this.dispose();
	}
}
