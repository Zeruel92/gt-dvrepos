package it.unisalento.view;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutUs extends JFrame {
	
	private JLabel logo;
	private JLabel stringa;
	private JPanel p;
	private final String arg0="<html>Libreria<br> Realizzata da Gabriele Tramonte e Daniele Viscuso<br>Progetto per il corso di \"Principi di Progettazione del Software\"<br>"
			+ "Anno Accademico 2014/2015";
	public AboutUs(){
		super("About Us");
		p=new JPanel();
		p.setLayout(new BorderLayout());
		this.add(p);
		logo=new JLabel();
		Image img=new ImageIcon("misc/unile.jpg").getImage();
		Image newimg=img.getScaledInstance(150,150,Image.SCALE_SMOOTH);
		logo.setIcon(new ImageIcon(newimg));
		p.add(logo,BorderLayout.WEST);
		stringa=new JLabel(arg0);
		p.add(stringa,BorderLayout.EAST);
		this.setResizable(false);
		pack();
	}
}	

