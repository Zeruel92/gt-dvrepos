package it.unisalento.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import it.unisalento.dao.*;
import it.unisalento.model.Libro;

public class Catalogo extends JPanel {
	private JPanel center;
	private JPanel south;
	private JButton addchart;
	private JButton search;
	private Libreria lib;
	public Catalogo(){
		this.setLayout(new BorderLayout());
		center=new JPanel();
		this.add(center, BorderLayout.NORTH);
		south=new JPanel();
		this.add(south, BorderLayout.SOUTH);
		addchart=new JButton("Aggiungi al Carrello");
		search=new JButton("Cerca");
		south.add(addchart);
		south.add(search);
		lib=new Libreria();
		center.setLayout(new GridLayout(0,7));
		System.out.println(lib.getDim());
		center.add(new JLabel(" "));
		center.add(new JLabel("Titolo"));
		center.add(new JLabel("Autore"));
		center.add(new JLabel("Casa Editrice"));
		center.add(new JLabel("Genere"));
		center.add(new JLabel("Prezzo"));
		center.add(new JLabel("Giacenza"));
		for (int i=0;i<lib.getDim();i++){
			Libro l= lib.getLibro(i);
			JCheckBox c=new JCheckBox();
			JLabel titolo,autore,casaed,genere,prezzo,giac;
			titolo=new JLabel(l.getTitolo());
			autore=new JLabel(l.getAutore());
			casaed=new JLabel(l.getCasaedi());
			genere=new JLabel(l.getGenere());
			prezzo=new JLabel(Float.toString(l.getCosto()));
			giac=new JLabel(Integer.toString(l.getGiacenza()));
			center.add(c);
			center.add(titolo);
			center.add(autore);
			center.add(casaed);
			center.add(genere);
			center.add(prezzo);
			center.add(giac);
		}
	}

}
