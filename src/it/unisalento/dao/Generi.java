package it.unisalento.dao;

import it.unisalento.model.CasaEditrice;
import it.unisalento.model.Genere;
import it.unisalento.dbinterface.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Generi {

	private static Generi istance;
	private Vector<Genere> lista;
	private DBManager db;
	private final String query="SELECT * FROM genere";

	public static Generi getIstance(){
		if(istance==null){
			istance=new Generi();
		}
		return istance;
	}

	private Generi(){
		lista=new Vector<Genere>();
		db=DBManager.getIstance();
		ResultSet rs=db.eseguiQuery(query);
		try {
			while(rs.next()){
				int id=Integer.parseInt(rs.getString("idGenere"));
				String nome=rs.getString("genere");
				lista.addElement(new Genere(id,nome));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void update(){
		ResultSet rs=db.eseguiQuery(query);
		try {
			while(rs.next()){
				int id=Integer.parseInt(rs.getString("idGenere"));
				String nome=rs.getString("genere");
				lista.addElement(new Genere(id,nome));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Genere getGenere(int index){
		return lista.elementAt(index);
	}
	public int getDim(){
		return lista.size();
	}
	
	public String[] getArray(){
		String array[]=new String[lista.size()];
		for (int i=0;i<lista.size();i++){
			array[i]=lista.elementAt(i).getNome();
		}
		return array;
	}

	public Genere getGenereID(int id) {
		Genere gen=new Genere();
		for(int i=0;i<lista.size();i++){
			if(lista.elementAt(i).getId()==id){
				gen=lista.elementAt(i);
			}
		}
		return gen;
	}
}
