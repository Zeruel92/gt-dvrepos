package it.unisalento.businesslogic;

import it.unisalento.Main;
import it.unisalento.dbinterface.DBManager;

import java.awt.GridLayout;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Ordini {
	JScrollPane centrosc;
	public Ordini(){
	String query="select l.titolo as titolo, u.nome as nome, u.cognome as cognome, u.citta as citta, u.codfisc as codfisc, u.provincia as provincia, u.telefono, l.costo as costo, u.email as email from richieste as r, libro as l, utente as u where r.idLibro=l.idLibro and r.idUtente=u.idUtente";
	DBManager d=DBManager.getIstance();
	ResultSet rs=d.eseguiQuery(query);
	JPanel centro=new JPanel();
	centro.setLayout(new GridLayout(0,3));
	centrosc=new JScrollPane(centro);
	try {
	while (rs.next())
		{
		
			String nomel=rs.getString("titolo");
			JLabel nomelibro=new JLabel();
			nomelibro.setText(nomel);
			centro.add(nomelibro);
			
			String nome=rs.getString("nome");
			String cognome=rs.getString("cognome");
			String citta=rs.getString("citta");
			String provincia=rs.getString("provincia");
			String tel=rs.getString("telefono");
			String cod=rs.getString("codfisc");
			String email=rs.getString("email");
			JLabel infocliente=new JLabel();
			infocliente.setText("<html>" +nome+ " " +cognome+ "<br>" +citta+","+provincia+ "<br>" +tel+ "<br>" +cod+ "<br>" +email+ "</html>");
			centro.add(infocliente);
			
			
			int price=rs.getInt("costo");
			JLabel prezzo=new JLabel();
			prezzo.setText(Integer.toString(price) + Main.EURO);
			centro.add(prezzo);
			
			if(rs.isLast())
			{
				break;
			}
		}

	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}
public JScrollPane getCentro(){
	return centrosc;
	
}
}