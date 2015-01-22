package it.unisalento.view;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import it.unisalento.dao.*;
import it.unisalento.model.Libro;

public class Catalogo extends JPanel {
	JTextArea area;
	
	public Catalogo(){
		area=new JTextArea();
		this.add(area);
		Libreria lib= new Libreria();
		for (int i =0; i<lib.getDim();i++){
			Libro l=lib.getLibro(i);
			area.append(l.getTitolo()+"\n");
		}
	}

}
