package it.unisalento.businesslogic;
import it.unisalento.Main;
import it.unisalento.view.RegistroVendite;
import it.unisalento.dbinterface.*;

import java.awt.GridLayout;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RegistroManager {
	JScrollPane centrosc;
	public RegistroManager(){
	String query="SELECT * from Vendite AS v JOIN Libro AS l JOIN Utente AS u WHERE v.idLibro = l.idLibro AND v.idUtente = u.idUtente ORDER BY idVendite;";
	DBManager d=DBManager.getIstance();
	ResultSet rs=d.eseguiQuery(query);
	JPanel centro=new JPanel();
	centro.setLayout(new GridLayout(0,4));
	centrosc=new JScrollPane(centro);
	try {
	while (rs.next())
		{
		
			String nomel=rs.getString("titolo");
			JLabel nomelibro=new JLabel();
			nomelibro.setText(nomel);
			centro.add(nomelibro);
			
			Date data=rs.getDate("data_vendita");
			JLabel date=new JLabel();
			date.setText(data.toString());
			centro.add(date);
			
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
