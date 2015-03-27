package it.unisalento.businesslogic;

import java.sql.ResultSet;
import java.sql.SQLException;

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