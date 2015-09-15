package it.unisalento.businesslogic;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import it.unisalento.actionListener.CatalogoListener;
import it.unisalento.dao.Libreria;
import it.unisalento.dbinterface.DBManager;
import it.unisalento.view.Catalogo;
import it.unisalento.view.SForm;

public class Research {
	String tipo;
	String stringa;
	JFrame lol=new JFrame();
	private Catalogo c;
	public Research(String tipo, String stringa) throws SQLException{
		this.tipo=tipo;
		this.stringa=stringa;
		
		
		if (tipo.equals("Titolo"))
				{
					String query="Select l.idLibro, l.titolo, g.idGenere, l.costo, l.giacenza, a.idAutore, e.idCasaEd as casaed\n"+
							"from Libro as l, Autore as a, CasaEditrice as e, Genere as g \n"+
							"where l.titolo='"+stringa+"' AND l.idAutore=a.idAutore and l.idCasaEd=e.idCasaEd and l.idGenere=g.idGenere \n"
							+ "ORDER BY l.idLibro";
					
							Libreria lib=Libreria.getIstance();
							lib.update(query);
					
		
	}
		if (tipo.equals("Autore"))
		{
			String query="Select l.idLibro, l.titolo, g.idGenere, l.costo, l.giacenza, a.idAutore, e.idCasaEd as casaed\n"+
					"from Libro as l, Autore as a, CasaEditrice as e, Genere as g \n"+
					"where a.cognome='"+stringa+"' AND l.idAutore=a.idAutore and l.idCasaEd=e.idCasaEd and l.idGenere=g.idGenere \n"
					+ "ORDER BY l.idLibro";
					Libreria lib=Libreria.getIstance();
					lib.update(query);
				
}
		
		if (tipo.equals("Genere"))
		{
			String query="Select l.idLibro, l.titolo, g.idGenere, l.costo, l.giacenza, a.idAutore, e.idCasaEd as casaed\n"+
					"from Libro as l, Autore as a, CasaEditrice as e, Genere as g \n"+
					"where g.Genere='"+stringa+"' AND l.idAutore=a.idAutore and l.idCasaEd=e.idCasaEd and l.idGenere=g.idGenere \n"
					+ "ORDER BY l.idLibro";
						Libreria lib=Libreria.getIstance();
						lib.update(query);
			
}
}
}