package it.unisalento.view;

import javax.swing.*;

import java.awt.*;
import java.util.Vector;

public class RegistroVendite extends JPanel {
	public JPanel uno,due,tre,quattro,centro;
	public JTextArea nomelibro, date, infocliente, prezzo;
	public ResistroVendite()
	{
		//Imposto Layout pannello generale
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		
		//creo pannelli superiori
		JPanel uno=new JPanel();
		uno.setName("Nome Libro");
		JPanel due= new JPanel();
		due.setName("Data di Vendita");
		JPanel tre= new JPanel();
		tre.setName("Info Cliente");
		JPanel quattro= new JPanel();
		quattro.setName("Prezzo Libro");
		this.add(uno, BorderLayout.NORTH);
		this.add(due, BorderLayout.NORTH);
		this.add(tre, BorderLayout.NORTH);
		this.add(quattro, BorderLayout.NORTH);
		
		//creo pannelli al centro
		
		JPanel centro= new JPanel();
		centro.setLayout(new GridLayout(0,4));
		this.add(centro, BorderLayout.CENTER);
		
		JTextArea nomelibro= new JTextArea();
		JTextArea date= new JTextArea();
		JTextArea infocliente=new JTextArea();
		JTextArea prezzo= new JTextArea();
		RegistroVendite r=new RegistroVendite();
		
	}
	public void Aggiorna(Carrello c)
	{
		int i=0;
		for (i=0; i<=c.registro.size(); i++)
		{
			nomelibro.setText(c.registro.elementAt(i).getText());
			centro.add(nomelibro);
			i++;
			date.setText(c.registro.elementAt(i).getText());
			centro.add(date);
			i++;
			infocliente.setText(c.registro.elementAt(i).getText());
			centro.add(infocliente);
			i++;
			prezzo.setText(c.registro.elementAt(i).getText());
			centro.add(prezzo);
			i++;
		}

			
	}

}
