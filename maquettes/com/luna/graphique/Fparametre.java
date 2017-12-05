package com.luna.graphique;

import javax.swing.JFrame;

public class Fparametre extends JFrame {
setTitle("Luna projet");
setIconImage(Toolkit.getDefaultToolkit().getImage(Fparametres.class.getResource("/images/Moon-32.png")));
setBounds(100, 100, 388, 237);

contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[grow][grow][grow][grow]"));


}}
