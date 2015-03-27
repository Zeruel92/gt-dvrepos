package it.unisalento.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.unisalento.businesslogic.Digest;
import it.unisalento.businesslogic.LoginManager;
import it.unisalento.view.Login;
import it.unisalento.view.Registrazione;
import it.unisalento.view.UserInterface;

public class LoginListener implements ActionListener {
	public static final String ACTION_LOGIN="login";
	public static final String ACTION_REGISTER="registra";
	public static final String ACTION_ABOUT="aboutus";
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
			Digest d=new Digest(pass);
			pass=""; 
			String hashpass=d.getResult();
			LoginManager lm=new LoginManager(username,hashpass);
			if(lm.getStatus()){
				System.out.println("login completato");
				UserInterface ui=new UserInterface(lm.getUser());
				ui.setVisible(true);
				f.setVisible(false);
			}
			else{
				JOptionPane.showMessageDialog(null,"I dati inseriti non sono validi, riprovare o registrarsi per accedere!");
			}
		}
		else if(actionCommand.equals(ACTION_ABOUT)){
			String abouts="Libreria\n Realizzata da Gabriele Tramonte e Daniele Viscuso\nProgetto per il corso di \"Principi di Progettazione del Software\"\n"
					+ "Anno Accademico 2014/2015 ";
			JOptionPane.showMessageDialog(null,abouts);
		}
		else{
			Registrazione r=new Registrazione();
			f.setVisible(false);
		}
	}

}
