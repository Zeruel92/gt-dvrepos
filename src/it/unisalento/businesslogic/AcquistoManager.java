package it.unisalento.businesslogic;

import it.unisalento.dao.Chart;
import it.unisalento.dao.Libreria;
import it.unisalento.dbinterface.DBManager;
import it.unisalento.model.Utente;

import javax.swing.JOptionPane;

public class AcquistoManager {
	
	public AcquistoManager(){
		Utente u=Utente.getUser();
		Chart c=Chart.getIstance();
		DBManager d=DBManager.getIstance();
		Libreria l=Libreria.getIstance();
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		for (int i=0;i<c.getDim();i++){
          if(c.getItem(i).getGiacenza()>0){
		String query="Insert into Vendite values (null,"+c.getItem(i).getIdlibro()+","+u.getIdutente()+",\""+currentTime+"\");";
		d.inserisciNuovo(query);
                c.getItem(i).setGiacenza(c.getItem(i).getGiacenza()-1);
                System.out.println(c.getItem(i).getGiacenza());
                query="UPDATE Libro "
                        + "set giacenza=\""+c.getItem(i).getGiacenza()+"\""
                        + "where idLibro=\""+c.getItem(i).getIdlibro()+"\"";
                d.inserisciNuovo(query);
                l.update();
                   }
         
                   else {
                       JOptionPane.showMessageDialog(null,"Libro: "+c.getItem(i).getTitolo()+" non disponibile");
                   }
		}
		c.svuotaCarrello();
	}
}
