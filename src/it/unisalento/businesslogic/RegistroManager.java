package it.unisalento.businesslogic;
import it.unisalento.view.RegistroVendite;
import it.unisalento.dbinterface.*;

import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class RegistroManager {
	JPanel centro;
	public RegistroManager(){
	String query="SELECT * from Vendite AS v JOIN Libro AS l JOIN Utente AS u WHERE v.idLibro = l.idLibro AND v.idUtente = u.idUtente ORDER BY idVendite;";
	DBManager d=DBManager.getIstance();
	ResultSet rs=d.eseguiQuery(query);
	centro=new JPanel();
	centro.setLayout(new GridLayout(0,5));
	
	try {
	while (rs.next())
		{
			JTextArea vuota=new JTextArea();
			vuota.setText("");
			centro.add(vuota);
		
			String nomel=rs.getString("titolo");
			JTextArea nomelibro=new JTextArea();
			nomelibro.setText(nomel);
			//r.setNomelibro(nomelibro);
			//System.out.println(nomelibro.getText());
			centro.add(nomelibro);
			
			String cliente=rs.getString("nome");
			JTextArea infocliente=new JTextArea();
			infocliente.setText(cliente);
			//System.out.println(infocliente.getText());
			centro.add(infocliente);
			
			
			int price=rs.getInt("costo");
			JTextArea prezzo=new JTextArea();
			prezzo.setText(Integer.toString(price));
			//System.out.println(prezzo.getText());
			centro.add(prezzo);
						
			int data=rs.getInt("data_vendita");
			JTextArea date=new JTextArea();
			date.setText(Integer.toString(data));
			//System.out.println(date.getText());
			centro.add(date);
			
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
public JPanel getCentro(){
	return centro;
	
}
}
