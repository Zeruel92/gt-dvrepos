package it.unisalento.businesslogic;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.unisalento.dao.Libreria;
import it.unisalento.dbinterface.DBManager;
import it.unisalento.view.SForm;
import it.unisalento.view.Result;

public class Research {
	String tipo;
	String stringa;
	JFrame lol=new JFrame();
	public Research(String tipo, String stringa) throws SQLException{
		this.tipo=tipo;
		this.stringa=stringa;
		
		
		if (tipo.equals("Titolo"))
				{
					String query="Select l.idLibro, l.titolo, g.idGenere, l.costo, l.giacenza, a.idAutore, e.idCasaEd as casaed\n"+
							"from Libro as l, Autore as a, CasaEditrice as e, Genere as g \n"+
							"where l.titolo='"+stringa+"' AND l.idAutore=a.idAutore and l.idCasaEd=e.idCasaEd and l.idGenere=g.idGenere \n"
							+ "ORDER BY l.idLibro";
					DBManager d=DBManager.getIstance();
					ResultSet rs=d.eseguiQuery(query);
							
					try {
						if (rs.getRow()=='0')
						{
							lol.setVisible(true);
							lol.setSize(200, 200);
							JOptionPane.showMessageDialog(lol, "Il libro da lei cercato non è presente in Catalogo!");
						}
							JFrame frame=new JFrame();
							Libreria lib=Libreria.getIstance();
							lib.update(query);
							Result r=new Result();
							frame.add(r);
							frame.setVisible(true);
							frame.pack();
							
					} catch (SQLException e) {
						e.printStackTrace();
					}
		
	}
		if (tipo.equals("Autore"))
		{
			String query="Select l.idLibro, l.titolo, g.idGenere, l.costo, l.giacenza, a.idAutore, e.idCasaEd as casaed\n"+
					"from Libro as l, Autore as a, CasaEditrice as e, Genere as g \n"+
					"where a.cognome='"+stringa+"' AND l.idAutore=a.idAutore and l.idCasaEd=e.idCasaEd and l.idGenere=g.idGenere \n"
					+ "ORDER BY l.idLibro";
			DBManager d=DBManager.getIstance();
			ResultSet rs=d.eseguiQuery(query);
					
			try {
				if (rs.getRow()=='0')
				{
					lol.setVisible(true);
					lol.setSize(200, 200);
					JOptionPane.showMessageDialog(lol, "L'autore da lei cercato non è presente in catalogo!");
				}
					JFrame frame=new JFrame();
					Libreria lib=Libreria.getIstance();
					lib.update(query);
					Result r=new Result();
					frame.add(r);
					frame.setVisible(true);
					frame.pack();
			} catch (SQLException e) {
				e.printStackTrace();
			}
}
		
		if (tipo.equals("Genere"))
		{
			String query="Select l.idLibro, l.titolo, g.idGenere, l.costo, l.giacenza, a.idAutore, e.idCasaEd as casaed\n"+
					"from Libro as l, Autore as a, CasaEditrice as e, Genere as g \n"+
					"where g.Genere='"+stringa+"' AND l.idAutore=a.idAutore and l.idCasaEd=e.idCasaEd and l.idGenere=g.idGenere \n"
					+ "ORDER BY l.idLibro";
			DBManager d=DBManager.getIstance();
			ResultSet rs=d.eseguiQuery(query);
					
			try {
				if (rs.getRow()=='0')
				{
					lol.setVisible(true);
					lol.setSize(200, 200);
					JOptionPane.showMessageDialog(lol, "Il genere da lei cercato non è presente in catalogo!");
				}
						JFrame frame=new JFrame();
						Libreria lib=Libreria.getIstance();
						lib.update(query);
						Result r=new Result();
						frame.add(r);
						frame.setVisible(true);
						frame.pack();	
			} catch (SQLException e) {
				e.printStackTrace();
			}
}
}
}