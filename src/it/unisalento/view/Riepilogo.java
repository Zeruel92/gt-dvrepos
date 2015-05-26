package it.unisalento.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;

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
		p2=new JPanel();
		p2.setLayout(new BorderLayout());
		this.getContentPane().add(p2,BorderLayout.SOUTH);
		p2.add(b2,BorderLayout.EAST);
		p2.add(b1,BorderLayout.WEST);
		pack();
		setVisible(true);
	}

}
