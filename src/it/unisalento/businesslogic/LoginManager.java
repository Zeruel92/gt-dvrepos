package it.unisalento.businesslogic;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import it.unisalento.dbinterface.DBManager;
import it.unisalento.model.Utente;

public class LoginManager {
	private Utente u;
	private boolean status=false;
	private DBManager DB;
	
	public LoginManager(String email, String password){
		String query="Select * from Utente Where email=\""+email+"\" and password=\""+password+"\"";
		try{
		ResultSet rs=DB.getIstance().eseguiQuery(query);
		if(rs.next()){
			
			int idUtente=Integer.parseInt(rs.getString("idUtente"));
			String nome=rs.getString("nome");
			String cognome=rs.getString("cognome");
			String codfisc=rs.getString("codfisc");
			int tipo=Integer.parseInt(rs.getString("tipo"));
			String citta=rs.getString("citta");
			String provincia=rs.getString("provincia");
			int telefono=Integer.parseInt(rs.getString("telefono"));
			String indirizzo=rs.getString("indirizzo");
			
			u=new Utente(idUtente,nome,cognome,codfisc,email,password,tipo,citta,provincia,telefono,indirizzo);
			status=true;
			query="Select distinct r.idRichieste as id, l.titolo as titolo from libro as l , utente as u,richieste as r where r.idUtente="+u.getIdutente()+" and l.idLibro=r.idLibro and l.giacenza>0;";
			rs=DB.getIstance().eseguiQuery(query);
			if(rs.next()){
				String richieste="Il/i Libro/i :\n";
				do{
					richieste+=rs.getString("titolo")+"\n";
					DB.getIstance().inserisciNuovo("Delete from Richieste where idRichieste="+rs.getInt("id"));
				}while(rs.next());
				richieste+="Sono di nuovo disponibili, puoi consultare il catalogo per completare l'acquisto";
				JOptionPane.showMessageDialog(null, richieste);
			}
		}
		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public boolean getStatus(){
		return status;
	}
	public Utente getUser(){
		return u;
	}
}
//Classe che gestisce il login