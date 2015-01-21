package it.unisalento.businesslogic;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.unisalento.dbinterface.DBManager;

public class LoginManager {
	private boolean status=false;
	private DBManager DB;
	
	public LoginManager(String username, String password){
		String query="Select * from Utente Where email=\""+username+"\" and password=\""+password+"\"";
		try{
		ResultSet rs=DB.getIstance().eseguiQuery(query);
		if(rs.next()){
			status=true;
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public boolean getStatus(){
		return status;
	}
}
//Classe che gestisce il login