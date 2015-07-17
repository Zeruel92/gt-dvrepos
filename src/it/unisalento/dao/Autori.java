package it.unisalento.dao;

import it.unisalento.dbinterface.DBManager;
import it.unisalento.model.Autore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Autori {
	private static Autori istance;
	private Vector<Autore> lista;
	private DBManager DB;
	private final String query="Select * FROM autore";

	public static Autori getIstance(){
		if(istance==null){
			istance=new Autori();
		}
		return istance;
	}
	private Autori(){
		lista=new Vector<Autore>();
		DB=DBManager.getIstance();
		ResultSet rs=DB.eseguiQuery(query);
		try {
			while(rs.next()){
				String nome=rs.getString("nome");
				String cognome=rs.getString("cognome");
				int id=Integer.parseInt(rs.getString("idAutore"));
				lista.addElement(new Autore(nome,cognome,id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Autore getAutore(int index){
		return lista.elementAt(index);
	}
	public int getDim(){
		return lista.size();
	}
	public void update(){
		lista.removeAllElements();
		ResultSet rs=DB.eseguiQuery(query);
		try {
			while(rs.next()){
				String nome=rs.getString("nome");
				String cognome=rs.getString("cognome");
				int id=Integer.parseInt(rs.getString("idAutore"));
				lista.addElement(new Autore(nome,cognome,id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
