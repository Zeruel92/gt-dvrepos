package it.unisalento.businesslogic;

import it.unisalento.dao.Autori;
import it.unisalento.dao.CaseEditrici;
import it.unisalento.dao.Generi;
import it.unisalento.dao.Libreria;
import it.unisalento.model.Libro;
import it.unisalento.view.ModificaForm;

public class LibreriaManager {
	
	private Libreria lib;
	private Autori au;
	private Generi gen;
	private CaseEditrici caseed;
	private ModificaForm f;
	
	public LibreriaManager(ModificaForm f){
		this.f=f;
		lib=Libreria.getIstance();
		au=Autori.getIstance();
		gen=Generi.getIstance();
	}
	public LibreriaManager(){
		lib=Libreria.getIstance();
		au=Autori.getIstance();
		gen=Generi.getIstance();
	}
	public void edit(int index,int type){
		switch(type){
		case 0:{
			
			break;
		}
		case 1:{
			break;
		}
		case 2:{
			break;
		}
		case 3:{
			break;
		}
		default: {
			break;
		}
		}
	}
}

//TODO implementare metodi
/*Classe che fornisce i metodi necessari all'aggiunta,
 *  rimozione modifica di libri,autori,generi e caseeditrici
 */