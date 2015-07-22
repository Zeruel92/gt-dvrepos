package it.unisalento.actionListener;

import it.unisalento.view.ModificaForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificaListener implements ActionListener {
	
	public static final String ACTION_APPLY="applica";
	public static final String ACTION_CANCEL="annulla";
	private ModificaForm f;
	
	 public ModificaListener(ModificaForm f) {
		this.f=f;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Implementare Controlli Finestra di Modifica
		
	}
		
}
