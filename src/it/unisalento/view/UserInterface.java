package it.unisalento.view;
import it.unisalento.model.Utente;

import javax.swing.*;

public class UserInterface extends JFrame {
	private Utente u;
	private JTabbedPane schede;
	private Carrello carrello;
	private Catalogo catalogo;
	private GestioneLibreria gestionelibreria;
	private RegistroVendite registrovendite;
	private GestioneAddetti gestioneaddetti;
	
	
	public UserInterface(Utente u){
		this.u=u;
		schede= new JTabbedPane();
		catalogo= new Catalogo();
		add(schede);
		if(u.getTipo()==0)
		{
			schede.addTab("Catalogo", catalogo);
			schede.addTab("Carrello", carrello);
		}
		else if(u.getTipo()==1)
		{
			schede.addTab("Catalogo", catalogo);
			schede.addTab("Carrello", carrello);
			schede.addTab("Gestione Libreria", gestionelibreria);
		}
		else if(u.getTipo()==2)
			{
			schede.addTab("Catalogo", catalogo);
			schede.addTab("Carrello", carrello);
			schede.addTab("Registro Vendite", registrovendite);
			}
		else if(u.getTipo()==3)
		{
			schede.addTab("Catalogo", catalogo);
			schede.addTab("Carrello", carrello);
			schede.addTab("Registro Vendite", registrovendite);
			schede.addTab("Gestione Addetti", gestioneaddetti);
		}
		
	}
	

}
