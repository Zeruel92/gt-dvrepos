package it.unisalento.dao;
import it.unisalento.model.Libro;
import it.unisalento.dbinterface.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import it.unisalento.model.Libro;
import it.unisalento.view.ModificaForm;

public class Libreria {
	private	static Vector<Libro> libreria= new Vector<Libro>();
	private	ModificaForm modifica;
	private DBManager db;
	private static Libreria istance;
	private final String query="Select l.idLibro, l.titolo, g.genere, l.costo, l.giacenza, a.nome, a.cognome, e.nome as casaed\n"+
			"from Libro as l, Autore as a, CasaEditrice as e, Genere as g \n"+
			"where l.idAutore=a.idAutore and l.idCasaEd=e.idCasaEd and l.idGenere=g.idGenere \n"
			+ "ORDER BY l.idLibro";

	public static Libreria getIstance(){
		if(istance==null){
			istance=new Libreria();
		}
		return istance;
	}
	public void modificaLibro(Libro l)
	{
		modifica= new ModificaForm(l);
	}

	public Libro getLibro(int index){
		return libreria.elementAt(index);
	}
	public Libro getLibroID(int id){
		Libro l=new Libro();
		for (int i=0;i<libreria.size();i++){
			if(libreria.elementAt(i).getIdlibro()==id)
				l=libreria.elementAt(i);
		}
		return l;
	}
	public int getDim(){
		return libreria.size();
	}
	public void update(){
		libreria.removeAllElements();
		try{
			ResultSet rs=db.getIstance().eseguiQuery(query);

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
	private Libreria()
	{
		try{
			ResultSet rs=db.getIstance().eseguiQuery(query);

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
