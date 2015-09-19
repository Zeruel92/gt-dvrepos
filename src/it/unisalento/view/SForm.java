package it.unisalento.view;

import it.unisalento.actionListener.SearchListener;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
	private Thread t;
	public String tipo,stringa;
	public SForm()
	{
		this.setLayout(new BorderLayout());
		JPanel sopra=new JPanel();
		JRadioButton titolo=new JRadioButton("Titolo");
		titolo.addItemListener(new RadioListener("Titolo"));
		JRadioButton autore=new JRadioButton("Autore");
		autore.addItemListener(new RadioListener("Autore"));
		JRadioButton genere=new JRadioButton("Genere");
		genere.addItemListener(new RadioListener("Genere"));
		sopra.add(titolo);
		sopra.add(autore);
		sopra.add(genere);
		
		this.add(sopra, BorderLayout.NORTH);
		ButtonGroup group= new ButtonGroup();
		group.add(titolo);
		group.add(autore);
		group.add(genere);
		
		sotto=new JTextField();
		this.add(sotto, BorderLayout.CENTER);
		
		JPanel bott=new JPanel();
		
		JButton cerca=new JButton("Cerca");
		cerca.setActionCommand("search");
		cerca.addActionListener(new SearchListener(this));
		JButton annulla=new JButton("Annulla");
		annulla.setActionCommand("canc");
		annulla.addActionListener(new SearchListener(this));
		bott.add(cerca);
		bott.add(annulla);
		this.add(bott, BorderLayout.SOUTH);
		
		setVisible(true);
		pack();
		
	}
	public String getTipo() {
		return tipo;
	}
	public String getStringa(){
		return sotto.getText();
	}
	
	class RadioListener implements ItemListener{
		String type;
		private RadioListener(String text)
		{
			type=text;
		}

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			tipo=type;
		}
		
	}
	
}