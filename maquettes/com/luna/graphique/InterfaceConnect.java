package com.luna.graphique;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.luna.graphique.InterfaceConnect;
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

public class InterfaceConnect extends JFrame {

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
					InterfaceConnect frame = new InterfaceConnect();
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
	public InterfaceConnect() {
		
		setTitle("Bienvenue sur SARL LUNA");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(InterfaceConnect.class.getResource("/com/luna/graphique/Moon-32.png")));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Label qui contient le titre en haut
		password = new JTextField();
		password.setBounds(227, 276, 136, 20);
		contentPane.add(password);

		login = new JTextField();
		login.setBounds(227, 165, 136, 20);
		contentPane.add(login);
		login.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsersTraitement auth = new UsersTraitement(login.getText(), password.getText(), GlobalConnection.getInstance());
				if(auth.Authentification()){
					Acceuil fen = new Acceuil();
					fen.setVisible(true);
					close();
				} else {
					JOptionPane.showMessageDialog(btnValider,"Le login ou le mot de passe saisi est incorrect.","Connexion impossible",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnValider.setBounds(64, 313, 89, 23);
		contentPane.add(btnValider);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(412, 313, 89, 23);
		contentPane.add(btnAnnuler);

		JLabel lblUser = new JLabel("USER");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUser.setBounds(280, 131, 83, 23);
		contentPane.add(lblUser);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(267, 230, 114, 23);
		contentPane.add(lblPassword);

		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label.setBounds(155, 25, 375, 75);
		contentPane.add(label);

		JLabel lblBienvenueSurSarl = new JLabel("Bienvenue sur SARL LUNA");
		lblBienvenueSurSarl.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBienvenueSurSarl.setBounds(137, 25, 375, 75);
		contentPane.add(lblBienvenueSurSarl);
	}
	
	public void close() {
		this.dispose();
	}
}
