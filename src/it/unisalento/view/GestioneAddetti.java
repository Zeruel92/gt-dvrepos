package it.unisalento.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GestioneAddetti extends JPanel {
	
	private JPanel p0,p1;
	private JButton b0,b1,b2;
	private JLabel l0,l1,l2;
	private Vector<JRadioButton> rb;
	private ButtonGroup group;
	private Vector<JComboBox> combo;
	
	public GestioneAddetti(){
		this.setLayout(new BorderLayout());
		p0=new JPanel();
		p0.setLayout(new GridLayout(0,4));
		this.add(p0);
		l0=new JLabel("Email");
		l1=new JLabel("Password");
		l2=new JLabel("Livello Utente");
		p0.add(new JLabel());
		p0.add(l0);
		p0.add(l1);
		p0.add(l2);
		this.add(p0,BorderLayout.NORTH);
	}
}
//TODO Gestione Addetti