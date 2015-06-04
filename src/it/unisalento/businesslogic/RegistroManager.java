package it.unisalento.businesslogic;
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
			//r.setNomelibro(nomelibro);
			//System.out.println(nomelibro.getText());
			centro.add(nomelibro);
			
			Date data=rs.getDate("data_vendita");
			JLabel date=new JLabel();
			date.setText(data.toString());
			//System.out.println(date.getText());
			centro.add(date);
			
			String cliente=rs.getString("nome");
			JLabel infocliente=new JLabel();
			infocliente.setText(cliente);
			//System.out.println(infocliente.getText());
			centro.add(infocliente);
			
			
			int price=rs.getInt("costo");
			JLabel prezzo=new JLabel();
			prezzo.setText(Integer.toString(price));
			//System.out.println(prezzo.getText());
			centro.add(prezzo);
			
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
public JScrollPane getCentro(){
	return centrosc;
	
}
}
