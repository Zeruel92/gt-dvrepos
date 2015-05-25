package it.unisalento.view;

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
	private JTextArea textArea1;
	private JButton b1;
	
	public Riepilogo(){
		chart=Chart.getIstance();
		u=Utente.getUser();
		textArea1=new JTextArea();
		add(textArea1);
		textArea1.setText("libri acquistati"+chart.getTotale()+"\nutente:"+u.getNome());
		b1=new JButton("Conferma");
		b1.setActionCommand(RiepilogoListener.ACTION_CONFIRM);
		b1.addActionListener(new RiepilogoListener(this));
		add(b1);
		pack();
		setVisible(true);
	}

}
