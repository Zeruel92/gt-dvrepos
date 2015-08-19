package it.unisalento.businesslogic;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.unisalento.dbinterface.DBManager;

public class Research {
	String tipo;
	String stringa;
	public Research(String tipo, String stringa) throws SQLException{
		this.tipo=tipo;
		this.stringa=stringa;
		
		
		if (tipo.equals("titolo"))
				{
					String query="SELECT * from Libro as l WHERE titolo= stringa";
					DBManager d=DBManager.getIstance();
					ResultSet rs=d.eseguiQuery(query);
					System.out.println(rs.getRow());
					try {
						while (rs.next())
						{
							
							System.out.println(rs.getString("titolo"));
							if(rs.isLast())
							{
								break;
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
		
	}
}
}