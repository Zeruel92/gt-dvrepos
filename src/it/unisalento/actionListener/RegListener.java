package it.unisalento.actionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import it.unisalento.dbinterface.DBManager;
import it.unisalento.view.Login;
import it.unisalento.view.Registrazione;


public class RegListener implements ActionListener {
	private Registrazione r;
	public RegListener(Registrazione r)
	{
		this.r=r;
	}
	@Override
	public void actionPerformed (ActionEvent e)
	{
		if(e.getActionCommand().equals("Canc")){
			r.setVisible(false);
			Login l= new Login();
			}
		else if(e.getActionCommand().equals("Ok")){
			String pass1=r.getPassword1();
			String pass2=r.getPassword2();
			if(pass1.equals(pass2)){
				
				String nome=r.getNome();
				String cognome=r.getCognome();
				String email=r.getEmail();
				String citta=r.getCitta();
				String provincia=r.getProvincia();
				String indirizzo=r.getIndirizzo();
				String tel=r.getTel();
				String cod=r.getCod();
				String sql="Insert into utente values (null,\""+nome+"\",\""+cognome+"\",\""+cod+"\",\""+email+"\",\""+pass1+"\","+1+",\""+citta+"\",\""+provincia+"\",\""+tel+"\",\""+indirizzo+"\")";
				DBManager.getIstance().inserisciNuovo(sql);
				
					
			}
			else
				JOptionPane.showMessageDialog(null,"Le password non coincidono, riprovare!");
			}
			
	
	}
}
//TODO Sistemare la ricomparsa della schermata di Login dopo registrazione