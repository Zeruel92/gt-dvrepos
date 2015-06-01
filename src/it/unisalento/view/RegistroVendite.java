package it.unisalento.view;


import it.unisalento.dao.Chart;
import it.unisalento.dbinterface.DBManager;
import it.unisalento.model.Utente;

import javax.swing.*;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class RegistroVendite extends JPanel {
	public JLabel uno,due,tre,quattro;
	public JPanel nord, centro;
	public JTextArea nomelibro, date, infocliente, prezzo;
	private static RegistroVendite istance;
	public RegistroVendite()
	{
		//Imposto Layout pannello generale
		this.setLayout(new BorderLayout());
		
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
		
		/*JTextArea date= new JTextArea();
		JTextArea nomelibro= new JTextArea();
		JTextArea infocliente=new JTextArea();
		JTextArea prezzo= new JTextArea(); */
		this.setVisible(true);
		
	}
	
	public static RegistroVendite getIstance(){
		if(istance==null){
			istance=new RegistroVendite();
		}
		return istance;
	}
	
	
}
