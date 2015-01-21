package it.unisalento.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.businesslogic.LoginManager;
import it.unisalento.view.Login;
import it.unisalento.view.Registrazione;

public class LoginListener implements ActionListener {
	public static final String ACTION_LOGIN="login";
	public static final String ACTION_REGISTER="registra";
	private Login f;
	
	public LoginListener(Login f){
		this.f=f;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String actionCommand=arg0.getActionCommand();
		if(actionCommand.equals(ACTION_LOGIN)){
			String username= f.getUsername();
			String pass=new String(f.getPassword());
			LoginManager lm=new LoginManager(username,pass);
			if(lm.getStatus()){
				System.out.println("login completato");
			}
			else{
				System.out.println("Login errato");
			}
		}
		else{
			Registrazione r=new Registrazione();
		}
	}

}
