package it.unisalento.actionListener;

import it.unisalento.businesslogic.CarrelloManager;
import it.unisalento.view.Result;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultListener implements ActionListener {
	
	public static final String ACTION_ADD="aggiungi";
	private Result r;
	
	public ResultListener(Result r){
		this.r=r;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals(ACTION_ADD)){
			CarrelloManager m=new CarrelloManager(r.getSelezionati());
			}
		}

}
