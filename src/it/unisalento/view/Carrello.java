package it.unisalento.view;

import java.awt.BorderLayout;
import java.util.TimeZone; 
import java.util.Calendar;
import java.awt.GridLayout;
import java.util.Vector;

import it.unisalento.actionListener.CarrelloListener;
import it.unisalento.actionListener.CatalogoListener;
import it.unisalento.dao.Chart;
import it.unisalento.dao.Libreria;
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
		north.add(new JLabel(" "));
		north.add(new JLabel("Titolo"));
		north.add(new JLabel("Autore"));
		north.add(new JLabel("Casa Editrice"));
		north.add(new JLabel("Genere"));
		north.add(new JLabel("Prezzo"));
		JLabel titolo,autore,casaed,genere,prezzo;
		JButton rimuovi;
		for (int i=0;i<chart.getDim();i++){
			titolo=new JLabel(chart.getItem(i).getTitolo());
			autore=new JLabel(chart.getItem(i).getAutore());
			casaed=new JLabel(chart.getItem(i).getCasaedi());
			genere=new JLabel(chart.getItem(i).getGenere());
			prezzo=new JLabel(Float.toString(chart.getItem(i).getCosto())+"Û");
			rimuovi=new JButton("Rimuovi");
			
			String command=carrList.ACTION_DELETE+Integer.toString(i);
			System.out.println("Actioncommand "+command);
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
		riepilogo.setText("Il totale e' di "+totale+"Û");
	}
	
	public void run(){
	try{
		while(true){
			t.sleep(1000);
			if(!this.isShowing()){
			aggiorna();
			}
		}
	}catch(Exception e){
		e.printStackTrace();
		}
	}
}
