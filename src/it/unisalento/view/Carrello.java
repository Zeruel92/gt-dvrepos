package it.unisalento.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import it.unisalento.actionListener.CatalogoListener;
import it.unisalento.dao.Chart;
import it.unisalento.dao.Libreria;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Carrello extends JPanel implements Runnable{
	
	private Chart chart;
	private Thread t;
	private JPanel north;
	
	public Carrello(){
		chart=Chart.getIstance();
		t=new Thread(this);
		t.start();
		this.setLayout(new BorderLayout());
		north=new JPanel();
		this.add(north, BorderLayout.NORTH);
		JPanel south = new JPanel();
		this.add(south, BorderLayout.SOUTH);
		north.setLayout(new GridLayout(0,6));
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
		for (int i=0;i<chart.getDim();i++){
			titolo=new JLabel(chart.getItem(i).getTitolo());
			autore=new JLabel(chart.getItem(i).getAutore());
			casaed=new JLabel(chart.getItem(i).getCasaedi());
			genere=new JLabel(chart.getItem(i).getGenere());
			prezzo=new JLabel(Float.toString(chart.getItem(i).getCosto()));
			north.add(new JLabel(" "));
			north.add(titolo);
			north.add(autore);
			north.add(casaed);
			north.add(genere);
			north.add(prezzo);
		}
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
