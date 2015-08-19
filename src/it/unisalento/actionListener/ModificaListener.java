package it.unisalento.actionListener;

import it.unisalento.businesslogic.LibreriaManager;
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
		// TODO Implementare Controlli Finestra di Modifica
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
			System.out.println("Aggiugi auore");
		}
		else if (cmd.equals(ACTION_APPLY_EDITA)){
			System.out.println("Modifica Autore");
		}
		else if (cmd.equals(ACTION_APPLY_ADDCAS)){
			System.out.println("aggiungi Casa editrice");
		}
		else if (cmd.equals(ACTION_APPLY_EDITCAS)){
			System.out.println("Modifica casa editrice");
		}
		else if (cmd.equals(ACTION_APPLY_ADDGEN)){
			System.out.println("Aggiungi genere");
		}
		else {
			System.out.println("Modifica genere");
			}
	}
}
