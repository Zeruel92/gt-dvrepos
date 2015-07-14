package it.unisalento.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;

import it.unisalento.actionListener.GestioneLibreriaListener;
import it.unisalento.dao.Libreria;
import it.unisalento.model.Libro;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GestioneLibreria extends JPanel {
	
	private Libreria l;
	private Vector<JRadioButton> items;
	private ButtonGroup group;
	private JButton modifica;
	private JButton cancella;
	private JButton aggiungi;
	
	public GestioneLibreria(){
		l=Libreria.getIstance();
		items=new Vector<JRadioButton>();
		group=new ButtonGroup();
		this.setLayout(new BorderLayout());
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(0,7));
		this.add(p1,BorderLayout.NORTH);
		p1.add(new JLabel(" "));
		p1.add(new JLabel("Titolo"));
		p1.add(new JLabel("Autore"));
		p1.add(new JLabel("Casa Editrice"));
		p1.add(new JLabel("Genere"));
		p1.add(new JLabel("Prezzo"));
		p1.add(new JLabel("Giacenza"));
		for (int i=0; i < l.getDim(); i++){
			Libro ll=l.getLibro(i);
			JLabel titolo=new JLabel(ll.getTitolo());
			JLabel autore=new JLabel(ll.getAutore());
			JLabel casa=new JLabel(ll.getCasaedi());
			JLabel genere=new JLabel(ll.getGenere());
			JLabel costo=new JLabel(Float.toString(ll.getCosto()));
			JLabel giac=new JLabel(Integer.toString(ll.getGiacenza()));
			items.addElement(new JRadioButton(Integer.toString(ll.getIdlibro())));
			items.lastElement().setActionCommand(Integer.toString(i));
			group.add(items.lastElement());
			p1.add(items.lastElement());
			p1.add(titolo);
			p1.add(autore);
			p1.add(casa);
			p1.add(genere);
			p1.add(costo);
			p1.add(giac);
		}
		JPanel p2=new JPanel();
		p2.setLayout(new GridLayout(0,3));
		this.add(p2,BorderLayout.SOUTH);
		modifica=new JButton("Modifica");
		modifica.addActionListener(new GestioneLibreriaListener(this));
		modifica.setActionCommand(GestioneLibreriaListener.ACTION_EDIT);
		cancella=new JButton("Cancella");
		cancella.addActionListener(new GestioneLibreriaListener(this));
		cancella.setActionCommand(GestioneLibreriaListener.ACTION_DELETE);
		aggiungi=new JButton("Aggiungi");
		aggiungi.addActionListener(new GestioneLibreriaListener(this));
		aggiungi.setActionCommand(GestioneLibreriaListener.ACTION_ADD);
		p2.add(modifica);
		p2.add(cancella);
		p2.add(aggiungi);
	}
}
