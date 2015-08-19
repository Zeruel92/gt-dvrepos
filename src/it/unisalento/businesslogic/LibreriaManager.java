package it.unisalento.businesslogic;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import it.unisalento.dao.Autori;
import it.unisalento.dao.CaseEditrici;
import it.unisalento.dao.Generi;
import it.unisalento.dao.Libreria;
import it.unisalento.dbinterface.DBManager;
import it.unisalento.model.Autore;
import it.unisalento.model.CasaEditrice;
import it.unisalento.model.Genere;
import it.unisalento.model.Libro;
import it.unisalento.view.ModificaForm;
import it.unisalento.view.UserInterface;

public class LibreriaManager {
	
	private Libreria lib;
	private Autori au;
	private Generi gen;
	private CaseEditrici caseed;
	
	public LibreriaManager(){
		lib=Libreria.getIstance();
		au=Autori.getIstance();
		gen=Generi.getIstance();
	}
	public void addLibro(Libro l){
		String titolo=l.getTitolo();
		int idautore=l.getAutore();
		int idcasa=l.getCasaedi();
		float costo=l.getCosto();
		int giac=l.getGiacenza();
		int idgenere=l.getGenere();
		String query="INSERT INTO libro values (null,\""+titolo+"\",+\""+idautore+"\",\""+idcasa+"\",\""+costo+"\",\""+giac+"\",\""+idgenere+"\")";
		DBManager db=DBManager.getIstance();
		int rs=db.inserisciNuovo(query);
		if(rs!=-1){
			JOptionPane.showMessageDialog(null, "Inserimento riuscito");
		}
		else JOptionPane.showMessageDialog(null, "Inserimento non riuscito");
	}
	public void editLibro(Libro l) {
		int idLibro=l.getIdlibro();
		String titolo=l.getTitolo();
		int idautore=l.getAutore();
		int idcasa=l.getCasaedi();
		float costo=l.getCosto();
		int giac=l.getGiacenza();
		int idgenere=l.getGenere();
		String query="UPDATE libro"
				+ " SET titolo=\""+titolo+"\",idAutore=\""+idautore+"\",idCasaEd=\""+idcasa+"\",costo="+costo+",giacenza="+giac+",idGenere="+idgenere+""
						+" WHERE idLibro="+idLibro+"";
		DBManager db=DBManager.getIstance();
		int rs=db.inserisciNuovo(query);
		if(rs!=-1){
			JOptionPane.showMessageDialog(null, "Modifica riuscita");
		}
		else JOptionPane.showMessageDialog(null, "Modifica non riuscita");
	}
	public void deleteLibro(Libro l) {
		String titolo="Eliminare "+l.getTitolo()+"?";
		String messaggio="Vuoi eliminare il libro dalla libreria?";
		int risposta=JOptionPane.showConfirmDialog(null,messaggio, titolo, JOptionPane.YES_NO_OPTION);
		if(risposta==JOptionPane.YES_OPTION){
			String query="DELETE from LIBRO where idLibro="+l.getIdlibro();
			DBManager db=DBManager.getIstance();
			int rs=db.inserisciNuovo(query);
			if(rs!=-1){
				JOptionPane.showMessageDialog(null, "Cancellazione riuscita");
			}
			else JOptionPane.showMessageDialog(null, "Cancellazione non riuscita");
		}
	}
	public void deleteAutori(Autore a) {
		String titolo="Eliminare "+a.getNome()+" "+a.getCognome()+"?";
		String messaggio="Vuoi eliminare l'autore dalla lista autori?";
		int risposta=JOptionPane.showConfirmDialog(null,messaggio, titolo, JOptionPane.YES_NO_OPTION);
		if(risposta==JOptionPane.YES_OPTION){
			String query="DELETE from Autore where idAutore="+a.getId();
			DBManager db=DBManager.getIstance();
			int rs=db.inserisciNuovo(query);
			if(rs!=-1){
				JOptionPane.showMessageDialog(null, "Cancellazione riuscita");
			}
			else JOptionPane.showMessageDialog(null, "Cancellazione non riuscita");
		}
	}
	public void deleteCasa(CasaEditrice c) {
		String titolo="Eliminare"+c.getNome()+"?";
		String messaggio="Vuoi eliminare la casa editrice dalla lista?";
		int risposta=JOptionPane.showConfirmDialog(null,messaggio, titolo, JOptionPane.YES_NO_OPTION);
		if(risposta==JOptionPane.YES_OPTION){
			String query="DELETE from CasaEditrice where idCasaEd="+c.getId();
			DBManager db=DBManager.getIstance();
			int rs=db.inserisciNuovo(query);
			if(rs!=-1){
				JOptionPane.showMessageDialog(null, "Cancellazione riuscita");
			}
			else JOptionPane.showMessageDialog(null, "Cancellazione non riuscita");
		}
	}
	public void deleteGenere(Genere g) {
		String titolo="Eliminare"+g.getNome()+"?";
		String messaggio="Vuoi eliminare il genere dalla lista?";
		int risposta=JOptionPane.showConfirmDialog(null,messaggio, titolo, JOptionPane.YES_NO_OPTION);
		if(risposta==JOptionPane.YES_OPTION){
			String query="DELETE from Genere where idGenere="+g.getId();
			DBManager db=DBManager.getIstance();
			int rs=db.inserisciNuovo(query);
			if(rs!=-1){
				JOptionPane.showMessageDialog(null, "Cancellazione riuscita");
			}
			else JOptionPane.showMessageDialog(null, "Cancellazione non riuscita");
		}
	}
}

//TODO implementare metodi
/*Classe che fornisce i metodi necessari all'aggiunta,
 *  rimozione modifica di libri,autori,generi e caseeditrici
 */