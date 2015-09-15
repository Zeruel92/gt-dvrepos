package it.unisalento.actionListener;

import it.unisalento.businesslogic.CarrelloManager;
import it.unisalento.dao.Libreria;
import it.unisalento.view.Catalogo;
import it.unisalento.view.SForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CatalogoListener implements ActionListener {
	
	public static final String ACTION_ADD="aggiungi";
	public static final String ACTION_SEARCH="cerca";
	private Catalogo c;
	private Libreria l;
	
	public CatalogoListener(Catalogo c){
		this.c=c;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals(ACTION_ADD)){
			CarrelloManager m=new CarrelloManager(c.getSelezionati());
			}
		else if(arg0.getActionCommand().equals(ACTION_SEARCH)){
			SForm s=new SForm();
			c.setSouth();
		}
		else if (arg0.getActionCommand().equals("canc"))
		{
			String query="Select l.idLibro, l.titolo, g.idGenere, l.costo, l.giacenza, a.idAutore, e.idCasaEd as casaed\n"+
					"from Libro as l, Autore as a, CasaEditrice as e, Genere as g \n"+
					"where l.idAutore=a.idAutore and l.idCasaEd=e.idCasaEd and l.idGenere=g.idGenere \n"
					+ "ORDER BY l.idLibro";
			Libreria l=Libreria.getIstance();
			l.update(query);
		}
		}

}
