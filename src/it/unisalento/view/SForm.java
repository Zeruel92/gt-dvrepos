package it.unisalento.view;

import it.unisalento.actionListener.SearchListener;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SForm extends JFrame 
{	
	public JRadioButton titolo, autore, genere;
	public JPanel sopra;
	public JTextField sotto;
	public JButton cerca;
	public SForm()
	{
		this.setLayout(new BorderLayout());
		JPanel sopra=new JPanel();
		JRadioButton titolo=new JRadioButton("Titolo");
		JRadioButton autore=new JRadioButton("Autore");
		JRadioButton genere=new JRadioButton("Genere");
		sopra.add(titolo);
		sopra.add(autore);
		sopra.add(genere);
		
		this.add(sopra, BorderLayout.NORTH);
		ButtonGroup group= new ButtonGroup();
		group.add(titolo);
		group.add(autore);
		group.add(genere);
		
		JTextField sotto=new JTextField();
		this.add(sotto, BorderLayout.CENTER);
		
		JButton cerca=new JButton("Cerca");
		cerca.setActionCommand("cerca");
		cerca.addActionListener(new SearchListener(this));
		this.add(cerca, BorderLayout.SOUTH);
		
		setVisible(true);
		pack();
		
	}
}