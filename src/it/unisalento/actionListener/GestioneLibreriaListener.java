package it.unisalento.actionListener;

import it.unisalento.view.GestioneLibreria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestioneLibreriaListener implements ActionListener {
	
	public static final String ACTION_EDIT="modifica";
	public static final String ACTION_DELETE="cancella";
	public static final String ACTION_ADD="aggiungi";
	private GestioneLibreria g;
	
	public GestioneLibreriaListener(GestioneLibreria g) {
		this.g=g;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String command=arg0.getActionCommand();
		int idlibro=Integer.parseInt(g.getGroup().getSelection().getActionCommand());
		if(command.equals(ACTION_EDIT)){
			//TODO modifica di un libro
		}
		else if(command.equals(ACTION_DELETE)){
			//TODO eliminazione di un libro
		}
		else{
			//TODO aggiunta di un libro
		}
	}

}
