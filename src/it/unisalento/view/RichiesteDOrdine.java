package it.unisalento.view;

import it.unisalento.businesslogic.Ordini;
import it.unisalento.businesslogic.RegistroManager;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RichiesteDOrdine extends JPanel implements Runnable{
	public JLabel uno,due,tre,quattro;
	public JPanel nord, centro;
	public JTextArea nomelibro, date, infocliente, prezzo,l;
	private Thread T;
	private JScrollPane centrosc;
	public RichiesteDOrdine()
	{
		//Imposto Layout pannello generale
		this.setLayout(new BorderLayout());
		
		//creo pannelli superiori
		JPanel nord= new JPanel();
		nord.setLayout(new GridLayout(1,4));
		this.add(nord, BorderLayout.NORTH);
		Font f=new Font("TimesRoman", Font.BOLD, 13);
		JLabel uno=new JLabel("NOME LIBRO");
		uno.setFont(f);
		JLabel tre= new JLabel("INFO CLIENTE");
		tre.setFont(f);
		JLabel quattro= new JLabel("PREZZO LIBRO");
		quattro.setFont(f);
	
		nord.add(uno);
		nord.add(tre);
		nord.add(quattro);
		
		//creo pannelli al centro
		
		centrosc=new Ordini().getCentro();
		this.add(centrosc,BorderLayout.CENTER);
		this.setVisible(true);
		T=new Thread(this);
		T.start();
	}
	@Override
	public void run() {
		while (true){
			try {
				T.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			centrosc=new Ordini().getCentro();
		}
	}
	
}
