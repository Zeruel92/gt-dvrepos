package it.unisalento.actionListener;

import it.unisalento.view.GestioneAddetti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;

public class AddettiListener implements ActionListener {
	
	public static final String ACTION_ADD="aggiungi";
	public static final String ACTION_EDIT="modifica";
	public static final String ACTION_DEL="cancella";
	private GestioneAddetti g;
	
	public AddettiListener(GestioneAddetti g){
		this.g=g;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String command=arg0.getActionCommand();
		ButtonGroup bg=this.g.getGroup();
		if(command.equals(ACTION_ADD)){
			//TODO Aggiungi
		}
		else if(command.equals(ACTION_EDIT)){
			//TODO MODIFICA
		}
		else{
			//TODO CANCELLA
		}
	}

}
