package it.unisalento.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import it.unisalento.view.*;

public class LoginListener implements ActionListener {
	private static final String actionLogin="login";
	private static final String actionRegister="registra";
	private JFrame f;
	
	public LoginListener(JFrame f){
		this.f=f;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String actionCommand=arg0.getActionCommand();
		if(actionCommand.equals(actionLogin)){
			//TODO Scrivere funzione di Login
		}
		else{
			Registrazione r=new Registrazione();
		}
	}

}
