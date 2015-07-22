package it.unisalento.dao;

import it.unisalento.dbinterface.DBManager;
import it.unisalento.model.CasaEditrice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class CaseEditrici {

	private static CaseEditrici istance;
	private Vector<CasaEditrice> lista;
	private DBManager db;
	private final String query="Select * FROM CasaEditrice";

	public static CaseEditrici getIstance(){
		if(istance==null){
			istance=new CaseEditrici();
		}
		return istance;
	}

	private CaseEditrici(){
		lista=new Vector<CasaEditrice>();
		db=DBManager.getIstance();
		ResultSet rs=db.eseguiQuery(query);
		try {
			while(rs.next()){
				int id=Integer.parseInt(rs.getString("idCasaEd"));
				String nome=rs.getString("nome");
				String piva=rs.getString("PIVA");
				lista.addElement(new CasaEditrice(id,nome,piva));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int getDim(){
		return lista.size();
	}
	public CasaEditrice getCasa(int index){
		return lista.elementAt(index);
	}
	public void update(){
		lista.removeAllElements();
		ResultSet rs=db.eseguiQuery(query);
		try {
			while(rs.next()){
				int id=Integer.parseInt(rs.getString("idCasaEd"));
				String nome=rs.getString("nome");
				String piva=rs.getString("PIVA");
				lista.addElement(new CasaEditrice(id,nome,piva));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public String[] getArray(){
		String array[]=new String[lista.size()];
		for (int i=0;i<lista.size();i++){
			array[i]=lista.elementAt(i).getNome();
		}
		return array;
	}
}
