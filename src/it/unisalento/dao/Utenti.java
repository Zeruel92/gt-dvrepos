package it.unisalento.dao;

import it.unisalento.dbinterface.DBManager;
import it.unisalento.model.UListModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Utenti {
	
	private static Utenti istance;
	private Vector<UListModel> lista;
	private DBManager db;
	private final String query="SELECT idUtente,email,tipo FROM utente";

		public static Utenti getIstance(){
			if(istance==null){
				istance=new Utenti();
			}
			return istance;
		}

		private Utenti(){
			lista=new Vector<UListModel>();
			db=DBManager.getIstance();
			update();
		}
		public void update(){
			ResultSet rs=db.eseguiQuery(query);
			try {
				while(rs.next()){
					int id=Integer.parseInt(rs.getString("idUtente"));
					String email=rs.getString("email");
					int tipo=Integer.parseInt(rs.getString("tipo"));
					lista.addElement(new UListModel(id,email,tipo));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public UListModel getUtente(int index){
			return lista.elementAt(index);
		}
		public int getDim(){
			return lista.size();
		}
		
		public String[] getArray(){
			String array[]=new String[lista.size()];
			for (int i=0;i<lista.size();i++){
				array[i]=lista.elementAt(i).getEmail();
			}
			return array;
		}

	public UListModel getUtenteID(int id) {
			UListModel user=new UListModel();
			for(int i=0;i<lista.size();i++){
				if(lista.elementAt(i).getId()==id){
					user=lista.elementAt(i);
				}
			}
			return user;
		}
	}

