package it.unisalento.businesslogic;

import javax.swing.JOptionPane;

import it.unisalento.dao.Utenti;
import it.unisalento.dbinterface.DBManager;
import it.unisalento.view.Registrazione;

public class AddettiManager {
	private DBManager db;
	private Utenti users;
	
	public AddettiManager(){
		db=DBManager.getIstance();
		users=Utenti.getIstance();
	}
	public void cancella(int id){
		String titolo="Eliminare?";
		String messaggio="Sicuro di volere eliminare l'utente con id"+id+"?";
		int risposta=JOptionPane.showConfirmDialog(null,messaggio, titolo, JOptionPane.YES_NO_OPTION);
		if(risposta==JOptionPane.YES_OPTION){
			String query="DELETE from Utente where idUtente="+id;
			DBManager db=DBManager.getIstance();
			int rs=db.inserisciNuovo(query);
			if(rs!=-1){
				JOptionPane.showMessageDialog(null, "Cancellazione riuscita");
				users.update();
			}
			else JOptionPane.showMessageDialog(null, "Cancellazione non riuscita");
		}
	}
	public void aggiungi() {
		Registrazione r=new Registrazione();
		r.setVisible(true);
	}
	public void modifica(int id) {
		String titolo="modificare?";
		String messaggio="Sicuro di volere modificare i privelegi dell'utente con id :"+id+"?";
		int risposta=JOptionPane.showConfirmDialog(null,messaggio, titolo, JOptionPane.YES_NO_OPTION);
		if(risposta==JOptionPane.YES_OPTION){
			int tipo=users.getUtenteID(id).getTipo()+1;
			if(tipo>3){
				tipo=0;
			}
			String query="UPDATE Utente SET tipo="+tipo+" WHERE idUtente="+id+";";
			DBManager db=DBManager.getIstance();
			int rs=db.inserisciNuovo(query);
			if(rs!=-1){
				JOptionPane.showMessageDialog(null, "Aggiornamento riuscito");
				users.update();
			}
			else JOptionPane.showMessageDialog(null, "Aggiornamento non riuscito");
		}
	}
}
