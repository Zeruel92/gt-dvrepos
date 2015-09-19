package it.unisalento.actionListener;

import it.unisalento.businesslogic.Research;
import it.unisalento.view.SForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SearchListener implements ActionListener{
	private SForm s;
	public String tipo, stringa;
	public SearchListener(SForm s){
		this.s=s;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("search"))
		{

			//Research r=new Research();

			tipo=s.getTipo();
			stringa=s.getStringa();
	
				try {
					Research r= new Research(tipo, stringa);
					s.setVisible(false);
					JOptionPane.showMessageDialog(null, "Ricerca Completata!");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		}
		else if (e.getActionCommand().equals("canc"))
		{
			s.setVisible(false);
		}
}
}
