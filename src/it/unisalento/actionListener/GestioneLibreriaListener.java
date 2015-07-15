package it.unisalento.actionListener;

import it.unisalento.view.GestioneLibreria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestioneLibreriaListener implements ActionListener {
	
	public static final String ACTION_EDIT="modifica";
	public static final String ACTION_DELETE="cancella";
	public static final String ACTION_ADD="aggiungi";
	public static final String RADIO_AUTORE="autore";
	public static final String RADIO_LIBRO="libro";
	public static final String RADIO_CASA="casa";
	public static final String RADIO_GENERE="genere";
	
	private GestioneLibreria g;
	private int edit;
	
	public GestioneLibreriaListener(GestioneLibreria g) {
		this.g=g;
		edit=0;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String command=arg0.getActionCommand();
		if(command.equals(RADIO_AUTORE)){
			edit=1;
			g.setAutoreEdit();
		}
		else if(command.equals(RADIO_LIBRO)){
			edit=0;
			g.setLibroEdit();
		}
		else if(command.equals(RADIO_GENERE)){
			//TODO setting view genere
		}
		else{
			//TODO setting view casaeditrice
		}
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
