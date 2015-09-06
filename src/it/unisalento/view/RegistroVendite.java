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
		Font f=new Font("TimesRoman", Font.BOLD, 13);
		JLabel uno=new JLabel("NOME LIBRO");
		uno.setFont(f);
		JLabel due= new JLabel("DATA DI VENDITA");
		due.setFont(f);
		JLabel tre= new JLabel("INFO CLIENTE");
		tre.setFont(f);
		JLabel quattro= new JLabel("PREZZO LIBRO");
		quattro.setFont(f);
	
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
