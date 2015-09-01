package it.unisalento.actionListener;

import it.unisalento.businesslogic.AddettiManager;
import it.unisalento.view.GestioneAddetti;
import it.unisalento.view.Registrazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;

public class AddettiListener implements ActionListener {
	
	public static final String ACTION_ADD="aggiungi";
	public static final String ACTION_EDIT="modifica";
	public static final String ACTION_DEL="cancella";
	private GestioneAddetti g;
	private AddettiManager man;
	
	public AddettiListener(GestioneAddetti g){
		this.g=g;
		man=new AddettiManager();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String command=arg0.getActionCommand();
		ButtonGroup bg=this.g.getGroup();
		
		if(command.equals(ACTION_ADD)){
			man.aggiungi();
			g.updateInterface();
		}
		else if(command.equals(ACTION_EDIT)){
			int id=Integer.parseInt(bg.getSelection().getActionCommand());
			man.modifica(id);
			g.updateInterface();
		}
		else{
			int id=Integer.parseInt(bg.getSelection().getActionCommand());
			man.cancella(id);
			g.updateInterface();
		}
	}

}
