package it.unisalento.actionListener;

import it.unisalento.dao.Chart;
import it.unisalento.view.RegistroVendite;
import it.unisalento.view.Carrello;
import it.unisalento.view.Riepilogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CarrelloListener implements ActionListener {
	
	private RegistroVendite r;
	private Carrello c;
	public static final String ACTION_DELETE="delete";
	public static final String ACTION_SHIP="goshipping";
	private static Chart cc;
	
	
	public CarrelloListener(Carrello c){
		this.c=c;
		cc=Chart.getIstance();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String a=arg0.getActionCommand();
		String command="";
		for(int i=0;i<cc.getDim();i++){
			command=ACTION_DELETE+Integer.toString(i);
		if(a.equals(command)){
			cc.rimuoviLibro(i);
			c.aggiorna();
		}
		}
		if(a.equals(ACTION_SHIP)){
			Riepilogo riep=new Riepilogo();
		}
	}

}
