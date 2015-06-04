package it.unisalento.view;


import it.unisalento.businesslogic.RegistroManager;
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
	public JTextArea nomelibro, date, infocliente, prezzo,l;
	private RegistroVendite istance;
	public RegistroVendite()
	{
		//Imposto Layout pannello generale
		this.setLayout(new BorderLayout());
		
		//creo pannelli superiori
		JPanel nord= new JPanel();
		nord.setLayout(new GridLayout(1,5));
		this.add(nord, BorderLayout.NORTH);
		JLabel uno=new JLabel("Nome Libro");
		JLabel due= new JLabel("Data di Vendita");
		JLabel tre= new JLabel("Info Cliente");
		JLabel quattro= new JLabel("Prezzo Libro");
	
		nord.add(uno);
		nord.add(due);
		nord.add(tre);
		nord.add(quattro);
		
		//creo pannelli al centro
		
		JScrollPane centro=new RegistroManager().getCentro();
		this.add(centro,BorderLayout.CENTER);
		this.setVisible(true);
		
	}
	
}
