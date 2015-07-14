package it.unisalento.actionListener;

import it.unisalento.businesslogic.Research;
import it.unisalento.view.SForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchListener implements ActionListener{
	private SForm s;
	private Research r;
	public SearchListener(SForm s){
		this.s=s;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("cerca"))
		{
			
			Research r=new Research();
		}
	}
	

}
