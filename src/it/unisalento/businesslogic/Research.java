package it.unisalento.businesslogic;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.unisalento.dbinterface.DBManager;
import it.unisalento.view.SForm;

public class Research {
	String tipo;
	String stringa;
	JFrame lol=new JFrame();
	public Research(String tipo, String stringa) throws SQLException{
		this.tipo=tipo;
		this.stringa=stringa;
		
		
		if (tipo.equals("Titolo"))
				{
					String query="SELECT * from Libro as l WHERE titolo='"+stringa+"'";
					DBManager d=DBManager.getIstance();
					ResultSet rs=d.eseguiQuery(query);
							
					try {
						if (rs.getRow()=='0')
						{
							lol.setVisible(true);
							lol.setSize(200, 200);
							JOptionPane.showMessageDialog(lol, "Il libro da lei cercato non è presente in Catalogo!");
						}
							
						while (rs.next())
						{
							System.out.println(rs.getString("titolo"));							
									
								if(rs.isLast())
								{
									break;
								}
							
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
		
	}
		if (tipo.equals("Autore"))
		{
			String query="SELECT * from Libro as l JOIN Autore as a WHERE a.cognome='"+stringa+"' AND l.idAutore=a.idAutore";
			DBManager d=DBManager.getIstance();
			ResultSet rs=d.eseguiQuery(query);
					
			try {
				if (rs.getRow()=='0')
					JOptionPane.showMessageDialog(null, "L'autore da lei cercato non è presente in Catalogo!");
				while (rs.next())
				{
					System.out.println(rs.getString("titolo"));							
							
						if(rs.isLast())
						{
							break;
						}
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
}
		
		if (tipo.equals("Genere"))
		{
			String query="SELECT * from Libro as l JOIN Genere as g WHERE g.Genere='"+stringa+"' AND l.idGenere=g.idGenere";
			DBManager d=DBManager.getIstance();
			ResultSet rs=d.eseguiQuery(query);
					
			try {
				if (rs.getRow()=='0')
					JOptionPane.showMessageDialog(null, "Il genere da lei cercato non è presente in Catalogo!");
				while (rs.next())
				{
					System.out.println(rs.getString("titolo"));							
							
						if(rs.isLast())
						{
							break;
						}
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
}
}

}