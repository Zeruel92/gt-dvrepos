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
	private ButtonGroup group1;
	private JRadioButton autore,libro,genere,casa;
	
	public GestioneLibreria(){
		l=Libreria.getIstance();
		items=new Vector<JRadioButton>();
		group=new ButtonGroup();
		modifica=new JButton("Modifica");
		cancella=new JButton("Cancella");
		aggiungi=new JButton("Aggiungi");
		
		autore=new JRadioButton("Autore");
		autore.addActionListener(new GestioneLibreriaListener(this));
		autore.setActionCommand(GestioneLibreriaListener.RADIO_AUTORE);
		libro=new JRadioButton("Libro");
		libro.addActionListener(new GestioneLibreriaListener(this));
		libro.setActionCommand(GestioneLibreriaListener.RADIO_LIBRO);
		genere=new JRadioButton("Genere");
		genere.addActionListener(new GestioneLibreriaListener(this));
		genere.setActionCommand(GestioneLibreriaListener.RADIO_GENERE);
		casa=new JRadioButton("Casa Editrice");
		casa.addActionListener(new GestioneLibreriaListener(this));
		casa.setActionCommand(GestioneLibreriaListener.RADIO_CASA);
		group1=new ButtonGroup();
		group1.add(libro);
		group1.add(autore);
		group1.add(genere);
		group1.add(casa);
		setLibroEdit();
	}
	public ButtonGroup getGroup(){
		return group;
	}
	public void setLibroEdit(){
		this.removeAll();
		libro.setSelected(true);
		this.setLayout(new BorderLayout());
		JPanel p0=new JPanel();
		p0.setLayout(new GridLayout(0,5));
		this.add(p0,BorderLayout.NORTH);
		JLabel label=new JLabel("Seleziona cosa modificare:");
		p0.add(label);
		p0.add(libro);
		p0.add(autore);
		p0.add(casa);
		p0.add(genere);
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(0,7));
		this.add(p1,BorderLayout.CENTER);
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
			items.lastElement().setActionCommand(Integer.toString(ll.getIdlibro()));
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
		modifica.addActionListener(new GestioneLibreriaListener(this));
		modifica.setActionCommand(GestioneLibreriaListener.ACTION_EDIT);
		cancella.addActionListener(new GestioneLibreriaListener(this));
		cancella.setActionCommand(GestioneLibreriaListener.ACTION_DELETE);
		aggiungi.addActionListener(new GestioneLibreriaListener(this));
		aggiungi.setActionCommand(GestioneLibreriaListener.ACTION_ADD);
		p2.add(modifica);
		p2.add(cancella);
		p2.add(aggiungi);
		this.repaint();
	}
	public void setAutoreEdit(){
		this.removeAll();
		this.setLayout(new BorderLayout());
		JPanel p0=new JPanel();
		p0.setLayout(new GridLayout(0,5));
		this.add(p0,BorderLayout.NORTH);
		JLabel label=new JLabel("Seleziona cosa modificare:");
		p0.add(label);
		p0.add(libro);
		p0.add(autore);
		p0.add(casa);
		p0.add(genere);
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(0,3));
		this.add(p1,BorderLayout.CENTER);
		
		this.repaint();
	}
}
//TODO Implementare gestione Autori/Casa/Genere