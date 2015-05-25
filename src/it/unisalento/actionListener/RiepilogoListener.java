package it.unisalento.actionListener;

import it.unisalento.businesslogic.AcquistoManager;
import it.unisalento.view.Riepilogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RiepilogoListener implements ActionListener {

	public static final String ACTION_CONFIRM="gesuèunbravoragazzo";
	public static final String ACTION_CANCEL="seeculuculu!!!!";
	
	private Riepilogo r;

	public RiepilogoListener(Riepilogo r){
		this.r=r;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String command=arg0.getActionCommand();
		if(command.equals(ACTION_CONFIRM)){
			AcquistoManager a=new AcquistoManager();
			r.setVisible(false);
		}
	}

}
