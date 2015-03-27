package it.unisalento.actionListener;

import it.unisalento.businesslogic.CarrelloManager;
import it.unisalento.view.Catalogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CatalogoListener implements ActionListener {
	
	public static final String ACTION_ADD="vyfsfkj";
	public static final String ACTION_SEARCH="shuduai";
	private Catalogo c;
	
	public CatalogoListener(Catalogo c){
		this.c=c;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals(ACTION_ADD)){
			CarrelloManager m=new CarrelloManager(c.getSelezionati());
			
		}
	}

}
