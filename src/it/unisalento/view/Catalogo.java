package it.unisalento.view;

import java.awt.BorderLayout;
import java.awt.Font;
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

public class Catalogo extends JPanel implements Runnable {
	
	private JPanel center;
	private JPanel south;
	private JButton addchart;
	private JButton search;
	private Libreria lib;
	private Vector<JCheckBox> selection;
	private Thread T;
	
	public Catalogo(){
		south=new JPanel();
		addchart=new JButton("Aggiungi al Carrello");
		addchart.addActionListener(new CatalogoListener(this));
		addchart.setActionCommand(CatalogoListener.ACTION_ADD);
		search=new JButton("Cerca");
		search.addActionListener(new CatalogoListener(this));
		search.setActionCommand(CatalogoListener.ACTION_SEARCH);
	    south.add(addchart);
	    south.add(search);
		build();
		Thread T=new Thread(this);
		T.start();
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
	
	public void build(){
		this.removeAll();
		this.setLayout(new BorderLayout());
		center=new JPanel();
		this.add(center, BorderLayout.NORTH);
		
		this.add(south, BorderLayout.SOUTH);
		
		
		lib=Libreria.getIstance();
		center.setLayout(new GridLayout(0,7));
		
		Font f=new Font("TimesRoman", Font.BOLD, 13);
		JLabel uno=new JLabel(" ");
		uno.setFont(f);
		center.add(uno);
		JLabel due=new JLabel("TITOLO");
		due.setFont(f);
		center.add(due);
		JLabel tre=new JLabel("AUTORE");
		tre.setFont(f);
		center.add(tre);
		JLabel quattro=new JLabel("CASA EDITRICE");
		quattro.setFont(f);
		center.add(quattro);
		JLabel cinque=new JLabel("GENERE");
		cinque.setFont(f);
		center.add(cinque);
		JLabel sei=new JLabel("PREZZO");
		sei.setFont(f);
		center.add(sei);
		JLabel sette=new JLabel("GIACENZA");
		sette.setFont(f);
		center.add(sette);
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
	
	public void setSouth ()
	{
		this.remove(south);
		this.south=new JPanel();
		south.add(addchart);
		south.add(search);
		JButton canc=new JButton("Annulla");
		canc.setActionCommand("canc");
		canc.addActionListener(new CatalogoListener(this));
		south.add(canc);
		this.add(south,BorderLayout.SOUTH);
	}
	@Override
	public void run() {
		try{
			while(true){
				T.sleep(1000);
			if(!this.isShowing()){
				build();
			}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
//TODO Ricerca di elementi