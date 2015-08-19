package it.unisalento.actionListener;

import it.unisalento.businesslogic.LibreriaManager;
import it.unisalento.dao.Autori;
import it.unisalento.dao.CaseEditrici;
import it.unisalento.dao.Generi;
import it.unisalento.dao.Libreria;
import it.unisalento.model.Autore;
import it.unisalento.model.CasaEditrice;
import it.unisalento.model.Genere;
import it.unisalento.model.Libro;
import it.unisalento.view.GestioneLibreria;
import it.unisalento.view.ModificaForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;

public class GestioneLibreriaListener implements ActionListener {

	public static final String ACTION_EDIT="modifica";
	public static final String ACTION_DELETE="cancella";
	public static final String ACTION_ADD="aggiungi";
	public static final String RADIO_AUTORE="autore";
	public static final String RADIO_LIBRO="libro";
	public static final String RADIO_CASA="casa";
	public static final String RADIO_GENERE="genere";

	private GestioneLibreria g;
	private LibreriaManager lm;
	private int edit;


	public GestioneLibreriaListener(GestioneLibreria g) {
		this.g=g;
		lm=new LibreriaManager();
		edit=0;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String command=arg0.getActionCommand();
		if(command.equals(RADIO_AUTORE)){
			edit=1;
			g.setAutoreEdit();
		}
		else if(command.equals(RADIO_LIBRO)){
			edit=0;
			g.setLibroEdit();
		}
		else if(command.equals(RADIO_GENERE)){
			edit=2;
			g.setGenere();
		}
		else if(command.equals(RADIO_CASA)){
			edit=3;
			g.setCasa();
		}
		else {
			switch (edit){
			case 0:
				if(command.equals(ACTION_EDIT)){
					ButtonGroup bg=g.getGroup();
					int id= Integer.parseInt(bg.getSelection().getActionCommand());
					Libro l=Libreria.getIstance().getLibroID(id);
					ModificaForm f=new ModificaForm(l);
					f.setVisible(true);
				}
				else if(command.equals(ACTION_DELETE)){
					ButtonGroup bg=g.getGroup();
					int id= Integer.parseInt(bg.getSelection().getActionCommand());
					Libro l=Libreria.getIstance().getLibroID(id);
					LibreriaManager libman=new LibreriaManager();
					libman.deleteLibro(l);
				}
				else{
					ModificaForm f=new ModificaForm(new Libro());
					f.setVisible(true);
				}
				break;
			case 1:
				if(command.equals(ACTION_EDIT)){
					ButtonGroup bg=g.getGroup();
					int id= Integer.parseInt(bg.getSelection().getActionCommand());
					Autore a=Autori.getIstance().getAutoreID(id);
					ModificaForm f=new ModificaForm(a);
					f.setVisible(true);
				}
				else if(command.equals(ACTION_DELETE)){
					ButtonGroup bg=g.getGroup();
					int id= Integer.parseInt(bg.getSelection().getActionCommand());
					Autore a=Autori.getIstance().getAutoreID(id);
					LibreriaManager libman=new LibreriaManager();
					libman.deleteAutori(a);
				}
				else{
					ModificaForm f=new ModificaForm(new Autore());
					f.setVisible(true);
				}
				break;

			case 2:
				if(command.equals(ACTION_EDIT)){
					ButtonGroup bg=g.getGroup();
					int id= Integer.parseInt(bg.getSelection().getActionCommand());
					Genere g=Generi.getIstance().getGenere(id-1);
					ModificaForm f=new ModificaForm(g);
					f.setVisible(true);
				}
				else if(command.equals(ACTION_DELETE)){
					//TODO elimina genere
				}
				else{
					ModificaForm f=new ModificaForm(new Genere());
					f.setVisible(true);
				}
				break;

			case 3:
				if(command.equals(ACTION_EDIT)){
					ButtonGroup bg=g.getGroup();
					int id= Integer.parseInt(bg.getSelection().getActionCommand());
					CasaEditrice c=CaseEditrici.getIstance().getCasaID(id);
					ModificaForm f=new ModificaForm(c);
					f.setVisible(true);
				}
				else if(command.equals(ACTION_DELETE)){
					ButtonGroup bg=g.getGroup();
					int id= Integer.parseInt(bg.getSelection().getActionCommand());
					CasaEditrice c=CaseEditrici.getIstance().getCasaID(id);
					LibreriaManager libman=new LibreriaManager();
					libman.deleteCasa(c);
				}
				else{
					ModificaForm f=new ModificaForm(new CasaEditrice());
					f.setVisible(true);
				}
				break;

			default: break;
			}
		}
	}
}
/*
EDIT =0 operazioni sui Libri
EDIT =1 operazioni sugli autori
EDIT =2 operazioni sulle generi
EDIT =3 Operazioni sui case editrici */