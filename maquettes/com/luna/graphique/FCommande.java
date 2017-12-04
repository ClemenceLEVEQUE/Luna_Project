package com.luna.graphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
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
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import com.luna.traitement.ArticleTableModel;

import javax.swing.event.ChangeEvent;
import javax.swing.JRadioButton;

public class FCommande extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JTextField txtCode;
	private JTextField txtCatgorie;
	private JTextField txtDsignation;
	private JTextField txtPrixUnitaire;
	private JTextField txtStock;
	private JTextField textField;
	private ArticleTableModel model;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FCommande frame = new FCommande();
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
	public FCommande() {
		setResizable(false);
		setMinimumSize(new Dimension(800, 560));
		setMaximumSize(new Dimension(1000, 1000));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 799, 586);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(227, 241, 182));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PCommande cmde = new PCommande(this);
		cmde.setBounds(0,0,800,560);
		getContentPane().add(cmde);
		
		PCommandeSearch search = new PCommandeSearch(cmde);
		search.setBounds(0,0,800,560);
		getContentPane().add(search);
		search.setVisible(false);
		
		cmde.setPCommandeSearch(search);
	}
	
	public void close() {
		this.dispose();
	}
}
