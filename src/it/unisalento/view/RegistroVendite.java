package it.unisalento.view;

import it.unisalento.dao.Chart;
import it.unisalento.model.Utente;

import javax.swing.*;

import java.awt.*;
import java.util.Vector;

public class RegistroVendite extends JPanel {
	public JLabel uno,due,tre,quattro;
	public JPanel nord, centro;
	public JTextArea nomelibro, date, infocliente, prezzo;
	private Chart cc;
	private Utente u;
	java.util.TimeZone time=java.util.TimeZone.getTimeZone("ECT");
	java.util.Calendar oggi = java.util.Calendar.getInstance(time);
	public RegistroVendite()
	{
		//Imposto Layout pannello generale
		this.setLayout(new BorderLayout());
		
		cc=Chart.getIstance();
		
		//creo pannelli superiori
		JPanel nord= new JPanel();
		this.add(nord, BorderLayout.NORTH);
		JLabel uno=new JLabel("Nome Libro");
		JLabel due= new JLabel("Data di Vendita");
		JLabel tre= new JLabel("Info Cliente");
		JLabel quattro= new JLabel("Prezzo Libro");
		nord.add(new JLabel(""));
		nord.add(uno);
		nord.add(due);
		nord.add(tre);
		nord.add(quattro);
		
		
		//creo pannelli al centro
		
		JPanel centro= new JPanel();
		centro.setLayout(new GridLayout(0,4));
		
		this.add(centro, BorderLayout.CENTER);
		
		JTextArea date= new JTextArea();
		
		JTextArea nomelibro= new JTextArea();
		JTextArea infocliente=new JTextArea();
		JTextArea prezzo= new JTextArea();
		this.setVisible(true);
		
	}
	public void Aggiorna()
	{
		int giorno = oggi.get(oggi.DAY_OF_MONTH);
		int mese = oggi.get(oggi.MONTH)+1;
		int anno = oggi.get(oggi.YEAR);
		int i=0;
		for (i=0; i<cc.getDim(); i++)
		{
			nomelibro.setText(cc.getItem(i).getTitolo());
			centro.add(nomelibro);
			System.out.println(nomelibro.getText());
			
			date.setText(giorno+"/"+mese+"/"+anno);
			centro.add(date);
			
			infocliente.setText(u.getNome()+" "+u.getCognome()+" "+u.getTelefono());
			centro.add(infocliente);
			
			prezzo.setText(Float.toString(cc.getItem(i).getCosto()));
			centro.add(prezzo);
		}
			
	}
	
}
