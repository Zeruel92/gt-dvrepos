package it.unisalento.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import it.unisalento.Main;
import it.unisalento.model.Utente;
import it.unisalento.actionListener.RiepilogoListener;
import it.unisalento.dao.Chart;

public class Riepilogo extends JFrame {
	
	private Chart chart;
	private Utente u;
	private JPanel p;
	private JButton b1;
	private JButton b2;
	private JPanel p2;
	public Riepilogo(){
		chart=Chart.getIstance();
		u=Utente.getUser();
		this.getContentPane().setLayout(new BorderLayout());
		p=new JPanel();
		p.setLayout(new FlowLayout());
		this.getContentPane().add(p,BorderLayout.CENTER);
		b1=new JButton("Conferma");
		b1.setActionCommand(RiepilogoListener.ACTION_CONFIRM);
		b1.addActionListener(new RiepilogoListener(this));
		b2=new JButton("Annulla");
		b2.setActionCommand(RiepilogoListener.ACTION_CANCEL);
		b2.addActionListener(new RiepilogoListener(this));
		JLabel utente=new JLabel();
		String sutente="<html>Riepilogo dati Cliente:<br>"
				+ "Nome: "+u.getNome()+"<br>"
						+ "Cognome: "+u.getCognome()+"<br>"
						+"Via: "+u.getIndirizzo()+", "+u.getCitta()+", ("+u.getProvincia()+")<br>"
						+"Telefono: "+u.getTelefono();
						
		utente.setText(sutente);
		p.add(utente);
		JLabel datiLibri=new JLabel();
		String sdatiLibri="<html>Riepilogo dai acquisto:<br>"
				+"Numero libri acquistati: "+chart.getDim()
				+"<br>Totale Costo: "+chart.getTotale()+Main.EURO
				+"</htm>";
		datiLibri.setText(sdatiLibri);
		p.add(datiLibri);
		p2=new JPanel();
		p2.setLayout(new BorderLayout());
		this.getContentPane().add(p2,BorderLayout.SOUTH);
		JPanel p3=new JPanel();
		p3.setLayout(new FlowLayout());
		p2.add(p3, BorderLayout.SOUTH);
		p3.add(b1);
		p3.add(b2);
		pack();
		setVisible(true);
	}

}
