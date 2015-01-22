package it.unisalento.dao;
import it.unisalento.model.Libro;
import it.unisalento.dbinterface.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import it.unisalento.model.Libro;
import it.unisalento.view.ModificaLibro;

	public class Libreria {
		private	Vector<Libro> libreria= new Vector<Libro>();
		private	ModificaLibro modifica;
		private DBManager db;
	
	public void modificaLibro(Libro l)
	{
		modifica= new ModificaLibro(l);
	}
	
	public Libro getLibro(int index){
		return libreria.elementAt(index);
	}
	public int getDim(){
		return libreria.size();
	}
	public Libreria()
	{
		try{
			ResultSet rs=db.getIstance().eseguiQuery("Select l.idLibro, l.titolo, l.genere, l.costo, l.giacenza, a.nome, a.cognome, e.nome as casaed\n"+
"from Libro as l, Autore as a, CasaEditrice as e \n"+
"where l.idAutore=a.idAutore and l.idCasaEd=e.idCasaEd");
			
			while (rs.next())
			{
				int idlibro= Integer.parseInt(rs.getString("idLibro"));
				String titolo=rs.getString("titolo");
				String autore=rs.getString("nome")+" "+rs.getString("cognome");
				String casaedi=rs.getString("casaed");
				float costo=Float.parseFloat(rs.getString("costo"));
				int giacenza=Integer.parseInt(rs.getString("giacenza"));
				String genere=rs.getString("genere");
				Libro l=new Libro(idlibro, titolo, autore, casaedi, costo, giacenza, genere);
				libreria.addElement(l);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
	}

}
