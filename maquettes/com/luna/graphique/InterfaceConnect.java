package com.luna.graphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.luna.graphique.InterfaceConnect;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InterfaceConnect extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_2;
	private JTextField textField_1;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceConnect.class.getResource("/com/luna/graphique/Moon-32.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Label qui contient le titre en haut
		
		
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {AbstractButton textField = null;
			JOptionPane.showMessageDialog(btnValider, "Vous avez saisi \"" +textField.getText() + "\"");
			
			
		}});
		btnValider.setBounds(64, 313, 89, 23);
		contentPane.add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(412, 313, 89, 23);
		contentPane.add(btnAnnuler);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(227, 254, 136, 23);
		contentPane.add(passwordField);
		
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
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(227, 255, 136, 22);
		contentPane.add(passwordField_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(227, 165, 136, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
