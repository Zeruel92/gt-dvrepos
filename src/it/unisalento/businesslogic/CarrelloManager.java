package it.unisalento.businesslogic;

import java.util.Vector;
import javax.swing.JCheckBox;
import it.unisalento.dao.*;

public class CarrelloManager {
	
	private Libreria lib;
	private Chart chart;
	
	public CarrelloManager(Vector<JCheckBox> vect){
		lib=Libreria.getIstance();
		chart=Chart.getIstance();
		for(int i=0;i<vect.size();i++){
			int id= Integer.parseInt(vect.elementAt(i).getText());
			vect.elementAt(i).setSelected(false);
			chart.add(lib.getLibroID(id));
		}
	}
}
