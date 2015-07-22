package it.unisalento.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import it.unisalento.Main;
import it.unisalento.actionListener.CatalogoListener;
import it.unisalento.dao.*;
import it.unisalento.model.Autore;
import it.unisalento.model.CasaEditrice;
import it.unisalento.model.Genere;
import it.unisalento.model.Libro;

public class Catalogo extends JPanel {
	private JPanel center;
	private JPanel south;
	private JButton addchart;
	private JButton search;
	private Libreria lib;
	private Vector<JCheckBox> selection;

	public Catalogo(){
		this.setLayout(new BorderLayout());
		center=new JPanel();
		this.add(center, BorderLayout.NORTH);
		south=new JPanel();
		this.add(south, BorderLayout.SOUTH);
		addchart=new JButton("Aggiungi al Carrello");
		addchart.addActionListener(new CatalogoListener(this));
		addchart.setActionCommand(CatalogoListener.ACTION_ADD);
		search=new JButton("Cerca");
		search.addActionListener(new CatalogoListener(this));
		search.setActionCommand(CatalogoListener.ACTION_SEARCH);
		south.add(addchart);
		south.add(search);
		lib=Libreria.getIstance();
		center.setLayout(new GridLayout(0,7));
		System.out.println(lib.getDim());
		center.add(new JLabel(" "));
		center.add(new JLabel("Titolo"));
		center.add(new JLabel("Autore"));
		center.add(new JLabel("Casa Editrice"));
		center.add(new JLabel("Genere"));
		center.add(new JLabel("Prezzo"));
		center.add(new JLabel("Giacenza"));
		selection=new Vector<JCheckBox>();

		for (int i=0;i<lib.getDim();i++){
			Libro l= lib.getLibro(i);
			JCheckBox c=new JCheckBox(Integer.toString(l.getIdlibro()));
			selection.add(c);
			JLabel titolo,autore,casaed,genere,prezzo,giac;
			titolo=new JLabel(l.getTitolo());
			int idautore=l.getAutore()-1;
			Autore a=Autori.getIstance().getAutore(idautore);
			autore=new JLabel(a.getNome()+" "+a.getCognome());
			int idCasa=l.getCasaedi()-1;
			CasaEditrice e=CaseEditrici.getIstance().getCasa(idCasa);
			casaed=new JLabel(e.getNome());
			int idgenere=l.getGenere()-1;
			Genere g=Generi.getIstance().getGenere(idgenere);
			genere=new JLabel(g.getNome());
			prezzo=new JLabel(Float.toString(l.getCosto())+Main.EURO);
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
	public Vector<JCheckBox> getSelezionati(){
		Vector<JCheckBox> selezionati=new Vector<JCheckBox>();
		for (int i=0;i< selection.size();i++){
			if(selection.elementAt(i).isSelected()){
				selezionati.addElement(selection.elementAt(i));
			}
		}
		return selezionati;
	}
}
