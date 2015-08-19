package it.unisalento.actionListener;

import it.unisalento.businesslogic.LibreriaManager;
import it.unisalento.model.Autore;
import it.unisalento.model.CasaEditrice;
import it.unisalento.model.Genere;
import it.unisalento.model.Libro;
import it.unisalento.view.ModificaForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificaListener implements ActionListener {
	
	public static final String ACTION_APPLY_ADDL="aggiungilibro";
	public static final String ACTION_APPLY_EDITL="applicamodificalibro";
	public static final String ACTION_APPLY_ADDAU="applicaggiungiautore";
	public static final String ACTION_APPLY_EDITA="modificaautore";
	public static final String ACTION_APPLY_ADDGEN="applicaaggiungigenere";
	public static final String ACTION_APPLY_EDITGEN="modificagenere";
	public static final String ACTION_APPLY_ADDCAS="aggiungicasa";
	public static final String ACTION_APPLY_EDITCAS="modificacasa";
	public static final String ACTION_CANCEL="annulla";
	private ModificaForm f;
	private LibreriaManager libman;
	
	 public ModificaListener(ModificaForm f) {
		this.f=f;
		libman=new LibreriaManager();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String cmd=arg0.getActionCommand();
		if(cmd.equals(ACTION_CANCEL)){
			this.f.setVisible(false);
			this.f=null;
		}
		else if (cmd.equals(ACTION_APPLY_ADDL)){
			Libro l=f.getLibro();
			libman.addLibro(l);
			this.f.setVisible(false);
			}
		else if(cmd.equals(ACTION_APPLY_EDITL)){
			Libro l=f.getLibro();
			libman.editLibro(l);
			this.f.setVisible(false);
		}
		else if (cmd.equals(ACTION_APPLY_ADDAU)){
			Autore a=f.getAutore();
			libman.addAutore(a);
			this.f.setVisible(false);
		}
		else if (cmd.equals(ACTION_APPLY_EDITA)){
			Autore a =f.getAutore();
			libman.editAutore(a);
			this.f.setVisible(false);
		}
		else if (cmd.equals(ACTION_APPLY_ADDCAS)){
			CasaEditrice c=f.getCasa();
			libman.addCasa(c);
			this.f.setVisible(false);
		}
		else if (cmd.equals(ACTION_APPLY_EDITCAS)){
			CasaEditrice c=f.getCasa();
			libman.editCasa(c);
			this.f.setVisible(false);
		}
		else if (cmd.equals(ACTION_APPLY_ADDGEN)){
			Genere g=f.getGenere();
			libman.addGenere(g);
			this.f.setVisible(false);
		}
		else {
			Genere g=f.getGenere();
			libman.editGenere(g);
			this.f.setVisible(false);
			}
	}
}
