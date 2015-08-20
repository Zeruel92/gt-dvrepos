package it.unisalento.actionListener;

import it.unisalento.businesslogic.Research;
import it.unisalento.view.SForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SearchListener implements ActionListener{
	private SForm s;
	public String tipo, stringa;
	public SearchListener(SForm s){
		this.s=s;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("search"))
		{

			//Research r=new Research();

			tipo=s.getTipo();
			stringa=s.getStringa();
			
			System.out.println(tipo);
			System.out.println(stringa);
				/*try {
					Research r= new Research(tipo, stringa);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
		}
}
}
