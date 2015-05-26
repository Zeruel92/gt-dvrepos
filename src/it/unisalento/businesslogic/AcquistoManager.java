package it.unisalento.businesslogic;

import it.unisalento.dao.Chart;
import it.unisalento.dbinterface.DBManager;
import it.unisalento.model.Utente;

public class AcquistoManager {
	
	public AcquistoManager(){
		Utente u=Utente.getUser();
		Chart c=Chart.getIstance();
		DBManager d=DBManager.getIstance();
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		for (int i=0;i<c.getDim();i++){
		String query="Insert into Vendite values (null,"+c.getItem(i).getIdlibro()+","+u.getIdutente()+",\""+currentTime+"\");";
		d.inserisciNuovo(query);
		}
		c.svuotaCarrello();
	}
}
