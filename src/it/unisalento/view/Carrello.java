package it.unisalento.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.TimeZone; 
import java.util.Calendar;
import java.awt.GridLayout;
import java.util.Vector;

import it.unisalento.Main;
import it.unisalento.actionListener.CarrelloListener;
import it.unisalento.actionListener.CatalogoListener;
import it.unisalento.dao.Autori;
import it.unisalento.dao.CaseEditrici;
import it.unisalento.dao.Chart;
import it.unisalento.dao.Generi;
import it.unisalento.dao.Libreria;
import it.unisalento.model.Autore;
import it.unisalento.model.CasaEditrice;
import it.unisalento.model.Genere;
import it.unisalento.model.Utente;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Carrello extends JPanel implements Runnable{
	
	Vector<JTextArea> registro= new Vector<JTextArea>();
	private Utente u;
	private Chart chart;
	private Thread t;
	private JPanel north;
	private CarrelloListener carrList;
	private JButton compra;
	private JLabel riepilogo;
	
	public Carrello(){
		u=Utente.getUser();
		chart=Chart.getIstance();
		carrList=new CarrelloListener(this);
		t=new Thread(this);
		t.start();
		this.setLayout(new BorderLayout());
		north=new JPanel();
		this.add(north, BorderLayout.NORTH);
		JPanel south = new JPanel();
		this.add(south, BorderLayout.SOUTH);
		north.setLayout(new GridLayout(0,6));
		compra=new JButton("Acquista");
		compra.setActionCommand(carrList.ACTION_SHIP);
		compra.addActionListener(carrList);
		south.add(compra);
		riepilogo=new JLabel();
		this.add(riepilogo, BorderLayout.CENTER);
		aggiorna();
	}
	
	public void aggiorna(){
		north.removeAll();
		
		Font f=new Font("TimesRoman", Font.BOLD, 13);
		north.add(new JLabel(" "));
		JLabel uno=new JLabel("TITOLO");
		uno.setFont(f);
		north.add(uno);
		JLabel due=new JLabel("AUTORE");
		due.setFont(f);
		north.add(due);
		JLabel tre=new JLabel("CASA EDITRICE");
		tre.setFont(f);
		north.add(tre);
		JLabel quattro=new JLabel("GENERE");
		quattro.setFont(f);
		north.add(quattro);
		JLabel cinque=new JLabel("PREZZO");
		cinque.setFont(f);
		north.add(cinque);
		JLabel titolo,autore,casaed,genere,prezzo;
		JButton rimuovi;
		for (int i=0;i<chart.getDim();i++){
			titolo=new JLabel(chart.getItem(i).getTitolo());
			int idautore=chart.getItem(i).getAutore();
			Autore a=Autori.getIstance().getAutoreID(idautore);
			autore=new JLabel(a.getNome()+" "+a.getCognome());
			int idcasa=chart.getItem(i).getCasaedi();
			CasaEditrice e=CaseEditrici.getIstance().getCasaID(idcasa);
			casaed=new JLabel(e.getNome());
			int idgenere=chart.getItem(i).getGenere()-1;
			Genere g=Generi.getIstance().getGenereID(idgenere);
			genere=new JLabel(g.getNome());
			prezzo=new JLabel(Float.toString(chart.getItem(i).getCosto())+Main.EURO);
			rimuovi=new JButton("Rimuovi");
			
			String command=carrList.ACTION_DELETE+Integer.toString(i);
			rimuovi.setActionCommand(command);
			rimuovi.addActionListener(carrList);
			north.add(rimuovi);
			north.add(titolo);
			north.add(autore);
			north.add(casaed);
			north.add(genere);
			north.add(prezzo);
			
		}
		String totale=Float.toString(chart.getTotale());
		riepilogo.setText("Il totale e' di "+totale+Main.EURO);
	}
	
	public void run(){
	try{
		while(true){
			t.sleep(1000);
			if(!this.isShowing()){
			aggiorna();
			}
			if(chart.isEmpty()){
				aggiorna();
			}
		}
	}catch(Exception e){
		e.printStackTrace();
		}
	}
}
